package ds;

public class DynamicStack  extends Stack{

	public void push(int ele) throws Exception {
		if(isfull()) {
			int[] new_arr = new int[arr.length*2];
			for(int i=0;i<=top_ele;i++) {
				new_arr[i] = arr[i]; 
			}
			arr = new_arr;
			
		}
		super.push(ele);
	}
	
}
