package ds;

public class Queue {
	
	protected int[] arr;
	protected int size;
	protected int sele;

	public Queue() {
		arr= new int[2];
		size =0;
		sele=0;
	}
	public Queue(int capacity) {
		arr = new int[capacity];
		size =0;
		sele=0;
	}
	public void enqueue(int ele) throws Exception {
		if(isfull()) {
			throw new  Exception(" Queue is full ");
		}
		arr[(size+sele)%arr.length] = ele;
		size++;
	}
	public int dequeue() throws Exception {
		if(isempty()) {
			throw new  Exception(" Queue is empty ");
		}
		int temp = arr[sele];
		sele++;
		sele=sele%arr.length;
		size--;
		return temp;
	}
	public boolean isfull() {
		return arr.length==size;
	}
	public boolean isempty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	public void disp() {
		for(int i = 0; i<size;i++) {
			System.out.print(arr[(sele+i)%arr.length]+"\t");
		}
		System.out.println();
	}

}
