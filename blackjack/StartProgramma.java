package blackjack;
import java.util.*;

public class StartProgramma {
	public static void main (String[] args) {
		PlayBlackJack spel = new PlayBlackJack();
		
		spel.startGame();		
	}
}

class PlayBlackJack{
	// hoe kan ik hier al de userName van de bank meegeven en niet in een functie?
	Player blackJackPlayer = new Player();
	Player bank = new Player();
	CardDeck playingCards = new CardDeck();	
		
	void startGame() {
		System.out.println("Welkom bij blackjack");
		blackJackPlayer.userName= blackJackPlayer.vraagNaam();
		bank.userName = "Bank";
		
		playingCards.showCards(playingCards.deck);
		playingCards.deck = playingCards.shuffledCards(playingCards.deck);
		
		Scanner askStart = new Scanner(System.in);
		System.out.println("Wilt u beginnen met het spel? Type J of N");
		String begin = askStart.nextLine();
		
		if (begin.equals("J")) {
			playGame();
		} else {
			System.out.println("U koos niet voor J, spel wordt gestopt.");
		}		
		
	}
	
	void playGame() {
		blackJackPlayer.hand.add(playingCards.dealCard());
		blackJackPlayer.hand.add(playingCards.dealCard());
		blackJackPlayer.showHand();
		
		bank.hand.add(playingCards.dealCard());
		bank.showHand();
		
		boolean playGame = true;
		
		
		
		while (playGame) {
			int playerHandValue = 0;
			for (int i = 0; i < blackJackPlayer.hand.size(); i ++) {
				playerHandValue += blackJackPlayer.hand.get(i).value;
			}
			int bankHandValue = 0;
			
			
			String choice = blackJackPlayer.gameChoice();
			if (choice.equals("K")) {
				bank.showHand();
				blackJackPlayer.hand.add(playingCards.dealCard());
				blackJackPlayer.showHand();
				playerHandValue = 0;
				for (int i = 0; i < blackJackPlayer.hand.size(); i ++) {
					playerHandValue += blackJackPlayer.hand.get(i).value;
				}
				
				if (playerHandValue > 21) {
					playGame = false;
					System.out.println("Game over, je hebt " + playerHandValue + " dat is meer dan 21 punten! De bank heeft gewonnen");
				} 
			} else if (choice.equals("P")) {
				while (playGame) {
					bank.hand.add(playingCards.dealCard());
					blackJackPlayer.showHand();
					bank.showHand();
				
					bankHandValue = 0;
					for (int i = 0; i < bank.hand.size(); i ++) {
						bankHandValue += bank.hand.get(i).value;
					}
					
					if (bankHandValue >= 17 && bankHandValue <= 21) {
						if (bankHandValue < playerHandValue) {
							System.out.println("Je hebt gewonnen!! Je had " + playerHandValue + " punten, de bank had " + bankHandValue + " punten. Proficiat!");
							playGame = false;
							} else {
								System.out.println("De bank heeft gewonnen met " + bankHandValue + " punten! Jij had er " + playerHandValue);
								playGame = false;
							}
					} else if (bankHandValue > 21) {
						System.out.println("Je hebt gewonnen!! Je had " + playerHandValue + " punten, de bank had " + bankHandValue + " punten, dat is meer dan 21. Proficiat!");
						playGame = false;
						}
				}
				
					
				
			} else if (choice.equals("S")) {
				System.out.println("U wilt stoppen het spel is voorbij.");
				playGame = false;
			}
				
		}	
		
	}
}

class Player{
	String userName;
	ArrayList<Card> hand = new ArrayList<Card>();
	
	String vraagNaam() {
		Scanner askName = new Scanner(System.in);
		System.out.println("Wat is je naam?");
		
		String userName = askName.nextLine();
		System.out.println("Hallo " + userName + ", veel plezier!");
		return userName;
	}
	
	void addCardToHand(Card next) {
		Card nextCard = new Card();
		nextCard = next;
		hand.add(nextCard);

	}
	
	void showHand() {
		System.out.println("Dit is de hand van: " + userName);
		for (int i = 0; i < hand.size(); i++) {
			System.out.print(hand.get(i).cardSymbol +" ");			
		}	
		System.out.println("\n");
	}
	
	String gameChoice() {
		Scanner ask = new Scanner(System.in);
		System.out.println("Wat wil je doen? \n Kies K voor nog een kaart, \n Kies P om te passen, \n Kies S om te stoppen");
		
		return ask.nextLine();
		
	}
	
	
	
	
}
class Card {
	int value;
	String cardSymbol;
}

class CardDeck{
	ArrayList<Card> deck = new ArrayList<Card>();
	
	CardDeck() {
		String[] cardSequence = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
		String[] suits = {"S", "H", "D", "C"};
		Card playingCard = null;
		
		for (String suit : suits) {
			for (String value : cardSequence) {
				playingCard = new Card();
				playingCard.cardSymbol = suit + value;
				
				// dit moet korter kunnen?
				if (value.equals("2")) {
					playingCard.value = 2;
				} else if(value.equals("3")) {
					playingCard.value = 3;
				} else if(value.equals("4")) {
					playingCard.value = 4;
				} else if(value.equals("5")) {
					playingCard.value = 5;
				} else if(value.equals("6")) {
					playingCard.value = 6;
				} else if(value.equals("7")) {
					playingCard.value = 7;
				} else if(value.equals("8")) {
					playingCard.value = 8;
				} else if(value.equals("9")) {
					playingCard.value = 9;
				} else if(value.equals("T")) {
					playingCard.value = 10;
				} else if(value.equals("J")) {
					playingCard.value = 10;
				} else if(value.equals("Q")) {
					playingCard.value = 10;
				} else if(value.equals("K")) {
					playingCard.value = 10;
				} else if(value.equals("A")) {
					playingCard.value = 11;
				}  
				
				deck.add(playingCard);
							
			}
		}
		
			
	}

	ArrayList<Card> shuffledCards(ArrayList<Card> deck) {
		Collections.shuffle(deck);
		return deck; 
	}
	
	void showCards(ArrayList<Card> cardDeck) {
		System.out.println("Dit zijn de kaarten waarmee gespeeld gaat worden:");
		for (int i =0; i < cardDeck.size(); i++) {
			if (i% 13 == 0) {
				System.out.println();
			}
			System.out.print(cardDeck.get(i).cardSymbol + ", ");
			
		}
		System.out.println();
		System.out.println();
		
	}
	
	Card dealCard() {
		Card playedCard = new Card();
		playedCard = deck.get(0);
		deck.remove(0);
		return playedCard;
	}
	
}