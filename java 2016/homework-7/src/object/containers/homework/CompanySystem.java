package object.containers.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class CompanySystem {

	private int numberOfParking = 3;
	private Collection<Employ> allManagers = new ArrayList<>();
	private Collection<Employ> allEngeniersSoftwares = new ArrayList<>();
	private Collection<Employ> allEmployers = new TreeSet<>();
	private List<Employ> employersWithoutParking = new ArrayList<Employ>();
	public void addManager(Employ employ){
		allManagers.add(employ);
	}
	public void addEngeniersSoftware(Employ employ){
		allEngeniersSoftwares.add(employ);
	}
	/**
	 * Can not be 2 person with the same seniority
	 */
	public void addAllEmployers(){
		System.out.println("All the employers");
		allEmployers.addAll(allManagers);
		allEmployers.addAll(allEngeniersSoftwares);
		for (Employ employ : allEmployers) {
			System.out.println(employ);
		}
	}
	public void allEmployersWithoutParking(){
		employersWithoutParking.addAll(allEmployers);
		
		if (numberOfParking < employersWithoutParking.size()){
			System.out.println("-----------------------------------------------");
			System.out.println("All te employers without parking are ");
			for (int i = numberOfParking; i < employersWithoutParking.size();i++){
				Employ employ = employersWithoutParking.get(i);
				System.out.println(employ.getName());
			}
		}else{
			System.out.println("All the employers have parking access");
		}
	}
}
