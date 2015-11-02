package incremental;

import struct.Node;
import struct.Tree;
import java.util.List;
import java.io.*;
import java.util.ArrayList;

public class initializeTree {
	
	public static String ROOT = "root";
	Node<nodeObject> root = new Node<nodeObject>(new nodeObject(nodeObject.TEXT_STRUCTURE, ROOT, null, 0));
	Tree<nodeObject> textTree = new Tree<nodeObject>(root);
	
	public initializeTree(){
		for(int i = 0;  i < 3; i++){
			root.addChild(new Node<nodeObject>(new nodeObject(nodeObject.CATEGORY, "category-" + i, null, i)));
		}
		root.getChildAt(0).setChildren(this.firstCategory(root));
		root.getChildAt(1).setChildren(this.secondCategory(root));
		root.getChildAt(2).setChildren(this.thirdCategory(root));
	}
	
	public ArrayList<Node<nodeObject>> firstCategory(Node<nodeObject> root){
		int chooser;
		ArrayList<Node<nodeObject>> messages = new ArrayList<Node<nodeObject>>();
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 0, null, 0)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 1, null, 1)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 2, null, 2)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 3, null, 3)));
		messages.get(0).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"In the region [region-name], ",
				0)));
		messages.get(1).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"a majority of [modifier-poor] households in [highest-count-area] ",
				0)));
		messages.get(2).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"have [highest-occupation-1] or [highest-occupation-2] ",
				0)));
		messages.get(3).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"as their primary [noun-occupation]. \n\n",
				0)));
		return messages;
	}
	
	public ArrayList<Node<nodeObject>> secondCategory(Node<nodeObject> root){
		int chooser;
		ArrayList<Node<nodeObject>> messages = new ArrayList<Node<nodeObject>>();
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 0, null, 0)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 1, null, 1)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 2, null, 2)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 3, null, 3)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 4, null, 4)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 5, null, 5)));
		messages.get(0).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"The number of [modifier-poor] [modifier-households] ",
				0)));
		messages.get(1).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"that listed no occupation [modifier-comprises] ",
				0)));
		messages.get(2).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"[percent value] of [actual-value] of the [modifier-respondents]. ",
				0)));
		messages.get(3).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"These [modifier-households] are [modifier-found] in [no-occupation-area-1], ",
				0)));
		messages.get(4).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"[no-occupation-area-2], [no-occupation-area-3], ",
				0)));
		messages.get(5).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"[no-occupation-area-4] and [no-occupation-area-5]. \n\n",
				0)));
		return messages;
	}
	
	public ArrayList<Node<nodeObject>> thirdCategory(Node<nodeObject> root){
		int chooser;
		ArrayList<Node<nodeObject>> messages = new ArrayList<Node<nodeObject>>();
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 0, null, 0)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 1, null, 1)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 2, null, 2)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 3, null, 3)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 4, null, 4)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 5, null, 5)));
		messages.add(new Node<nodeObject>(new nodeObject(nodeObject.MESSAGE, "message-" + 6, null, 6)));
		messages.get(0).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"For [highest-population-area-n], [actual-value-of-occupation-1] ",
				0)));
		messages.get(1).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"or [percent-value-1] of the [modifier-respondents] are [occupation-1]. ",
				0)));
		messages.get(2).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"Next [modifier-occupation] being [occupation-2], ",
				0)));
		messages.get(3).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"with [actual-value-of-occupation-2] or [percent-value-of-actual-value-2] ",
				0)));
		messages.get(4).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"of the [modifier-respondents]. ",
				0)));
		messages.get(5).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"Third being [occupation-3], with [actual-value-of-occupation-3] ",
				0)));
		messages.get(6).addChild(new Node<nodeObject>(new nodeObject(nodeObject.VALUE,
				"value",
				"or [percent-value-of-actual-value-3]. \n\n",
				0)));
		return messages;
	}
}
