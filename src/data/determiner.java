package data;

import java.util.ArrayList;
import CSVProcess.InfoBean;
import data.Sort;
import user.Config;

public class determiner {
	private ArrayList<InfoBean> data;
	private ArrayList<InfoBean> occupationList;
	private ArrayList<InfoBean> noOccupationList;
	private InfoBean majorRegion;
	private ArrayList<tableObject> topOccupation;
	private ArrayList<tableObject> topNoOccupation;
	private ArrayList<tableObject> secondOccupation;
	private ArrayList<tableObject> thirdOccupation;
	
	private ArrayList<tableObject> majorOccupation;
	private ArrayList<tableObject> majorNoOccupation;
	
	private ArrayList<tableObject> secondNoOccupation;
	private ArrayList<tableObject> thirdNoOccupation;
	private ArrayList<tableObject> fourthNoOccupation;

	public ArrayList<Integer> noOccupationRanking;
	public ArrayList<Integer> occupationRanking;
	public int majorOccupationTotal;

	
	public Config user;
	
	
	
	public int regionNone;
	
	public determiner(ArrayList<InfoBean> data, Config user){
		this.data = cloneArrayList(data);
		this.occupationList = cloneArrayList(data);
		this.noOccupationList = cloneArrayList(data);
		
		this.majorRegion = data.get(0);
		
		this.occupationList.remove(0);
		this.noOccupationList.remove(0);
		
		this.user = user;
		
		this.regionNone = this.majorRegion.getNone();
		
		this.occupationList = Sort.sortTotal(occupationList, user);
		this.noOccupationList = Sort.sortTotal(noOccupationList , user);
		
		this.topOccupation = createRow(occupationList.get(0),user);
		this.secondOccupation = createRow(occupationList.get(1),user);
		this.thirdOccupation = createRow(occupationList.get(2),user);
		
		this.topNoOccupation = createRow(noOccupationList.get(0),user);
		this.secondNoOccupation = createRow(noOccupationList.get(1),user);
		this.thirdNoOccupation = createRow(noOccupationList.get(2),user);
		
		this.majorOccupation = createRow(this.majorRegion,user);
		this.majorOccupationTotal = this.majorRegion.getTotal();
	
		
		this.topOccupation = Sort.sortRow(topOccupation , user);
		this.secondOccupation = Sort.sortRow(secondOccupation, user);
		this.thirdOccupation = Sort.sortRow(thirdOccupation, user);
		
		this.topNoOccupation = Sort.sortRow(topNoOccupation, user);
		this.secondNoOccupation = Sort.sortRow(secondNoOccupation, user);
		this.thirdNoOccupation = Sort.sortRow(thirdNoOccupation, user);
		
		this.majorOccupation = Sort.sortRow(majorOccupation, user);
		
		this.occupationRanking = new ArrayList<Integer>();
		this.noOccupationRanking = new ArrayList<Integer>();
		
		for(int i = 0; i < this.occupationList.size(); i++){
			this.occupationRanking.add(this.occupationList.get(i).getTotal());
		}
		
		for(int i = 0; i < this.noOccupationList.size(); i++){
			this.noOccupationRanking.add(this.noOccupationList.get(i).getNone());
		}
	}
	
