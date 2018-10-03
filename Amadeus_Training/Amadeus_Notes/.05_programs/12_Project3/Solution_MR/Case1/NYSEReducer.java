import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class NYSEReducer extends Reducer<Text,IntWritable,Text,LongWritable>{
	
	private static Long totalVolume = new Long(0);
	public void reduce( Text stockSymbol ,Iterable<IntWritable> volume,Context context)throws IOException,InterruptedException{
	
		totalVolume = new Long(0);
		
		for(IntWritable value : volume) {
			totalVolume += value.get();
			
		}
			
		    context.write(stockSymbol, new LongWritable(totalVolume));
	}
	
}
	
