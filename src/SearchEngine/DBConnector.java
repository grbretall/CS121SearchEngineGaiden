package SearchEngine;



import java.io.File;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class DBConnector 
{
	private Connection connection;
	public static HashSet<String> excludedWords = new HashSet<String>();
	
	
	public DBConnector() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		// Incorporate mySQL driver
        Class.forName("com.mysql.jdbc.Driver").newInstance();
         // Connect to the test database
        connection = DriverManager.getConnection("jdbc:mysql:///wordrelations","infom141", "cs121");
        excludedWords.clear();
		//excludedWords.addAll(Utilities.tokenizeFile(new File("resources.txt")));
	}
	

	/**
	 * Attempts to close the data base connection.
	 * */
	
	public void dbConnectorCloser() throws SQLException{
		connection.close();
	}
	public int findWordIdByWord(String word) throws SQLException
	{
		//String queryString = "SELECT * FROM words WHERE words.word = '"+word+"';";
		String queryString = "SELECT * FROM words WHERE words.word = ?;";
		
		//Statement select = connection.createStatement();
		PreparedStatement select = connection.prepareStatement(queryString);
		select.setString(1, word);
		ResultSet result = select.executeQuery();
		while (result.next())
		{
			//System.out.println(result.getInt(1)+" "+ result.getString(2));
			return result.getInt(1);
		}
		System.out.println("nothing here");
		return 0;
	}
	
	/*
	 * select group_concat(u.id), w.word
	 * from words w, urls u, words_in_url wiu
	 * where w.id = wiu.word_id && u.id = wiu.url_id && w.id = 122
	 * group by w.id;
	 */
	public String findUrlIdByWordId(long wordId) throws SQLException
	{
		String queryString = "select group_concat(u.id), w.word from words w, urls u, words_in_url wiu where w.id = wiu.word_id && u.id = wiu.url_id "
				+ "&& w.id = ? group by w.id;";
		PreparedStatement select = connection.prepareStatement(queryString);
		select.setLong(1, wordId);
		ResultSet result = select.executeQuery();
		while(result.next())
		{
			return result.getString(1);
		}
		System.out.println("Nothing here");
		return null;
	}
	

}
