package ds;

import java.util.*;

public class BTree {
	Scanner sc = new Scanner(System.in);
private class Node{
	int data;
	Node leftChild;
	Node rightChild;
}
private Node root;
public BTree() {
	root = constructor(null,1000);
}
private Node constructor(Node parent,int child_num) {
	Node nn = new Node();
	if(parent==null) {
		System.out.println("Enter the root node of binary Tree");
	}
	else {
		if(child_num==0) {
			System.out.println("What is the " + parent.data + " left child data ?");
		}
		else {
			System.out.println("What is the " + parent.data + " right child data ?");
		}
	}
	nn.data=sc.nextInt();
	System.out.println("Does " +nn.data+" has left child");
	boolean lcheck = sc.nextBoolean();
	if(lcheck) {
		nn.leftChild=constructor(nn,0);
	}
	System.out.println("Does " +nn.data+" has right child");
	boolean rcheck = sc.nextBoolean();
	if(rcheck) {
		nn.rightChild=constructor(nn,1);
	}
	return nn;
	
}
public void display() {
	display(root);
}
private void display(Node base) {
	if(base==null) {
		return;
	}
	String str="";
	if(base.leftChild!=null) {
		str=str+base.leftChild.data+"->";
	}
	str=str+base.data;
	if(base.rightChild!=null) {
		str=str+"<-"+base.rightChild.data;
	}
  System.out.println(str);
	display(base.leftChild);
	display(base.rightChild);
	return;
	
}
public int size() {
	return size(root);
}
private int size(Node base) {
	if(base==null) {
		return 0;
	}
	int a1 =size(base.leftChild);
	int a2=size(base.rightChild);
	
	return a1+a2+1;
			
}

public int max() {
	return max(root);
}
private int max(Node base) {
	if(base==null) {
		return Integer.MIN_VALUE;
	}
	int ml=max(base.leftChild);
	int mr=max(base.rightChild);
	
	return Math.max(base.data,Math.max(ml, mr));
}
}
