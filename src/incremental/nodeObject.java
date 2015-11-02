package incremental;

public class nodeObject {
	private String type;
	private Object value;
	private boolean identifier;
	private String nodeName;
	private int order;

	
	public static String TEXT_STRUCTURE = "textStructure";
	public static String CATEGORY = "category";
	public static String MESSAGE = "message";
	public static String VALUE = "message-value";
	
	public nodeObject(String type, String nodeName, Object value, int order){
		this.type = type;
		this.nodeName = nodeName;
		this.value = value;
		if(value == null){
			this.identifier = true;
		}
		else{
			this.identifier = false;
		}
		this.order = order;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public boolean isIdentifier() {
		return identifier;
	}
	public void setIdentifier(boolean identifier) {
		this.identifier = identifier;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	
}
