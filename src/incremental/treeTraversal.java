package incremental;

import struct.Node;
import struct.Tree;
import java.util.ArrayList;

import incremental.nodeObject;

public class treeTraversal {
	public static final String POST_ORDER = "post-order";
	public static final String PRE_ORDER = "pre-order";
	private Tree<nodeObject> tree;
	private ArrayList<Node<nodeObject>> traversalList;

	public treeTraversal(String traversal, Node<nodeObject> root){
		this.tree = new Tree<nodeObject>(root);
		switch(traversal){
			case POST_ORDER:
				traversalList = tree.getPostOrderTraversal();
				break;
			case PRE_ORDER:
				traversalList = tree.getPreOrderTraversal();
				break;
			default:
				System.out.println("ERROR");
		}
	}
	
	public ArrayList<Node<nodeObject>> getTraversalList(){
		return traversalList;
	}
}
