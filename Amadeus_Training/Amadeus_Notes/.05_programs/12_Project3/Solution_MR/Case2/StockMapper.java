import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

 // Hadoop MapReduce example showing high and low for a day across all stock symbols
 
public class StockMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
              
				
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
                                
		String record = value.toString();
                               
        if (record.startsWith("exchange,")) {
          // Line is the header, ignore it
             return;
         }
                               
         String[] columns = record.split(",");
                               
          if (columns.length != 9) {
        	  return;
         }

          double close = Double.parseDouble(columns[6]);
          context.write(new Text(columns[2]), new DoubleWritable(close));                      
                }
}
