package user;

public class Config {
	public static final int HIGHEST_AREA_HIGHEST_OCCU = 0;
	public static final int HIGHEST_AREA_LOWEST_OCCU = 1;
	public static final int LOWEST_AREA_HIGHEST_OCCU = 2;
	public static final int LOWEST_AREA_LOWEST_OCCU = 3;
	
	private int modeVariants;
	private String src;
	
	public Config(){
		this.modeVariants = 0;
		this.src = "";
	}

	public int getModeVariants() {
		return modeVariants;
	}

	public void setModeVariants(int modeVariants) {
		this.modeVariants = modeVariants;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	public String getMode(){
		int mode = this.getModeVariants();
		switch(mode){
			case 0:
				return "Highest Area | Highest Occupation";
			case 1:
				return "Highest Area | Lowest Occupation";
			case 2:
				return "Lowest Area | Highest Occupation";
			case 3:
				return "Lowest Area | Lowest Occupation";
			default:
				return "";
		}
	}
}
