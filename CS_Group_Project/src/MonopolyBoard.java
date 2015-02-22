/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACobranchi
 */
import java.applet.Applet;
import java.applet.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.*;
import java.awt.List;
import java.awt.image.*;
import java.lang.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalIconFactory.*;
///////////////////////////////////////////////////
public class MonopolyBoard extends Component {
	private int Width  = 550;
	private int Height = 570;
	//The propertymanager and the players
	private PropertyManager propertymanager;
	private MonopolyPlayer monopolyplayer;
	private Monopoly monopoly;
	private MonopolyPlayer Player1;
	private MonopolyPlayer Player2;
        private MonopolyPlayer Player3;
        private MonopolyPlayer Player4;
        private MonopolyPlayer Player5;
        private MonopolyPlayer Player6;
        private MonopolyPlayer Player7;
        private MonopolyPlayer Player8;
	static final Frame quit = new Frame("Are you sure?");
	static final Frame pr = new Frame("Properties");
	static final Choice choice = new Choice();
	static final Choice p2 = new Choice();	
	static final Frame trade = new Frame("Trade Your Properties");
	private Image board;
	// if turn == true, it is player1's turn
	public boolean turn   = true;
	// if rolled == true, the player has already rolled.
	public boolean rolled = false;
	// the numbers on the dice
	private int Dice1 = 0;
	private int Dice2 = 0;
	// The frame that pops up when you must sell houses because you are in debt
	final Frame frame = new Frame( "Must sell" );
	// The 'remove houses' frame
	final Frame fr = new Frame( "Remove Houses" );
	// if noMoney == true, the player whose turn it is is in debt.
	private boolean noMoney = false;	
////////////////////////////////////////////////////////////////////////////////////
	public MonopolyBoard( String one, String two, String three, String four, 
                String five, String six, String seven, String eight) {
		//create the two players with the specified names
		Player1 = new MonopolyPlayer( one, 1 );
		Player2 = new MonopolyPlayer( two, 2 );
                Player3 = new MonopolyPlayer( three, 3 );
                
		//create the propertymanager with the two players
		propertymanager = new PropertyManager( Player1, Player2 );
		//enable events for the board
		enableEvents( AWTEvent.MOUSE_EVENT_MASK );
		enableEvents( AWTEvent.KEY_EVENT_MASK );
		repaint();
	}
	//public void init() {
	//	board = getImage(getDocumentBase(),"boards.gif");
	//}
	public void paint( Graphics g ) {
		//Draw the board
//		g.drawImage(board,1,1,this);
		g.setColor( new Color( (80), (180), (210) ) ); 		//board
//		g.setColor( new Color( (80), (180), (110) ) );
//		g.setColor(Color.white);
//		g.setColor(Color.lightGray);
		g.fillRect( 1, 1, 569, 539 );
		///g.fill3DRect( 501, 1, 740, 598, true );
		g.setColor( Color.white );
		g.fill3DRect( 5, 5, 488, 488, true );
		g.setColor( new Color( (80), (180), (210) ) ); //blue color
		g.fill3DRect( 100, 100, 300, 300, true ); //box in the middle

		g.setColor( new Color( (100), (30), (100) ) );
		g.fill3DRect( 80, 300, 20, 33, true );				//baltic
		g.fill3DRect( 80, 366, 20, 33, true );				//mediterranean

		g.setColor( new Color( (200), (200), (240) ) );
		g.fill3DRect( 80, 100, 20, 33, true );				//connecticut
		g.fill3DRect( 80, 133, 20, 33, true );				//vermont
		g.fill3DRect( 80, 200, 20, 33, true );				//oriental
		

		g.setColor( new Color( (200), (30), (200) ) );
		g.fill3DRect( 100, 80, 33, 20, true );				//st.charles ave.
		g.fill3DRect( 166, 80, 33, 20, true );				//states ave.
		g.fill3DRect( 200, 80, 33, 20, true );				//virginia ave.


		g.setColor( new Color( (220), (140), (140) ) );
		g.fill3DRect( 266, 80, 33, 20, true );				//st. james
		g.fill3DRect( 333, 80, 33, 20, true );				//tennessee
		g.fill3DRect( 366, 80, 33, 20, true );				//new york


		g.setColor( new Color( (180), (10), (10) ) );
		g.fill3DRect( 400, 100, 20, 33, true );				//kentucky
		g.fill3DRect( 400, 166, 20, 33, true );				//indiana	
		g.fill3DRect( 400, 200, 20, 33, true );				//illinois
		

		g.setColor( Color.yellow );
		g.fill3DRect( 400, 266, 20, 33, true );				//atlantic	
		g.fill3DRect( 400, 300, 20, 33, true );				//ventnor	
		g.fill3DRect( 400, 366, 20, 33, true );				//marvin gardens		

		g.setColor( new Color( (10), (180), (10) ) );
		g.fill3DRect( 366, 400, 33, 20, true );				//pacific
		g.fill3DRect( 333, 400, 33, 20, true );				//North Carolina
		g.fill3DRect( 266, 400, 33, 20, true );				//Pensylvania
		
		g.setColor( new Color( (30), (30), (100) ) );
		g.fill3DRect( 100, 400, 33, 20, true );				//Boardwalk
		g.fill3DRect( 166, 400, 33, 20, true );				//ParkPlace
		g.setColor( new Color( (180), (40), (40) ) );

		g.fill3DRect( 30, 30, 70, 70, true );				//jail

		g.setColor( new Color( (230), (230), (230) ) );
		g.fill3DRect( 80, 166, 20, 33, true );				//Chance
		g.fill3DRect( 400, 133, 20, 33, true );				//Chance
		g.fill3DRect( 200, 400, 33, 20, true );				//Chance
		g.fill3DRect( 300, 80, 33, 20, true );				//Comm. Chest
		g.fill3DRect( 80, 333, 20, 33, true );				//Comm. Chest
		g.fill3DRect( 300, 400, 33, 20, true );				//Comm. Chest
		g.fill3DRect( 80, 233, 20, 33, true );				//RR
		g.fill3DRect( 233, 80, 33, 20, true );				//RR
		g.fill3DRect( 400, 233, 20, 33, true );				//RR
		g.fill3DRect( 233, 400, 33, 20, true );				//RR
		g.fill3DRect( 133, 80, 33, 20, true );				//Electricity
		
		g.fill3DRect( 400, 333, 20, 33, true );				//Water
		
		g.fill3DRect( 7,  400, 93, 93, true );				//Go
		g.fill3DRect( 400, 400, 93, 93, true );				//Go to jail
		g.fill3DRect( 400, 7, 93, 93, true );				//free parking
		
		
//		g.setColor( new Color( (230), (230), (230) ) );			//Free parking
//		g.fill3DRect( 300, 200, 100, 100 ,true);
		g.setColor( Color.black );
//		g.drawString( "Free Parking", 314, 220 );
		String fp =  "$" + propertymanager.Properties[20][1];
		g.setFont( new Font( "Courier", Font.BOLD, 15 ) );
	//	FontMetrics fm = g.getFontMetrics();
	//	int wide = fm.stringWidth( fp );

		// Draw how much money is in the middle
		g.drawString( fp, 412 , 90 );

		//Draw the words for the properties
		g.setColor( Color.black );
		g.setFont( new Font( "Courier", Font.BOLD, 30 ) );
		g.drawString( "GO",30, 460 );						//Go
		g.setFont( new Font( "verdana", Font.BOLD, 10 ) );
		g.drawString( "?", 87, 184 );						//Chance
		g.drawString( "?", 407, 151 );						//Chance
		g.drawString( "?", 212, 413 );						//Chance
		g.setColor( Color.black );
		g.drawString( "Income Tax - $200", 8, 288 );		//income tax
		g.drawString( "CC", 84, 353 );						//Comm. Chest
		g.drawString( "CC", 307, 93 );						//Comm. Chest
		g.drawString( "CC", 307, 413 );						//Comm. Chest
		g.drawString( "Tax", 142, 446 );					//Luxury Tax
		g.drawString( "$75", 142, 463 );
		g.setFont( new Font( "Verdana", Font.BOLD, 22 ) );
		g.drawString( "Go to", 416, 435 );					//Go to jail
		g.drawString( "Jail", 426, 465 );
		g.drawString( "Free", 425, 45 );					//Free parking
		g.drawString( "Parking", 407, 69 );
		g.drawString( "Jail", 48, 73 );						//Jail
		g.setFont( new Font( "arial",Font.BOLD, 8 ) );
		//Water
		g.drawString( "Water", 430, 350 );
		g.drawString( "Works", 430, 360 );
		//Electricity
		g.drawString( "E", 143, 20 );
		g.drawString( "l", 143, 30 );
		g.drawString( "e", 143, 40 );
		g.drawString( "c", 143, 50 );
		g.drawString( "t", 143, 60 );
		g.drawString( "r", 143, 70 );
		g.drawString( "i", 143, 80 );
		g.drawString( "c", 143, 90 );
		g.drawString( "C", 153, 30 );
		g.drawString( "O", 153, 40 );
		//ParkPlace
		g.drawString( "P", 174, 436 );
		g.drawString( "a", 174, 446 );
		g.drawString( "r", 174, 456 );
		g.drawString( "k", 174, 466 );
		g.drawString( "P", 184, 436 );
		g.drawString( "l", 184, 446 );
		g.drawString( "a", 184, 456 );
		g.drawString( "c", 184, 466 );
		g.drawString( "e", 184, 476 );
		//Boardwalk
		g.drawString( "B", 108, 426 );
		g.drawString( "o", 108 ,436);
		g.drawString( "a", 108, 446 );
		g.drawString( "r", 108, 456 );
		g.drawString( "d", 108, 466 );
		g.drawString( "w", 118, 456 );
		g.drawString( "a", 118, 466 );
		g.drawString( "l", 118, 476 );
		g.drawString( "k", 118, 486 );
		//Pensylvania
		g.drawString("P",275,426);
		g.drawString("e",275,436);
		g.drawString("n",275,446);
		g.drawString("s",275,456);
		g.drawString("y",275,466);
		g.drawString("l",275,476);
		g.drawString("v",275,486);
		g.drawString("a",275,446);
		g.drawString("n",275,456);
		g.drawString("i",275,466);
		g.drawString("a",275,476);
		//North Carolina
		g.drawString("N",341,426);
		g.drawString("o",341,436);
		g.drawString("r",341,446);
		g.drawString("t",341,456);
		g.drawString("h",341,466);
		g.drawString("C",341,426);
		g.drawString("a",341,436);
		g.drawString("r",341,446);
		g.drawString("o",341,456);
		g.drawString("l",341,466);
		g.drawString("i",341,476);
		g.drawString("n",341,486);
		g.drawString("a",341,496);
		//pacific
		g.drawString("P",374,426);
		g.drawString("a",374,436);
		g.drawString("c",374,446);
		g.drawString("i",374,456);
		g.drawString("f",374,466);
		g.drawString("i",374,476);
		g.drawString("c",374,486);
		//marvin gardens
		g.drawString( "Marvin", 430, 386);
		g.drawString( "Gardens", 430, 396);
		//ventnor
		g.drawString( "Ventour", 430 ,320 );
		g.drawString("C",110,20);
		g.drawString("h",110,30);
		g.drawString("a",110,40);		
		g.drawString("r",110,50);
		g.drawString("l",110,60);
		g.drawString("e",110,70);
		g.drawString("s",110,80);
		g.drawString("A",120,20);
		g.drawString("v",120,30);
		g.drawString("e",120,40);

		//states ave.
		g.drawString("S",176,20);
		g.drawString("t",176,30);
		g.drawString("a",176,40);
		g.drawString("t",176,50);
		g.drawString("e",176,60);
		g.drawString("s",176,70);
		g.drawString("A",186,20);
		g.drawString("v",186,30);
		g.drawString("e",186,40);
		//virginia ave.
		g.drawString("V",210,20);
		g.drawString("i",210,30);
		g.drawString("r",210,40);
		g.drawString("g",210,50);
		g.drawString("i",210,60);
		g.drawString("n",210,70);
		g.drawString("i",210,80);
		g.drawString("a",210,90);
		g.drawString("A",220,30);
		g.drawString("v",220,40);
		g.drawString("e",220,50);
		//st. james
		g.drawString("S",276,20);
		g.drawString("t",276,30);
		g.drawString("J",286,30);
		g.drawString("a",286,40);
		g.drawString("m",286,50);
		g.drawString("e",286,60);
		g.drawString("s",286,70);
		//tennessee
//		DrawVertString("tennesse",340,10);
		g.drawString("t",340,10);
		g.drawString("e",340,20);
		g.drawString("n",340,30);
		g.drawString("n",340,40);
		g.drawString("e",340,50);
		g.drawString("s",340,60);
		g.drawString("s",340,70);
		g.drawString("e",340,80);
		g.drawString("e",340,90);
		//new york
		g.drawString("n",376,20);
		g.drawString("e",376,30);
		g.drawString("w",376,40);
		g.drawString("y",376,50);
		g.drawString("o",376,60);
		g.drawString("r",376,70);
		g.drawString("k",376,80);
		//kentucky		
		g.drawString( "Kentucky", 430, 120 );
		//indiana
		g.drawString( "Indiana", 430, 185 );
		//illinois
		g.drawString( "Illinois", 430, 220);
		//atlantic
		g.drawString( "Atlantic", 430, 286 );
		//oriental
		g.drawString("Oriental", 10,220);
		//vermont
		g.drawString("Vermont", 10,153);
		//connecticut
		g.drawString("Connecticut", 10,120);
		//mediterranean
		g.drawString ("Mediterranean", 10,386);
		//baltic
		g.drawString ("Baltic" , 10,326);


		//Draw the outlines of each property
		g.drawLine( 7, 100, 79, 100 );
		g.drawLine( 7, 133, 79, 133 );
		g.drawLine( 7, 166, 79, 166 ); 
		g.drawLine( 7, 200, 79, 200 ); 
		g.drawLine( 7, 233, 79, 233 ); 
		g.drawLine( 7, 266, 79, 266 ); 
		g.drawLine( 7, 300, 79, 300 ); 
		g.drawLine( 7, 333, 79, 333 ); 
		g.drawLine( 7, 366, 79, 366 ); 
		g.drawLine( 7, 400, 79, 400 ); 
		g.drawLine( 421, 100, 490, 100 );
		g.drawLine( 421, 133, 490, 133 );
		g.drawLine( 421, 166, 490, 166 );
		g.drawLine( 421, 200, 490, 200 );
		g.drawLine( 421, 233, 490, 233 );
		g.drawLine( 421, 266, 490, 266 );
		g.drawLine( 421, 300, 490, 300 );
		g.drawLine( 421, 333, 490, 333 );
		g.drawLine( 421, 366, 490, 366 );
		g.drawLine( 421, 400, 490, 400 );
		g.drawLine( 100, 79, 100, 7 );
		g.drawLine( 133, 79, 133, 7 );
		g.drawLine( 166, 79, 166, 7 );
		g.drawLine( 200, 79, 200, 7 );
		g.drawLine( 233, 79, 233, 7 );
		g.drawLine( 266, 79, 266, 7 );
		g.drawLine( 300, 79, 300, 7 );
		g.drawLine( 333, 79, 333, 7 );
		g.drawLine( 366, 79, 366, 7 );
		g.drawLine( 400, 79, 400, 7 );
		g.drawLine( 100, 421, 100, 490 );
		g.drawLine( 133, 421, 133, 490 );
		g.drawLine( 166, 421, 166, 490 );
		g.drawLine( 200, 421, 200, 490 );
		g.drawLine( 233, 421, 233, 490 );
		g.drawLine( 266, 421, 266, 490 );
		g.drawLine( 300, 421, 300, 490 );
		g.drawLine( 333, 421, 333, 490 );
		g.drawLine( 366, 421, 366, 490 );
		g.drawLine( 400, 421, 400, 490 );

		//the array of positions for the location of where to draw the houses
		int places[][] = {	{-1,-1},{85,378},{-1,345},{85,312},{-1,-1},{85,245},{85,212},
						{-1,-1},{85,145},{85,112},{-1,-1},{112,85},{145,85},{178,85},
						{212,85},{245,85},{278,85},{-1,-1},{345,85},{378,85},{-1,-1},
						{405,112},{-1,-1},{405,178},{405,212},{405,245},{405,278},
						{405,312},{405,345},{405,378},{-1,-1},{378,405},{345,405},
						{-1,-1},{278,405},{245,405},{-1,-1},{178,405},{145,-1},
						{112,405}};
		
		//Draw how many houses are on each owned property
		for( int i=0;  i<40;  i++ ) {
			if( propertymanager.Properties[i][0] == 1 ) {
				g.setColor( Color.blue );
				g.fill3DRect(places[i][0],places[i][1],10,10,true );
				g.setColor( Color.white );
				g.setFont( new Font( "Verdana", Font.PLAIN, 8 ) );
				if(  propertymanager.Properties[i][1] != -1 )
					g.drawString( propertymanager.Properties[i][1]+"",places[i][0]+3,places[i][1]+8 );
			}
			else if( propertymanager.Properties[i][0] == 2 ) {
				g.setColor( Color.red );
				g.fill3DRect(places[i][0],places[i][1],10,10,true );
				g.setColor( Color.white );
				g.setFont( new Font( "Verdana", Font.PLAIN, 8 ) );
				if(  propertymanager.Properties[i][1] != -1 )
					g.drawString( propertymanager.Properties[i][1]+"",places[i][0]+3,places[i][1]+8 );
			}
		}

		//Draw the dice
		g.setColor( new Color( (230), (230), (230) ) );
		g.setFont( new Font( "verdana", Font.BOLD, 20 ) );
		g.fillRoundRect( 120, 150, 33, 33 ,5,5);
		g.fillRoundRect( 161, 150, 33, 33,5,5);
//		g.setFont( new Font( "Arial", Font.BOLD, 20 ) );
		g.setColor( Color.black );
		//Dice 1
		if (Dice1 ==1){
			g.fill3DRect(130,165,6,6,true);
		}
		else if (Dice1 == 2){
			g.fill3DRect(125,165,6,6,true);
			g.fill3DRect(145,165,6,6,true);
		}
		else if (Dice1 == 3){
			g.fill3DRect(125,155,6,6,true);
			g.fill3DRect(135,165,6,6,true);
			g.fill3DRect(145,175,6,6,true);
		}
		else if (Dice1 == 4){
			g.fill3DRect(125,155,6,6,true);
			g.fill3DRect(125,170,6,6,true);
			g.fill3DRect(140,155,6,6,true);
			g.fill3DRect(140,170,6,6,true);
		}
		else if (Dice1 == 5){
			g.fill3DRect(125,155,6,6,true);
			g.fill3DRect(125,170,6,6,true);
			g.fill3DRect(140,155,6,6,true);
			g.fill3DRect(140,170,6,6,true);
			g.fill3DRect(132,165,6,6,true);
		}
		else if (Dice1 == 6) {
			g.fill3DRect(125,155,6,6,true);
			g.fill3DRect(125,165,6,6,true);
			g.fill3DRect(125,175,6,6,true);
			g.fill3DRect(140,155,6,6,true);
			g.fill3DRect(140,165,6,6,true);
			g.fill3DRect(140,175,6,6,true);
		}
		//Dice 2
		g.setColor(Color.black);
		if (Dice2 ==1){
			g.fill3DRect(172,165,6,6,true);
		}
		else if (Dice2 == 2){
			g.fill3DRect(165,165,6,6,true);
			g.fill3DRect(185,165,6,6,true);
		}
		else if (Dice2 == 3){
			g.fill3DRect(165,155,6,6,true);
			g.fill3DRect(175,165,6,6,true);
			g.fill3DRect(185,175,6,6,true);
		}
		else if (Dice2 == 4){
			g.fill3DRect(165,155,6,6,true);
			g.fill3DRect(165,170,6,6,true);
			g.fill3DRect(175,155,6,6,true);
			g.fill3DRect(175,170,6,6,true);
		}
		else if (Dice2 == 5){
			g.fill3DRect(165,155,6,6,true);
			g.fill3DRect(165,170,6,6,true);
			g.fill3DRect(180,155,6,6,true);
			g.fill3DRect(180,170,6,6,true);
			g.fill3DRect(172,165,6,6,true);
		}
		else if (Dice2 == 6) {
			g.fill3DRect(165,155,6,6,true);
			g.fill3DRect(165,165,6,6,true);
			g.fill3DRect(165,175,6,6,true);
			g.fill3DRect(180,155,6,6,true);
			g.fill3DRect(180,165,6,6,true);
			g.fill3DRect(180,175,6,6,true);
		}
		g.drawString("Total=" + (Dice1 + Dice2),200,190);
		
		//Draw the border around the property stats
		//g.setColor( new Color( (200), (200), (240) ) );

		g.setColor(Color.white);	
		g.fill3DRect( 107, 203, 184, 192, true );
		g.setColor(Color.black);
		g.drawRect( 112,205,170,185);
	/*	if (propertymanager.one.Position == 1  || propertymanager.one.Position == 3 ||propertymanager.two.Position == 1 || propertymanager.two.Position== 3   )
			g.setColor(Color.blue);
		else if (propertymanager.one.Position == 0 || propertymanager.one.Position == 2 || propertymanager.one.Position == 4 || propertymanager.one.Position == 7|| propertymanager.one.Position == 17|| propertymanager.one.Position == 22 || propertymanager.one.Position == 4 || propertymanager.one.Position == 36|| propertymanager.one.Position == 38|| propertymanager.two.Position == 0 || propertymanager.two.Position == 2 || propertymanager.two.Position == 4 || propertymanager.two.Position == 7|| propertymanager.two.Position == 17|| propertymanager.two.Position == 22 || propertymanager.two.Position == 33|| propertymanager.two.Position == 36|| propertymanager.two.Position == 38)
			g.setColor(Color.lightGray);
		else if (propertymanager.one.Position == 6 || propertymanager.one.Position == 8 || propertymanager.one.Position == 9 || propertymanager.two.Position== 6 ||propertymanager.two.Position== 8||propertymanager.two.Position== 9)
			g.setColor( new Color( (200), (200), (240) ) );
		else if (propertymanager.one.Position == 11 || propertymanager.one.Position == 13 || propertymanager.one.Position == 14 || propertymanager.two.Position== 11 ||propertymanager.two.Position== 13||propertymanager.two.Position== 14)
			g.setColor( new Color( (200), (30), (200) ) );
		else if (propertymanager.one.Position == 16 || propertymanager.one.Position == 18 || propertymanager.one.Position == 19 || propertymanager.two.Position== 16 ||propertymanager.two.Position== 18 || propertymanager.two.Position== 19)
			g.setColor( new Color( (220), (140), (140) ) );
		else if (propertymanager.one.Position == 21 || propertymanager.one.Position == 23 || propertymanager.one.Position == 24 || propertymanager.two.Position== 21 ||propertymanager.two.Position== 23 ||propertymanager.two.Position== 24)
			g.setColor( new Color( (180), (10), (10) ) );
		else if (propertymanager.one.Position == 26 || propertymanager.one.Position == 27 || propertymanager.one.Position == 29 || propertymanager.two.Position== 26 ||propertymanager.two.Position== 27 ||propertymanager.two.Position== 29 )
			g.setColor(Color.yellow);
		else if (propertymanager.one.Position == 31 || propertymanager.one.Position == 32 || propertymanager.one.Position == 34 || propertymanager.two.Position== 31 ||propertymanager.two.Position== 32 ||propertymanager.two.Position== 34)
			g.setColor(new Color( (10),(180),(10)));
		else if (propertymanager.one.Position == 37 || propertymanager.one.Position == 39  || propertymanager.two.Position== 37 ||propertymanager.two.Position== 39)
			g.setColor(new Color( (30), (30), (100) ));
		else 
			g.setColor(Color.white);
			g.fillRect(116,210,160,50);*/
			g.setColor(Color.black);
			g.drawRect( 116,210,160,50);
			//g.drawRect( 110,207,182,190);



		//Draw the property stats for the property just landed on by the player
		if( turn ) {
		if (propertymanager.one.Position == 1  || propertymanager.one.Position == 3 ){
			g.setColor(Color.blue);
			g.fillRect(116,210,160,50);}			
		else if (propertymanager.one.Position == 0 || propertymanager.one.Position == 2 || propertymanager.one.Position == 4 || propertymanager.one.Position == 7|| propertymanager.one.Position == 17|| propertymanager.one.Position == 22 || propertymanager.one.Position == 4 || propertymanager.one.Position == 36|| propertymanager.one.Position == 38){
			g.setColor(Color.lightGray);
			g.fillRect(116,210,160,50);}
		else if (propertymanager.one.Position == 6 || propertymanager.one.Position == 8 || propertymanager.one.Position == 9 ){
			g.setColor( new Color( (200), (200), (240) ) );
			g.fillRect(116,210,160,50);}
		else if (propertymanager.one.Position == 11 || propertymanager.one.Position == 13 || propertymanager.one.Position == 14){
			g.setColor( new Color( (200), (30), (200) ) );
			g.fillRect(116,210,160,50);}
		else if (propertymanager.one.Position == 16 || propertymanager.one.Position == 18 || propertymanager.one.Position == 19 ){
			g.setColor( new Color( (220), (140), (140) ) );
			g.fillRect(116,210,160,50);}
		else if (propertymanager.one.Position == 21 || propertymanager.one.Position == 23 || propertymanager.one.Position == 24 ){
			g.setColor( new Color( (180), (10), (10) ) );
			g.fillRect(116,210,160,50);}
		else if (propertymanager.one.Position == 26 || propertymanager.one.Position == 27 || propertymanager.one.Position == 29 ){
			g.setColor(Color.yellow);
			g.fillRect(116,210,160,50);}
		else if (propertymanager.one.Position == 31 || propertymanager.one.Position == 32 || propertymanager.one.Position == 34 ){
			g.setColor(new Color( (10),(180),(10)));
			g.fillRect(116,210,160,50);}
		else if (propertymanager.one.Position == 37 || propertymanager.one.Position == 39  ){
			g.setColor(new Color( (30), (30), (100) ));
			g.fillRect(116,210,160,50);}		
		else {
			g.setColor(Color.white);
			g.fillRect(116,210,160,50);}	
				

			propertymanager.DrawPropertyStats( Player1.Position, 110, 207, g );
			g.setColor( Color.blue );
			g.setFont( new Font( "Courier", Font.PLAIN, 18 ) );
			g.drawString( "Turn = " + Player1.Name, 110, 120 );

			if( !rolled )
				g.drawString( "Roll", 180, 140 );
		}
		else { // for player 2
		if (propertymanager.two.Position == 1  || propertymanager.two.Position == 3 ){
			g.setColor(Color.blue);
			g.fillRect(116,210,160,50);}			
		else if (propertymanager.two.Position == 0 || propertymanager.two.Position == 2 || propertymanager.two.Position == 4 || propertymanager.two.Position == 7|| propertymanager.two.Position == 17|| propertymanager.two.Position == 22 || propertymanager.two.Position == 4 || propertymanager.two.Position == 36|| propertymanager.two.Position == 38){
			g.setColor(Color.lightGray);
			g.fillRect(116,210,160,50);}
		else if (propertymanager.two.Position == 6 || propertymanager.two.Position == 8 || propertymanager.two.Position == 9 ){
			g.setColor( new Color( (200), (200), (240) ) );
			g.fillRect(116,210,160,50);}
		else if (propertymanager.two.Position == 11 || propertymanager.two.Position == 13 || propertymanager.two.Position == 14){
			g.setColor( new Color( (200), (30), (200) ) );
			g.fillRect(116,210,160,50);}
		else if (propertymanager.two.Position == 16 || propertymanager.two.Position == 18 || propertymanager.two.Position == 19 ){
			g.setColor( new Color( (220), (140), (140) ) );
			g.fillRect(116,210,160,50);}
		else if (propertymanager.two.Position == 21 || propertymanager.two.Position == 23 || propertymanager.two.Position == 24 ){
			g.setColor( new Color( (180), (10), (10) ) );
			g.fillRect(116,210,160,50);}
		else if (propertymanager.two.Position == 26 || propertymanager.two.Position == 27 || propertymanager.two.Position == 29 ){
			g.setColor(Color.yellow);
			g.fillRect(116,210,160,50);}
		else if (propertymanager.two.Position == 31 || propertymanager.two.Position == 32 || propertymanager.two.Position == 34 ){
			g.setColor(new Color( (10),(180),(10)));
			g.fillRect(116,210,160,50);}
		else if (propertymanager.two.Position == 37 || propertymanager.two.Position == 39  ){
			g.setColor(new Color( (30), (30), (100) ));
			g.fillRect(116,210,160,50);}		
		else {
			g.setColor(Color.white);
			g.fillRect(116,210,160,50);}

			propertymanager.DrawPropertyStats( Player2.Position, 110, 207, g );
			g.setColor( Color.red);
			g.setFont( new Font( "Courier", Font.PLAIN, 18 ) );
			g.drawString( "Turn = " + Player2.Name, 110, 120 );
			if( !rolled )
				g.drawString( "Roll", 180, 140 );
		}
		//Draw the players

		Player1.DrawPlayer( g );
		
		Player2.DrawPlayer( g );
		
		//is the player out of money?  if so, draw the frame telling them they
		//must sell property
		if( (Player1.Money < 0 || Player2.Money < 0) && !frame.isShowing() ) {
			frame.setBackground( Color.lightGray );
			frame.setSize( 400, 110 );
			Label lab = new Label( "You must sell property or houses to pay your debt." );
			frame.add( lab );
			frame.setVisible( true );
			frame.addWindowListener( new WindowAdapter() {
				public void windowClosing( WindowEvent e ) {
					frame.setVisible( false );
				}
			});
			noMoney = true;
			Rem();
		}

	}
	
