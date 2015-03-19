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

public class MonopolyButton {
	public int X = 510;
	public int Y = 0;
	public int Width  = 100;
	public int Height = 26;
	public Font font = new Font( "Helvetica", Font.PLAIN, 16 );
	private FontMetrics fm;
	private String label = "";

	public MonopolyButton( String label ) {
		this.label = label;
	}
	public void Draw( Graphics g ) {
		g.setFont( font );
		fm = g.getFontMetrics();
		int w = fm.stringWidth( label );
		g.setColor(Color.lightGray);
		g.fill3DRect( X, Y, Width, Height, true );
		g.setColor( Color.black );
		if( label != "$50" )
			g.drawString( label, X+Width/2-w/2, Y+18 );
		else
			g.drawString( label, X+Width/2-w/2, Y+13 );
		g.setColor( Color.red );
		if( label != "$50" )
			g.drawString( label.substring(0,1), X+Width/2-w/2, Y+18 );
		else
			g.drawString( label.substring(0,1), X+Width/2-w/2, Y+13 );
	}
	public boolean isInside( int x, int y ) {
		if( x>X && x<X+Width && y>Y && y<Y+Height )
			return true;
		return false;
	}
	public void actionPerformed( ActionEvent e ) {
	    }

}

