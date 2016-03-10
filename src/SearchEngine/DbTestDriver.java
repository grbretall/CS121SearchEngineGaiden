package SearchEngine;

import java.sql.SQLException;


public class DbTestDriver {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DBConnector db = new DBConnector();
		int wordId = db.findWordIdByWord("science");
		System.out.println(wordId);
		System.out.println(db.findUrlIdByWordId(wordId));
		db.dbConnectorCloser();

	}

}
