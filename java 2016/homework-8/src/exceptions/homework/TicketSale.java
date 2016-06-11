package exceptions.homework;


public class TicketSale {
   public static void main(String[] args) throws CategoryTicketsSoldoutException{
	   int nrTotalBilete = 50;
	   int totalTicketsOfCat3 = (nrTotalBilete * 50) / 100;
	   int totalTicketsOfCat2 = (nrTotalBilete * 35) / 100;
	   int totalTicketsOfCat1 = (nrTotalBilete * 15) / 100;

		   CategoryThree categoryThree = new CategoryThree(totalTicketsOfCat3);
	try{   
		   categoryThree.calculateTiket();
	   }catch(CategoryTicketsSoldoutException e){
			System.out.println(e.message);
			System.out.println("-------------------------------------");
	   }
	   
		   CategoryTwo categoryTwo = new CategoryTwo(totalTicketsOfCat2);
	try{  
		   categoryTwo.calculateTiket();
	   }catch(CategoryTicketsSoldoutException e){
		   System.out.println(e.message);
		   System.out.println("-------------------------------------");
	   }
      
			System.out.println("-------------------------------------");
			CategoryOne categoryOne = new CategoryOne(totalTicketsOfCat1);
	try{		
			categoryOne.calculateTiket();   
	   }catch(CategoryTicketsSoldoutException e1){
			System.out.println(e1.message);
	   }
		int total = categoryThree.calculateValue() + categoryTwo.calculateValue() + categoryOne.calculateValue();
			System.out.println("-------------------------------------");
			System.out.println("Valoarea totala este : "+total);
	  
		try{ 
		}catch(RuntimeException e2){
			System.out.println(e2.toString());
		}
			if(nrTotalBilete == 50 ){
			 RuntimeException e2 = new RuntimeException("S-au vandut toate biletele");
			 throw e2;
		   }
	}
}
   

