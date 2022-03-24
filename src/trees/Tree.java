package trees;

import java.util.ArrayList;
import java.util.HashSet;
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

	ArrayList<Integer> left = new ArrayList<>();
	HashSet<Integer> levelSet = new HashSet<>();

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

	/*
	 * Given a binary tree, find its height.
	 * 
	 * Example 1:
	 * 
	 * Input: 1 / \ 2 3 Output: 2
	 * 
	 * 
	 */
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
				System.out.println("q size=" + size + " i=" + i + " current=" + curr);
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

	/*
	 * Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set
	 * of nodes visible when tree is visited from Left side. The task is to complete
	 * the function leftView(), which accepts root of the tree as argument.Left view
	 * of following tree is 1 2 4 8.
	 * 
	 * 1 / \ 2 3 / \ / \ 4 5 6 7 \ 8
	 * 
	 * 
	 * 
	 */
	public ArrayList<Integer> leftView(Node root) {
		ArrayList<Integer> list = new ArrayList<>();
		leftView(root, list, 0);
		return list;
	}

	private void leftView(Node root, ArrayList<Integer> list, int i) {

		if (root == null)
			return;

		if (list.size() == i) {
			list.add(root.value);
		}
		leftView(root.leftChild, list, i + 1);
		leftView(root.rightChild, list, i + 1);
	}
	/*
	 * The diameter of a tree (sometimes called the width) is the number of nodes on
	 * the longest path between two end nodes. The diagram below shows two trees
	 * each with diameter nine, the leaves that form the ends of the longest path
	 * are shaded (note that there is more than one path in each tree of length
	 * nine, but no path longer than nine nodes).
	 * 
	 * Example 1:
	 * 
	 * Input: 1 / \ 2 3 Output: 3 Example 2:
	 * 
	 * Input: 10 / \ 20 30 / \ 40 60 Output: 4
	 * 
	 * 
	 * 
	 */

	int res = 0;

	public int diameter(Node root) {
		if (root == null)
			return 0;
		int left = diameter(root.leftChild);
		int right = diameter(root.rightChild);
		res = treeHeight(root.rightChild) + treeHeight(root.leftChild) + 1;

		return Math.max(result, Math.max(left, right));
	}

	private int treeHeight(Node root) {
		if (root == null)
			return 0;

		int left = treeHeight(root.leftChild);
		int right = treeHeight(root.rightChild);

		return 1 + Math.max(left, right);
	}

	/*
	 * Given a Binary Tree, find its Boundary Traversal. The traversal should be in
	 * the following order:
	 * 
	 * Left boundary nodes: defined as the path from the root to the left-most node
	 * ie- the leaf node you could reach when you always travel preferring the left
	 * subtree over the right subtree.
	 * 
	 * Leaf nodes: All the leaf nodes except for the ones that are part of left or
	 * right boundary.
	 * 
	 * Reverse right boundary nodes: defined as the path from the right-most node to
	 * the root. The right-most node is the leaf node you could reach when you
	 * always travel preferring the right subtree over the left subtree. Exclude the
	 * root from this as it was already included in the traversal of left boundary
	 * nodes.
	 * 
	 * Note: If the root doesn't have a left subtree or right subtree, then the root
	 * itself is the left or right boundary.
	 * 
	 * Example 1:
	 * 
	 * Input: 1 / \ 2 3 / \ / \ 4 5 6 7 / \ 8 9
	 * 
	 * Output: 1 2 4 8 9 6 7 3
	 * 
	 * 
	 * 
	 */
	public ArrayList<Integer> boundaryTraversal(Node node) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(node.value);

		// left
		left(node.leftChild, result);

		// leaf
		leaf(node.leftChild, result);
		leaf(node.rightChild, result);

		// right
		right(node.rightChild, result);
		return result;
	}

	private static void left(Node node, ArrayList<Integer> result) {
		if (node == null || (node.leftChild == null && node.rightChild == null)) {
			return;
		}
		result.add(node.value);
		if (node.leftChild != null)
			left(node.leftChild, result);
		else
			left(node.rightChild, result);
	}

	private static void leaf(Node root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.leftChild == null && root.rightChild == null) {
			result.add(root.value);
			return;
		}
		leaf(root.leftChild, result);
		leaf(root.rightChild, result);
	}

	private static void right(Node root, ArrayList<Integer> result) {
		if (root == null || (root.leftChild == null && root.rightChild == null)) {
			return;
		}
		if (root.rightChild != null)
			right(root.rightChild, result);
		else
			right(root.leftChild, result);
		result.add(root.value);
	}
	/*
	 * Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.

			Example 1:
			
			Input:
			        3
			      /   \
			     2     1
			Output:
			3 1 2
	 * 
	 */
	public ArrayList<Integer> zigZagTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int flag = 0;

		queue.add(root);

		while (queue.size() != 0) {
			int s = queue.size();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < s; i++) {
				Node n = queue.peek();
				queue.remove();
				temp.add(n.value);

				if (n.leftChild != null)
					queue.add(n.leftChild);
				if (n.rightChild != null)
					queue.add(n.rightChild);
			}
			if (flag == 0) {
				for (int i = 0; i < temp.size(); i++)
					result.add(temp.get(i));
				flag = 1;
			} else if (flag == 1) {
				for (int i = temp.size() - 1; i >= 0; i--) {
					result.add(temp.get(i));
				}
				flag = 0;
			}
		}
		return result;
	}
	/**
	 * 
	 * Amazon - Phone Screen
		Question 1: You are given a binary tree having ‘N’ distinct nodes and an integer ‘M’, 
		you have to return the postorder successor of ‘M’. 
		The postorder successor of ‘M’ is defined as the next element to ‘M’ in the sequence 
		of postorder traversal.
	 * 
	 * 
	 * @param root
	 * @param M
	 */
	//postOrder -> {LEFT -> RIGHT -> ROOT}
	public void postOrderSuccessor(int M) {
		postOrderSuccessor(root, M);
	}
	private int postOrderSuccessor(Node root, int M) {
		if(root == null) return -1;
		int successor = 0;
		
		var current = root;
		
		if(current.leftChild != null) {
			postOrderSuccessor(current.leftChild, M);
		}
		postOrderSuccessor(current.rightChild, M);
		if(current.rightChild != null) {
			postOrderSuccessor(current.rightChild, M);
		}
		postOrderSuccessor(current.leftChild, M);
		
		System.out.println(current.value);
		if(current.value == M) {
			if(current.leftChild != null) {
				successor = current.leftChild.value;
			}
			successor = current.rightChild.value;
		}
		return successor;
	}

}
