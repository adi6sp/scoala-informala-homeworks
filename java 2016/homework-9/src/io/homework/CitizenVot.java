package io.homework;

public class CitizenVot {

	String cnp;
	String name;
	String candidateName;
	
	public CitizenVot(String cnp, String name, String candidateName) {
		this.cnp = cnp;
		this.name = name;
		this.candidateName = candidateName;
	}

	public String getCnp() {
		return cnp;
	}

	public String getName() {
		return name;
	}

	public String getCandidateName() {
		return candidateName;
	}

	@Override
	public String toString() {
		return cnp + "," + name + "," + candidateName;
	}
	
	
}
