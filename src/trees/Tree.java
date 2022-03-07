package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
	private class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node=" + value;
		}
	}

	private Node root;
	static int result = -1;
	static int maxLevel = -1;

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
		var current = root;
		while (current != null) {
			if (value < current.value) {
				current = current.leftChild;
			} else if (value > current.value) {
				current = current.rightChild;
			} else
				return true;
		}
		return false;
	}

	// ROOT - LEFT - RIGHT
	public void traversePreOrder() {
		traversePreOrder(root);
		System.out.println();
	}

	private void traversePreOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.value + " ");
		traversePreOrder(root.leftChild);
		traversePreOrder(root.rightChild);
	}

	// LEFT - ROOT - RIGHT
	public void traverseInOrder() {
		traverseInOrder(root);
		System.out.println();
	}

	private void traverseInOrder(Node root) {
		if (root == null)
			return;

		traverseInOrder(root.leftChild);
		System.out.print(root.value + " ");
		traverseInOrder(root.rightChild);

	}

	// LEFT - RIGHT - ROOT
	public void traversePostOrder() {
		traversePostOrder(root);
		System.out.println();
	}

	private void traversePostOrder(Node root) {
		if (root == null)
			return;

		traversePostOrder(root.leftChild);
		traverseInOrder(root.rightChild);
		System.out.print(root.value + " ");
	}

	public int height() {
		return height(root);
	}

	private int height(Node root) {
		if (root == null)
			return -1;

		if (isLeaf(root))
			return 0;

		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}

	public int min() {
		return min(root);
	}

	public int max() {
		return max(root);
	}

	private int max(Node root) {
		if (isLeaf(root))
			return root.value;

		var left = max(root.leftChild);
		var right = max(root.rightChild);

		return Math.max(Math.max(left, right), root.value);
	}

	private int min(Node root) {
		if (isLeaf(root))
			return root.value;

		var left = min(root.leftChild);
		var right = min(root.rightChild);

		return Math.min(Math.min(left, right), root.value);
	}

	private boolean isLeaf(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}

	public boolean equals(Tree other) {
		if (other == null)
			return false;

		return equals(root, other.root);
	}

	private boolean equals(Node first, Node second) {
		if (first == null && second == null)
			return true;

		if (first != null && second != null)
			return first.value == second.value && equals(first.leftChild, second.leftChild)
					&& equals(first.rightChild, second.rightChild);
		return false;
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBinarySearchTree(Node root, int min, int max) {
		if (root == null)
			return true;

		if (root.value < min || root.value > max)
			return false;

		return isBinarySearchTree(root.leftChild, min, root.value - 1)
				&& isBinarySearchTree(root.rightChild, root.value + 1, max);
	}

	public ArrayList<Integer> getNodesAtDistance(int distance) {
		var list = new ArrayList<Integer>();
		getNodesAtDistance(root, distance, list);

		return list;
	}

	private void getNodesAtDistance(Node root, int distance, List<Integer> list) {
		if (root == null)
			return;

		if (distance == 0) {
			list.add(root.value);
			return;
		}

		getNodesAtDistance(root.leftChild, distance - 1, list);
		getNodesAtDistance(root.rightChild, distance - 1, list);
	}

	public void traverseLevelOrder() {
		for (var i = 0; i <= height(); i++) {
			for (var value : getNodesAtDistance(i))
				System.out.println(value);
		}
	}

	public int deepNode() {
		return deepNode(root);
	}

	private int deepNode(Node root) {
		int min = root.value;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		System.out.println(q);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				System.out.println("q size="+size+" i="+i+" current="+curr);
				if (i == 0)
					min = curr.value;
				if (curr.leftChild != null)
					q.offer(curr.leftChild);
				if (curr.rightChild != null)
					q.offer(curr.rightChild);
			}
		}
		return min;
	}

}
