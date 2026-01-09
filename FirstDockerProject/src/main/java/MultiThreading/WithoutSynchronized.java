package MultiThreading;

public class WithoutSynchronized {
	
	public static void main(String[] args) throws InterruptedException {
		
		Count count = new Count();
		
		Thread t1 = new Thread(() ->{
			for(int i = 0; i< 1000; i++) {
				count.increament();
			}
		});
		
		Thread t2 = new Thread(() ->{
			for(int i = 0; i< 1000; i++) {
				count.increament();
			}
		});
		
		t1.start();
		t2.start();
		
		
		t1.join();
		t2.join();
		
        System.out.println("Final Count: " + count.count);
		
		
		
	}
}


//jJUNIt
//@Qualifier
//Mokitto
//mokitto injection
//Actuator impementatuion
//git mearge 
//git fetch
//cicd pipline implementation
//Maven 
	

class Count{
	int count = 0;
	
	
	void increament() {
		 	count++;
		
	}
}