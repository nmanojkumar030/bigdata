import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class NYSEMapper extends Mapper<LongWritable,Text,Text,IntWritable>{


	public void map(LongWritable offset,Text value,Context context) throws IOException,InterruptedException {
	
		String record = value.toString();
		String [] records = record.split(",");
		String stockTicker = records[1];
		int stockVolume = Integer.parseInt(records[7]);
		context.write(new Text(stockTicker), new IntWritable(stockVolume));
	}

}