//Project by Gregory Bretall (21284961), Miles Bonner (82127215), Zach Anderson (22109634), and Lauren Dimailig (73117811)
package Utilities;
public final class FrequencyFloat {
	private final String word;
	private double frequency;
	
	public FrequencyFloat(String word) {
		this.word = word;
		this.frequency = 0;
	}
	
	public FrequencyFloat(String word, double frequency) {
		this.word = word;
		this.frequency = frequency;
	}
	
	public String getText() {
		return word;
	}
	
	public double getFrequency() {
		return frequency;
	}
	
	public void incrementFrequency() {
		frequency++;
	}
	
	@Override
	public String toString() {
		return word + ":" + frequency;
	}
}
