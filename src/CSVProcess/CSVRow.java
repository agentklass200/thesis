package CSVProcess;

import java.util.ArrayList;
import java.util.List;

public class CSVRow {
	public List<String> data;
	
	public CSVRow(){
		data = new ArrayList<String>();
	}
	
	public CSVRow(List<String> data){
		this.data = data;
	}
	
	public CSVRow clone(){
		CSVRow b = new CSVRow();
		b.data = this.data;
		return b;
	}

	@Override
	public String toString() {
		return "CSVRow [data=" + data + "]";
	}
}
