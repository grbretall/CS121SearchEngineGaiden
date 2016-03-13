//Project by Gregory Bretall (21284961), Miles Bonner (82127215), Zach Anderson (22109634), and Lauren Dimailig (73117811)
package SearchEngine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Utilities.FrequencyFloat;
import Utilities.FrequencyFloatMap;
import Utilities.tfIdfCalculator;

public class SearchEngine 
{
	FrequencyFloatMap searchResults;
	DBConnector dbc;
	final int corpusSize = 44535;
	
	public SearchEngine() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		searchResults = new FrequencyFloatMap();
		dbc = new DBConnector();
	}
	
	public void performSearch() throws SQLException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a search term, with separate words delimited by spaces (type quit to quit): ");
		String[] currentTermList;
		int currentWordId;
		double currentTfIdfScore;
		long startTime = 0;
		ResultSet currentSearchResults;
		String current = scan.nextLine();
		while(!current.toLowerCase().equals("quit"))
		{
			if(current.equals(""))
			{
				System.out.println("Invalid Search Term");
			}
			else
			{
				startTime = System.currentTimeMillis();
				currentTermList = current.split(" ");
				for(String currentTerm: currentTermList)
				{
					System.out.println("about to access the db");
					currentSearchResults = dbc.findUrlIdByWordId(dbc.findWordIdByWord(currentTerm));
					System.out.println("about to update hashmap");
					while(currentSearchResults.next())
					{
						currentTfIdfScore = tfIdfCalculator.milesTFIDFCalculator(currentSearchResults.getInt(2), currentSearchResults.getInt(3), corpusSize);
						searchResults.addToMap(currentSearchResults.getString(1), currentTfIdfScore);
					}
				}
				System.out.println(toString());
				searchResults.clear();
				System.out.println("Time took in seconds: " + ((System.currentTimeMillis() - startTime)/1000));
			}
			System.out.println("Enter a search term, with separate words delimited by spaces (type quit to quit): ");
			current = scan.nextLine();
		}
	}
	
	public String toString()
	{
		String returnString = "";
		int numDocs = 0;
		ArrayList<FrequencyFloat> urlResultsList = searchResults.sort();
		if(urlResultsList.size() < 100)
		{
			for(int i = 0; i < urlResultsList.size(); i++)
			{
				returnString += urlResultsList.get(i).getText() + " \n";
				numDocs++;
			}
		}
		else
		{
			for(int i = 0; i < 100; i++)
			{
				returnString += urlResultsList.get(i).getText() +" "+ urlResultsList.get(i).getFrequency()+ " \n";
				numDocs++;
			}
		}
		returnString += "Number of relevant documents found: " + numDocs + " \n";
		return returnString;
	}
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
