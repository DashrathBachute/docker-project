package SolidPrinciple;

public class OPrinciple {
	
	//open/Close Principle  this is not a exaple for OPENS /clone principle
	//Modifying the existing code
	// if new discounts come then we need to modify the existing code or tested code 
	
	
	public Double getDiscount(String type, Double amount) {
		if("FESTIVAL".equals(type)) {
			return amount * 0.1;
		}else if("NEWUSER".equals(type)) {
			return amount * 0.2;
		}
		return 0.0;
	}

}

//here is open for extension and close for the modification

interface Discount{
	
    public Double getDiscount(Double amount);
	
}




class  FestivalDiscoutn implements Discount{

	@Override
	public Double getDiscount(Double amount) {
		return amount * 0.1;
	}
	
	
}


class NewUser implements Discount{

	@Override
	public Double getDiscount(Double amount) {
		return amount * 0.2;
	}
}


