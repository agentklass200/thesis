package CSVProcess;

import java.util.ArrayList;

public class CSVColumn {
	public String columnName;
	public ArrayList<Object> data; 
	
	public CSVColumn(String columnName, ArrayList<Object> data){
		this.data = data;
		this.columnName = columnName;
	}
	
	public CSVColumn(){
		this.data = new ArrayList<Object>();
	}

	@Override
	public String toString() {
		return "CSVColumn [columnName=" + columnName + ", data=" + data + "]";
	}
}
