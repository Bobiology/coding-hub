package revision;

import java.util.ArrayList;

/*
 * Creating a binary search tree
 * 
 */
public class BinaryTree {
	private Node root;

	private class Node {
		private Node left;
		private Node right;
		private int value;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node=" + value;
		}
	}

	// 1-2-3-4-5-6
	public void populateTree(int value) {
		Node node = new Node(value);
		if (root == null) {
			root = node;
			return;
		}

		var current = root;
		while(true) {
			if (value < root.value) {
				if (current.left == null) {
					current.left = node;
					break;
				}
				current = current.left;
				
			} else {
				if (current.right == null) {
					current.right = node;
					break;
				}
				current = current.right;

			}
		}
			

	}
	
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node node) {
		if(node == null) return;
		
		inOrderTraversal(node.left);
		System.out.print(node.value +" ");
		//list.add(node.value);
		inOrderTraversal(node.right);
		
	}
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}
	
	//ROOT - L - RIGHT
	private void preOrderTraversal(Node root) {
		if(root == null) return;
		System.out.print(root.value +" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		
	}
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}
	//LEFT - RIGHT - ROOT
	private void postOrderTraversal(Node root) {
		if(root == null) return;
		
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.value +" ");
	}
	
	public boolean find(int value) {
		if(root == null)return false;
		
		var current = root;
		while(current != null) {
			if(value == current.value) {
				return true;
			}else if(current.value > value) {
				current = current.left;
				root = current;
			}else{
				current = current.right;
				root = current;
			}	
		}
		return false;
		
	}
	public void reverse() {
		reverse(root);
	}
	
	private void reverse(Node root) {
		if(root == null) return;
		
		var current = root;
		var left = current.left;
		var right = current.right;
		while(true) {
			current.right = left;
			current.left = right;
			root = current;
			return;
		}
	}
/*
 * 
 * 			    10
 * 			5		 20
 * 		  3   7   12	21
 */
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.populateTree(10);
		bt.populateTree(5);
		bt.populateTree(20);
		bt.populateTree(7);
		bt.populateTree(3);
		bt.populateTree(12);
		bt.populateTree(21);
		
		bt.preOrderTraversal();
		bt.reverse();
		System.out.println();
		System.out.println();
		bt.preOrderTraversal();
		System.out.println();
		System.out.println(bt.find(21));
		
	}

}
