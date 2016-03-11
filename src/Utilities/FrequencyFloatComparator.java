package Utilities;
import java.util.Comparator;

//Code base formed from on sample from https://stackoverflow.com/questions/3408976/sort-array-first-by-length-then-alphabetically-in-java
public class FrequencyFloatComparator implements Comparator<FrequencyFloat>{
   //overriding of the compare function for Frequency
   public int compare(FrequencyFloat f1, FrequencyFloat f2){
      //to create a list in descending order
      if (f1.getFrequency() < f2.getFrequency()){
         return 1;
      } else if (f1.getFrequency() > f2.getFrequency()){ 
         return -1;
      }
      return f1.getText().compareTo(f2.getText());
   }
}