package incremental;

import struct.Node;
import struct.Tree;
import java.util.List;
import user.Config;

import CSVProcess.InfoBean;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import incremental.treeTraversal;
import data.Corpus;
import data.determiner;


public class initializeTree {
	
	public static String ROOT = "root";
	private Node<nodeObject> root = new Node<nodeObject>(new nodeObject(nodeObject.TEXT_STRUCTURE, ROOT, null, 0));
	private ArrayList<Node<nodeObject>> traversalList;
	private determiner tableData;
	DecimalFormat numberFormat = new DecimalFormat("0.00");
	DecimalFormat whole = new DecimalFormat("###,###,###");
	Config user;
	
	public initializeTree(ArrayList<InfoBean> data, Config user){
		for(int i = 0;  i < 4; i++){
			root.addChild(new Node<nodeObject>(new nodeObject(nodeObject.CATEGORY, "category-" + i, null, i)));
		}
		this.user = user;
		tableData = new determiner(data, user);
		root.getChildAt(0).setChildren(this.firstCategory(root));
		root.getChildAt(1).setChildren(this.secondCategory(root));
		if(tableData.withTies()){
			root.getChildAt(2).setChildren(this.withTiesCategory(root));
		}
		else{
			root.getChildAt(2).setChildren(this.thirdCategory(root));
		}
		
		treeTraversal traversal = new treeTraversal(treeTraversal.PRE_ORDER, root);
		traversalList = traversal.getTraversalList();
		
		
	}
	
