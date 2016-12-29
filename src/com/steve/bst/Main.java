package com.steve.bst;

public class Main
{

    public static void main(String[] args)
    {
        Node n1 = new Node(1);
        Node n2 = new Node(13);
        Node n3 = new Node(5);
        Node n4 = new Node(2);
        Node n5 = new Node(16);
        Node n6 = new Node(7);

        BST bst = new BST();
        bst.addNode(n1);
        bst.addNode(n2);
        bst.addNode(n3);
        bst.addNode(n4);
        bst.addNode(n5);
        bst.addNode(n6);

        bst.displayTree();

        bst.removeNode(n4);

        bst.displayTree();

        Node n7 = new Node(34);
        Node n8 = new Node(99);
        Node n9 = new Node(4);

        bst.addNode(n7);
        bst.addNode(n8);
        bst.addNode(n9);

        bst.displayTree();
    }
}
