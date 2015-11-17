package data;

import CSVProcess.InfoBean;
import user.Config;

import java.util.*;
import java.util.ArrayList;
import java.util.Collection;

public class Sort {
	public void info(ArrayList<InfoBean> list){
		System.out.println("Length = " + list.size());
	}
	
	public static  ArrayList<InfoBean> sortTotal(ArrayList<InfoBean> list, Config user){
		for(int i = 0; i < list.size() ; i++){
			for(int j = 1; j < list.size() - i; j++){
				if(user.getModeVariants() == Config.HIGHEST_AREA_HIGHEST_OCCU || user.getModeVariants() == Config.HIGHEST_AREA_LOWEST_OCCU){
					if(list.get(j-1).getTotal() < list.get(j).getTotal()){
						Collections.swap(list, (j-1), j);
					}
				}
				else{
					if(list.get(j-1).getTotal() > list.get(j).getTotal()){
						Collections.swap(list, (j-1), j);
					}
				}
				
			}
		}
		return list;
	}
	
	public static  ArrayList<InfoBean> sortNone(ArrayList<InfoBean> list, Config user){
		for(int i = 0; i < list.size() ; i++){
			for(int j = 1; j < list.size() - i; j++){
				if(user.getModeVariants() == Config.HIGHEST_AREA_HIGHEST_OCCU || user.getModeVariants() == Config.HIGHEST_AREA_LOWEST_OCCU){
					if(list.get(j-1).getTotal() < list.get(j).getTotal()){
						Collections.swap(list, (j-1), j);
					}
				}
				else{
					if(list.get(j-1).getTotal() > list.get(j).getTotal()){
						Collections.swap(list, (j-1), j);
					}
				}
			}
		}
		return list;
	}
	

	
	public static  ArrayList<tableObject> sortRow(ArrayList<tableObject> list, Config user){
		for(int i = 0; i < list.size() ; i++){
			for(int j = 1; j < list.size() - i; j++){
				if(user.getModeVariants() == Config.HIGHEST_AREA_HIGHEST_OCCU || user.getModeVariants() == Config.LOWEST_AREA_HIGHEST_OCCU){
					if(list.get(j-1).getValue() < list.get(j).getValue()){
						Collections.swap(list, (j-1), j);
					}
				}
				else{
					if(list.get(j-1).getValue() > list.get(j).getValue()){
						Collections.swap(list, (j-1), j);
					}
				}
			}
		}
		return list;
	}
	
	
//	public static ArrayList<InfoBean> chooseColumn(String sortColumn, ArrayList<InfoBean> list){
//		switch(sortColumn){
//			case "Total":
//				sortTotal(list);	
//				break;
//			case "No Occupation":
//				sortNone(list);
//				break;
//			default:
//				System.out.println("String is invalid");
//		}
//		return list;
//	}
	
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
