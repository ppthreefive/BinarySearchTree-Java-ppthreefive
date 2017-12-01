package com.phillippham.binary_search_tree;

public class Node<T>
{
	// Attributes
	private T info; // Data that is stored in this Node
	private Node<T> left, right; // Left and right children which are smaller data and larger data respectively
	
	// Constructors
	public Node()
	{
		this.info = null;
		this.left = null;
		this.right = null;
	}

	public Node(T info)
	{
		this.info = info;
		this.left = null;
		this.right = null;
	}

	// Accessors
	public T getInfo()
	{
		return info;
	}

	public Node<T> getLeft()
	{
		return left;
	}

	public Node<T> getRight()
	{
		return right;
	}

	// Mutators
	public void setInfo(T info)
	{
		this.info = info;
	}

	public void setLeft(Node<T> left)
	{
		this.left = left;
	}

	public void setRight(Node<T> right)
	{
		this.right = right;
	}
}