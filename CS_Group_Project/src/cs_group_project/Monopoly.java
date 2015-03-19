/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs_group_project;

/**
 *
 * @author md kashem
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Monopoly extends Applet implements ActionListener, WindowListener {
  
    
    
    static Frame mainFrame = new Frame( " Monopoly " );
	static MonopolyBoard monopolyBoard;
	static MonopolyPlayer monopolyplayer;
	static final DoubleBufferPanel dbp = new DoubleBufferPanel();
	static final BufferPanel bp = new BufferPanel();
	static final Frame a = new Frame();
	static final Frame help = new Frame();
	static PropertyManager propertymanager;
	private Button yes = new Button(" Yes ");
	private Button no = new Button (" No ");
	private Button Roll  = new Button( "Roll Dice" );
	private Button Buy   = new Button( "Buy Property" );
	private Button Add   = new Button( "Add a House" );
	private Button Rem   = new Button( "Sell a House" );
	private Button New   = new Button( "New Game" );
	private Button Done  = new Button( "Done" );
	private Button pay50 = new Button( "Get out of Jail!" );
	private Button start  = new Button( "Start" );
	private Button stop = new Button( "Stop" );
	private Button Help  = new Button( "Help" );
	private Button Credits = new Button( "Credits ");
	private Button ShortCuts = new Button ( "");
//	private List property;// = new List();
	static final TextField tf1 = new TextField("Player 1", 13 );
	static final TextField tf2 = new TextField("Player 2", 13 );
	static final Button b = new Button( "Start the Game!" );
	static final Button Quit = new Button ("Close X");
	static final Button Exit = new Button ("Exit this Game X");
	static final Button Exit2 = new Button ("Exit this Game X");
	static final Label comments = new Label ("Welcome to Monopoly! This game is created by " );
	static final Label comments1 = new Label ("group of student from WVU at Parkersburg."); 
	static final Label comments2 = new Label ("Please enter your names for player 1 and player 2 .");
	static final Label comments3 = new Label (" NB: this is a two player game only!");
	static final Label comments4 = new Label ("");
	static final Button Info = new Button ("Rules");
	private AudioClip sound;
	int Money = 1500;
	Image back ;
    
    public static void main(String argv[]) 
    {
     new Monopoly();

    }
    
    	public void init() {
		sound = getAudioClip(getDocumentBase(), "music.wav");
		back = getImage(getDocumentBase(),"mono.gif");
		a.setSize( 380, 390 );
		a.setBackground(new Color( (80), (180), (210) ));
		a.setLayout(new FlowLayout(FlowLayout.CENTER));
		a.setResizable(false);
		Panel mainstuff = new Panel(new GridLayout(0,1));
		mainstuff.add(comments);
		mainstuff.add(comments1);
		mainstuff.add(comments2);
		mainstuff.add(comments3);
		mainstuff.add(comments4);
		mainstuff.add(new Label ("            "));
		mainstuff.add( tf1);
		mainstuff.add(tf2);
		mainstuff.add(new Label ("          "));
		mainstuff.add( b );
		mainstuff.add(Info);
		mainstuff.add(Exit);
		a.add(mainstuff);
		a.setVisible( true );
		Exit.addActionListener(this);
		Info.addActionListener(this);
		b.addActionListener( this );
		mainFrame.addWindowListener( this );
	}
	public void paint(Graphics g){
		g.drawImage(back,15,15,this);
	}
	public void actionPerformed( ActionEvent e ) {
	if (e.getSource() == Info) {
			HelpDialog();
		}
		
	if (e.getSource() == Exit){
	    a.setVisible(false);    
	    }
	    
	if (e.getSource() == b){
		sound.loop();
		a.setVisible( false );
		monopolyBoard = new MonopolyBoard( tf1.getText(), tf2.getText() );
		dbp.setLayout( new BorderLayout() );
		bp.setLayout( new BorderLayout() );	
		mainFrame.setSize( 800,650 );
		mainFrame.setBackground(new Color( (80), (180), (210) ) ); //blue color
		mainFrame.setLayout( new FlowLayout(FlowLayout.CENTER));
		mainFrame.add(dbp );
		dbp.add( "Center", bp );
		bp.add( monopolyBoard);
		Panel buttons = new Panel(new GridLayout(0,1));
								
				buttons.add(Roll);
				Roll.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
							if( !monopolyBoard.rolled ) {
								monopolyBoard.Roll();
							}
					}});
				buttons.add(Done);
				Done.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						if( monopolyBoard.rolled ) {
								monopolyBoard.rolled = false;
								monopolyBoard.turn = !monopolyBoard.turn;
								repaint();
							}
						}});

				buttons.add(Buy);
				Buy.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						monopolyBoard.Buy();
					}});
				buttons.add(Add);
				Add.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						monopolyBoard.Add();
					}});
				buttons.add(Rem);
				Rem.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						monopolyBoard.Rem();
					}});
				buttons.add(New);
				New.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						monopolyBoard.New();
					}});
				buttons.add(pay50);
				pay50.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						monopolyBoard.pay50();
					}});
					
				buttons.add(Quit);
				Quit.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						monopolyBoard.quit();
					}});
				
				buttons.add(Help);
				Help.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						HelpDialog();
					}});
				
		
				buttons.add(start);
				Credits.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						sound.loop();
					}});

				buttons.add(stop);
				Credits.addActionListener(new ActionListener() {
					public void actionPerformed( ActionEvent e ) {
						sound.stop();
					}});
					
					
		mainFrame.add(buttons);
		mainFrame.setVisible( true );
		}
	}
	public void HelpDialog()  {
		TextArea taHelp;
		String s = "OBJECT\n"+
	"The object of the game is to become the wealthiest player through buying, renting and selling property.\n"+								
	"EQUIPMENT\n"+ 
	"The equipment consists of a board, 2 dice, tokens, 32 houses and 12 hotels. There are Chance and Community Chest cards, a Title Deed card for each property and play money.\n"+
	"PREPARATION\n"+
	"Place the board on a table and put the Chance and Community Chest cards face down on their allotted spaces on the board. Each player chooses one token to represent him/her while traveling around the board.\n"+
	"Each player is given $1500 divided as follows: 2 each of $500's, $100's and $50's; 6 $20's; 5 each of $10's, $5's and $1's."+
	"All remaining money and other equipment go to the Bank."+		
	"BANKER"+
	"Select as Banker a player who will also make a good Auctioneer. A Banker who plays in the game must keep his/her personal funds separate from those of the Bank. When more than five persons play, the Banker may elect to act only as Banker and Auctioneer."+
	"THE BANK"+
	"Besides the Bank's money, the Bank holds the Title Deed cards and houses and hotels prior to purchase and use by the players. The Bank pays salaries and bonuses. It sells and auctions properties and hands out the proper Title Deed cards; it sells houses and hotels to the players and loans money when required on mortgages."+
	"The Bank collects all taxes, fines, loans and interest, and the price of all properties which it sells and auctions."+
	"The Bank never goes broke. If the Bank runs out of money, the Banker may issue as much more as may be needed by writing on any ordinary paper."+
	"THE PLAY"+
	"Starting with the Banker, each player in turn throws the dice. The player with the highest total starts the play: Place your token on the corner marked "+"GO,"+" throw the dice and move your token in the direction of the arrow the number of spaces indicated by the dice. After you have completed your play, the turn passes to the left. The tokens remain on the spaces occupied and proceed from that point on the player's next turn. Two or more tokens may rest on the same space at the same time."+					
	"According to the space your token reaches, you may be entitled to buy real estate or other properties--or obliged to pay rent, pay taxes, draw a Chance or Community Chest card, Go to Jail®, etc."+
	"If you throw doubles, you move your token as usual, the sum of the two dice, and are subject to any privileges or penalties pertaining to the space on which you land. Retaining the dice, throw again and move your token as before. If you throw doubles three times in succession, move your token immediately to the space marked (In Jail) (see JAIL)."+
	"GO"+
	"Each time a player's token lands on or passes over GO, whether by throwing the dice or drawing a card, the Banker pays him/her a $200 salary."+
	"The $200 is paid only once each time around the board. However, if a player passing GO on the throw of the dice lands 2 spaces beyond it on Community Chest, or 7 spaces beyond it on Chance, and draws the"+ "Advance to GO" +"card, he/she collects $200 for passing GO the first time and another $200 for reaching it the second time by instructions on the card."+
	"BUYING PROPERTY"+
	"Whenever you land on an unowned property you may buy that property from the Bank at its printed price. You receive the Title Deed card showing ownership; place it face up in front of you."+
	"If you do not wish to buy the property, the Banker sells it at auction to the highest bidder. The buyer pays the Bank the amount of the bid in cash and receives the Title Deed card for that property. Any player, including the one who declined the option to buy it at the printed price, may bid. Bidding may start at any price."+
	"PAYING RENT"+
	"When you land on property owned by another player, the owner collects rent from you in accordance with the list printed on its Title Deed card."+
	"If the property is mortgaged, no rent can be collected. When a property is mortgaged, its Title Deed card is placed face down in front of the owner."+
	"It is an advantage to hold all the Title Deed cards in a color-group (e.g., Boardwalk and Park Place; or Connecticut, Vermont and Oriental Avenues) because the owner may then charge double rent for unimproved properties in that color-group. This rule applies to unmortgaged properties even if another property in that color-group is mortgaged."+
	"It is even more advantageous to have houses or hotels on properties because rents are much higher than for unimproved properties."+
	"The owner may not collect the rent if he/she fails to ask for it before the second player following throws the dice."+
	"CHANCE"+"and"+  "COMMUNITY CHEST"+
	"When you land on either of these spaces, take the top card from the deck indicated, follow the instructions and return the card face down to the bottom of the deck."+
	"The "+"Get Out of Jail Free"+" card is held until used and then returned to the bottom of the deck. If the player who draws it does not wish to use it, he/she may sell it, at any time, to another player at a price agreeable to both."+
	"INCOME TAX"+
	"If you land here you have two options: You may estimate your tax at $200 and pay the Bank, or you may pay 10% of your total worth to the Bank. Your total worth is all your cash on hand, printed prices of mortgaged and unmortgaged properties and cost price of all buildings you own."+
	"You must decide which option you will take before you add up your total worth."+
	"JAIL"+
	"You land in Jail when... (1) your token lands on the space marked"+ "Go to Jail"+"; (2) you draw a card marked "+"Go to Jail"+"; or (3) you throw doubles three times in succession."+
	"When you are sent to Jail you cannot collect your $200 salary in that move since, regardless of where your token is on the board, you must move directly into Jail. Your turn ends when you are sent to Jail."+
	"If you are not"+ "sent"+" to Jail but in the ordinary course of play land on that space, you are"+ "Just Visiting,"+" you incur no penalty, and you move ahead in the usual manner on your next turn."+
	"You get out of Jail by... (1) throwing doubles on any of your next three turns; if you succeed in doing this you immediately move forward the number of spaces shown by your doubles throw; even though you had thrown doubles, you do not take another turn; (2) using the - Get Out of Jail Free - card if you have it; (3) purchasing the  - Get Out of Jail Free - card from another player and playing it; (4) paying a fine of $50 before you roll the dice on either of your next two turns."+
	"If you do not throw doubles by your third turn, you must pay the $50 fine. You then get out of Jail and immediately move forward the number of spaces shown by your throw."+
	"Even though you are in Jail, you may buy and sell property, buy and sell houses and hotels and collect rents."+
	"FREE PARKING"+
	"A player landing on this place does not receive any money, property or reward of any kind. This is just a "+"free"+" resting place."+
	"HOUSES"+
	"When you own all the properties in a color-group you may buy houses from the Bank and erect them on those properties."+
	"If you buy one house, you may put it on any one of those properties. The next house you buy must be erected on one of the unimproved properties of this or any other complete color-group you may own."+
	"The price you must pay the Bank for each house is shown on your Title Deed card for the property on which you erect the house."+
	"The owner still collects double rent from an opponent who lands on the unimproved properties of his/her complete color-group."+
	"Following the above rules, you may buy and erect at any time as many houses as your judgment and financial standing will allow. But you must build evenly, i.e., you cannot erect more than one house on any one property of\n"+
	"any color-group until you have built one house on every property of that group. You may then begin on the second row of houses, and so on, up to a limit of four houses to a property. For example, you cannot build three houses on one property if you have only one house on another property of that group./n"+
	"As you build evenly, you must also break down evenly if you sell houses back to the Bank (see SELLING PROPERTY)."+
	"HOTELS"+
	"When a player has four houses on each property of a complete color-group, he/she may buy a hotel from the Bank and erect it on any property of the color-group. He/she returns the four houses from that property to the Bank and pays the price for the hotel as shown on the Title Deed card. Only one hotel may be erected on any one property.\n"+
	"BUILDING SHORTAGES\n"+
	"When the Bank has no houses to sell, players wishing to build must wait for some player to return or sell his/her houses to the Bank before building. If there are a limited number of houses and hotels available and two or more players wish to buy more than the Bank has, the houses or hotels must be sold at auction to the highest bidder.\n"+
	"SELLING PROPERTY\n"+
	"Unimproved properties, railroads and utilities (but not buildings) may be sold to any player as a private transaction for any amount the owner can get; however, no property can be sold to another player if buildings are standing on any properties of that color-group. Any buildings so located must be sold back to the Bank before the owner can sell any property of that color-group.\n"+
	"Houses and hotels may be sold back to the Bank at any time for one-half the price paid for them.\n"+
	"All houses on one color-group may be sold at once, or they may be sold one house at a time (one hotel equals five houses), evenly, in reverse of the manner in which they were erected.\n"+
	"RULES for a SHORT GAME (60 to 90 minutes):\n"+
	"1. There are three changed rules for this Short Game. 1. During PREPARATION for play, the Banker shuffles the pack of Title Deed cards, has the player to the left cut them, then deals out two, one at a time, to each player. The players must immediately pay the Bank the printed price of each. Play then begins as in the regular game.\n"+
	"2. In this short game, it is necessary to have only three houses (instead of four) on each lot of a complete color-group before the player may buy a hotel.\n"+
	"Rent for a hotel remains the same as in the regular game.\n"+
	"The turn-in value of a hotel is still one-half the purchase price, which in this game is one house fewer than in the regular game.\n"+
	"3. END OF GAME. The first player to go bankrupt retires from play, as in the regular game; however, when the second bankruptcy occurs, the game ends. Play immediately ceases, with the bankrupt player's turning over to his/her creditor all that he/she has of value, including buildings and any other properties. This happens whether the creditor is a rival player or the Bank.\n"+
	"Each remaining player then values his/her property: (1) cash on hand; (2) lots, utilities and railroads owned, at the price printed on the board; (3) any mortgaged property owned, at one-half the price printed on the board; (4) houses, valued at purchase price; (5) hotels, valued at purchase price including the value of the three houses turned in.\n"+
	"The richest player wins!\n"+
	"ANOTHER GOOD SHORT GAME: TIME LIMIT GAME\n"+
	"Before starting, agree upon a definite hour of termination, when the richest player will be declared the winner. Before starting, the Banker shuffles and cuts the Title Deed cards and deals two to each player. Players immediately pay the Bank the price of the properties dealt to them.\n";


 		Button exit = new Button ("<< Return Back");
		Frame help = new Frame();
		help.setSize(500,320);
		help.setResizable(false);
		taHelp = new TextArea(s, 5, 20);
		taHelp.setEditable(false);
		taHelp.setForeground(Color.blue);
		help.add(taHelp);
		help.setVisible(true);
		help.addWindowListener(this);

    }

	public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	}
	public void windowIconified( WindowEvent e ) {}
	public void windowClosed( WindowEvent e ) {}
	public void windowActivated( WindowEvent e ) {}
	public void windowDeactivated( WindowEvent e ) {}
	public void windowDeiconified( WindowEvent e ) {}
	public void windowOpened( WindowEvent e ) {}
	public void processKeyEvent (KeyEvent e) {
		if( e.getKeyChar() =='q' || e.getKeyChar() == 'Q'){
		    mainFrame.setVisible (false);
		    System.exit(0);}
		}

}
