//Project by Gregory Bretall (21284961), Miles Bonner (82127215), Zach Anderson (22109634), and Lauren Dimailig (73117811)
package SearchEngine;

import java.sql.SQLException;


public class DbTestDriver {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		/*DBConnector db = new DBConnector();
		int wordId = db.findWordIdByWord("science");
		System.out.println(wordId);
		System.out.println(db.findUrlIdByWordId(wordId));
		db.dbConnectorCloser();*/
		long startTime = System.currentTimeMillis();
		SearchEngine se = new SearchEngine();
		se.performSearch();
	}

}
