package CSVProcess;
import javafx.beans.property.*;

public class InfoBean {
	String region;
	int total, specialOccupation,
	officials, professionals;
	int technicians, clerks,
	serviceWorkers, farmers, trades;
	int operators, laborers, none,
	noAnswer;
	
	public SimpleStringProperty regionView;
	public SimpleIntegerProperty totalView, specialOccupationView,officialsView,professionalsView;
	public SimpleIntegerProperty techniciansView, clerksView, serviceWorkersView, farmersView, tradesView;
	public SimpleIntegerProperty operatorsView, laborersView, noneView, noAnswerView;
	
	public void populateView(){
		this.regionView = new SimpleStringProperty(this.region);
		this.totalView = new SimpleIntegerProperty(this.total);
		this.specialOccupationView = new SimpleIntegerProperty(this.specialOccupation);
		this.officialsView = new SimpleIntegerProperty(this.officials);
		this.professionalsView = new SimpleIntegerProperty(this.professionals);
		this.techniciansView = new SimpleIntegerProperty(this.technicians);
		this.clerksView = new SimpleIntegerProperty(this.clerks);
		this.serviceWorkersView = new SimpleIntegerProperty(this.serviceWorkers);
		this.farmersView = new SimpleIntegerProperty(this.farmers); 
		this.tradesView = new SimpleIntegerProperty(this.trades);
		this.operatorsView = new SimpleIntegerProperty(this.operators);
		this.laborersView = new SimpleIntegerProperty(this.laborers);
		this.noneView = new SimpleIntegerProperty(this.none);
		this.noAnswerView = new SimpleIntegerProperty(this.noAnswer);
	}


	public String getRegion() {
		return region;
	}

	public String getRegionColumnName() {
		return "Region";
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public int getTotal() {
		return total;
	}
	
	public String getTotalColumnName() {
		return "Total";
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getSpecialOccupation() {
		return specialOccupation;
	}
	
	public String getSpecialOccupationColumnName() {
		return "Special Occupation";
	}
	
	public void setSpecialOccupation(int specialOccupation) {
		this.specialOccupation = specialOccupation;
	}

	public int getOfficials() {
		return officials;
	}

	public String getOfficialsColumnName() {
		return "Gov't and Special Interest Organization Officials";
	}

	public void setOfficials(int officials) {
		this.officials = officials;
	}

	public int getProfessionals() {
		return professionals;
	}

	public String getProfessionalsColumnName() {
		return "Professionals";
	}

	public void setProfessionals(int professionals) {
		this.professionals = professionals;
	}

	public int getTechnicians() {
		return technicians;
	}

	public String getTechniciansColumnName() {
		return "Technicians and Associate Professionals";
	}

	public void setTechnicians(int technicians) {
		this.technicians = technicians;
	}

	public int getClerks() {
		return clerks;
	}

	public String getClerksColumnName() {
		return "Clerks";
	}

	public void setClerks(int clerks) {
		this.clerks = clerks;
	}

	public int getServiceWorkers() {
		return serviceWorkers;
	}

	public String getServiceWorkersColumnName() {
		return "Service Workers and Shops and Market Sales Workers";
	}

	public void setServiceWorkers(int serviceWorkers) {
		this.serviceWorkers = serviceWorkers;
	}

	public int getFarmers() {
		return farmers;
	}

	public String getFarmersColumnName() {
		return "Farmers, Forestry, Workers and Fishermen";
	}

	public void setFarmers(int farmers) {
		this.farmers = farmers;
	}

	public int getTrades() {
		return trades;
	}

	public String getTradesColumnName() {
		return "Trades and Related Works";
	}

	public void setTrades(int trades) {
		this.trades = trades;
	}

	public int getOperators() {
		return operators;
	}

	public String getOperatorsColumnName() {
		return "Plants and Machine Operators and Assemblers";
	}

	public void setOperators(int operators) {
		this.operators = operators;
	}

	public int getLaborers() {
		return laborers;
	}

	public String getLaborersColumnName() {
		return "Laborers and Unskilled Workers";
	}

	public void setLaborers(int laborers) {
		this.laborers = laborers;
	}

	public int getNone() {
		return none;
	}

	public String getNoneColumnName() {
		return "None";
	}

	public void setNone(int none) {
		this.none = none;
	}

	public int getNoAnswer() {
		return noAnswer;
	}

	public String getNoAnswerColumnName() {
		return "No Answer";
	}

	public void setNoAnswer(int noAnswer) {
		this.noAnswer = noAnswer;
	}
	
	@Override
	public String toString() {
		return "[region=" + region + ", total=" + total + ", specialOccupation=" + specialOccupation
				+ ", officials=" + officials + ", professionals=" + professionals + ", technicians=" + technicians
				+ ", clerks=" + clerks + ", serviceWorkers=" + serviceWorkers + ", farmers=" + farmers + ", trades="
				+ trades + ", operators=" + operators + ", laborers=" + laborers + ", none=" + none + ", noAnswer="
				+ noAnswer + "]";
	}


	
	
	
}
