package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final int numberOfNode;
    }
}

class Node {
    private char data;
    private Node left, right;

    public char getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node(char data) {
        this.data = data;
    }
}

class Tree {
    private Node root;
    public void add(char data) {

    }

    public void preOrder(Node node){
        System.out.println(node.getData());
        if(node.getLeft() != null) {
            preOrder(node.getLeft());
        }
        if(node.getRight() != null) {
            preOrder(node.getRight());
        }
    }

    public void inOrder(Node node){
        if(node.getLeft() != null) {
            preOrder(node.getLeft());
        }
        System.out.println(node.getData());
        if(node.getRight() != null) {
            preOrder(node.getRight());
        }
    }

    public void postOrder(Node node){
        if(node.getLeft() != null) {
            preOrder(node.getLeft());
        }
        if(node.getRight() != null) {
            preOrder(node.getRight());
        }
        System.out.println(node.getData());
    }

}