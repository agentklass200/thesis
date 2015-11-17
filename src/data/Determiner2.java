package data;

import java.util.ArrayList;

import CSVProcess.*;



public class Determiner2 {
	private CSVTable data;
	private CSVTable occupationList;
	private CSVTable noOccupationList;
	private CSVRow majorRegion;
	private CSVTable topOccupation;
	private CSVTable topNoOccupation;
	private CSVTable secondOccupation;
	
	public Determiner2(CSVTable data){
		this.data = data.clone();
		
		this.occupationList = data.clone().sortColumn(1);
		this.noOccupationList = data.clone().sortColumn(12);
		
		this.occupationList = this.occupationList.removeRow(1);
		this.noOccupationList = this.occupationList.removeRow(1);
		
		this.majorRegion = data.getRow().get(1).clone();
		
		this.topOccupation = new CSVTable(data.getRow(), data.getColumn());
		this.topOccupation = this.topOccupation.removeColumn(1);
		this.topOccupation = this.topOccupation.removeColumn(12);
		this.topNoOccupation = new CSVTable(data.getRow(), data.getColumn());
		this.topNoOccupation = this.topNoOccupation.removeColumn(1);
		this.topNoOccupation = this.topNoOccupation.removeColumn(12);
		this.secondOccupation = new CSVTable(data.getRow(), data.getColumn());
		this.secondOccupation = this.secondOccupation.removeColumn(1);
		this.secondOccupation = this.secondOccupation.removeColumn(12);
		
	}
	
}
