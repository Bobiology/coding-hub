package trees;

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
		
		Tree tree2 = new Tree();
		tree2.insert(7);
		tree2.insert(4);
		tree2.insert(9);
		tree2.insert(1);
		tree2.insert(6);
		tree2.insert(8);
		tree2.insert(10);
		
		System.out.println("PRE-ORDER TRAVERSAL");
		tree.traversePreOrder();
		
		System.out.println("IN-ORDER TRAVERSAL");
		tree.traverseInOrder();
		
		System.out.println("POST-ORDER TRAVERSAL");
		tree.traversePostOrder();
		
		System.out.println("HEIGHT OF TREE = "+tree.height());
		
		System.out.println("MINIMUM VALUE = "+tree.min());
		
		System.out.println("MAXIMUM VALUE = "+tree.max());
		
		System.out.println("IS EQUAL = " + tree.equals(tree2) );
		
		var list = tree.getNodesAtDistance(2);
		System.out.println("LEVEL ORDER TRAVERSAL");
		System.out.println(list);
		
		System.out.println("Deep Node = "+ tree.deepNode());

		//for(int item : list)
			//System.out.print(item);
		
		//System.out.println("LEVEL ORDER TRAVERSAL");
		//tree.traverseLevelOrder();
		
	}

}
