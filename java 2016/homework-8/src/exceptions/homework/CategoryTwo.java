package exceptions.homework;

import java.util.HashMap;

public class CategoryTwo {
	
	private int totalTicketsOfCat2;
	private int nrBileteVandute = 0;
	
	
	public CategoryTwo(int totalTicketsOfCat2) {
		super();
		this.totalTicketsOfCat2 = totalTicketsOfCat2;
	}
	public void calculateTiket() throws CategoryTicketsSoldoutException{
		while (totalTicketsOfCat2 != 0) {
			HashMap<String, Integer> m1 = new HashMap<>();
			Ticket tiket = new Ticket("II", 80);
			if (totalTicketsOfCat2 % 17 == 0){
				totalTicketsOfCat2 = totalTicketsOfCat2 -2;
				System.out.println("Categoria biletului "+tiket.getCategory()+" , pretul pt 3 bilete "+tiket.getPrice() * 3);
				m1.put("II", totalTicketsOfCat2);
				nrBileteVandute += 2;
			}else{
			totalTicketsOfCat2--;
			nrBileteVandute++;
			System.out.println("Categoria biletului "+tiket.getCategory()+" , pretul biletului "+tiket.getPrice());
			m1.put("II", totalTicketsOfCat2);
			System.out.println("Au mai ramas "+m1.values()+" bilete");	
			}
		}
		System.out.println("Bilete vandute :"+nrBileteVandute+" , Valoarea :"+nrBileteVandute * 80);
	
	if (totalTicketsOfCat2 == 0){
		throw new CategoryTicketsSoldoutException("Nu mai sunt bilete la cat 2");
	}
	}	
	
	public int calculateTickets(){
		return nrBileteVandute ;
	}
	public int calculateValue(){
		return nrBileteVandute * 80;	
	}
}


