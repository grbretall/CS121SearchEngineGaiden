package SearchEngine;

import java.sql.SQLException;

public class RunSearchEngine {

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		long startTime = System.currentTimeMillis();
		SearchEngine se = new SearchEngine();
		se.performSearch();
	}

}
