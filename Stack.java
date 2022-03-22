package ds;

public class Stack {
 protected int [] arr;
 protected int top_ele; 
	public Stack() {
		// TODO Auto-generated constructor stub
		arr=new int[2];
		top_ele=-1;
	}
	
	public Stack(int size) {
		arr=new int[size];
		top_ele=-1;
	}
	
	public void push(int ele) throws Exception {
		if(isfull()) {
			throw new Exception("Stack is full");
		}
		top_ele++;
		arr[top_ele]=ele;
		
	}
	
	public int pop() throws Exception {
		if(isempty()) {
			throw new Exception("Stack is empty");
		}
		int t = arr[top_ele];
		arr[top_ele]=0;
		top_ele--;
		return t;
		
	}
	public void disp() {
		for(int i=0 ;i<=top_ele;i++) {
			System.out.print("| "+arr[i]+" ");
		}
		System.out.println("|");
		System.out.println("----------------------------------------");
	}
	
	public boolean isfull() {
		
		return top_ele==arr.length-1;
	}
public boolean isempty() {
		
		return top_ele==-1;
	}
public int size() {
	return top_ele+1;
}
public int peek() {
	return arr[top_ele];
}
	
	

}
