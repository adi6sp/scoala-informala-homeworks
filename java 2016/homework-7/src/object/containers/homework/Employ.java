package object.containers.homework;

public class Employ implements Comparable<Employ>{
	private String name;
	private int numberOfYearsSpentInTheCompany;
	public Employ(int numberOfYearsSpentInTheCompany, String name) {
		super();
		this.numberOfYearsSpentInTheCompany = numberOfYearsSpentInTheCompany;
		this.name = name;
	}
	public int getnumberOfYearsSpentInTheCompany() {
		return numberOfYearsSpentInTheCompany;
	}
	public void setnumberOfYearsSpentInTheCompany(int numberOfYearsSpentInTheCompany) {
		this.numberOfYearsSpentInTheCompany = numberOfYearsSpentInTheCompany;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employ [numberOfYearsSpentInTheCompany=" + numberOfYearsSpentInTheCompany + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Employ o) {
		if (this.numberOfYearsSpentInTheCompany < o.getnumberOfYearsSpentInTheCompany()) {
			return 1;
		}
		if (this.numberOfYearsSpentInTheCompany > o.getnumberOfYearsSpentInTheCompany()) {
			return -1;
		}
		return 0;
	}
	
}
