package com.phillippham.binary_search_tree;

public class BinarySearchTree<T extends Comparable<T>>
{
	// Attribute
	private Node<T> root;
	
	public BinarySearchTree()
	{
		this.root = null;
	}
	
	// Behaviors
	public boolean isEmpty()
	{
		return this.root == null;
	}
	
	public void add(T data)
	{
		// Create the Node
		Node<T> p = new Node<T>(data);
		
		// Check to see if Node is empty, then add Node to the tree
		if(this.root == null)
		{
			this.root = p;
		}
		else
		{
			insert(p, this.root);
		}
	}

	private void insert(Node<T> nodeToInsert, Node<T> root)
	{
		// Find the spot for the Node
		if(nodeToInsert.getInfo().compareTo(root.getInfo()) < 0)//(nodeToInsert.getInfo() < root.getInfo())
		{
			if(root.getLeft() == null)
			{
				root.setLeft(nodeToInsert);
			}
			else
			{
				insert(nodeToInsert, root.getLeft());
			}
		}
		else
		{
			if(root.getRight() == null)
			{
				root.setRight(nodeToInsert);
			}
			else
			{
				insert(nodeToInsert, root.getRight());
			}
		}
	}
	
	public boolean remove(T data)
	{
		if(this.root == null)
		{
			// Empty tree
			return false;
		}
		else if(this.root.getInfo().compareTo(data) == 0)//(this.root.getInfo() == data)
		{
			Node<T> left = this.root.getLeft();
			Node<T> right = this.root.getRight();
			
			
			if(left != null && right != null)
			{	
				// If the left and right nodes are not null, then put the left branch into right branch
				insert(left, right);
				this.root = right;
			}
			else if(right != null)
			{
				// Right is not null, but the left is null so we need to make the right the root position
				this.root = right;
			}
			else
			{
				// Right is null or both sides are null so we make the left the root position
				this.root = left;
			}
			
			// In all these cases, data was removed so we return true
			return true;
		}
		else
		{
			// Send the root Node down as the parent Node
			return delete(data, this.root);
		}
	}

	private boolean delete(T data, Node<T> parent)
	{
		// Look for the data
		if(data.compareTo(parent.getInfo()) > 0)//(data > parent.getInfo())
		{
			// Data is on the right branch of this parent node
			Node<T> right = parent.getRight();
			
			if(right == null)
			{
				// Right is null so data was not found
				return false;
			}
			else if(data.compareTo(right.getInfo()) == 0)//(data == right.getInfo())
			{
				// Data matches the right node, so delete the right node
				Node<T> leftChild = right.getLeft();
				Node<T> rightChild = right.getRight();
				
				if(leftChild != null && rightChild != null)
				{
					// Put the leftChild branch into the rightChild branch, and then set the rightChild
					// to the parent's right side
					insert(leftChild, rightChild);
					parent.setRight(rightChild);
				}
				else if(rightChild != null)
				{
					// leftChild is null so we just need to set rightChild to the parent's right side
					parent.setRight(rightChild);
				}
				else
				{
					// Right child is null or both sides are null so we set the leftChild into the parent's right side
					parent.setRight(leftChild);
				}
				
				// In all cases, data was removed so return true
				return true;
			}
			else
			{
				// Send the right node down as the parent node
				return delete(data, right);
			}
		}
		else
		{
			// Data is on the left branch of this parent node
			Node<T> left = parent.getLeft();
			
			if(left == null)
			{
				// Left side is null so data was not found
				return false;
			}
			else if(left.getInfo().compareTo(data) == 0)//(left.getInfo() == data)
			{
				// Data matches the left node, so delete the left node
				Node<T> leftChild = left.getLeft();
				Node<T> rightChild = left.getRight();
				
				if(leftChild != null && rightChild != null)
				{
					// Put the leftChild branch into the rightChild branch, 
					// and then set the rightChild branch into parent's left side
					insert(leftChild, rightChild);
					parent.setLeft(rightChild);
				}
				else if(rightChild != null)
				{
					// leftChild is null so we just need to set the rightChild into the parent's left side
					parent.setLeft(rightChild);
				}
				else
				{
					// rightChild is null or both sides are null so we set the leftChild into the parent's left side
					parent.setLeft(leftChild);
				}
				
				//In all these cases, data was removed so return true.
				return true;
			}
			else
			{
				// Send the left down as the parent node
				return delete(data, left);
			}
		}
	}
	
	public boolean contains(T data)
	{
		return search(data, root);
	}

	private boolean search(T data, Node<T> root)
	{
		// Search for the data
		if(root == null)
		{
			return false;
		}
		else if(root.getInfo().compareTo(data) == 0)//(root.getInfo() == data)
		{
			return true;
		}
		else if(data.compareTo(root.getInfo()) < 0)//(data < root.getInfo())
		{
			// Data must be on the left side of the tree if it exists
			return search(data, root.getLeft());
		}
		else
		{
			// Data must be on the right side if it exists
			return search(data, root.getRight());
		}
	}
	
	public boolean removeMax()
	{
		if(root == null)
		{
			return false;
		}
		else
		{
			Node<T> current = this.root;
			T data = findMax();
			
			delete(data, current);
			
			return true;
		}
	}
	
	public T findMin()
	{
		Node<T> current = this.root;
			
		while(current.getLeft() != null)
		{
			current = current.getLeft();
		}
		
		return current.getInfo();
	}
	
	public T findMax()
	{
		Node<T> current = this.root;
		
		while(current.getRight() != null)
		{
			current = current.getRight();
		}
			
		return current.getInfo();
	}
	
	// Print all of the data in sorted order
	public void printInOrder()
	{
		printInOrder(this.root);
	}

	private void printInOrder(Node<T> root)
	{
		// Is the binary tree empty?
		if(root == null)
		{
			return; // End the method
		}
		
		// Print the left side
		printInOrder(root.getLeft());
		
		// Print this node
		System.out.println(root.getInfo());
		
		// Print the right side
		printInOrder(root.getRight());
	}
	
	// Print all of the data starting with the top Node
	public void printFromTop()
	{
		printFromTop(this.root, "");
	}

	private void printFromTop(Node<T> root, String spaces)
	{
		// Is the tree empty?
		if(root == null)
		{
			return; // Ends the current method
		}
		
		System.out.println(spaces + root.getInfo());
		
		// Print the left side
		printFromTop(root.getLeft(), spaces + "     ");
		
		printFromTop(root.getRight(), spaces + "     ");
	}
}