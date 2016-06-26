/**
 * 
 */
package io.homework;

/**
 * @author RaduAdrian
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		try(VotesList votes = new VotesList()){
			votes.open();
			CountingProcess calculate =new CountingProcess(votes);
			votes.save(new CitizenVot("1982037357397", "Dick Dastardly", "Muttley"));
			votes.save(new CitizenVot("2909763891982", "Burt Reynolds", "Mr. Bean"));
			votes.save(new CitizenVot("0977187368992","Ronaldo", "Spirt Mona"));
			votes.save(new CitizenVot("8889097263791","Britney Spears", "A tree"));
			votes.save(new CitizenVot("9555682954009","Stevie Wonder", " "));
			votes.save(new CitizenVot("1982037357397","Dick Dastardly", "Muttley"));
			votes.save(new CitizenVot("6789293661803","Scooby Doo", "Mr. Bean"));
			votes.close();
			reportCountingVotes(calculate);
		}
	}

	private synchronized static void reportCountingVotes(CountingProcess calculate) {
		new Thread("votes-thread") {
			public void run() {
				try {
						Thread.sleep(5000);
						calculate.checkCitizenVotes();
						System.out.println("--------------------------------------------");
						System.out.println("Invalide votes "+calculate.invalidVotes);
						System.out.println("Valide votes "+calculate.validVotes);
						System.out.println("Mr. Bean votes "+calculate.votesForMrBean+" %");
						System.out.println("Spirt Mona votes "+calculate.votesForSpirtMona+" %");
						System.out.println("Muttley votes "+calculate.votesForMuttley+" %");
						System.out.println("A tree votes "+calculate.votesForAtree+" %");
		
				}catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}.start();
	}
}
