package object.containers.homework;

public class Main {

	public static void main(String[] args) {
		CompanySystem system = new CompanySystem();
		system.addManager(new Employ(10,"Mihai"));
		system.addManager(new Employ(2,"Mircea"));
		system.addManager(new Employ(9,"Adi"));
		system.addManager(new Employ(14,"Gabi"));
		system.addEngeniersSoftware(new Employ(11,"Razvan"));
		system.addEngeniersSoftware(new Employ(8,"Raul"));
		system.addEngeniersSoftware(new Employ(12,"Cata"));
		system.addAllEmployers();
		system.allEmployersWithoutParking();
	}

}
