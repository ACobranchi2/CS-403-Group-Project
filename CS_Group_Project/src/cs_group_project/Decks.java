/**
 * Author: Sean
 * 
 * Creates the chance and community chest decks with a method to draw a random card from the respective deck.
 * 
 * methods require methods that will move the player and add or subtract money from the player.
 */
import java.util.ArrayList;

public class Decks {
	
	//array for card strings
	private ArrayList<String> chance;
	private ArrayList<String> community;
	
	// constructor to create the two decks
	public Decks(){
		
		chance = new ArrayList<String>();
		chance.add("Pay poor tax of $15.");
		chance.add("Make repairs to property.  Pay $200.");
		chance.add("Advance to Illinois Avenue.");
		chance.add("Go back 3 spaces.");
		chance.add("Your building and loan matures.  Collect $150.");
		chance.add("Take a walk on the Board Walk.");
		chance.add("Advance to St. Charles Place.");
		chance.add("Elected Chairman of the Board, pay $50.");
		chance.add("Take a ride on the Reading.  If owned, pay twice the amount.");
		chance.add("Bank pays you dividend of $50.");
		chance.add("Advance to Go.");
		chance.add("Go directly to Jail.");
		
		community = new ArrayList<String>();
		community.add("Go directly to Jail.");
		community.add("Second prize in a beauty contest.  Collect $10.");
		community.add("Bank error in your favor.  Collect $200.");
		community.add("Doctor's fee, Pay $50.");
		community.add("Christmas Fund matures, Collect $100.");
		community.add("Grand Opening.  Collect $50.");
		community.add("Advance to Go.");
		community.add("Life insurance matures, Collect $100.");
		community.add("Pay school tax of $150.");
		community.add("Assessed for street repairs.  Pay $150.");
		community.add("You inherit $100.");
		community.add("From Sale of stock, you get $45.");
		community.add("Pay Hospital $100.");
		community.add("Income tax refund, Collect $20.");
		
	}
	
	// method to draw a random chance card
	public String chanceDraw(){
		
		int cardNumber = (int) Math.floor(Math.random() * chance.size());
		if (cardNumber == 0){
			
			//player method - 15
			
			return chance.get(cardNumber);
		}
		
		else if (cardNumber == 1){
			
			//player method - 200
			
			return chance.get(cardNumber);
		}
		
		else if (cardNumber == 2){
			
			//method to move player to illinois avenue
			
			return chance.get(cardNumber);
		}
		
		else if (cardNumber == 3){
			
			//method to move player back 3 spaces
			
			return chance.get(cardNumber);
		}
		
		else if (cardNumber == 4){
			
			//player method + 150
			
			return chance.get(cardNumber);
		}
		
		else if (cardNumber == 5){
			
			//player method to move player to boardwalk
			
			return chance.get(cardNumber);
		}
		
		else if (cardNumber == 6){
			
			//player method to move player to st. charels place
			
			return chance.get(cardNumber);
		}
		
		else if (cardNumber == 7){
			
			//player method - 50
			
			return chance.get(cardNumber);
		}
		
		else if (cardNumber == 8){
			
			//player method move to reading railroad double payment method
			
			return chance.get(cardNumber);
		}
		
		else if (cardNumber == 9){
			
			//player method + 50
			
			return chance.get(cardNumber);
		}
		
		else if (cardNumber == 10){
			
			//player method to move to go
			
			return chance.get(cardNumber);
		}
		
		else{
			
			//player method to move to jail
			
			return chance.get(cardNumber);
		}
	}
	
	//method to draw a random community chest card
	public String communityDraw(){
		
		int cardNumber = (int) Math.floor(Math.random() * community.size());
		if (cardNumber == 0){
			
			//player method to move to jail
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 1){
			
			//player method + 10
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 2){
			
			//player method + 200
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 3){
			
			//player method - 50
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 4){
			
			//player method + 100
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 5){
			
			//player method + 50
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 6){
			
			//player method to move player to go
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 7){
			
			//player method + 100
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 8){
			
			//player method - 150
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 9){
			
			//player method - 150
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 10){
			
			//player method + 100
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 11){
			
			//player method + 45
			
			return community.get(cardNumber);
		}
		
		else if (cardNumber == 12){
			
			//player method - 100
			
			return community.get(cardNumber);
		}
		
		else{
			
			//player method + 20
			
			return community.get(cardNumber);
		}
	}

}