	/*public void DrawVertString (String propertyname,int x,int y){
		//String m = propertyname.length();
		for (int i = 0; i< propertyname;i++){
			y = y + 10;
			drawString(propertyname,x,y);
		}
		
	}*/
	
	
	//The usual component methods
	public boolean contains( int x, int y ) {
		if( x>0  &&  x<Width  &&  y>0  &&  y<Height ) 
			return true;
		return false;
	}
	public Dimension getPreferredSize() {
		return new Dimension( Width, Height );
	}
	public Dimension getMinimumSize() {
		return new Dimension( Width, Height );
	}
	
//mehtods used in Monopoly . java.
//getting out of jail...
	public void pay50() {
			if( turn && Player1.inJail ) {
						Player1.Money -= 50;
						System.out.println( Player1.Name +" paid $50 to get out of jail." );
						propertymanager.Properties[20][1] += 50;
						Player1.inJail = false;
					}
					else if( !turn && Player2.inJail ) {
						Player2.Money -= 50;
						System.out.println( Player2.Name +" paid $50 to get out of jail." );
						propertymanager.Properties[20][1] += 50;
						Player2.inJail = false;
					}
					repaint();
				}
				

	//credits

		
	//quiting the program;
	public void quit() {
	final Frame quit = new Frame();
		final Label question = new Label("Are you sure you want to end this game?" );
		final Button yes = new Button("Yes" );
		final Button no = new Button( "NO" );
		quit.setSize( 400, 90 );
		quit.setBackground( Color.lightGray );
		quit.setLayout( new FlowLayout(FlowLayout.CENTER) );
		quit.add( question);
		quit.add( yes );
		quit.add( no );
		quit.setVisible( true );
		no.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				quit.setVisible(false);
				}
				
		});
		yes.addActionListener ( new ActionListener() {
		    public void actionPerformed ( ActionEvent e) {
			//System.out.println("quit");
			quit.setVisible(false);
			Monopoly.mainFrame.setVisible(false);//System.exit(0);
			}
			});
		quit.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				quit.setVisible( false );
				repaint();
			}
		});
		repaint();
	}
	//either the 'roll' button was clicked or 'r' was pressed.
	public void Roll() {
		boolean snakeEyes = false;
		Dice1 = ( int )( Math.random() * 6 + 1 );
		Dice2 = ( int )( Math.random() * 6 + 1 );
		if( Dice1 == Dice2 ) {
			snakeEyes = true;
			rolled = false;
		}
		else
			rolled = true;
		if( turn ) {
			Player1.Move( Dice1 + Dice2, snakeEyes, propertymanager );
			String a1 = propertymanager.CheckProperty( Player1.PlayerNum, Player1.Position );
		}
		else {
			Player2.Move( Dice1 + Dice2, snakeEyes, propertymanager );
			String a2 = propertymanager.CheckProperty( Player2.PlayerNum, Player2.Position );
		}
		repaint();
	}
	//either the 'buy' button was clicked or the 'b' button was typed
	public void Buy() {
		// if they have enough money, sell it and set it as being owned
		if (propertymanager.Properties[Player1.Position][0] == 2)// 
		       	propertymanager.Properties[Player1.Position][0] = 2;
		else if (propertymanager.Properties[Player2.Position][0] == 1)
		    	propertymanager.Properties[Player1.Position][0] = 1;

		    
		else if( turn && Player1.Money>=propertymanager.Properties[Player1.Position][8] &&
		propertymanager.Properties[Player1.Position][0] != -1 &&
		propertymanager.Properties[Player1.Position][0] != 1      ) {
			propertymanager.Properties[Player1.Position][0] = 1;
			Player1.Money -= propertymanager.Properties[Player1.Position][8];
System.out.println( Player1.Name + " paid $" + propertymanager.Properties[Player1.Position][8] + " for "+ propertymanager.List[Player1.Position] );
			if( Player1.Position == 5 || Player1.Position == 15 || Player1.Position == 25 || Player1.Position == 35 ) {
				int count = 0;
				//fix the railroad price according to the number owned
				if( propertymanager.Properties[5][0] == 1 ) count++;
				if( propertymanager.Properties[15][0] == 1 ) count++;
				if( propertymanager.Properties[25][0] == 1 ) count++;
				if( propertymanager.Properties[35][0] == 1 ) count++;
				if( count == 1 ) count = 25;
				else if( count == 2 ) count = 50;
				else if( count == 3 ) count = 100;
				else if( count == 4 ) count = 200;
				if( propertymanager.Properties[5][0] == 1 ) propertymanager.Properties[5][2] = count;
				if( propertymanager.Properties[15][0] == 1 ) propertymanager.Properties[15][2] = count;
				if( propertymanager.Properties[25][0] == 1 ) propertymanager.Properties[25][2] = count;
				if( propertymanager.Properties[35][0] == 1 ) propertymanager.Properties[35][2] = count;
			}
		}//do the same for player 2
		
		else if( !turn && Player2.Money>=propertymanager.Properties[Player2.Position][8] &&
		propertymanager.Properties[Player2.Position][0] != -1 &&
		propertymanager.Properties[Player2.Position][0] != 2      ) {
			propertymanager.Properties[Player2.Position][0] = 2;
			Player2.Money -= propertymanager.Properties[Player2.Position][8];
System.out.println( Player2.Name + " paid $" + propertymanager.Properties[Player2.Position][8] + " for "+ propertymanager.List[Player2.Position] );
			if( Player2.Position == 5 || Player2.Position == 15 || Player2.Position == 25 || Player2.Position == 35 ) {
				int count = 0;
				if( propertymanager.Properties[5][0]  == 2 ) count++;
				if( propertymanager.Properties[15][0] == 2 ) count++;
				if( propertymanager.Properties[25][0] == 2 ) count++;
				if( propertymanager.Properties[35][0] == 2 ) count++;
				if( count == 1 ) count = 25;
				else if( count == 2 ) count = 50;
				else if( count == 3 ) count = 100;
				else if( count == 4 ) count = 200;
				if( propertymanager.Properties[5][0]  == 2 ) propertymanager.Properties[5][2] = count;
				if( propertymanager.Properties[15][0] == 2 ) propertymanager.Properties[15][2] = count;
				if( propertymanager.Properties[25][0] == 2 ) propertymanager.Properties[25][2] = count;
				if( propertymanager.Properties[35][0] == 2 ) propertymanager.Properties[35][2] = count;
			}
		}
		repaint();
	}
		
	//either the 'add' button was clicked or the 'a' button was typed
	public void Add() {
		final Frame fr = new Frame( "Add Houses" );
		final Choice choice = new Choice();
		for( int i=0;  i<40;  i++ ) {
			//check to see if all three of the properties are owned, if so, add it
			//to the list of possible house additions
			if(propertymanager.Properties[i][11] != -1 &&
			propertymanager.Properties[i][12] != -1 ) {
				if( turn && propertymanager.Properties[i][0] == 1 && 
				propertymanager.Properties[propertymanager.Properties[i][11]][0] == 1 &&
				(propertymanager.Properties[propertymanager.Properties[i][12]][0] == 1 ||
				propertymanager.Properties[i][12] == -1) && i!=12 && i!=28)
					choice.add( propertymanager.List[i] );
				else if( !turn && propertymanager.Properties[i][0] == 2 &&
				propertymanager.Properties[propertymanager.Properties[i][11]][0] == 2 &&
				(propertymanager.Properties[propertymanager.Properties[i][12]][0] == 2 ||
				propertymanager.Properties[i][12] == -1)&& i!=12 && i!=28)
					choice.add( propertymanager.List[i] );
			}
		}
		final TextField howMany = new TextField( "1", 1 );
		final Label l = new Label( "How Many:" );
		final Button done = new Button( "Done" );
		final Button go = new Button( "Add the House(s)" );
		fr.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		fr.setBackground( Color.lightGray );
		fr.setLayout( new GridLayout( 2, 3) );
		fr.setSize( 400, 170 );
		fr.add( choice );
		fr.add( l, Label.CENTER );
		fr.add( howMany );
		fr.add( go );
		fr.add( done );
		fr.setVisible( true );
		done.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				fr.setVisible( false );
			}
		});
		go.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				int amt = Integer.parseInt( howMany.getText() );
				int selected = 0;
				for( int i=0;  i<40;  i++ )
					if( choice.getSelectedItem() == propertymanager.List[i] )
						selected = i;

				if( turn ) {
					//add the house(s) and take the money
					if( propertymanager.Properties[selected][11] != -1 &&
			   		 propertymanager.Properties[selected][12] != -1 )
						if( propertymanager.Properties[selected][1] < 5 &&
						propertymanager.Properties[propertymanager.Properties[selected][11]][0] == 1 &&
						(propertymanager.Properties[propertymanager.Properties[selected][12]][0] == 1 ||
						 propertymanager.Properties[selected][12] == -1) &&
						(selected != 12  || selected != 28)) {
							int count=0;
							while( count < amt && propertymanager.Properties[selected][1] < 5 &&
							Player1.Money>=propertymanager.Properties[selected][10]	) {
								propertymanager.Properties[selected][1]++;
								Player1.Money-=propertymanager.Properties[selected][10];
								count++;
							}
						}
				}
				else {//do same for player 2
					if( propertymanager.Properties[selected][11] != -1 &&
			  		propertymanager.Properties[selected][12] != -1 )
						if( propertymanager.Properties[selected][1] < 5 &&
						propertymanager.Properties[propertymanager.Properties[selected][11]][0] == 2 &&
						(propertymanager.Properties[propertymanager.Properties[selected][12]][0] == 2 ||
						 propertymanager.Properties[selected][12] == -1) &&
						(selected != 12  || selected != 28)) {
							int count=0;
							while( count < amt && propertymanager.Properties[selected][1] < 5 &&
							Player2.Money>=propertymanager.Properties[selected][10]	) {
								propertymanager.Properties[selected][1]++;
								Player2.Money-=propertymanager.Properties[selected][10];
								count++;
							}
						}
				}
				repaint();
			}
		});

	}
	//either the 'remove' button was clicked or the 'r' button was typed
	public void Rem() {
		final Choice choice = new Choice();
		fr.setBackground( Color.lightGray );
		fr.setSize( 400, 170 );
		//if the property is owned, add it to the list
		for( int i=0;  i<40;  i++ ) {
			if( turn && propertymanager.Properties[i][0] == 1 )
				choice.add( propertymanager.List[i] );
			else if( !turn && propertymanager.Properties[i][0] == 2 )
				choice.add( propertymanager.List[i] );
		}
		//if they don't have any money and they have no property to sell, they lose
		if( noMoney && choice.getItemCount() == 0 && !fr.isShowing() ) {
			if( turn )
				fr.add( new Label( "You Lose " + Player1.Name + "." ) );
			else
				fr.add( new Label( "You Lose " + Player2.Name + "." ) );
			fr.setVisible( true );
			fr.addWindowListener( new WindowAdapter() {
				public void windowClosing( WindowEvent e ) {
					fr.setVisible( false );
				}
			});
		}
		else {
			final TextField howMany = new TextField( "1", 1 );
			final Label l = new Label( "How Many:" );
			final Button done = new Button( "Done" );
			final Button go = new Button( "Remove the House(s)" );
			final Button sell = new Button("Sell the Property");
			fr.setLayout( new GridLayout( 2, 3) );
			fr.add( choice );
			fr.add( l, Label.CENTER );
			fr.add( howMany );
			fr.add( go );
			fr.add( sell );
			fr.add( done );
			fr.setVisible( true );
			done.addActionListener( new ActionListener() {
				public void actionPerformed( ActionEvent e ) {
					if( frame.isShowing() )
						frame.setVisible( false );
					fr.setVisible( false );
					fr.remove( choice );
					fr.remove( l );
					fr.remove( howMany );
					fr.remove( go );
					fr.remove( sell );
					fr.remove( done );
				}
			});
			sell.addActionListener( new ActionListener() {
				public void actionPerformed( ActionEvent e ) {
					//sell the houses and add the money to the persons .Money
					int selected = 0;
					for( int i=0;  i<40;  i++ )
						if( choice.getSelectedItem() == propertymanager.List[i] )
							selected = i;
					if( selected == 5 ) {
						if( turn ){
							Player1.Money+=100;
						}
						else {
							Player2.Money+=100;
						}
						propertymanager.Properties[selected][0] = 0;
					}
					else if( selected == 15 ) {
						if( turn ) {
							Player1.Money+=100;
						}
						else {
							Player2.Money+=100;
						}
						propertymanager.Properties[selected][0] = 0;
					}
					else if( selected == 25 ) {
						if( turn ) {
							Player1.Money+=100;
						}
						else {
							Player2.Money+=100;
						}
						propertymanager.Properties[selected][0] = 0;
					}
					else if( selected == 35 ) {
						if( turn ) {
							Player1.Money+=100;
						}
						else {
							Player2.Money+=100;
						}
						propertymanager.Properties[selected][0] = 0;
					}
					else if( selected == 12 || selected == 28 ) {
						if( turn ) {
							Player1.Money+=75;
						}
						else {
							Player2.Money+=75;
						}
					}

					else if( propertymanager.Properties[selected][1] == 0 || 
					    propertymanager.Properties[selected][1] == -1   ) {
						propertymanager.Properties[selected][0] = 0;
						if( turn ) {
							Player1.Money+=propertymanager.Properties[selected][10];
						}
						else {
							Player2.Money+=propertymanager.Properties[selected][10];

						}
					}
					choice.remove( propertymanager.List[selected] );
					repaint();
				}
			});
			go.addActionListener( new ActionListener() {
				public void actionPerformed( ActionEvent e ) {
					int amt = Integer.parseInt( howMany.getText() );
					int selected = 0;
					for( int i=0;  i<40;  i++ )
						if( choice.getSelectedItem() == propertymanager.List[i] )
							selected = i;

					if( turn ) {
						if( propertymanager.Properties[selected][1] > 0 ) {
							int count=0;
							//remove the house(s) and add the money
							while( count < amt && propertymanager.Properties[selected][1] > 0 ) {
								propertymanager.Properties[selected][1]--;
								Player1.Money+=propertymanager.Properties[selected][10];
//System.out.println( Player1.Name + " gained $" + propertymanager.Properties[selected][10] + " for selling houses on " + propertymanager.List[selected] );
								count++;
							}
						}
					}
					else {
						if( propertymanager.Properties[selected][1] > 0 ) {
							int count=0;
							while( count < amt && propertymanager.Properties[selected][1] > 0 ) {
								propertymanager.Properties[selected][1]--;
								Player2.Money+=propertymanager.Properties[selected][10];
//System.out.println( Player2.Name + " gained $" + propertymanager.Properties[selected][10] + " for selling houses on " + propertymanager.List[selected] );
								count++;
							}
						}
					}
					repaint();
				}
			});
		}
	}
	//start a new game
	public void New() {
		final Frame a = new Frame();
		final TextField tf1 = new TextField("Player 1", 20 );
		final TextField tf2 = new TextField("Player 2", 20 );
		final Button b = new Button( "Start the Game!");
		a.setSize( 400, 110 );
		a.setBackground( Color.lightGray );
		a.setLayout( new FlowLayout(FlowLayout.CENTER) );
		a.add( tf1);
		a.add( b );
		a.add( tf2 );
		a.setVisible( true );
		b.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				Player1.Name = tf1.getText();
				Player2.Name = tf2.getText();
				a.setVisible( false );
				Player1.Position = 0;
				Player2.Position = 0;
				Player1.Money = 1500;
				Player2.Money = 1500;
				Player1.inJail = false;
				Player2.inJail = false;
				noMoney = false;
				turn = true;
				rolled = false;
				for( int i=0;  i<40;  i++ ) {
					if( propertymanager.Properties[i][0] != -1 )
						propertymanager.Properties[i][0] = 0;
					if( propertymanager.Properties[i][1] != -1 )
						propertymanager.Properties[i][1] = 0;
				}
				propertymanager.Properties[20][1] = 500;
				repaint();
			}
		});
		a.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				a.setVisible( false );
				repaint();
			}
		});
		repaint();
	}
}

