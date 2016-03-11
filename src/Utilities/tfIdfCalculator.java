package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class tfIdfCalculator
{
	private Connection connection;
	
	public tfIdfCalculator() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		// Incorporate mySQL driver
        Class.forName("com.mysql.jdbc.Driver").newInstance();
         // Connect to the test database
        connection = DriverManager.getConnection("jdbc:mysql:///wordrelations","infom141", "cs121");
	}
	
	public void close() throws SQLException {
		connection.close();
		HashMap<String,Integer> hash = new HashMap<String,Integer>(); 
	}
	
	
    private List<String[]> termsDocsArray = new ArrayList<String[]>();
    private List<String> allTerms = new ArrayList<String>(); //to hold all terms
    private List<double[]> tfidfDocsVector = new ArrayList<double[]>();
    
    public double milesTFIDFCalculator(Integer termF, Integer docFreq, Integer corpusSize){
    	double tfidf = (1+Math.log10(termF)) * Math.log10(Math.abs(corpusSize/docFreq));
    	return tfidf;
    }
}
