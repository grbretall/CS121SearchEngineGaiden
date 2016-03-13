//Project by Gregory Bretall (21284961), Miles Bonner (82127215), Zach Anderson (22109634), and Lauren Dimailig (73117811)
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
		String queryString = "SELECT * FROM words WHERE words.word = ?;";
		
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
	
	
	public ResultSet findUrlIdByWordId(long wordId) throws SQLException
	{
		String queryString = "select u.url, wiu.frequency, w.occurences from words w, urls u, words_in_url wiu where w.id = wiu.word_id && u.id = wiu.url_id "
				+ "&& w.id = ?;";
		PreparedStatement select = connection.prepareStatement(queryString);
		select.setLong(1, wordId);
		ResultSet result = select.executeQuery();
		return result;
	}
	
	

}
