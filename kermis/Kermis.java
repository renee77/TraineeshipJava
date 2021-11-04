package kermis;
import java.util.Scanner;

// programma dat omzet kermis bijhoudt

public class Kermis {
	public static void main(String[] args) {
		BotsAutos botsautos = new BotsAutos();
		Spin spin = new Spin();
		SpiegelPaleis spiegelPaleis = new SpiegelPaleis();
		Spookhuis spookhuis = new Spookhuis();
		Hawaii hawaii = new Hawaii();
		LadderKlimmen ladderKlimmen = new LadderKlimmen();
		
		boolean stoppen = false;
		Scanner input = new Scanner(System.in);
		
		while (!stoppen) {
			System.out.println("Kies een attractie: 1 = botsautos, 2 = spin, 3 = spiegelpaleis, 4 = Spookhuis, 5 = hawaii, 6 = ladderklimmen of 0 om te stoppen");
			System.out.println("Of kies 7 om administratie in te zien");
			int keuze = input.nextInt();
			
			switch(keuze) {
			case 0: stoppen = true;
			break;
			case 1: botsautos.draaien();
			break;
			case 2: spin.draaien();
			break;
			case 3: spiegelPaleis.draaien();
			break;
			case 4: spookhuis.draaien();
			break;
			case 5: hawaii.draaien();
			break;
			case 6: ladderKlimmen.draaien();
			break;
			case 7: 
				System.out.println("Voer in: O = Omzet, K = aantalverkochte kaartjes");
				String adminKeuze = input.next();
				if (adminKeuze.equals("O")) {
					System.out.println("Totaal omzet is " + botsautos.totaalOmzet);
					break;
				} else if (adminKeuze.equals("K")) {
					System.out.println("Totaal verkochte kaartjes is " + botsautos.totaalKaartjes);
					break;
				}
			default: System.out.println("Onjuiste invoer");
			}
		
		}
	}
	
}

abstract class Atractie{
	String naam;
	double prijs;
	double oppervlakte;
	double omzet = 0;
	int kaartjes= 0;
	static double totaalOmzet = 0;
	static int totaalKaartjes = 0;
	
	void draaien() {
		System.out.println(naam + " draait!");
		omzet += prijs;
		kaartjes++;
		totaalOmzet += prijs;
		totaalKaartjes++;
	}
	
}

class BotsAutos extends Atractie{
	BotsAutos(){
		prijs = 2.50;
		naam = "Botsautos";
	}
	
}

class Spin extends Atractie{
	Spin(){
		prijs = 2.25;
		naam = "Spin";
	}
	public void draaien() {
		super.draaien();
		
	}
}

class SpiegelPaleis extends Atractie{
	SpiegelPaleis(){
		prijs = 2.75;
		naam = "SpiegelPaleis";
	}
	
}

class Spookhuis extends Atractie{
	Spookhuis(){
		prijs = 3.20;
		naam = "Spookhuis";
	}
	
}

class Hawaii extends Atractie{
	Hawaii(){
		prijs = 2.90;
		naam = "Hawaii";
	}
	
}

class LadderKlimmen extends Atractie{
	LadderKlimmen(){
		naam = "LadderKlimmen";
		prijs = 5.0;
	}
	
}

