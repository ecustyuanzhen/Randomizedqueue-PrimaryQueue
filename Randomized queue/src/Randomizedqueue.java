import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


public class Randomizedqueue<Item> implements Iterable<Item> {
	int size;
	int currentsize;
	Item[] a ;
  
public Randomizedqueue(){                 			// construct an empty randomized queue
   
	   size = 0;
	   currentsize = 0;
	   a = (Item[])new Object[1];
   }
   public boolean isEmpty(){						// is the deque empty?	
	   if (size<1) {
		return true;
	}return false;
   }                 
   public int size(){									// return the number of items on the deque	
	   return size;
   }                           							// return the number of items on the randomized queue
   public void enqueue(Item item){
	   if (item==null) {
		throw new IllegalArgumentException("IllegalArgument");
	   }else {
		   if(size>a.length/2){
			   Item[] temp = (Item[])new Object[a.length*2];
			   for(int i=0;i<a.length;i++){
				   temp[i] = a[i];			   			   
			   }a = temp;
		   }
		   a[size] = item;		   	   	   
		   size++;
		   currentsize++;	
	   }

	   
   }           														// add the item
   public Item dequeue(){
	   if (size<1) {
		throw new NoSuchElementException("NoSuchElement");
	}else {
		Random rand = new Random();
		   int temp = rand.nextInt(size);
		   Item deleteItem = a[temp];
		   for(int i=temp;i<size;i++){
			   a[i]=a[i+1];
		   }
		   a[size] = null;
		   size--;		  
		   currentsize--;
		   return deleteItem;
	}
	   
   }                    													// remove and return a random item
   public Item sample(){
	   Random rand = new Random();
	   currentsize = rand.nextInt(size);
	   return a[currentsize];
   }                     														// return a random item (but do not remove it)
   public Iterator<Item> iterator(){
	   return new RandomizedQueueiterator();
   }         									// return an independent iterator over items in random order
   class RandomizedQueueiterator implements Iterator<Item>{

	@Override
	public boolean hasNext() {
		
		// TODO Auto-generated method stub
		return currentsize>0;
	}

	@Override
	public Item next() {	
		if (currentsize<1) {
			throw new NoSuchElementException("NoSuchElement");
		}else {
			--currentsize;
	
			return a[currentsize];
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("UnsupportedOperation");
	}
	   
   }
   public static void main(String[] args) {
	   Randomizedqueue<Integer> randomizedqueue = new Randomizedqueue<Integer>();	 
	   for(int i=0;i<10;i++){
		   randomizedqueue.enqueue(i);
	   }
	   System.out.print("删除的值");
	   for(int i=0;i<5;i++){
		   System.out.print(+randomizedqueue.dequeue());
	   }
	   Iterator<Integer> randomizedQueueiterator = randomizedqueue.iterator();
	   System.out.println();
	   System.out.print("剩余的值");
	  
	   while (randomizedQueueiterator.hasNext()){
		   System.out.print(randomizedQueueiterator.next());		   
		   
	   }
	   
   }  // unit testing (optional)
}