package miniOpdrachten;

import java.util.*;

public class MiniOpdrachten {

	public static void main(String[] args) {
		// opdracht 2
		String woord = "hottentottententententoonstelling";
		char letter = 't';
		System.out.println("de letter " + letter + " komt " + hoeveelKeer(letter, woord) + " keer voor, in het woord " + woord);
		
		// opdracht 3
		int[] lijst = { 1, 3, 6, 95, 35};
		System.out.println("uitkomst optellen array = " + telArrayOp(lijst));
		
		// opdracht 4
		int[] tienGetallen = arrayTienRandomGetallen();
		System.out.println();
		sortArray(tienGetallen);	
		System.out.println();
		
		//opdracht 5
		boolean[] onderdelen = { true, false, true, false};
		Auto vroem = new Auto(onderdelen);
		System.out.println(vroem.toString());
		new Monteur().repareerAuto(vroem);
		System.out.println(vroem.toString());
		
		//opdracht 7 lingo
		Scanner input = new Scanner(System.in);
		//new Lingo().speelLingo(input);
		
		// opdracht 8
		Boot boot = new Boot();
		SpeedBoot speedBoot = new SpeedBoot();
		Kapitein kapitein = new Kapitein();
		kapitein.varen(speedBoot);
		kapitein.varen(boot);
		
		
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
		String kapotteOnderdelen = "Kapot zijn: ";
		String heleOnderdelen = "Heel zijn: ";
		if(this.motor) {
			kapotteOnderdelen = kapotteOnderdelen.concat("de motor ");
		} else {
			heleOnderdelen = heleOnderdelen.concat("de motor ");
		}
		if(this.deur) {
			kapotteOnderdelen = kapotteOnderdelen.concat("de deur ");
		} else {
			heleOnderdelen = heleOnderdelen.concat("de deur ");
		}
		if(this.voorruit) {
			kapotteOnderdelen = kapotteOnderdelen.concat("de voorruit ");
		} else {
			heleOnderdelen = heleOnderdelen.concat("de voorruit ");
		}
		if(this.uitlaat) {
			kapotteOnderdelen = kapotteOnderdelen.concat("de uitlaat ");
		} else {
			heleOnderdelen = heleOnderdelen.concat("de uitlaat ");
		}
		
		
		return kapotteOnderdelen + heleOnderdelen;
	}

	public boolean getMotor() {
		return motor;
	}

	public void setMotor(boolean motor) {
		this.motor = motor;
	}

	public boolean getDeur() {
		return deur;
	}

	public void setDeur(boolean deur) {
		this.deur = deur;
	}

	public boolean getVoorruit() {
		return voorruit;
	}

	public void setVoorruit(boolean voorruit) {
		this.voorruit = voorruit;
	}

	public boolean getUitlaat() {
		return uitlaat;
	}

	public void setUitlaat(boolean uitlaat) {
		this.uitlaat = uitlaat;
	}
	
	
}

class Monteur{
	void repareerAuto(Auto auto) {
		int prijs = 0;
		
		for (int i = 0; i < 4; i++) {
			switch(i) {
			case 0:
				if (auto.getMotor()) {
					auto.setMotor(false);
					System.out.println("Motor gemaakt!");
					prijs += 25;
				}
			case 1:
				if (auto.getDeur()) {
					auto.setDeur(false);
					System.out.println("Deur gemaakt!");
					prijs += 25;
				}
			case 2:
				if (auto.getVoorruit()) {
					auto.setVoorruit(false);
					System.out.println("Voorruit gemaakt!");
					prijs += 25;
				}
			case 3:
				if (auto.getUitlaat()) {
					auto.setUitlaat(false);
					System.out.println("Uitlaat gemaakt!");
					prijs += 25;
				}
			}
			
		
		}
		System.out.println("De kosten zijn " + prijs + " euro!");
	}
	
}

class Lingo{
	private String woord = "fiets";
	private String woordSpeler;
	private ArrayList<Integer> geradenLetters = new ArrayList<Integer>();
	private ArrayList<Character> spelerLetters = new ArrayList<Character>();
	private ArrayList<Character> letters = new ArrayList<Character>();
	private boolean gewonnen =  false;
	
	void speelLingo(Scanner input) {
		// woord in arraylist
		for (int i = 0; i < woord.length(); i++) {
			letters.add(woord.charAt(i));
		}
		// geradenLetters instellen op 0 geraden letters
		for(int i = 0; i < woord.length(); i++) {
			geradenLetters.add(0);
		}
		
		System.out.println("Raad een woord van " + woord.length() + " letters");
		System.out.println("2 is Letter goed en op juiste plaats, 1 is Letter goed niet op juiste plek, 0 is foute Letter.");
		
		//loop totdat de speler het woord heeft geraden
		while(!gewonnen) {
			// input speler	
			System.out.println("Voer een woord in: ");
			// weergave juistheid van geraden letters
			for (int i = 0; i < geradenLetters.size(); i++) {
				System.out.print(geradenLetters.get(i).toString());
			}
			System.out.println();
			woordSpeler = input.next();
			
			//woordSpeler in arrayList
			for (int i = 0; i < woordSpeler.length(); i++) {
				spelerLetters.add(woordSpeler.charAt(i));
			}
			
			// vergelijking van de woorden
			if (woord.equalsIgnoreCase(woordSpeler)) { // gewonnen als de strings hetzelfde zijn
				System.out.println("Gefeliciteerd je hebt gewonnen! Het woord is " + woord);
				gewonnen = true;
			} else if (woord.length() == woordSpeler.length()){ // check op juiste lengte invoer
				for (int i = 0; i < woord.length(); i++) { 
					for (int j = 0 ; j < woord.length(); j++) {
						if (woordSpeler.charAt(i) == woord.charAt(j) && i == j) {
							geradenLetters.set(i, 2);
							break;
						} else if (woordSpeler.charAt(i) == woord.charAt(j)) {
							geradenLetters.set(i, 1);
							break;
						} else {
							geradenLetters.set(i, 0);
						}
					}
				}
			} else {
				System.out.println("Onjuiste invoer!");
			}
			
			
		}
		//zodat het volgende spel weer schoon begint.
		gewonnen = false;	
	
	}
	
}

class Boot{
	void starten() {
		System.out.println("De boot vaart");
	}
}

class SpeedBoot extends Boot{
	void starten() {
		System.out.println("De speedboot vaart");
	}
}

class Kapitein{
	void varen(Boot boot) {
		if (boot instanceof SpeedBoot) {
			System.out.println("Ik zet mijn pet even af!");
		}
		boot.starten();
	}
}
