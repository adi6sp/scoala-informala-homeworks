package io.homework;

import java.io.IOException;
import java.util.List;

public interface Votes {

	void save(CitizenVot citizenVot) throws IOException;
	List<CitizenVot> loadAll() throws IOException;
}
