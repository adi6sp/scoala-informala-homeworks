package exceptions.homework;

import java.util.HashMap;

public class CategoryOne {


	private int totalTicketsOfCat1;
	private int nrBileteVandute = 0;
	public CategoryOne(int totalTicketsOfCat1) {
		super();
		this.totalTicketsOfCat1 = totalTicketsOfCat1;
	}
	public void calculateTiket() throws CategoryTicketsSoldoutException{
		while (totalTicketsOfCat1 != 0) {
			HashMap<String, Integer> m1 = new HashMap<>();
			Ticket tiket = new Ticket("I", 120);
			if (totalTicketsOfCat1 % 17 == 0){
				totalTicketsOfCat1 = totalTicketsOfCat1 -2;
				System.out.println("Categoria biletului "+tiket.getCategory()+" , pretul pt 3 bilete "+tiket.getPrice() * 3);
				m1.put("I", totalTicketsOfCat1);
				nrBileteVandute += 2;
			}else{
			totalTicketsOfCat1--;
			nrBileteVandute++;
			System.out.println("Categoria biletului "+tiket.getCategory()+" , pretul biletului "+tiket.getPrice());
			m1.put("I", totalTicketsOfCat1);
			System.out.println("Au mai ramas "+m1.values()+" bilete");	
			}
		}
		System.out.println("Bilete vandute :"+nrBileteVandute+" , Valoarea :"+nrBileteVandute * 120);
	
	if (totalTicketsOfCat1 == 0){
		throw new CategoryTicketsSoldoutException("Nu mai sunt bilete la cat 1");
	}
	}

	public int calculateTikets(){
		return nrBileteVandute;	
	}
	
		public int calculateValue(){
		return nrBileteVandute * 120;	
	}


}
