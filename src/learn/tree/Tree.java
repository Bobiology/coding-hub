package learn.tree;

public class Tree {

	private class Node {
		private Node leftChild;
		private Node rightChild;
		private int value;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "value=" + value;
		}
	}

	public Node root;

	public void insert(int value) {
		var node = new Node(value);
		if (root == null) {
			root = node;
			return;
		}

		var current = root;
		while (true) {
			if (value > current.value) {
				if (current.rightChild == null) {
					current.rightChild = node;
					break;
				}
				current = current.rightChild;
			} else {
				if (current.leftChild == null) {
					current.leftChild = node;
					break;
				}
				current = current.leftChild;
			}
		}

	}

	public boolean find(int value) {
		if (root == null)
			return false;

		var current = root;
		while (current != null) {
			if (value > current.value)
				current = current.rightChild;

			else if (value < current.value)
				current = current.leftChild;
			else
				return true;

		}
		return false;
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(root); 
	}
	
	private void preOrderTraversal(Node node) {
		if(node == null)
			return;
		System.out.println(node.value + " ");
		preOrderTraversal(node.leftChild);
		preOrderTraversal(node.rightChild);
	}
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}
	private void inOrderTraversal(Node node) {
		if(node == null)
			return;
		
		inOrderTraversal(node.leftChild);
		System.out.println(node.value);
		inOrderTraversal(node.rightChild);
	}
	public void posOrderTraversal() {
		postOrderTraversal(root);
	}
	private void postOrderTraversal(Node node) {
		if(node == null)
			return;
		
		postOrderTraversal(node.leftChild);
		postOrderTraversal(node.rightChild);
		System.out.println(node.value);
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(Node node) {
		if(node == null)
			return -1;
		
		if(isLeaf(node))
			return 0;
		return 1 + Math.max(height(node.leftChild), height(node.rightChild));
	}
	public int min() {
		//return min(root);
		if(root == null)
			throw new IllegalStateException();
		
		var current = root;
		var last = current;
		while(current != null) {
			last = current;
			current = current.leftChild;
		}
		//return last.value;
		return min(root);
	}
	private int min(Node node) {
		if(isLeaf(node))
			return node.value;
		
		var left = min(node.leftChild);
		var right = min(node.rightChild);
		
		return Math.min(Math.min(left, right), node.value);
	}
	public int max() {
		return max(root);
	}
	private int max(Node node) {
		if(isLeaf(node))
			return node.value;
		var left = max(node.leftChild);
		var right = max(node.rightChild);
		return Math.max(Math.max(left, right),node.value);
	}
	
	private boolean isLeaf(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}

}
