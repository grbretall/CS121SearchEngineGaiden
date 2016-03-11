package Utilities;

public class tfIdfCalculator
{
    public double milesTFIDFCalculator(Integer termF, Integer docFreq, Integer corpusSize){
    	double tfidf = (1+Math.log10(termF)) * Math.log10(Math.abs(corpusSize/docFreq));
    	return tfidf;
    }
}
