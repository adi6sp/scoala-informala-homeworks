/**
 * 
 */
package io.homework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RaduAdrian
 *
 */
public class CountingProcess {

	private Votes vote;
	public int invalidVotes;
	public int validVotes;
	public int votesForMuttley;
	public int votesForMrBean;
	public int votesForSpirtMona;
	public int votesForAtree;
	private boolean ilegalVote;

	public CountingProcess(Votes vote) {
		super();
		this.vote = vote;
	}
	
	public synchronized void checkCitizenVotes() throws IOException{
			
		List <CitizenVot> allVotes = vote.loadAll();
		List <CitizenVot> newListAllVotes = new ArrayList<>();		
		for (CitizenVot citizen : allVotes) {
			if (citizen.getCandidateName().equals(" ")){
				calculateInvalidVotes();
			}else{
				if (newListAllVotes.isEmpty()){
					newListAllVotes.add(citizen);
				}else{
					countingVotes(newListAllVotes, citizen);
					if (ilegalVote == true){
						System.out.println(citizen.getName()+" has broken the rules and will be fined. All of his votes are invalidated.");
					}
				}	
			}
		}
		votesForMrBean = calculatePercentage(validVotes, votesForMrBean);
		votesForSpirtMona = calculatePercentage(validVotes, votesForSpirtMona);
		votesForAtree = calculatePercentage(validVotes, votesForAtree);
		votesForMuttley = calculatePercentage(validVotes, votesForMuttley);
						
	}
	private void countingVotes(List<CitizenVot> allValidVotes, CitizenVot citizen) {
		ilegalVote = false;
		for (CitizenVot citizenVot : allValidVotes){
			if (citizen.getCnp().equals(citizenVot.getCnp())){
				ilegalVote = true;
				invalidVotes = calculateInvalidVotes() + 1;
			}else{
				if (citizen.getCandidateName().equals("Mr. Bean")){
					votesForMrBean += 1 ;
				}
				if (citizen.getCandidateName().equals("Spirt Mona")){
					votesForSpirtMona += 1 ;
				}
				if (citizen.getCandidateName().equals("Muttley")){
					votesForMuttley += 1 ;
				}
				if (citizen.getCandidateName().equals("A tree")){
					votesForAtree += 1 ;
				}
				calculateValidVotes();
			}
		}
	}
	
	public int calculateInvalidVotes(){
		invalidVotes += 1;
		return	invalidVotes;		
	}
	
	public int calculateValidVotes(){
		validVotes +=1 ;
		return validVotes;
	}
	
	public int calculatePercentage(int max, int actual) {
		return actual*100/max;
	}
}
