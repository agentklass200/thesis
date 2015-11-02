package data;

import CSVProcess.InfoBean;
import java.util.*;
import java.util.ArrayList;
import java.util.Collection;

public class Sort {
	public void info(ArrayList<InfoBean> list){
		System.out.println("Length = " + list.size());
	}
	
	public  ArrayList<InfoBean> sortTotal(ArrayList<InfoBean> list){
		for(int i = 0; i < list.size() ; i++){
			for(int j = 1; j < list.size() - i; j++){
				System.out.println(list.get(j));
				if(list.get(j-1).getTotal() < list.get(j).getTotal()){
					Collections.swap(list, (j-1), j);
				}
			}
		}
		return list;
	}
	
	public  ArrayList<InfoBean> sortNone(ArrayList<InfoBean> list){
		for(int i = 0; i < list.size() ; i++){
			for(int j = 1; j < list.size() - i; j++){
				System.out.println(list.get(j));
				if(list.get(j-1).getNone() < list.get(j).getNone()){
					Collections.swap(list, (j-1), j);
				}
			}
		}
		return list;
	}
	

	
	public  ArrayList<tableObject> sortRow(ArrayList<tableObject> list){
		for(int i = 0; i < list.size() ; i++){
			for(int j = 1; j < list.size() - i; j++){
				if(list.get(j-1).getValue() < list.get(j).getValue()){
					Collections.swap(list, (j-1), j);
				}
			}
		}
		return list;
	}
	
	
	public  ArrayList<InfoBean> chooseColumn(String sortColumn, ArrayList<InfoBean> list){
		switch(sortColumn){
			case "Total":
				sortTotal(list);	
				break;
			case "No Occupation":
				sortNone(list);
				break;
			default:
				System.out.println("String is invalid");
		}
		return list;
	}
	
	public void  listSortedColumn(String type ,ArrayList<InfoBean> list){
		if(type == "Total"){
			for(int i=0; i <  list.size(); i++){
				System.out.println(list.get(i).getRegion() + " - " + list.get(i).getTotal());
			}
		}
		else if(type == "noOccupation"){
			for(int i=0; i <  list.size(); i++){
				System.out.println(list.get(i).getRegion() + " - " + list.get(i).getNone());
			}
		}
		
	}
	
}