	public ArrayList<Node<nodeObject>> getList(){
		return traversalList;
	}
	
	
	public ArrayList<Node<nodeObject>> firstCategory(Node<nodeObject> root){
		int chooser = (int) Math.floor((Math.random() * 2) + 1);
		ArrayList<Node<nodeObject>> messages = new ArrayList<Node<nodeObject>>();
		switch(chooser){
			case 1:
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 0, null, 0)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 1, null, 1)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 2, null, 2)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 3, null, 3)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 4, null, 4)));
				messages.get(0).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"In " + tableData.getMajorRegion().getRegion() + ", the occupation with the " + Corpus.ranking(user) + " ",
						0)));
				messages.get(1).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"number of respondent count is " + tableData.getMajorOccupation().get(0).getObjectName().toLowerCase() + ", ",
						0)));
				messages.get(2).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"with " + whole.format(tableData.getMajorOccupation().get(0).getValue()) + " (" + numberFormat.format(((double)tableData.getMajorOccupation().get(0).getValue()/(double)tableData.majorOccupationTotal)*100) + "%) " + Corpus.modifierRespondents() + ". ",
						0)));
				messages.get(3).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"Ranking second is " + tableData.getMajorOccupation().get(1).getObjectName().toLowerCase() + " with ",
						0)));
				messages.get(4).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						whole.format(tableData.getMajorOccupation().get(1).getValue()) + " (" + numberFormat.format(((double)tableData.getMajorOccupation().get(1).getValue()/(double)tableData.majorOccupationTotal)*100) + "%) " + Corpus.modifierRespondents() + ". \n\n",
						0)));
				break;
			case 2:
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 0, null, 0)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 1, null, 1)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 2, null, 2)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 3, null, 3)));
				messages.get(0).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"A " + Corpus.ranking1(user) + " of the " + Corpus.modifierRespondents() + " in " + tableData.getMajorRegion().getRegion() + " are " + tableData.getMajorOccupation().get(0).getObjectName().toLowerCase() + ", ",
						0)));
				messages.get(1).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"with " + whole.format(tableData.getMajorOccupation().get(0).getValue()) + " (" + numberFormat.format(((double)tableData.getMajorOccupation().get(0).getValue()/(double)tableData.majorOccupationTotal)*100) + "%) " + Corpus.modifierRespondents() + ". ",
						0)));
				messages.get(2).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"The occupation with the next " + Corpus.ranking(user) + " count is " + tableData.getMajorOccupation().get(1).getObjectName().toLowerCase() + " ",
						0)));
				messages.get(3).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"with " + whole.format(tableData.getMajorOccupation().get(1).getValue()) + " (" + numberFormat.format(((double)tableData.getMajorOccupation().get(1).getValue()/(double)tableData.majorOccupationTotal)*100) + "%) " + Corpus.modifierRespondents() + ". \n\n",
						0)));
				break;
			default:
				
		}
		
		
		return messages;
	}
	
	public ArrayList<Node<nodeObject>> secondCategory(Node<nodeObject> root){
		int chooser = (int) Math.floor((Math.random() * 2) + 1);
		ArrayList<Node<nodeObject>> messages = new ArrayList<Node<nodeObject>>();
		switch(chooser){
			case 1:
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 0, null, 0)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 1, null, 1)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 2, null, 2)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 3, null, 3)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 4, null, 4)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 5, null, 5)));
				messages.get(0).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"The number of " + Corpus.modifierPoor() + " " + Corpus.modifierHouseholds() + " ",
						0)));
				messages.get(1).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"that listed no occupation or ‘none’ in the table " + Corpus.modifierComprises() + " ",
						0)));
				messages.get(2).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						whole.format(tableData.regionNone) + " (" + numberFormat.format(((double)tableData.regionNone/(double)tableData.majorOccupationTotal)*100) + "%) " + Corpus.modifierRespondents() + ". ",
						0)));
				messages.get(3).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"The " + Corpus.ranking(user) + " number of " + Corpus.modifierHouseholds() + " that are listed under “no occupation“  are in " + tableData.getNoOccupationList().get(0).getRegion() + ", ",
						0)));
				messages.get(4).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"" + tableData.getNoOccupationList().get(1).getRegion() + ", " + tableData.getNoOccupationList().get(2).getRegion() + ", ",
						0)));
				messages.get(5).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"" + tableData.getNoOccupationList().get(3).getRegion() + " and " + tableData.getNoOccupationList().get(4).getRegion() + ". \n\n",
						0)));
				break;
			case 2:
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 0, null, 0)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 1, null, 1)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 2, null, 2)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 3, null, 3)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 4, null, 4)));
				messages.get(0).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"The following are the cities that that have " + Corpus.ranking2(user) + " of “no occupation” or “none” in descending order: " + tableData.getNoOccupationList().get(0).getRegion() + " ",
						0)));
				messages.get(1).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"(" + whole.format(tableData.noOccupationRanking.get(0)) + " or " + numberFormat.format(((double)tableData.noOccupationRanking.get(0)/(double)tableData.occupationRanking.get(0))*100) + "%),  " + tableData.getNoOccupationList().get(1).getRegion() + "  (" + whole.format(tableData.noOccupationRanking.get(1)) + " or " + numberFormat.format(((double)tableData.noOccupationRanking.get(1)/(double)tableData.occupationRanking.get(1))*100) + "%), ",
						0)));
				messages.get(2).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"" + tableData.getNoOccupationList().get(2).getRegion() + "  (" + whole.format(tableData.noOccupationRanking.get(2)) + " or " + numberFormat.format(((double)tableData.noOccupationRanking.get(2)/(double)tableData.occupationRanking.get(2))*100) + "%), " + tableData.getNoOccupationList().get(3).getRegion() + " ",
						0)));
				messages.get(3).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"(" + whole.format(tableData.noOccupationRanking.get(3)) + " or " + numberFormat.format(((double)tableData.noOccupationRanking.get(3)/(double)tableData.occupationRanking.get(3))*100) + "%), and " + tableData.getNoOccupationList().get(4).getRegion() + "  (" + whole.format(tableData.noOccupationRanking.get(4)) + " or " + numberFormat.format(((double)tableData.noOccupationRanking.get(4)/(double)tableData.occupationRanking.get(4))*100) + "%). \n\n",
						0)));
				break;
			default:
		}
		
		return messages;
	}
	
	public ArrayList<Node<nodeObject>> thirdCategory(Node<nodeObject> root){
		int chooser = (int) Math.floor((Math.random() * 1) + 1);
		ArrayList<Node<nodeObject>> messages = new ArrayList<Node<nodeObject>>();
		switch(chooser){
			case 1:
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 0, null, 0)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 1, null, 1)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 2, null, 2)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 3, null, 3)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 4, null, 4)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 5, null, 5)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 6, null, 6)));
				messages.get(0).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						 "The area with the " + Corpus.ranking3(user) + " " + Corpus.modifierNumber() + " ",
						0)));
				messages.get(1).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"of " + Corpus.modifierRespondents() + " is " + tableData.getOccupationList().get(0).getRegion() + ". The top three " + Corpus.ranking4(user) + "occupations in " + tableData.getOccupationList().get(0).getRegion() + " are " + tableData.getTopOccupation().get(0).getObjectName().toLowerCase() + " ",
						0)));
				messages.get(2).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"(" + whole.format(tableData.getTopOccupation().get(0).getValue()) + " ",
						0)));
				messages.get(3).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"or " + numberFormat.format((((double)tableData.getTopOccupation().get(0).getValue()/(double)tableData.occupationRanking.get(0)) *100 )) + "%); " + tableData.getTopOccupation().get(1).getObjectName().toLowerCase() + " (" + whole.format(tableData.getTopOccupation().get(1).getValue()) + " ",
						0)));
				messages.get(4).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"or " + numberFormat.format((((double)tableData.getTopOccupation().get(1).getValue()/(double)tableData.occupationRanking.get(1)) *100 )) + "%); and " + tableData.getTopOccupation().get(2).getObjectName().toLowerCase() + " ",
						0)));
				messages.get(5).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"(" + whole.format(tableData.getTopOccupation().get(2).getValue()) + " or " + numberFormat.format((((double)tableData.getTopOccupation().get(2).getValue()/(double)tableData.occupationRanking.get(2)) *100 )) + "%). \n\n",
						0)));
				break;
			default:
		}
		
		
		return messages;
	}
	
	
	public ArrayList<Node<nodeObject>> withTiesCategory(Node<nodeObject> root){
		int chooser = (int) Math.floor((Math.random() * 1) + 1);
		ArrayList<Node<nodeObject>> messages = new ArrayList<Node<nodeObject>>();
		switch(chooser){
			case 1:
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 0, null, 0)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 1, null, 1)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 2, null, 2)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 3, null, 3)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 4, null, 4)));
				messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 5, null, 5)));
				messages.get(0).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						Corpus.forIn() + " " + tableData.getOccupationList().get(1).getRegion() + ", " + whole.format(tableData.getTopOccupation().get(1).getValue()) + " ",
						0)));
				messages.get(1).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"(" + numberFormat.format((((double)tableData.getTopOccupation().get(1).getValue()/(double)tableData.getTopOccupation().get(0).getValue()) *100 )) + "%) of the " + Corpus.modifierRespondents() + " are " + tableData.getTopOccupation().get(1).getObjectName().toLowerCase() + ". ",
						0)));
				messages.get(2).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"Next " + Corpus.modifierRespondents() + " being " + tableData.getTopOccupation().get(2).getObjectName().toLowerCase() + ", ",
						0)));
				messages.get(3).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"with " + whole.format(tableData.getTopOccupation().get(2).getValue()) + " (" + numberFormat.format((((double)tableData.getTopOccupation().get(2).getValue()/(double)tableData.getTopOccupation().get(0).getValue()) *100 )) + "%). ",
						0)));
				messages.get(4).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"Third being " + tableData.getTopOccupation().get(3).getObjectName().toLowerCase() + ", with " + whole.format(tableData.getTopOccupation().get(3).getValue()) + " ",
						0)));
				messages.get(5).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
						"value",
						"(" + numberFormat.format((((double)tableData.getTopOccupation().get(3).getValue()/(double)tableData.getTopOccupation().get(0).getValue()) *100 )) + "%). \n\n",
						0)));
				break;
			default:
		}
		
		return messages;
	}
}
