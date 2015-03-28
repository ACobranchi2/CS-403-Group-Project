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
import java.awt.event.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
	
public class PropertyManager {
	private MonopolyBoard monopolyboard;
	MonopolyPlayer one;
	MonopolyPlayer two;
        MonopolyPlayer three;
	MonopolyPlayer four;
        MonopolyPlayer five;
	MonopolyPlayer six;
        MonopolyPlayer seven;
	MonopolyPlayer eight;
/*
 *		00  = owner, -1 if cannot be owned, 1 if player1, and 2 if player2, 0 if unowned
 *		01  = number of houses.  -1 if houses cannot be put on it
 *		02  = price if no houses, just owned
 *		03  = price for 1 house.
 *		04  = price for 2 houses.
 *		05  = price for 3 houses.
 *		06  = price for 4 houses.
 *		07  = price for 5 houses ( a hotel )
 *		08  = price to buy the property from the bank
 *		09  = mortgage price.  what you get back when you sell the property
 *		10  = price to buy a house.
 *		11  = first property associated to make the group. used to see if they are all owned.
 *		12  = second property associated to make the group.
 */		
	public int Properties[][] = {
//		   0  01  02  03  04  05    06   07  08  09  10  11  12
		{ -1, -1, -1, -1, -1, -1 ,  -1,  -1, -1, -1, -1, -1, -1},	//Go					0
		{  0,  0,  2, 10, 30,  90, 160, 250, 60, 30, 50,  3,  3},	//Mediterranean Avenue		1
		{ -1, -1, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Community Chest			2
		{  0,  0,  4, 20, 60, 180, 320, 450, 60, 30, 50,  1,  1},	//Baltic Avenue			3
		{ -1, -1, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Income Tax			4
		{  0, -1, 25, -1, -1,  -1,  -1,  -1,200,100, -1, -1, -1},	//Reading Railroad		5
		{  0,  0,  6, 30, 90, 270, 400, 550,100, 50, 50,  8,  9},	//Oriental Avenue			6
		{ -1, -1, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Chance				7
		{  0,  0,  6, 30, 90, 270, 400, 550,100, 50, 50,  6,  9},	//Vermont Avenue			8
		{  0,  0,  8, 40,100, 300, 450, 600,120, 60, 50,  6,  8},	//Connecticut Avenue		9
		{ -1, -1, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Jail				10
		{  0,  0, 10, 50,150, 450, 625, 750,140, 70,100, 13, 14},	//St. Charles Place		11
		{  0, -1, 24, 24, 24,  -1,  -1,  -1,150, 75, -1, 28, 28},	//Electric Company		12
		{  0,  0, 10, 50,150, 450, 625, 750,140, 70,100, 11, 14},	//States Avenue			13
		{  0,  0, 12, 60,180, 500, 700, 900,160, 80,100, 11, 13},	//Virginia Avenue			14
		{  0, -1, 25, -1, -1,  -1,  -1,  -1,200,100, -1, -1, -1},	//Pennsylvania Railroad		15
		{  0,  0, 14, 70,200, 550, 750, 950,180, 90,100, 18, 19},	//St. James Place			16
		{ -1, -1, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Community Chest			17
		{  0,  0, 14, 70,200, 550, 750, 950,180, 90,100, 16, 19},	//Tennessee Avenue		18
		{  0,  0, 16, 80,220, 600, 800,1000,200,100,100, 16, 18},	//New York Avenue			19
		{ -1,  500, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Free Parking			20
		{  0,  0, 18, 90,250, 700, 875,1050,220,110,150, 23, 24},	//Kentucky Avenue			21
		{ -1, -1, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Chance				22
		{  0,  0, 18, 90,250, 700, 875,1050,220,110,150, 21, 24},	//Indiana Avenue			23
		{  0,  0, 20,100,300, 750, 925,1100,240,120,150, 21, 23},	//Illinois Avenue			24
		{  0, -1, 25, -1, -1,  -1,  -1,  -1,200,100, -1, -1, -1},	//B & O RailRoad			25
		{  0,  0, 22,110,330, 800, 975,1150,260,130,150, 27, 29},	//Atlantic Avenue			26
		{  0,  0, 22,110,330, 800, 975,1150,260,130,150, 26, 29},	//Ventnor Avenue			27
		{  0, -1, 24, 24, 24,  -1,  -1,  -1,150, 75, -1, 12, 12},	//Water Works			28
		{  0,  0, 24,120,360, 850,1025,1200,280,140,150, 26, 27},	//Marvin Gardens			29
		{ -1, -1, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Go to Jail			30
		{  0,  0, 26,130,390, 900,1100,1275,300,150,200, 32, 34},	//Pacific Avenue			31
		{  0,  0, 26,130,390, 900,1100,1275,300,150,200, 31, 34},	//North Carolina Avenue		32
		{ -1, -1, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Community Chest			33
		{  0,  0, 28,150,450,1000,1200,1400,320,160,200, 31, 32},	//Pennsylvania Avenue		34
		{  0, -1, 25, -1, -1,  -1,  -1,  -1,200,100, -1, -1, -1},	//Short Line Railroad		35
		{ -1, -1, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Chance				36
		{  0,  0, 35,175,500,1100,1300,1500,350,175,200, 39, 39},	//Park Place			37
		{ -1, -1, -1, -1, -1,  -1,  -1,  -1, -1, -1, -1, -1, -1},	//Luxury Tax			38
		{  0,  0, 50,200,600,1400,1700,2000,400,200,200, 37, 37}	//Board Walk			39
	};
	// list of the names of the properties.
	public String List[] = {
		"Go",
		"Mediterranean Avenue",
		"Community Chest",
		"Baltic Avenue",
		"Income Tax",
		"Reading Railroad",
		"Oriental Avenue",
		"Chance",
		"Vermont Avenue",
		"Connecticut Avenue",
		"Jail",
		"St. Charles Place",
		"Electric Company",
		"States Avenue",
		"Virginia Avenue",
		"Pennsylvania Railroad",
		"St. James Place",
		"Community Chest",
		"Tennessee Avenue",
		"New York Avenue",
		"Free Parking",
		"Kentucky Avenue",
		"Chance",
		"Indiana Avenue",
		"Illinois Avenue",
		"B & O RailRoad",
		"Atlantic Avenue",
		"Ventnor Avenue",
		"Water Works",
		"Marvin Gardens",
		"Go to Jail",
		"Pacific Avenue",
		"North Carolina Avenue",
		"Community Chest",
		"Pennsylvania Avenue",
		"Short Line Railroad",
		"Chance",
		"Park Place",
		"Luxury Tax",
		"Board Walk"
	};
	//Chance strings
	String chance[] = {
		"Pay poor tax of $15.",
		"Make repairs to property.  Pay $200.",
		"Advance to Illinois Avenue.",
		"Go back 3 spaces.",
		"Your building and loan matures.  Collect $150.",
		"Take a walk on the Board Walk.",
		"Advance to St. Charles Place.",
		"Elected Chairman of the Board, pay $50.",
		"Take a ride on the Reading.  If owned, pay twice the amount.",
		"Bank pays you dividend of $50.",
		"Advance to Go.",
		"Go directly to Jail."
	};
	//Community Chest strings
	String cchest[] = {
		"Go directly to Jail.",
		"Second prize in a beauty contest.  Collect $10.",
		"Bank error in your favor.  Collect $200.",
		"Doctor's fee, Pay $50.",
		"Christmas Fund matures, Collect $100.",
		"Grand Opening.  Collect $50.",
		"Advance to Go.",
		"Life insurance matures, Collect $100.",
		"Pay school tax of $150.",
		"Assessed for street repairs.  Pay $150.",
		"You inherit $100.",
		"From Sale of stock, you get $45.",
		"Pay Hospital $100.",
		"Income tax refund, Collect $20."
	};

	public PropertyManager( MonopolyPlayer a, MonopolyPlayer b ) {
		one = a;
		two = b;
	}

    PropertyManager(MonopolyPlayer Player1, MonopolyPlayer Player2, MonopolyPlayer Player3, MonopolyPlayer Player4, MonopolyPlayer Player5, MonopolyPlayer Player6, MonopolyPlayer Player7, MonopolyPlayer Player8) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	//Used to draw the stats of the property last landed on.
	public void DrawPropertyStats( int PropertyNum, int x, int y, Graphics g ) {
		//method to check and draw which property player has landed on!
		g.setColor( Color.black );
		g.setFont( new Font( "Verdana", Font.BOLD, 15 ) );
		g.drawString( List[PropertyNum], x+8, y+25 );
		g.setFont( new Font( "Verdana", Font.PLAIN, 12 ) );
		if( Properties[PropertyNum][0] == 0 ) {
			g.drawString( "This property is not owned.", x+8, y+65 );
			g.drawString( "Price to Buy: $" + Properties[PropertyNum][8], x+8, y+80 );
			g.drawString( "Mortgage Price: $" + Properties[PropertyNum][9], x+8, y+95 );
		}
		else if( Properties[PropertyNum][0] == 1 || Properties[PropertyNum][0] == 2 ) {
			String owner = ( Properties[PropertyNum][0] == 1 )? one.Name : two.Name;
			g.drawString( "Owned by " + owner, x+8, y+65 );
			if( Properties[PropertyNum][Properties[PropertyNum][1]+2] != -1 && 
				PropertyNum != 12 && PropertyNum != 28 )
					g.drawString( "Tresspassing Price: $" +  
						Properties[PropertyNum][Properties[PropertyNum][1]+2], x+8, y+85 );
			else
					g.drawString( "Tresspassing Price: $" +  
						Properties[PropertyNum][Properties[PropertyNum][1]+3], x+8, y+85 );

			int h = Properties[PropertyNum][1];
			if( h == 5 )
				g.drawString( "This property has a Hotel", x+8, y+100 );
			else if( h != -1 )
				g.drawString( "This property has " + h + " houses.", x+8, y+75 );
			if( Properties[PropertyNum][10] != -1 )
				g.drawString( "Houses cost $" + Properties[PropertyNum][10], x+8, y+95 );
		}
	}
	// Check to see if the player owes any money or landed on chance, cchest, etc.
	public String CheckProperty( int playerNum, int position ) {
		if( position == 12 || position == 28 ) {
			int r = ( int )( Math.random() * 12 + 1 );
			if( playerNum == 1 ) {
				if( Properties[12][0] == 2 ){
					if( Properties[28][0] == 2 ) {
						one.Money -= 10*r;
						Properties[28][2] = 10*r;
						Properties[12][2] = 10*r;
						Properties[28][3] = 10*r;
						Properties[12][3] = 10*r;
						Properties[28][4] = 10*r;
						Properties[12][5] = 10*r;
					}
					else {
						Properties[28][2] = 4*r;
						Properties[28][3] = 4*r;
						Properties[28][4] = 4*r;
						one.Money -= 4*r;
					}
				}
				else if( Properties[28][0] == 2 ) {
					if( Properties[12][0] == 2 ) {
						one.Money -= 10*r;
						Properties[28][2] = 10*r;
						Properties[12][2] = 10*r;
						Properties[28][3] = 10*r;
						Properties[12][3] = 10*r;
						Properties[28][3] = 10*r;
						Properties[12][3] = 10*r;
					}
					else {
						Properties[28][2] = 4*r;
						Properties[28][3] = 4*r;
						Properties[28][4] = 4*r;
						one.Money -= 4*r;
					}
				}
			}
			else {
				if( Properties[12][0] == 1 ){
					if( Properties[28][0] == 1 ) {
						two.Money -= 10*r;
						Properties[28][2] = 10*r;
						Properties[12][2] = 10*r;
						Properties[28][3] = 10*r;
						Properties[12][3] = 10*r;
						Properties[28][4] = 10*r;
						Properties[12][5] = 10*r;
					}
					else {
						Properties[28][2] = 4*r;
						Properties[28][3] = 4*r;
						Properties[28][4] = 4*r;
						two.Money -= 4*r;
					}
				}
				else if( Properties[28][0] == 1 ) {
					if( Properties[12][0] == 1 ) {
						two.Money -= 10*r;
						Properties[28][2] = 10*r;
						Properties[12][2] = 10*r;
						Properties[28][3] = 10*r;
						Properties[12][3] = 10*r;
						Properties[28][4] = 10*r;
						Properties[12][4] = 10*r;
					}
					else {
						Properties[28][2] = 4*r;
						Properties[28][3] = 4*r;
						Properties[28][4] = 4*r;
						two.Money -= 4*r;
					}
				}
			}
		}
		if( position == 5 || position == 15 || position == 25 || position == 35 ){
			if( playerNum == 1 && Properties[position][0] == 2 &&position!= 12 &&position!=28) {
				one.Money -= Properties[position][Properties[position][1]+3];
				two.Money += Properties[position][Properties[position][1]+3];
			}
			else if( playerNum == 2 && Properties[position][0] == 1 &&position!= 12 &&position!=28 ) {
				one.Money += Properties[position][Properties[position][1]+3];
				two.Money -= Properties[position][Properties[position][1]+3];
			}
		}
		else if( playerNum == 1  &&  Properties[position][0] == 2 &&position!= 12 &&position!=28 ) {
			one.Money -= Properties[position][Properties[position][1]+2];
			two.Money += Properties[position][Properties[position][1]+2];
		}
		else if( playerNum == 2  &&  Properties[position][0] == 1 &&position!= 12 &&position!=28 ) {
			one.Money += Properties[position][Properties[position][1]+2];
			two.Money -= Properties[position][Properties[position][1]+2];
		}
		if( playerNum == 1 ) {
			if( one.Position == 30 ) {		//if on 'Go to Jail'
				one.inJail = true;
				one.Position = 10;
			}
			else if( one.Position == 20 ) {	//if on 'Free Parking'
				System.out.println(one.Name+" gained $" +Properties[20][1]+" for landing on free parking");
				one.Money += Properties[20][1];
				Properties[20][1] = 500;
			}
			else if( one.Position == 4 ) {	//if on 'Income Tax'
				one.Money -= 200;
				Properties[20][1] += 200;
			}
			else if( one.Position == 38 ) {	//if on 'Luxury Tax'
				one.Money -= 75;
				Properties[20][1] += 75;
			}
			else if( one.Position == 7  ||	//if on 'Chance'
				   one.Position == 22 ||
				   one.Position == 36   )
					return Chance( 1 );
			else if( one.Position == 2  ||	//if on 'Comm. Chest'
				   one.Position == 17 ||
				   one.Position == 33   )
					return CChest( 1 );

		}
		else if( playerNum == 2 ) {
			if( two.Position == 30 ) {		//if on 'Go to Jail'
				two.inJail = true;
				two.Position = 10;
			}
			else if( two.Position == 20 ) {	//if on 'Free Parking'
				two.Money += Properties[20][1];
				Properties[20][1] = 500;
			}
			else if( two.Position == 4 ) {	//if on 'Income Tax'
				two.Money -= 200;
				Properties[20][1] += 200;
			}
			else if( two.Position == 38 ) {	//if on 'Luxury Tax'
				two.Money -= 75;
				Properties[20][1] += 75;
			}
			else if( two.Position == 7  ||	//if on 'Chance'
				   two.Position == 22 ||
				   two.Position == 36   ) {
					return Chance( 2 );
			}
			else if( two.Position == 2  ||	//if on 'Comm. Chest'
				   two.Position == 17 ||
				   two.Position == 33   ) {
					return CChest( 2 );
			}
		}
		return "";
	}
	public String Chance( int pn ) {
		int r = ( int )( Math.random() * chance.length );
		if( pn == 1 ) {
			switch( r ) {
				case 0:
					one.Money-=15;
					Properties[20][1] += 15;
					break;
				case 1:
					one.Money-=200;
					Properties[20][1] += 200;
					break;
				case 2:
					if( one.Position >= 24 )
						one.Money+=200;
					one.Position = 24;
					if( Properties[24][0] == 2 ) {
						one.Money -= Properties[24][Properties[24][1]+2];
						two.Money += Properties[24][Properties[24][1]+2];
					}
					break;
				case 3:
					one.Position -= 3;
					if( one.Position == 4 ) {
						one.Money -= 200;
						Properties[20][1] += 200;
					}
					else if( one.Position == 19 && Properties[19][0] == 2 ) {
						one.Money -= Properties[19][Properties[19][1]+2];
						two.Money += Properties[19][Properties[19][1]+2];
					}
					break;
				case 4:
					one.Money+=150;
					break;
				case 5:
					one.Position = 39;
					if( one.Position == 39 && Properties[39][0] == 2 ) {
						one.Money -= Properties[39][Properties[19][1]+2];
						two.Money += Properties[39][Properties[19][1]+2];
					}
					break;
				case 6:
					if( one.Position >= 11 )
						one.Money+=200;
					one.Position = 11;
					break;
				case 7:
					one.Money-=50;
					Properties[20][1] += 50;
					break;
				case 8:
					if( one.Position >= 5 )
						one.Money += 200;
					one.Position = 5;
					if( Properties[5][0] == 2 ) {
						one.Money -= 2*Properties[5][2];
						two.Money += 2*Properties[5][2];
					}
					break;
				case 9:
					one.Money+=50;
					break;
				case 10:
					one.Money+=200;
					one.Position = 0;
					break;
				case 11:
					one.inJail = true;
					one.Position = 10;
					break;
			}
		}
		else {
			switch( r ) {
				case 0:
					two.Money-=15;
					Properties[20][1] += 15;
					break;
				case 1:
					two.Money-=200;
					Properties[20][1] += 200;
					break;
				case 2:
					if( two.Position >= 24 )
						two.Money+=200;
					two.Position = 24;
					if( Properties[24][0] == 1 ) {
						one.Money += Properties[24][Properties[24][1]+2];
						two.Money -= Properties[24][Properties[24][1]+2];
					}
					break;
				case 3:
					two.Position -= 3;
					if( two.Position == 4 ) {
						two.Money -= 200;
						Properties[20][1] += 200;
					}
					else if( two.Position == 19 && Properties[19][0] == 1 ) {
						one.Money += Properties[19][Properties[19][1]+2];
						two.Money -= Properties[19][Properties[19][1]+2];
					}
					break;
				case 4:
					two.Money+=150;
					break;
				case 5:
					two.Position = 39;
					if( two.Position == 39 && Properties[39][0] == 1 ) {
						one.Money += Properties[39][Properties[19][1]+2];
						two.Money -= Properties[39][Properties[19][1]+2];
					}
					break;
				case 6:
					if( two.Position >= 11 )
						two.Money+=200;
					two.Position = 11;
					break;
				case 7:
					two.Money-=50;
					Properties[20][1] += 50;
					break;
				case 8:
					if( two.Position >= 5 )
						two.Money += 200;
					two.Position = 5;
					if( Properties[5][0] == 1 ) {
						one.Money += 2*Properties[5][2];
						two.Money -= 2*Properties[5][2];
					}
					break;
				case 9:
					two.Money+=50;
					break;
				case 10:
					two.Money+=200;
					two.Position = 0;
					break;
				case 11:
					two.inJail = true;
					two.Position = 10;
					break;
			}
		}
			//Draw the frame for chance
			final Frame f = new Frame(" Chance ");
			f.setSize( 400, 100 );
			f.setBackground( Color.lightGray);
			f.setLayout( new BorderLayout() );
			Label l = new Label( chance[r] );
			f.add( l, BorderLayout.CENTER );
			f.setVisible( true );
			try { Thread.sleep( 3000 ); }
			catch( Exception ex ) {}
			f.setVisible( false );
			f.addWindowListener( new WindowAdapter() {
				public void windowClosing( WindowEvent e ) {
					f.setVisible( false );
				}
			});
		return chance[r];
	}
	public String CChest( int pn ) {
		int r = ( int )( Math.random() * cchest.length );
		if( pn == 1 ) {
			switch( r ) {
				case 0:
					one.Position = 10;
					one.inJail = true;
					break;
				case 1:
					one.Money+=10;
					break;
				case 2:
					one.Money+=200;
					break;
				case 3:
					one.Money-=50;
					Properties[20][1] += 50;
					break;
				case 4:
					one.Money+=100;
					break;
				case 5:
					one.Money+=50;
					break;
				case 6:
					one.Position = 0;
					one.Money+=200;
				case 7:
					one.Money+=100;
					break;
				case 8:
					one.Money-=150;
					Properties[20][1] += 150;
					break;
				case 9:
					one.Money-=150;
					Properties[20][1] += 150;
					break;
				case 10:
					one.Money+= 100;
					break;
				case 11:
					one.Money+=45;
					break;
				case 12:
					one.Money-=100;
					Properties[20][1] += 100;
					break;
				case 13:
					one.Money+=20;
					break;
			}
		}
		else {
			switch( r ) {
				case 0:
				
					two.Position = 10;
					two.inJail = true;
					break;
				case 1:
					two.Money+=10;
					break;
				case 2:
					two.Money+=200;
					break;
				case 3:
					two.Money-=50;
					Properties[20][1] += 50;
					break;
				case 4:
					two.Money+=100;
					break;
				case 5:
					two.Money+=50;
					break;
				case 6:
					two.Position = 0;
					two.Money+=200;
				case 7:
					two.Money+=100;
					break;
				case 8:
					two.Money-=150;
					Properties[20][1] += 150;
					break;
				case 9:
					two.Money-=150;
					Properties[20][1] += 150;
					break;
				case 10:
					two.Money+= 100;
					break;
				case 11:
					two.Money+=45;
					break;
				case 12:
					two.Money-=100;
					Properties[20][1] += 100;
					break;
				case 13:
					two.Money+=20;
					break;
			}
		}
			//Draw the frame for cchest
					
			final Frame f2 = new Frame(" Community Chest ");
			f2.setSize( 400, 100 );
			f2.setBackground( Color.lightGray );
			f2.setLayout( new BorderLayout() );
			Label l2 = new Label( cchest[r] );
			f2.add( l2, BorderLayout.CENTER );
			f2.setVisible( true );
			try { Thread.sleep( 3000 ); }
			catch( Exception ex ) {}
			f2.setVisible( false );
			f2.addWindowListener( new WindowAdapter() {
				public void windowClosing( WindowEvent e ) {
					f2.setVisible( false );
				}
			});
		return cchest[r];
	}
}
