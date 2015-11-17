package CSVProcess;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import CSVProcess.CSVRow;

import org.supercsv.io.*;
import org.supercsv.prefs.CsvPreference;


public class CSVListProcessing {
	

	public static ArrayList<CSVRow> readCSV(String filename) throws IOException{
		ArrayList<CSVRow> data = new ArrayList<CSVRow>();
		ICsvListReader listReader = null;
		try{
			listReader = new CsvListReader(new FileReader(filename), CsvPreference.STANDARD_PREFERENCE);

			CSVRow list = new CSVRow();
			
			data = new ArrayList<CSVRow>();
			
			List<String> line;
			while((line = listReader.read()) != null){
				data.add(new CSVRow(line));
				
			}
			return data;
		}
		finally{
			if(listReader != null){
				listReader.close();
			}
		}
		
	}
	
	public static ArrayList<CSVRow> cloneArrayList(ArrayList<CSVRow> list){
		ArrayList<CSVRow> clone = new ArrayList<CSVRow>();
		for(CSVRow newList: list){
			CSVRow a = new CSVRow();
			a = newList.clone();
			clone.add(a);
		}
		return clone;
	}
}



