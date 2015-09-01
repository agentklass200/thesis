package data;

import java.util.ArrayList;
import CSVProcess.InfoBean;

public class ColumnData {
	private int Ttotal, TspecialOccupation, Tofficials, Tprofessionals;
	private int Ttechnicians, Tclerks, TserviceWorkers, Tfarmers, Ttrades;
	private int Toperators, Tlaborers, Tnone, TnoAnswer;

	private int noOfColumns;
	
	ColumnData(ArrayList<InfoBean> data){
		this.noOfColumns = data.size();
		this.setTtotal(data);
		this.setTspecialOccupation(data);
		this.setTclerks(data);
		this.setTfarmers(data);
		this.setTlaborers(data);
		this.setTnoAnswer(data);
		this.setTnone(data);
		this.setTofficials(data);
		this.setToperators(data);
		this.setTprofessionals(data);
		this.setTserviceWorkers(data);
		this.setTtechnicians(data);
		this.setTtrades(data);
	}
	
	public int getTtotal() {
		return Ttotal;
	}

	public double getTotalPercentage(InfoBean row) {
		return (row.getTotal()/Ttotal) * 100;
	}

	public void setTtotal(ArrayList<InfoBean> data) {
		for(int i = 0; i < noOfColumns; i++){
			this.Ttotal = this.Ttotal + data.get(i).getTotal();
		}
	}
	public int getTspecialOccupation() {
		return TspecialOccupation;
	}

	public double getSpecialOccupationPercentage(InfoBean row) {
		return (row.getSpecialOccupation()/TspecialOccupation) * 100;
	}

	public void setTspecialOccupation(ArrayList<InfoBean> data) {
		for(int i = 0; i < noOfColumns; i++){
			this.TspecialOccupation = this.TspecialOccupation + data.get(i).getSpecialOccupation();
		}
	}

	public int getTofficials() {
		return Tofficials;
	}

	public double getOfficialsPercentage(InfoBean row) {
		return (row.getOfficials()/Tofficials) * 100;
	}

	public void setTofficials(ArrayList<InfoBean> data) {
		for(int i = 0; i < noOfColumns; i++){
			this.Tofficials = this.Tofficials + data.get(i).getOfficials();
		}
	}

	public int getTprofessionals() {
		return Tprofessionals;
	}

	public double getProfessionalsPercentage(InfoBean row) {
		return (row.getProfessionals()/Tprofessionals) * 100;
	}

	public void setTprofessionals(ArrayList<InfoBean> data) {
		for(int i = 0; i < noOfColumns; i++){
			this.Tprofessionals = this.Tprofessionals + data.get(i).getProfessionals();
		}
	}

	public int getTtechnicians() {
		return Ttechnicians;
	}

	public double getTechniciansPercentage(InfoBean row) {
		return (row.getTechnicians()/Ttechnicians) * 100;
	}

	public void setTtechnicians(ArrayList<InfoBean> data) {
		for(int i = 0; i < noOfColumns; i++){
			this.Ttechnicians = this.Ttechnicians + data.get(i).getTechnicians();
		}
	}

	public int getTclerks() {
		return Tclerks;
	}

	public double getClerksPercentage(InfoBean row) {
		return (row.getClerks()/Tclerks) * 100;
	}


	public void setTclerks(ArrayList<InfoBean> data) {
		for (int i = 0; i < noOfColumns; i++){
			this.Tclerks = this.Tclerks + data.get(i).getClerks();
		}
	}

	public int getTserviceWorkers() {
		return TserviceWorkers;
	}

	public double getServiceWorkersPercentage(InfoBean row) {
		return (row.getServiceWorkers()/TserviceWorkers) * 100;
	}

	public void setTserviceWorkers(ArrayList<InfoBean> data) {
		for (int i = 0; i < noOfColumns; i++){
			this.TserviceWorkers = this.TserviceWorkers + data.get(i).getServiceWorkers();
		}
	}

	public int getTfarmers(){
		return Tfarmers;
	}

	public double getFarmersPercentage(InfoBean row) {
		return (row.getFarmers()/Tfarmers) * 100;
	}

	public void setTfarmers(ArrayList<InfoBean> data) {
		for (int i = 0; i < noOfColumns; i++){
			this.Tfarmers = this.Tfarmers + data.get(i).getFarmers();
		}
	}

	public int getTtrades() {
		return Ttrades;
	}

	public double getTradesPercentage(InfoBean row) {
		return (row.getTrades()/Ttrades) * 100;
	}

	public void setTtrades(ArrayList<InfoBean> data) {
		for (int i = 0; i < noOfColumns; i++){
			this.Ttrades = this.Ttrades + data.get(i).getTrades();
		}
	}

	public int getToperators() {
		return Toperators;
	}

	public double getOperatorsPercentage(InfoBean row) {
		return (row.getOperators()/Toperators) * 100;
	}

	public void setToperators(ArrayList<InfoBean> data) {
		for (int i = 0; i < noOfColumns; i++){
			this.Toperators = this.Toperators + data.get(i).getOperators();
		}
	}

	public int getTlaborers() {
		return Tlaborers;
	}

	public double getLaborersPercentage(InfoBean row) {
		return (row.getLaborers()/Tlaborers) * 100;
	}

	public void setTlaborers(ArrayList<InfoBean> data) {
		for (int i = 0; i < noOfColumns; i++){
			this.Tlaborers = this.Tlaborers + data.get(i).getLaborers();
		}
	}

	public int getTnone() {
		return Tnone;
	}

	public double getNonePercentage(InfoBean row) {
		return (row.getNone()/Tnone) * 100;
	}

	public void setTnone(ArrayList<InfoBean> data) {
		for (int i = 0; i < noOfColumns; i++){
			this.Tnone = this.Tnone + data.get(i).getNone();
		}
	}

	public int getTnoAnswer() {
		return TnoAnswer;
	}

	public double getNoAnswerPercentage(InfoBean row) {
		return (row.getNoAnswer()/TnoAnswer) * 100;
	}

	public void setTnoAnswer(ArrayList<InfoBean> data) {
		for (int i = 0; i < noOfColumns; i++){
			this.TnoAnswer = this.TnoAnswer + data.get(i).getNoAnswer();
		}
	}

}
