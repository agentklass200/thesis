package documentPlanning;

import java.util.ArrayList;

public class DPobj {
	private String type, object;
	private boolean areChildrenExist;
	private boolean	isRoot;
	
	private DPobj parent;
	private ArrayList<DPobj> children;
	
	public DPobj(String type, String obj){
		this.object = obj;
		this.type = type;
		areChildrenExist = false;
		isRoot = true;
	}
	
	public DPobj(String type, String obj, DPobj parent){
		this.object = obj;
		this.type = type;
		this.setParent(parent);
		areChildrenExist = false;
		isRoot = false;
	}
	
	public DPobj(String type, String obj, DPobj parent, ArrayList<DPobj> children){
		this.object = obj;
		this.type = type;
		this.parent = parent;
		this.children = children;
		this.areChildrenExist = true;
		this.isRoot = false;
	}
	
	public void addChild(DPobj child){
		children.add(child);
		this.areChildrenExist = true;
	}
	
	public boolean areChildExist() {
		return areChildrenExist;
	}
	

	public void setAreChildExist(boolean isChildExist) {
		this.areChildrenExist = isChildExist;
	}


	public boolean isRoot() {
		return isRoot;
	}


	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public DPobj getParent() {
		return parent;
	}

	public void setParent(DPobj parent) {
		this.parent = parent;
	}

	public ArrayList<DPobj> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<DPobj> children) {
		this.children = children;
	}
}
