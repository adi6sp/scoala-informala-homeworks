package exceptions.homework;

import java.util.HashMap;

public class CategoryThree {

	private int totalTicketsOfCat3;
	private int nrBileteVandute = 0;
	public CategoryThree(int totalTicketsOfCat3) {
		super();
		this.totalTicketsOfCat3 = totalTicketsOfCat3;
	}
	
	public void calculateTiket() throws CategoryTicketsSoldoutException{
		while (totalTicketsOfCat3 != 0) {
			HashMap<String, Integer> m1 = new HashMap<>();
			Ticket tiket = new Ticket("III", 50);
			if (totalTicketsOfCat3 % 17 == 0){
				totalTicketsOfCat3 = totalTicketsOfCat3 -2;
				System.out.println("Categoria biletului "+tiket.getCategory()+" , pretul pt 3 bilete "+tiket.getPrice() * 3);
				m1.put("III", totalTicketsOfCat3);
				nrBileteVandute += 2;
			}else{
			totalTicketsOfCat3--;
			nrBileteVandute++;
			System.out.println("Categoria biletului "+tiket.getCategory()+" , pretul biletului "+tiket.getPrice());
			m1.put("III", totalTicketsOfCat3);
			System.out.println("Au mai ramas "+m1.values()+" bilete");	
			}
		}
		System.out.println("Bilete vandute :"+nrBileteVandute+" , Valoarea :"+nrBileteVandute * 50);
		if (totalTicketsOfCat3 == 0){
			throw new CategoryTicketsSoldoutException("Nu mai sunt bilete la cat 3");
		}
	}
	
	public int calculateTickets(){
		return nrBileteVandute;	
	}
	
	public int calculateValue(){
		return nrBileteVandute * 50;	
	}
}
