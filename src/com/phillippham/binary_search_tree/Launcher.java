package com.phillippham.binary_search_tree;

public class Launcher
{
	public static void main(String[] args)
	{
		final int NUM_ITEMS = 10;
		
		// Create binary search tree
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		// Add random numbers
		for (int i = 0; i < NUM_ITEMS; ++i)
		{
			int x = (int)(Math.random() * 90 + 10);
			bst.add(x);
		}
		
		// Add a 10 and then show the data
		bst.add(10);
		bst.printInOrder();
		System.out.println();
		bst.printFromTop();
		
		bst.remove(10);
		bst.printInOrder();
		System.out.println();
		bst.printFromTop();
		
		BinarySearchTree<String> strBST = new BinarySearchTree<String>();
		
		strBST.add("Lisa");
		strBST.add("George");
		strBST.add("Mathis");
		strBST.add("Pheezus");
		strBST.add("Albert");
		strBST.add("Frederick");
		strBST.add("Yuma");
		strBST.add("Ulysses");
		strBST.add("Ivan");
		strBST.add("Nadeen");
		
		strBST.printInOrder();
		System.out.println();
		strBST.printFromTop();
		
		BinarySearchTree<Employee> empBST = new BinarySearchTree<Employee>();
		empBST.add(new Employee("John Doe", 5000));
		empBST.add(new Employee("Jane Doe", 8000));
		empBST.add(new Employee("Billy Robertson", 32000));
		empBST.add(new Employee("Nadeen Parakeet", 56000));
		empBST.add(new Employee("Phil Dawson", 41000));
		empBST.add(new Employee("Bruce Wayne", 36000));
		empBST.add(new Employee("Clark Kent", 29000));
		empBST.add(new Employee("Thomas Kane", 66000));
		empBST.add(new Employee("Hugh Jackson", 69000));
		empBST.add(new Employee("Ken Bone", 99999));
		
		empBST.printInOrder();
		System.out.println();
		empBST.printFromTop();
		
		
		// Exit gracefully
		System.exit(0);
	}
}
