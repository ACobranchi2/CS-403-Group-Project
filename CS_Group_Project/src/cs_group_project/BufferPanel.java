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
public class BufferPanel extends Container {
	Image background;
	BufferPanel() {}
	public void update(Graphics g) {
		paint(g);
	}
	public void paint(Graphics g) {
		super.paint(g); 
	}
}