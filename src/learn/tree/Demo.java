package learn.tree;

public class Demo {

	public static void main(String[] args) {
		Tree tree = new Tree();

		
		tree.insert(7);
		tree.insert(4);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		tree.insert(8);
		tree.insert(10);
		
		//System.out.println(tree.find(7));
		System.out.println("pre");
		tree.preOrderTraversal();
		System.out.println("inorder");
		tree.inOrderTraversal();
		System.out.println("post");
		tree.posOrderTraversal();
		
		System.out.println("height="+tree.height());
		System.out.println("min="+tree.min());
		System.out.println("max="+tree.max());
		
		System.out.println("Done");

	}

}
