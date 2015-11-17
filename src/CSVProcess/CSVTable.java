package CSVProcess;

import CSVProcess.*;
import java.util.*;

public class CSVTable {
	
	private ArrayList<CSVRow> row;
	private ArrayList<CSVColumn> column;
	
	public CSVTable(){
		row = new ArrayList<CSVRow>();
		column = new ArrayList<CSVColumn>();
	}
	
	public CSVTable(ArrayList<CSVRow> row){
		this.row = row;
		this.column = new ArrayList<CSVColumn>();
		
		for(int i = 0; i < row.size(); i++ ){
			if(i == 0){				
				for(int j = 0; j < row.get(0).data.size(); j++){
					column.add(new CSVColumn());
					column.get(j).columnName = row.get(i).data.get(j).toString();
				}
			}
			else{
				for(int j = 0; j < row.get(i).data.size(); j++){
					if(isNumeric(row.get(i).data.get(j))){
						column.get(j).data.add(Integer.parseInt(row.get(i).data.get(j)));
					}
					else{
						column.get(j).data.add(row.get(i).data.get(j));
					}
				}
			}
		}
		
		
	}
	
	public CSVTable(ArrayList<CSVRow> row, ArrayList<CSVColumn> column){
		this.row = row;
		this.column = column;
	}
	
	public CSVTable clone(){
		ArrayList<CSVColumn> column = new ArrayList<CSVColumn>();
		ArrayList<CSVRow> row = new ArrayList<CSVRow>();
		for(int i = 0; i < this.column.size(); i++){
			column.add(new CSVColumn());
			column.get(i).columnName = this.column.get(i).columnName;
			for(int j = 0; j < this.column.get(i).data.size(); j++){
				column.get(i).data.add(this.column.get(i).data.get(j));
			}
		}
		
		for(int i = 0; i < this.row.size(); i++){
			row.add(new CSVRow());
			for(int j = 0; j < this.row.get(i).data.size(); j++){
				row.get(i).data.add(this.row.get(i).data.get(j));
			}
		}
		CSVTable clone = new CSVTable(row, column);
		return clone;
	}
	
	public CSVTable sortTotalColumn(){
		for(int i = 0; i < getColumn().get(1).data.size(); i++){
			for(int j = 1; j < getColumn().get(1).data.size() - i; j++){
				if(Integer.parseInt(getColumn().get(1).data.get(j-1).toString()) < Integer.parseInt(getColumn().get(1).data.get(j).toString())){
					for(int c1 = 0; c1 < getColumn().size(); c1++){
						System.out.println(c1 + " - "+  (j-1) + " - " + j);
						Collections.swap(getColumn().get(c1).data, (j-1), j);
					}
					Collections.swap(getRow(), j, j+1);
				}
			}
		}
		
		return this;
	}
	
	public CSVTable removeColumn(int index){
		this.column.remove(index);
		for(int i = 0; i < row.size(); i++){
			this.row.get(i).data.remove(index);
		}
		return this;
	}
	
	public CSVTable removeRow(int index){
		this.row.remove(index);
		for(int i = 0; i < column.size(); i++){
			this.column.get(i).data.remove(index - 1);
		}
		return this;
	}
	
	public CSVTable sortColumn(int index){
		for(int i = 0; i < getColumn().get(index).data.size(); i++){
			for(int j = 1; j < getColumn().get(index).data.size() - i; j++){
				if(Integer.parseInt(getColumn().get(index).data.get(j-1).toString()) < Integer.parseInt(getColumn().get(index).data.get(j).toString())){
					for(int c1 = 0; c1 < getColumn().size(); c1++){
						Collections.swap(getColumn().get(c1).data, (j-1), j);
					}
					Collections.swap(getRow(), j, j+1);
				}
			}
		}
		
		return this;
	}
	
	public CSVTable sortRow(int index){
		for(int i = 1; i < getRow().get(index).data.size(); i++){
			for(int j = 2; j < getRow().get(index).data.size() - i; j++){
				if(Integer.parseInt(getRow().get(index).data.get(j-1).toString()) < Integer.parseInt(getRow().get(index).data.get(j).toString())){
					for(int c1 = 0; c1 < getRow().size(); c1++){
						Collections.swap(getRow().get(c1).data, (j-1), j);
					}
					Collections.swap(getColumn(), j, j-1);
				}
			}
		}
		
		return this;
	}
	
	

	
	public boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}

	public ArrayList<CSVRow> getRow() {
		return row;
	}

	public void setRow(ArrayList<CSVRow> row) {
		this.row = row;
	}

	public ArrayList<CSVColumn> getColumn() {
		return column;
	}

	public void setColumn(ArrayList<CSVColumn> column) {
		this.column = column;
	}  
	
	
}
