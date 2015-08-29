package data;

public class columnsTotal {
	private int Ttotal, TspecialOccupation, Tofficials, Tprofessionals;
	private int Ttechnicians, Tclerks, TserviceWorkers, Tfarmers, Ttrades;
	private int Toperators, Tlaborers, Tnone, TnoAnswer;
	
	
	public int getTtotal() {
		return Ttotal;
	}
	public void setTtotal(int[] Ttotal) {
		for(int i = 0; i < Ttotal.length; i++){
			this.Ttotal = this.Ttotal + Ttotal[i];
		}
	}

	public int getTspecialOccupation() {
		return TspecialOccupation;
	}

	public void setTspecialOccupation(int[] TspecialOccupation) {
		for(int i = 0; i < TspecialOccupation.length; i++){
			this.TspecialOccupation = this.TspecialOccupation + TspecialOccupation[i];
		}
	}

	public int getTofficials() {
		return Tofficials;
	}

	public void setTofficials(int[] Tofficials) {
		for(int i = 0; i < Tofficials.length; i++){
			this.Tofficials = this.Tofficials + Tofficials[i];
		}
	}

	public int getTprofessionals() {
		return Tprofessionals;
	}

	public void setTprofessionals(int[] Tprofessionals) {
		for(int i = 0; i < Tprofessionals.length; i++){
			this.Tprofessionals = this.Tprofessionals + Tprofessionals[i];
		}
	}

	public int getTtechnicians() {
		return Ttechnicians;
	}

	public void setTtechnicians(int[] Ttechnicians) {
		for(int i = 0; i < Ttechnicians.length; i++){
			this.Ttechnicians = this.Ttechnicians + Ttechnicians[i];
		}
	}

	// public int getCTclerks() {
	// 	return CTclerks;
	// }

	// public void setCTclerks(int cTclerks) {
	// 	CTclerks = cTclerks;
	// }

	// public int getCTserviceWorkers() {
	// 	return CTserviceWorkers;
	// }

	// public void setCTserviceWorkers(int cTserviceWorkers) {
	// 	CTserviceWorkers = cTserviceWorkers;
	// }

	// public int getCTfarmers() {
	// 	return CTfarmers;
	// }

	// public void setCTfarmers(int cTfarmers) {
	// 	CTfarmers = cTfarmers;
	// }

	// public int getCTtrades() {
	// 	return CTtrades;
	// }

	// public void setCTtrades(int cTtrades) {
	// 	CTtrades = cTtrades;
	// }

	// public int getCToperators() {
	// 	return CToperators;
	// }

	// public void setCToperators(int cToperators) {
	// 	CToperators = cToperators;
	// }

	// public int getCTlaborers() {
	// 	return CTlaborers;
	// }

	// public void setCTlaborers(int cTlaborers) {
	// 	CTlaborers = cTlaborers;
	// }
	// public int getCTnone() {
	// 	return CTnone;
	// }

	// public void setCTnone(int cTnone) {
	// 	CTnone = cTnone;
	// }

	// public int getCTnoAnswer() {
	// 	return CTnoAnswer;
	// }

	// public void setCTnoAnswer(int cTnoAnswer) {
	// 	CTnoAnswer = cTnoAnswer;
	// }


}
