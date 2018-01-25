import java.awt.RenderingHints.Key;
import java.util.Random;


public class PrimaryQueue {
	int[] a;
	int size=1;
	PrimaryQueue(int N){
		a = new int[N];
	}
	void insert(int i){
		if(size==1){
			a[size] = i;
			size++;
		}else {
			int temp;
			int lastN = size;
			int currentN = size;
			while (currentN/2>0) {				
				if(i>a[currentN/2]){
					temp = a[currentN/2];					
					a[currentN/2] = i;
					a[lastN] = temp;			
					currentN = currentN/2;
					lastN = currentN;
				}
			}
			size++;
		}
	}
	int max(){return a[1];}
	int delMax(){return 0;}
	boolean isEmpty(){
		if(size>1)return true;
		else {
			return false;
		}
	}
	int size(){return --size;}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		PrimaryQueue primaryQueue = new PrimaryQueue(10);
		
		primaryQueue.insert(1);		
		primaryQueue.insert(2);	
		primaryQueue.insert(3);	
		primaryQueue.insert(4);	
		for(int i=1;i<10;i++){
			System.out.print(primaryQueue.a[i]);
		}
		System.out.print("size:"+primaryQueue.size());
	}

}
