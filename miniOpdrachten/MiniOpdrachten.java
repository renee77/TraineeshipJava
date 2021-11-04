package miniOpdrachten;

import java.util.Random;

public class MiniOpdrachten {

	public static void main(String[] args) {
		String woord = "hottentottententententoonstelling";
		char letter = 't';
		System.out.println("de letter " + letter + " komt " + hoeveelKeer(letter, woord) + " keer voor, in het woord " + woord);
		
		int[] lijst = { 1, 3, 6, 95, 35};
		System.out.println("uitkomst optellen array = " + telArrayOp(lijst));
		
		int[] tienGetallen = arrayTienRandomGetallen();
		System.out.println();
		sortArray(tienGetallen);		
		
	}
	
	static int hoeveelKeer(char letter, String woord) {
		int count = 0;
		for (int i = 0; i < woord.length(); i++) {
			if (woord.charAt(i) == letter) {
				count++;
			}
		}
		return count;
	}
	
	static int telArrayOp(int[] array) {
		int totaal = 0;
		for(int i = 0; i < array.length; i++) {
			totaal += array[i];
		}
		
		return totaal;
	}
	
	static int[] arrayTienRandomGetallen(){
		int[] arrayGetal = new int[10];
		
		for (int i = 0; i  < 10; i++) {
			arrayGetal[i] = new Random().nextInt(100);
			System.out.print(arrayGetal[i] + " ");
		}
		return arrayGetal;
	}
	
	static void sortArray(int[]arrayGetal) {
		int temp;
		// sorteren van de array ik vergelijk index 1 met 0, daarna 2 met 0 en 1, daarna 3 met 0, 1, 2
		for (int i = 1; i < arrayGetal.length; i++ )
		{
			for (int j = 0; j < i; j++) {
				if (arrayGetal[i] < arrayGetal[j]) {
					temp = arrayGetal[i];
					arrayGetal[i] = arrayGetal[j];
					arrayGetal[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < arrayGetal.length; i++) {
			System.out.print(arrayGetal[i] + " ");
		}
	}

}

class Auto{
	private boolean motor = false;
	private boolean deur = false;
	private boolean voorruit = false;
	private boolean uitlaat = false;
	
	Auto(boolean[] lijst){
		for (int i = 0; i < lijst.length; i++) {
			if (lijst[i]) {
				switch (i) {
				case 0: 
					this.motor = true;
					break;
				case 1:
					this.deur = true;
					break;
				case 2:
					this.voorruit = true;
					break;
				case 3:
					this.uitlaat = true;
				break;
				}
			}
		}
	}
	
	public String toString() {
		return " ";
	}
}

class Monteur{
	
}
