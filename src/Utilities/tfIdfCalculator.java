//Project by Gregory Bretall (21284961), Miles Bonner (82127215), Zach Anderson (22109634), and Lauren Dimailig (73117811)
package Utilities;

public class tfIdfCalculator
{
    public static double milesTFIDFCalculator(Integer termF, Integer docFreq, Integer corpusSize){
    	double tfidf = (1+Math.log10(termF)) * Math.log10(Math.abs(corpusSize/docFreq));
    	return tfidf;
    }
}
