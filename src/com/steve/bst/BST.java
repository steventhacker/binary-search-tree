package com.steve.bst;

/**
 * Binary Search Tree class, for holding data in a tree format
 */
public class BST
{
	// Root node
	private Node root;

	/**
	 * Add a new node to the tree. Nodes will be added in order of tree, traversing left or right down
	 * depending on parent node's value in comparison to value being added
	 *
	 * @param node node being added to the tree
	 */
	public void addNode(Node node)
	{
		if (root == null)
		{
			root = node;
			return;
		}

		Node temp = root;
		Node parentNode;

		int value = node.getData();

		while (true)
		{
			parentNode = temp;

			// If value is less than current parent, traverse to the left
			if (value < temp.getData())
			{
				temp = temp.getLeft();

				if (temp == null)
				{
					parentNode.setLeft(node);
					return;
				}
			}
			// If value if greater than current parent, traverse to the right
			else
			{
				temp = temp.getRight();

				if (temp == null)
				{
					parentNode.setRight(node);
					return;
				}
			}
		}
	}

	/**
	 * Remove a node from the tree. Traverses until it finds the given node then removes it from the
	 * tree and sets the parent to the node's children, closing the gap
	 *
	 * @param node node to be removed
	 */
	public void removeNode(Node node)
	{
		Node currentNode = root;
		Node parentNode = root;

		boolean isLeft = false;

		// Loop until the node is found
		while (currentNode.getData() != node.getData())
		{
			parentNode = currentNode;

			// Determine if left subtree should be traversed
			if (currentNode.getData() > node.getData())
			{
				isLeft = true;
				currentNode = currentNode.getLeft();
			}
			// Determine if right subtree should be traversed
			else
			{
				isLeft = false;
				currentNode = currentNode.getRight();
			}

			// If the given node is not present, exit
			if (currentNode == null)
			{
				return;
			}
		}

		// Set the node's parent to remove the node from the tree
		if (currentNode.getLeft() == null && currentNode.getRight() == null)
		{
			if (isLeft)
			{
				parentNode.setLeft(null);
			}
			else
			{
				parentNode.setRight(null);
			}
		}
		else if (currentNode.getLeft() == null)
		{
			if (currentNode == root)
			{
				root = currentNode.getRight();
			}
			else if (isLeft)
			{
				parentNode.setLeft(currentNode.getRight());
			}
			else
			{
				parentNode.setRight(currentNode.getRight());
			}
		}
		else if (currentNode.getLeft() != null && currentNode.getRight() != null)
		{
			Node childNode = getNextChild(currentNode);

			if (currentNode == root)
			{
				root = childNode;
			}
			else if (isLeft)
			{
				parentNode.setLeft(childNode);
			}
			else
			{
				parentNode.setRight(childNode);
			}
			childNode.setLeft(currentNode.getLeft());
		}
	}

	private Node getNextChild(Node deleteNode)
	{
		Node childNode = null;
		Node parentNode = null;
		Node currentNode = deleteNode.getRight();

		while (currentNode != null)
		{
			parentNode = childNode;
			childNode = currentNode;
			currentNode = currentNode.getLeft();
		}

		if (childNode != deleteNode.getRight())
		{
			parentNode.setLeft(childNode.getRight());
			childNode.setRight(deleteNode.getRight());
		}
		return childNode;
	}

	/**
	 * Display tree contents using simple console output format
	 */
	public void displayTree()
	{
		System.out.println("Tree contents: ");
		displayNode(root);
		System.out.println();
	}

	private void displayNode(Node node)
	{
		if (node != null)
		{
			displayNode(node.getLeft());
			System.out.printf(" " + node.getData());
			displayNode(node.getRight());
		}
	}
}
