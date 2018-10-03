import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


// Hadoop MapReduce example showing high and low for a day across all stock symbols


public class StockDriver {

			 public static void main(String args[]) throws IllegalArgumentException, IOException, ClassNotFoundException, InterruptedException{

			 Configuration conf = new Configuration();
          
			  Job job = new Job(conf,"Nyse - 3");
              job.setJarByClass(StockDriver.class);
          
              job.setMapperClass(StockMapper.class);
              job.setReducerClass(StockReducer.class);

              job.setMapOutputKeyClass(Text.class);
              job.setMapOutputValueClass(DoubleWritable.class);

              job.setOutputKeyClass(Text.class);
              job.setOutputValueClass(Text.class);
              
              FileInputFormat.addInputPath(job, new Path(args[0]));
              FileOutputFormat.setOutputPath(job, new Path(args[1]));
              System.exit(job.waitForCompletion(true) ? 0 : 1);

             
     
             
       }
}