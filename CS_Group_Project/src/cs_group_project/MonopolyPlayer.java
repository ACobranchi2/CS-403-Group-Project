import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Label;
/*
 * expanded the template of the monoployplayer class for 8 players
 * feel free to edit as needed.
 */

public class MonopolyPlayer {

	public String Name;
	public int Money = 1500;
	public int Position = 0;
	public int PlayerNum;
	public boolean inJail = false;
	public int turns = 0;
	private Label player,bal;
	public int placement[][] = {
		//Positions for the player as he travels around the board
		{ 10, 450 },
		{ 10, 369 },
		{ 10, 336 },
		{ 10, 303 },
		{ 10, 269 },
		{ 10, 236 },
		{ 10, 203 },
		{ 10, 169 },
		{ 10, 136 },
		{ 10, 103 },
		{ 10, 10  },
		{ 103, 10 },
		{ 136, 10 },
		{ 169, 10 },
		{ 203, 10 },
		{ 236, 10 },
		{ 269, 10 },
		{ 303, 10 },
		{ 336, 10 },
		{ 369, 10 },
		{ 426, 10 },
		{ 426, 103 },
		{ 426, 136 },
		{ 426, 169 },
		{ 426, 203 },
		{ 426, 236 },
		{ 426, 269 },
		{ 426, 303 },
		{ 426, 336 },
		{ 426, 369 },
		{ 426, 403 },
		{ 369, 426 },
		{ 336, 426 },
		{ 303, 426 },
		{ 269, 426 },
		{ 236, 426 },
		{ 203, 426 },
		{ 169, 426 },
		{ 136, 426 },
		{ 103, 426 }};
	
	public MonopolyPlayer( String name, int num ) {
		Name = name;
		PlayerNum = num;
	}
	//Make the move
	public void Move( int numSpaces, boolean doubles, PropertyManager pm ) {
		if( (inJail && doubles) || !inJail ){
			inJail = false;
			Position += numSpaces;
			if( Position > 39 || Position == 0 )
				Money += 200;
		}
		else if( inJail )
			turns++;
		if( !inJail )
			turns = 0;
		if( turns == 2 ) {
			inJail = false;
			turns = 0;
			Money -= 50;
			pm.Properties[20][1] += 50;
		}
		Position %= 40;
	}
	public void DrawPlayer( Graphics g ) {
		//Draw the player according to the position on the board
		int y;
		if( PlayerNum == 1 ) {
			y = 510;
			g.setColor( Color.blue );
			if( inJail )
				g.fillOval( 34, 34, 15, 15 );
			else
				g.fillOval( placement[Position][0],placement[Position][1],15, 15 );
		if (PlayerNum == 1) {
			g.setFont( new Font( "Arial", Font.BOLD, 16 ) );
			FontMetrics fm = g.getFontMetrics();
			int w = fm.stringWidth(Name);
			g.drawString( Name, 50, y );
			w = fm.stringWidth("$"+Money);
			g.drawString( "$" + Money, 50, y+20 );
			}
		}
		else if( PlayerNum == 2 ){
			y = 510;
			g.setColor( Color.red );
			if( inJail )
				g.fillOval( 39, 39, 15, 15 );
			else
				g.fillOval( placement[Position][0]+9,placement[Position][1]+9,15, 15 );
			if (PlayerNum == 2) {
				g.setFont( new Font( "Arial", Font.BOLD, 16 ) );
				FontMetrics fm = g.getFontMetrics();
				int w = fm.stringWidth(Name);
				g.drawString( Name, 300, y );
				w = fm.stringWidth("$"+Money);
				g.drawString( "$" + Money, 300, y+20 );
			}
		}
		else if( PlayerNum == 3 ){
			y = 510;
			g.setColor( Color.green );
			if( inJail )
				g.fillOval( 39, 39, 15, 15 );
			else
				g.fillOval( placement[Position][0]+9,placement[Position][1]+9,15, 15 );
			if (PlayerNum == 3) {
				g.setFont( new Font( "Arial", Font.BOLD, 16 ) );
				FontMetrics fm = g.getFontMetrics();
				int w = fm.stringWidth(Name);
				g.drawString( Name, 300, y );
				w = fm.stringWidth("$"+Money);
				g.drawString( "$" + Money, 300, y+20 );
			}
		}
		else if( PlayerNum == 4 ){
			y = 510;
			g.setColor( Color.yellow );
			if( inJail )
				g.fillOval( 39, 39, 15, 15 );
			else
				g.fillOval( placement[Position][0]+9,placement[Position][1]+9,15, 15 );
			if (PlayerNum == 4) {
				g.setFont( new Font( "Arial", Font.BOLD, 16 ) );
				FontMetrics fm = g.getFontMetrics();
				int w = fm.stringWidth(Name);
				g.drawString( Name, 300, y );
				w = fm.stringWidth("$"+Money);
				g.drawString( "$" + Money, 300, y+20 );
			}
		}
		else if( PlayerNum == 5 ){
			y = 510;
			g.setColor( Color.orange );
			if( inJail )
				g.fillOval( 39, 39, 15, 15 );
			else
				g.fillOval( placement[Position][0]+9,placement[Position][1]+9,15, 15 );
			if (PlayerNum == 5) {
				g.setFont( new Font( "Arial", Font.BOLD, 16 ) );
				FontMetrics fm = g.getFontMetrics();
				int w = fm.stringWidth(Name);
				g.drawString( Name, 300, y );
				w = fm.stringWidth("$"+Money);
				g.drawString( "$" + Money, 300, y+20 );
			}
		}
		else if( PlayerNum == 6 ){
			y = 510;
			g.setColor( Color.black );
			if( inJail )
				g.fillOval( 39, 39, 15, 15 );
			else
				g.fillOval( placement[Position][0]+9,placement[Position][1]+9,15, 15 );
			if (PlayerNum == 6) {
				g.setFont( new Font( "Arial", Font.BOLD, 16 ) );
				FontMetrics fm = g.getFontMetrics();
				int w = fm.stringWidth(Name);
				g.drawString( Name, 300, y );
				w = fm.stringWidth("$"+Money);
				g.drawString( "$" + Money, 300, y+20 );
			}
		}
		else if( PlayerNum == 7 ){
			y = 510;
			g.setColor( Color.white );
			if( inJail )
				g.fillOval( 39, 39, 15, 15 );
			else
				g.fillOval( placement[Position][0]+9,placement[Position][1]+9,15, 15 );
			if (PlayerNum == 7) {
				g.setFont( new Font( "Arial", Font.BOLD, 16 ) );
				FontMetrics fm = g.getFontMetrics();
				int w = fm.stringWidth(Name);
				g.drawString( Name, 300, y );
				w = fm.stringWidth("$"+Money);
				g.drawString( "$" + Money, 300, y+20 );
			}
		}
		else {
			y = 510;
			g.setColor( Color.magenta );
			if( inJail )
				g.fillOval( 39, 39, 15, 15 );
			else
				g.fillOval( placement[Position][0]+9,placement[Position][1]+9,15, 15 );
			if (PlayerNum == 8) {
				g.setFont( new Font( "Arial", Font.BOLD, 16 ) );
				FontMetrics fm = g.getFontMetrics();
				int w = fm.stringWidth(Name);
				g.drawString( Name, 300, y );
				w = fm.stringWidth("$"+Money);
				g.drawString( "$" + Money, 300, y+20 );
			}
		}
	}

}
