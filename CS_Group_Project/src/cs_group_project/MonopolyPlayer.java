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
		else {
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
	}

}