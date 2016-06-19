package io.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VotesList implements Votes,AutoCloseable {

	protected static final String FILE_NAME = "vote.txt";
	private FileWriter writer;
	
	@Override
	public void save(CitizenVot citizenVot) throws IOException {
		File file = new File(FILE_NAME);
		try (FileWriter writer = new FileWriter(file, true)) {
			writer.write(citizenVot+"\n");
		}
	}

	@Override
	public List<CitizenVot> loadAll() throws IOException {
		File file = new File(FILE_NAME);
		List<CitizenVot> citizenVotes = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			while(line!=null){
				String[] info = line.split(",");
				citizenVotes.add(new CitizenVot(info[0], info[1], info[2]));
				line = reader.readLine();
			}
		}
		
		return citizenVotes;
	}

	public void open() throws IOException {
		File file = new File(FILE_NAME);
		writer = new FileWriter(file, true);
	}
	
	public void close() throws IOException{
		if(writer!=null){
			writer.close();
		}
	}
	

}
