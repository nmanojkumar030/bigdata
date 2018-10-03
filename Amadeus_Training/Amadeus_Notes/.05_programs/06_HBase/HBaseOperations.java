import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseOperations {
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args) throws IOException {

		Configuration config = HBaseConfiguration.create();

		HTable table = new HTable(config, "employee");

		Put p = new Put(Bytes.toBytes("Emp001"));

		p.add(Bytes.toBytes("personal"), Bytes.toBytes("mobile"),Bytes.toBytes("9845098450"));

		table.put(p);

		Get g = new Get(Bytes.toBytes("Emp001"));
		Result r = table.get(g);
		byte[] value = r.getValue(Bytes.toBytes("personal"), Bytes.toBytes("email"));

		String valueStr = Bytes.toString(value);
		System.out.println("get command: " + valueStr);

		Scan s = new Scan();
		s.addColumn(Bytes.toBytes("official"), Bytes.toBytes("FirstName"));
		ResultScanner scanner = table.getScanner(s);
		try {
			for (Result rr = scanner.next(); rr != null; rr = scanner.next()) {

				System.out.println("scan command : " + rr);
			}


		} finally {

			scanner.close();
		}}}
