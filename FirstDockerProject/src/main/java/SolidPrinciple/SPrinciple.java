package SolidPrinciple;

public class SPrinciple {
	
	
	//this is not as Single Responsibility principle  
	
	public void saveData() {
		System.out.println("Data saved !!!");
	}
	
	public String getData() {
		return "Return data";
	}

}



//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// this is a Single Responsibility principle


class SaveData{
	
	public void saveData() {
		System.out.println("Data saved !!!");
	}
	
}


class GetData {
	
	public String getData() {
		return "Return Data";
	}
}
