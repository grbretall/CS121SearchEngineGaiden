import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class FrequencyFloatMap 
{

	private HashMap<String, Double> wordFrequencyFloatMap;
	private HashSet<String> excludedWords = new HashSet<String>();
	
	public FrequencyFloatMap()
	{
		wordFrequencyFloatMap  = new HashMap<String, Double>();
		excludedWords = new HashSet<String>();
	}
	
	public void addToMap(String token)
	{
		if(excludedWords.contains(token) || token.length() < 2)
		{
			return;
		}
		else if(wordFrequencyFloatMap.containsKey(token))
		{
			wordFrequencyFloatMap.put(token, wordFrequencyFloatMap.get(token)+1);
		}
		else
		{
			wordFrequencyFloatMap.put(token, 1.0);
		}
	}
	
	public void addToMap(String token, double value){
		//System.out.println("token:"+ token+ " value:"+ value);
		wordFrequencyFloatMap.put(token, value);
	}
	
	public HashMap<String, Double> getMap()
	{
		return wordFrequencyFloatMap;
	}
	
	public double getFrequency(String key)
	{
		return wordFrequencyFloatMap.get(key);
	}
	
	public void setExcludedWords(HashSet<String> toSet){
		excludedWords = toSet;
	}
	
	public void clear()
	{
		wordFrequencyFloatMap.clear();
	}
	
	public ArrayList<FrequencyFloat> sort()
	{
		ArrayList<FrequencyFloat> returnList = new ArrayList<FrequencyFloat>();
		//Comparator new FrequencyComparator();
		wordFrequencyFloatMap.forEach((key, value) -> 
				returnList.add(new FrequencyFloat(key, value)));
		Collections.sort(returnList, new FrequencyFloatComparator());
		return returnList;
	}
}
