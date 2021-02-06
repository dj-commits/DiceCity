package com.slyvronline.game.utils;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.badlogic.gdx.math.Rectangle;
import com.slyvronline.game.objects.Ent;

public class GameUtils {

	public GameUtils() {
		
	}
	
	public static double calcDistance(Rectangle pos1, Rectangle pos2){
		//Set to center point of entity
		pos1 = new Rectangle(pos1);
		pos2 = new Rectangle(pos2);
		pos1.setX(pos1.getX() + pos1.getWidth()/2);
		pos1.setY(pos1.getY() + pos1.getHeight()/2);
		pos2.setX(pos2.getX() + pos2.getWidth()/2);
		pos2.setY(pos2.getY() + pos2.getHeight()/2);
		return Math.sqrt(Math.pow((pos2.x - pos1.x), 2) + Math.pow((pos2.y - pos1.y), 2));
	}
	
	public static int[] getNextLinePoint(int x,int y,int x2, int y2) {
	    int w = x2 - x;
	    int h = y2 - y;
	    int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0;
	    if (w<0) dx1 = -1; else if (w>0) dx1 = 1;
	    if (h<0) dy1 = -1; else if (h>0) dy1 = 1;
	    if (w<0) dx2 = -1; else if (w>0) dx2 = 1;
	    int longest = Math.abs(w);
	    int shortest = Math.abs(h);
	    if (!(longest>shortest)) {
	        longest = Math.abs(h);
	        shortest = Math.abs(w);
	        if (h<0) dy2 = -1; else if (h>0) dy2 = 1;
	        dx2 = 0;            
	    }
	    int numerator = longest >> 1;
	    numerator += shortest;
	    if (!(numerator<longest)) {
	        numerator -= longest;
	        x += dx1;
	        y += dy1;
	    } else {
	        x += dx2;
	        y += dy2;
	    }
	    int[] res = {x, y};
	    return res;
	}
	
	public static Document loadXMLFromString(String xml) {
		try{
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    InputSource is = new InputSource(new StringReader(xml));
		    return builder.parse(is);
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