	public boolean withTies(){
		for(int j = 1; j < this.occupationList.size(); j++){
			if(this.occupationList.get(0).getTotal() == this.occupationList.get(j).getTotal()){
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<InfoBean> cloneArrayList(ArrayList<InfoBean> list){
		ArrayList<InfoBean> clone = new ArrayList<InfoBean>();
		for(InfoBean newList: list){
			InfoBean a = new InfoBean();
			a = newList.clone();
			clone.add(a);
		}
		return clone;
	}
	
	public static ArrayList<tableObject> createRow(InfoBean obj, Config user){
		ArrayList<tableObject> objList = new ArrayList<tableObject>();
//		if(user.getModeVariants() == Config.HIGHEST_AREA_HIGHEST_OCCU || user.getModeVariants() == Config.LOWEST_AREA_HIGHEST_OCCU){
//			objList.add(new tableObject(obj.getTotalColumnName(), obj.getTotal()));
//		}
		objList.add(new tableObject(obj.getSpecialOccupationColumnName(), obj.getSpecialOccupation()));
		objList.add(new tableObject(obj.getOfficialsColumnName(), obj.getOfficials()));
		objList.add(new tableObject(obj.getProfessionalsColumnName(), obj.getOfficials()));
		objList.add(new tableObject(obj.getTechniciansColumnName(), obj.getTechnicians()));
		objList.add(new tableObject(obj.getClerksColumnName(), obj.getClerks()));
		objList.add(new tableObject(obj.getServiceWorkersColumnName(), obj.getServiceWorkers()));
		objList.add(new tableObject(obj.getFarmersColumnName(), obj.getFarmers()));
		objList.add(new tableObject(obj.getTradesColumnName(), obj.getTrades()));
		objList.add(new tableObject(obj.getOperatorsColumnName(), obj.getOperators()));
		objList.add(new tableObject(obj.getLaborersColumnName(), obj.getLaborers()));
		return objList;
	}

	public ArrayList<InfoBean> getData() {
		return data;
	}

	public void setData(ArrayList<InfoBean> data) {
		this.data = data;
	}

	public ArrayList<InfoBean> getOccupationList() {
		return occupationList;
	}

	public void setOccupationList(ArrayList<InfoBean> occupationList) {
		this.occupationList = occupationList;
	}

	public ArrayList<InfoBean> getNoOccupationList() {
		return noOccupationList;
	}

	public void setNoOccupationList(ArrayList<InfoBean> noOccupationList) {
		this.noOccupationList = noOccupationList;
	}

	public InfoBean getMajorRegion() {
		return majorRegion;
	}

	public void setMajorRegion(InfoBean majorRegion) {
		this.majorRegion = majorRegion;
	}

	public ArrayList<tableObject> getTopOccupation() {
		return topOccupation;
	}

	public void setTopOccupation(ArrayList<tableObject> topOccupation) {
		this.topOccupation = topOccupation;
	}

	public ArrayList<tableObject> getTopNoOccupation() {
		return topNoOccupation;
	}

	public void setTopNoOccupation(ArrayList<tableObject> topNoOccupation) {
		this.topNoOccupation = topNoOccupation;
	}

	public ArrayList<tableObject> getSecondOccupation() {
		return secondOccupation;
	}

	public void setSecondOccupation(ArrayList<tableObject> secondOccupation) {
		this.secondOccupation = secondOccupation;
	}

	public ArrayList<tableObject> getMajorOccupation() {
		return majorOccupation;
	}

	public void setMajorOccupation(ArrayList<tableObject> majorOccupation) {
		this.majorOccupation = majorOccupation;
	}

	public ArrayList<tableObject> getThirdOccupation() {
		return thirdOccupation;
	}

	public void setThirdOccupation(ArrayList<tableObject> thirdOccupation) {
		this.thirdOccupation = thirdOccupation;
	}

	public ArrayList<tableObject> getMajorNoOccupation() {
		return majorNoOccupation;
	}

	public void setMajorNoOccupation(ArrayList<tableObject> majorNoOccupation) {
		this.majorNoOccupation = majorNoOccupation;
	}

	public ArrayList<tableObject> getSecondNoOccupation() {
		return secondNoOccupation;
	}

	public void setSecondNoOccupation(ArrayList<tableObject> secondNoOccupation) {
		this.secondNoOccupation = secondNoOccupation;
	}

	public ArrayList<tableObject> getThirdNoOccupation() {
		return thirdNoOccupation;
	}

	public void setThirdNoOccupation(ArrayList<tableObject> thirdNoOccupation) {
		this.thirdNoOccupation = thirdNoOccupation;
	}

	public ArrayList<tableObject> getFourthNoOccupation() {
		return fourthNoOccupation;
	}

	public void setFourthNoOccupation(ArrayList<tableObject> fourthNoOccupation) {
		this.fourthNoOccupation = fourthNoOccupation;
	}

	public int getRegionNone() {
		return regionNone;
	}

	public void setRegionNone(int regionNone) {
		this.regionNone = regionNone;
	}
}
