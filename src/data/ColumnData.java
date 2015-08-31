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
	}
	
	public int getTtotal() {
		return Ttotal;
	}

	public double getTotalPercentage() {
		return (Ttotal / noOfColumns) * 100;
	}

	public void setTtotal(int[] Ttotal) {
		for(int i = 0; i < noOfColumns; i++){
			this.Ttotal = this.Ttotal + Ttotal[i];
		}
	}

	public int getTspecialOccupation() {
		return TspecialOccupation;
	}

	public double getSpecialOccupationPercentage() {
		return (TspecialOccupation / noOfColumns) * 100;
	}

	public void setTspecialOccupation(int[] TspecialOccupation) {
		for(int i = 0; i < noOfColumns; i++){
			this.TspecialOccupation = this.TspecialOccupation + TspecialOccupation[i];
		}
	}

	public int getTofficials() {
		return Tofficials;
	}

	public double getOfficialsPercentage() {
		return (Tofficials / noOfColumns) * 100;
	}

	public void setTofficials(int[] Tofficials) {
		for(int i = 0; i < noOfColumns; i++){
			this.Tofficials = this.Tofficials + Tofficials[i];
		}
	}

	public int getTprofessionals() {
		return Tprofessionals;
	}

	public double getProfessionalsPercentage() {
		return (Tprofessionals / noOfColumns) * 100;
	}

	public void setTprofessionals(int[] Tprofessionals) {
		for(int i = 0; i < noOfColumns; i++){
			this.Tprofessionals = this.Tprofessionals + Tprofessionals[i];
		}
	}

	public int getTtechnicians() {
		return Ttechnicians;
	}

	public double getTechniciansPercentage() {
		return (Ttechnicians / noOfColumns) * 100;
	}

	public void setTtechnicians(int[] Ttechnicians) {
		for(int i = 0; i < noOfColumns; i++){
			this.Ttechnicians = this.Ttechnicians + Ttechnicians[i];
		}
	}

	public int getTclerks() {
		return Tclerks;
	}

	public double getClerksPercentage() {
		return (Tclerks / noOfColumns) * 100;
	}


	public void setTclerks(int[] Tclerks) {
		for (int i = 0; i < noOfColumns; i++){
			this.Tclerks = this.Tclerks + Tclerks[i];
		}
	}

	public int getTserviceWorkers() {
		return TserviceWorkers;
	}

	public double getServiceWorkersPercentage() {
		return (TserviceWorkers / noOfColumns) * 100;
	}

	public void setTserviceWorkers(int[] TserviceWorkers) {
		for (int i = 0; i < noOfColumns; i++){
			this.TserviceWorkers = this.TserviceWorkers + TserviceWorkers[i];
		}
	}

	public int getTfarmers(){
		return Tfarmers;
	}

	public double getFarmersPercentage() {
		return (Tfarmers / noOfColumns) * 100;
	}

	public void setTfarmers(int[] Tfarmers) {
		for (int i = 0; i < noOfColumns; i++){
			this.Tfarmers = this.Tfarmers + Tfarmers[i];
		}
	}

	public int getTtrades() {
		return Ttrades;
	}

	public double getTradesPercentage() {
		return (Ttrades / noOfColumns) * 100;
	}

	public void setTtrades(int[] Ttrades) {
		for (int i = 0; i < noOfColumns; i++){
			this.Ttrades = this.Ttrades + Ttrades[i];
		}
	}

	public int getToperators() {
		return Toperators;
	}

	public double getOperatorsPercentage() {
		return (Toperators / noOfColumns) * 100;
	}

	public void setToperators(int[] Toperators) {
		for (int i = 0; i < noOfColumns; i++){
			this.Toperators = this.Toperators + Toperators[i];
		}
	}

	public int getTlaborers() {
		return Tlaborers;
	}

	public double getLaborersPercentage() {
		return (Tlaborers / noOfColumns) * 100;
	}

	public void setCTlaborers(int[] Tlaborers) {
		for (int i = 0; i < noOfColumns; i++){
			this.Tlaborers = this.Tlaborers + Tlaborers[i];
		}
	}

	public int getTnone() {
		return Tnone;
	}

	public double getNonePercentage() {
		return (Tnone / noOfColumns) * 100;
	}

	public void setTnone(int[] Tnone) {
		for (int i = 0; i < noOfColumns; i++){
			this.Tnone = this.Tnone + Tnone[i];
		}
	}

	public int getTnoAnswer() {
		return TnoAnswer;
	}

	public double getNoAnswerPercentage() {
		return (TnoAnswer / noOfColumns) * 100;
	}

	public void setTnoAnswer(int[] TnoAnswer) {
		for (int i = 0; i < noOfColumns; i++){
			this.TnoAnswer = this.TnoAnswer + TnoAnswer[i];
		}
	}

}
