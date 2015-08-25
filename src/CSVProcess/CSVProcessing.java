package CSVProcess;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;


public class CSVProcessing {
	

	public static ArrayList<InfoBean> readCSV(String filename, ArrayList<InfoBean> data) throws IOException{
		
		ICsvBeanReader beanReader = null;
		try{
			beanReader = new CsvBeanReader(new FileReader(filename), CsvPreference.EXCEL_PREFERENCE);
			final String[] header = new String[] {"region","total", "specialOccupation","officials", "professionals","technicians", "clerks","serviceWorkers", "farmers", "trades","operators", "laborers", "none","noAnswer"};
			beanReader.getHeader(true);
			CellProcessor[] processor = new CellProcessor[] {null, new ParseInt(), new ParseInt(), new ParseInt(), new ParseInt(),new ParseInt(), new ParseInt(), new ParseInt(), new ParseInt(),new ParseInt(), new ParseInt(), new ParseInt(), new ParseInt(),new ParseInt(),	};
			InfoBean bean;
			
			data = new ArrayList<InfoBean>();

			while((bean = beanReader.read(InfoBean.class, header, processor)) != null){
				data.add(bean);

			}
			
			return data;
		}
		finally{
			if(beanReader != null){
				beanReader.close();
			}
		}
		
	}
}
