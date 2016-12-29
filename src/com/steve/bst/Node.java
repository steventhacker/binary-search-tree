package com.steve.bst;

/**
 * Model for holding data in Binary Search Tree
 */
public class Node
{
	private int data;
	private Node left;
	private Node right;

	public Node(int data)
	{
		this.data = data;
	}

	public int getData()
	{
		return data;
	}

	public Node getLeft()
	{
		return left;
	}

	public void setLeft(Node left)
	{
		this.left = left;
	}

	public Node getRight()
	{
		return right;
	}

	public void setRight(Node right)
	{
		this.right = right;
	}
}
