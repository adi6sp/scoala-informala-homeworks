package io.homework;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class CountingProcessTest {
	Votes vote;
	@Test
	public void checkAllInavalidVotes() throws IOException {
		
		CountingProcess counting = new CountingProcess( vote);
		assertEquals(0, counting.invalidVotes);
	}

	@Test
	public void checkAllValidVotes() throws IOException{

		CountingProcess counting = new CountingProcess( vote);
		assertEquals(0, counting.validVotes);
	}
}

