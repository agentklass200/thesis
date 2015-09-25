package documentPlanning;

import java.util.ArrayList;

public class DocumentTreeBuilder {
	private ArrayList<DPobj> tree;
	
	private DocumentStructure root;
	private ArrayList<ParagraphStructure> paraStruct;
	private ArrayList<Messages> messages;
	
	public DocumentTreeBuilder(){
		root = new DocumentStructure("DocumentStructure");
		tree.add(root);
	}
	
	public void populateParagraphStructure(ArrayList<ParagraphStructure> paraStruct){
		this.paraStruct = paraStruct;
	}
	
	public void populateMessages(ArrayList<Messages> messages){
		this.messages = messages;
	}


}
