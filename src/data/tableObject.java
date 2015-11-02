package data;

public class tableObject {
	private String objectName;
	private int value;
	
	public tableObject(String objectName, int value){
		this.objectName = objectName;
		this.value = value;
	}
	
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
