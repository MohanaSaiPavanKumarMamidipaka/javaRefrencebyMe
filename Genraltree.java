package ds;

import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Genraltree {
	Scanner scn = new Scanner(System.in);
	private class Node{
		int data;
		ArrayList<Node> childern;
	}
	private Node root;
	public Genraltree() {
		root = constructor(null,1000);
	}
	public Node constructor(Node parent,int ith) {
		Node nn =new Node();
		if(parent == null) {
			System.out.println("Input root value as root is empty");
		}
		else {
			System.out.println("Enter Child"+(ith+1)+"of" + parent.data);
		}
		int item =scn.nextInt();
		//System.out.println("Enter Child of" + parent);
		nn.data=item;
		System.out.println(" How many Chilern does " + item+" have ?");
		int noc = scn.nextInt();
		nn.childern=new ArrayList<>();
		for(int i=0;i<noc;i++) {
			//System.out.println("Enter Child"+i+"of" + item);
			Node child =   constructor(nn,i);
			nn.childern.add(child);
			
		}
		return nn;
	}
	public void disp() {
		if(root==null) {
			System.out.println("Tree is empty");
		}
		else {
			disp(root);
		}
		
	}
	private void disp(Node parent) {
		System.out.print(parent.data+" -> ");
		for(int i=0;i<parent.childern.size();i++) {
			System.out.print(parent.childern.get(i).data+" -> ");
			

		}
		System.out.println();
		for(Node n : parent.childern) {
			disp(n);
		}
		
		
	}
public int size() {
	
	return size(root) ;
}
private int size(Node parent) {
	int ans=1;
	//height=height+parent.childern.size();
    for(Node i: parent.childern) {
		int sst=size(i);
		ans=ans+sst;
	}
	return ans;
}

public boolean find(int data) {
	return find(root,data);
}
private boolean find(Node r,int data) {
	if(r.data==data) {
		return true;
	}
	for(Node i:r.childern) {
		if(find(i,data)) {
			return true;
		}
			
	}
	return false;
}

public int height() {
	return height(root);
}
private int height(Node base) {
	int ans=0;
	for(Node i:base.childern) {
		int h=height(i);
		h++;
		ans=Math.max(ans, h);
	}
	return ans;
}

public void mirror() {
	mirror(root);
}
private void mirror(Node base) {
	System.out.print(base.data);
	for(int i = base.childern.size();i>0;i--) {
		Node curr_node=base.childern.get(i-1);
		System.out.print("--->"+curr_node.data);
	}
	System.out.println("");
	for(int i = base.childern.size();i>0;i--) {
		Node curr_node=base.childern.get(i-1);
		mirror(curr_node);
	}
	
}

public void reverse() {
	reverse(root);
}
private void reverse(Node base) {
	for(Node i : base.childern) {
		reverse(i);
	}
	ArrayList<Node> extra = new ArrayList<>();
	while(!base.childern.isEmpty()) {
		Node tnode =base.childern.remove(base.childern.size()-1);
		extra.add(tnode);
	}
	base.childern=extra;
	
}

public void atLevel(int flvl) {
	atLevel(root,flvl,0);
}
private void atLevel(Node base,int flvl,int clvl) {
	if(flvl<clvl) {
		return;
	}
	if(flvl==clvl) {
		System.out.print(base.data+" ");
	}
	for(Node i : base.childern) {
		atLevel(i,flvl,clvl+1);
	}
}


public void lvlTraversal() {
	Queue<Node> qu= new LinkedList<>();
	qu.add(root);
	while(!qu.isEmpty()) {
		Node cn = qu.poll();
		System.out.print(cn.data+" ");
		for(Node i:cn.childern) {
			qu.add(i);
		}
	}
	
}



public void zigzagTraversal() {
	Stack<Node> cst = new Stack<>();
	Stack<Node> nst = new Stack<>();
	cst.push(root);
	int lvl=0;
	while(!cst.isEmpty()) {
		Node cn =cst.pop();
		System.out.print(cn.data+" ");
		if(lvl%2==0) {
			
		
		for(Node i:cn.childern) {
			nst.push(i);
		}
	}
		else {
			for(int i = cn.childern.size()-1;i>=0;i--) {
				nst.push(cn.childern.get(i));
			}
		}
		
		if(cst.isEmpty()) {
			
		lvl++;
		cst=nst;
		nst=new Stack<>();
		}
	}
	//System.out.print(base.data+" ");
	
}
}

