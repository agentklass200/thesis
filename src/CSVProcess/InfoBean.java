package CSVProcess;
import javafx.beans.property.*;

public class InfoBean {
	private String region;
	private int total, specialOccupation,
	officials, professionals;
	private int technicians, clerks,
	serviceWorkers, farmers, trades;
	private int operators, laborers, none,
	noAnswer;
	
	public InfoBean clone(){
		InfoBean b = new InfoBean();
		b.region = this.region;
		b.total =this.total;
		b.specialOccupation = this.specialOccupation;
		b.officials = this.officials;
		b.professionals = this.professionals;
		b.technicians = this.technicians;
		b.clerks = this.clerks;
		b.serviceWorkers = this.serviceWorkers;
		b.farmers = this.farmers;
		b.trades = this.trades;
		b.operators = this.operators;
		b.laborers = this.laborers;
		b.none = this.none;
		b.noAnswer = this.noAnswer;
		return b;
	}

	double specialOccupationRowPercentage, officialsRowPercentage, professionalsRowPercentage, techniciansRowPercentage, 
			clerksRowPercentage, serviceWorkersRowPercentage, farmersRowPercentage, tradesRowPercentage, 
			operatorsRowPercentage, laborersRowPercentage, noneRowPercentage, noAnswerRowPercentage;
	
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


	private void setSpecialOccupationRowPercentage(int total) {
		this.specialOccupationRowPercentage = (this.specialOccupation / total) * 100;
	}


	private void setOfficialsRowPercentage(int total) {
		this.officialsRowPercentage = (this.officials/total) *100;
	}


	private void setProfessionalsRowPercentage(int total) {
		this.professionalsRowPercentage = (this.professionals/total) *100;;
	}


	private void setTechniciansRowPercentage(int total) {
		this.techniciansRowPercentage = (this.technicians/total) *100;;
	}


	private void setClerksRowPercentage(int total) {
		this.clerksRowPercentage = (this.clerks/total) *100;;
	}


	private void setServiceWorkersRowPercentage(int total) {
		this.serviceWorkersRowPercentage = (this.serviceWorkers/total) *100;;
	}


	private void setFarmersRowPercentage(int total) {
		this.farmersRowPercentage = (this.farmers/total) *100;;
	}


	private void setTradesRowPercentage(int total) {
		this.tradesRowPercentage = (this.trades/total) *100;;
	}


	private void setOperatorsRowPercentage(int total) {
		this.operatorsRowPercentage = (this.operators/total) *100;;
	}


	private void setLaborersRowPercentage(int total) {
		this.laborersRowPercentage = (this.laborers/total) *100;;
	}


	private void setNoneRowPercentage(int total) {
		this.noneRowPercentage = (this.none/total) *100;;
	}


	private void setNoAnswerRowPercentage(int total) {
		this.noAnswerRowPercentage = (this.noAnswer/total) *100;;
	}
	
	public void initializeAllRowPercentage(){
		this.setClerksRowPercentage(this.total);
		this.setFarmersRowPercentage(this.total);
		this.setLaborersRowPercentage(this.total);
		this.setNoAnswerRowPercentage(this.total);
		this.setNoneRowPercentage(this.total);
		this.setOfficialsRowPercentage(this.total);
		this.setOperatorsRowPercentage(this.total);
		this.setProfessionalsRowPercentage(this.total);
		this.setServiceWorkersRowPercentage(this.total);
		this.setSpecialOccupationRowPercentage(this.total);
		this.setTechniciansRowPercentage(this.total);
		this.setTradesRowPercentage(this.total);
	}
}
