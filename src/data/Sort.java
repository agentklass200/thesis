package data;

import CSVProcess.InfoBean;
import java.util.*;
import java.util.List;
import java.util.Collection;

public class Sort {
	public List<InfoBean> sortTotal(List<InfoBean> list){
		for(int i = 0; i < list.size() - 1; i++){
			for(int j = 0; j < list.size() - i; j++){
				if(list.get(j-1).getTotal() > list.get(j).getTotal()){
					Collections.swap(list, (j-1), j);
				}
			}
		}
		return list;
	}
	
	public List<InfoBean> sortSpecialOccupation(List<InfoBean> list){
		for(int i = 0; i < list.size() - 1; i++){
			for(int j = 0; j < list.size() - i; j++){
				if(list.get(j-1).getSpecialOccupation() > list.get(j).getSpecialOccupation()){
					Collections.swap(list, (j-1), j);
				}
			}
		}
		return list;
	}
}