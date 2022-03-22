package ds;

public class DynamicQueue extends Queue {

	
	public void enqueue(int ele) throws Exception {
		if(isfull()) {
			int[] narr = new int[arr.length*2];
 			for(int i=0;i<size;i++) {
				int cele=arr[(sele+i)%arr.length];
				narr[i]=cele;
			}
 			sele=0;
 			arr=narr;
		}
	
		super.enqueue(ele);
	}
}
