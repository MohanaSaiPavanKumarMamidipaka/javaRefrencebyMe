package ds;

public class LinkedList {
private class Node{
	int data;
	Node next;
}
Node Head;
public void add(int ele) {
	Node n = new Node();
	n.data=ele;
	if(Head==null) {
		Head=n;
		return;
	}
	Node temp= Head;
		while(temp.next!=null) {
			temp=temp.next;
		}
	temp.next=n;
}
public void disp() {
	Node temp = Head;
	while(temp !=null) {
		System.out.print(temp.data+"---->");
		temp=temp.next;
	}
	System.out.println("");
}
public int length() {
	Node temp = Head;
	int l=0;
	while(temp!=null) {
		l++;
		temp=temp.next;
	}
	return l;
}
public void addfirst(int ele) {
	Node n =new Node();
	n.data=ele;
	n.next=Head;
	Head=n;
}
private Node NodeAt(int index) {
	
	Node temp=Head;
	for(int i=1;i<=index;i++) {
		temp=temp.next;
	}
	return temp;
}
public void addat(int index ,int ele) throws Exception {
	if(index<0 || index > length()) {
		throw new Exception ("Index is out of the bound");
	}
	Node temp=Head;
	Node n = new Node();
	n.data=ele;
	
		if(index==0) {
			addfirst(ele);
		
		}
		else if(index == length()) {
			add (ele);
		}
		else{
		Node n1=NodeAt(index-1);
		//Node n2=NodeAt(index);
		n.next=n1.next;
		n1.next=n;
			
		}
		
	
}
public int removeLast() throws Exception {
	if(Head==null) {
		throw new Exception("Linked List is empty");
	}
	
	if(length()==1) {
		int data = Head.data;
		Head=null;
		return data;
	}
	Node lno = NodeAt(length()-2);
	int data = lno.next.data;
	lno.next=null;
	return data;
}
public int removeFirst() throws Exception {
	if(Head==null) {
		throw new Exception("Linked List is empty");
	}
	int data =Head.data;
	Head=Head.next;
	return data;
}
public int remove(int index) throws Exception {
	if(Head==null) {
		throw new Exception("Linked List is empty");
	}
	if(index<0 || index >=length()) {
		throw new Exception ("Index is out of the bound");
	}
	if(index==0) {
		return removeFirst();
		
	}
	if(index==length()-1) {
		return removeLast();
	}
//	Node rn = NodeAt(index);
//	int data =rn.data;
//	Node pn = NodeAt(index-1);
//	pn.next=rn.next;
	Node pn = NodeAt(index-1);
	int data = pn.next.data;
	pn.next=pn.next.next;
	return data;
}
private void recrev(Node no) {
	if(no.next==null) {
		System.out.print(no.data+" ");
		return;
	}
	recrev(no.next);
	System.out.print(no.data+" ");
	return;
}
public void reverse() throws Exception {
	if(length()==0) {
		throw new Exception ("Linked List is empty");
	}
	recrev(Head);
	System.out.println("");	 
}
public void reverseList() {
	if(length()==1) {
		return;
	}
	Node prev= Head;
	Node curr = prev.next;
	while(curr!=null) {
		Node after = curr.next;
		curr.next=prev;
		prev = curr;
		curr =after;	
	}
	Head.next=null;
	Head=prev;
	
}
public void reverse_rec() {
	Node temp = Head;
	reverse_rec(Head);
	temp.next=null;
}
private void reverse_rec(Node curr) {
	
	if(curr.next==null) {
		Head=curr;
		return;
	}
	reverse_rec(curr.next);
	curr.next.next=curr;
	return ;
}
public int Mid() {
	Node s = Head;
	Node f= Head;
	while(f!=null&& f.next!=null ) {
		s=s.next;
		f=f.next.next;
	}
	return s.data;
}
public  int kth(int index) {
	Node kele=Head;
	Node ck = NodeAt(index);
	while(ck!=null) {
		ck=ck.next;
		kele=kele.next;
	}
	
	return kele.data;
}
public int intersection(LinkedList ll2) {
	Node p1=this.Head;
	Node p2=ll2.Head;
//	Node n =ll2.NodeAt(ll2.length()-1);
//	n.next=this.NodeAt(this.kth(1));
//	ll2.Head.next.next=this.Head.next;
	
	while(p1!=p2) {
		p1=p1.next;
		p2=p2.next;
		if(p1==null&& p2!=null) {
			p1=ll2.Head;
			
		}
		else if(p1!=null&& p2==null) {
			p2=this.Head;
		}
	}
	
	return p1.data;
}
}
