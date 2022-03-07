package data.structure.tree;

public class Tree {
	public static void main(String[] args) {
		Tree tree=new Tree();
		Node root = new Node(5);
		System.out.println("My Binary Tree");
		System.out.println("Building tree with root value "+root.value);
        tree.add(root, 2);
        tree.add(root, 4);
        tree.add(root, 8);
        tree.add(root, 6);
        tree.add(root, 7);
        tree.add(root, 3);
        tree.add(root, 9);
		
		System.out.println("Traversing tree - in order");
		tree.traverseInOrder(root);
		System.out.println(); 
		System.out.println("Traversing tree - pre order");
		tree.traversePreOrder(root);
		System.out.println();
		System.out.println("Traversing tree -  post order");
		tree.traversePostOrder(root);
		System.out.println();
		System.out.println("Traversing tree - level order");
		tree.traverseLevelOrder(root);
		System.out.println();

	}
	static class Node {
		int value;
		Node left, right;

		Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}
	public void add(Node node, int value) {
		if(value<node.value) {
			if(node.left !=null) {
				add(node.left,value);
			}else {
				System.out.println("Added "+value+" to the left of "+node.value);
				node.left=new Node(value);
			}
		}else if(value>node.value) {
			if(node.right !=null) {
				add(node.right,value);
			}else {
				System.out.println("Added "+value+" to the right of "+node.value);
				node.right=new Node(value);
			}
		}
	}
	//Visit left subtree, root & finish with right subtree
	//LTR
	public void traverseInOrder(Node node) {
		if(node !=null) {
			traverseInOrder(node.left);
			System.out.print(" "+node.value);
			traverseInOrder(node.right);
		}
	}
	//TLR
	public void traversePreOrder(Node node) {
		if(node !=null) {
			System.out.print(" "+node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	//LRT
	public void traversePostOrder(Node node) {
		if(node !=null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" "+node.value);
		}
	}
	// BFS
	public void traverseLevelOrder(Node node) {
		if(node !=null) {
			traverseLevelOrder(node.left);
			traverseLevelOrder(node.right);
			System.out.print(" "+node.value);
		}
	}
	
}
