import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCount {

  public static class TokenizerMapper
       extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
    	 
    	System.out.println("*** Mapper Execution Begins ***");
    	System.out.println("The key input to the mapper class is:"+key);
    	System.out.println("The value input to the mapper class is:"+value);
    	
      StringTokenizer itr = new StringTokenizer(value.toString());
      while (itr.hasMoreTokens()) {
        word.set(itr.nextToken());
        context.write(word, one);
       
    	System.out.println("The key output of the mapper class is:"+word);
    	System.out.println("The value output of the mapper class is:"+one);
      }
      System.out.println("*** Mapper Execution Ends ***");
    }
  }

  public static class IntSumReducer
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
                       ) throws IOException, InterruptedException {
    	System.out.println("*** Reducer Execution Begins ***");
    	
    
      int sum = 0;
      for (IntWritable val : values) {
        sum += val.get();
      }
      result.set(sum);
      context.write(key, result);
      System.out.println("The final key is:"+key);
  	System.out.println("The final value is:"+result);
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(WordCount.class);
    job.setMapperClass(TokenizerMapper.class);
   
    //job.setCombinerClass(IntSumReducer.class);
    
    //job.setNumReduceTasks(3);
    // job.setPartitionerClass(getPartitioner.class);
    
    
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }



public static class getPartitioner extends Partitioner <Text, IntWritable>
{
   @Override
   public int getPartition(Text key, IntWritable value, int numPartitions)
   {
      String myKey = key.toString();

			if (myKey.equals("Hadoop")) {
				return 0;
			}

			if (myKey.equals("buzz")) {
				return 1;
			} 
			
			else {
				return 2;
			}
   }
}

}