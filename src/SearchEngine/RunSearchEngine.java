//Project by Gregory Bretall (21284961), Miles Bonner (82127215), Zach Anderson (22109634), and Lauren Dimailig (73117811)

package SearchEngine;

import java.sql.SQLException;

public class RunSearchEngine {

	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		long startTime = System.currentTimeMillis();
		SearchEngine se = new SearchEngine();
		se.performSearch();
	}

}
