package com.dicecity.utils;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.badlogic.gdx.math.Rectangle;
import com.dicecity.Game;
import com.dicecity.objects.Ent;

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
	
	public static ArrayList<Ent> buildChevronBG(){
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		Ent chevron1 = new Ent();
		chevron1.setName("chevron1");
		chevron1.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron1.setPosBox(new Rectangle(-1,
				-1,
				chevron1.getImg().getTex().getWidth(),
				chevron1.getImg().getTex().getHeight()));
		ents.add(chevron1);
		
		Ent chevron12 = new Ent();
		chevron12.setName("chevron12");
		chevron12.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron12.setPosBox(new Rectangle(chevron1.getPosBox().getX()+chevron1.getImg().getTex().getWidth(),
				chevron1.getPosBox().getY(),
				chevron12.getImg().getTex().getWidth(),
				chevron12.getImg().getTex().getHeight()));
		ents.add(chevron12);
		
		Ent chevron13 = new Ent();
		chevron13.setName("chevron13");
		chevron13.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron13.setPosBox(new Rectangle(chevron12.getPosBox().getX()+chevron12.getImg().getTex().getWidth(),
				chevron1.getPosBox().getY(),
				chevron13.getImg().getTex().getWidth(),
				chevron13.getImg().getTex().getHeight()));
		ents.add(chevron13);
		
		Ent chevron14 = new Ent();
		chevron14.setName("chevron14");
		chevron14.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron14.setPosBox(new Rectangle(chevron13.getPosBox().getX()+chevron13.getImg().getTex().getWidth(),
				chevron1.getPosBox().getY(),
				chevron14.getImg().getTex().getWidth(),
				chevron14.getImg().getTex().getHeight()));
		ents.add(chevron14);
		
		Ent chevron15 = new Ent();
		chevron15.setName("chevron15");
		chevron15.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron15.setPosBox(new Rectangle(chevron14.getPosBox().getX()+chevron14.getImg().getTex().getWidth(),
				chevron1.getPosBox().getY(),
				chevron15.getImg().getTex().getWidth(),
				chevron15.getImg().getTex().getHeight()));
		ents.add(chevron15);
		
		Ent chevron16 = new Ent();
		chevron16.setName("chevron16");
		chevron16.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron16.setPosBox(new Rectangle(chevron15.getPosBox().getX()+chevron15.getImg().getTex().getWidth(),
				chevron1.getPosBox().getY(),
				chevron16.getImg().getTex().getWidth(),
				chevron16.getImg().getTex().getHeight()));
		ents.add(chevron16);
		
		Ent chevron2 = new Ent();
		chevron2.setName("chevron2");
		chevron2.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron2.setPosBox(new Rectangle(chevron1.getPosBox().getX(),
				chevron1.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron2.getImg().getTex().getWidth(),
				chevron2.getImg().getTex().getHeight()));
		ents.add(chevron2);
		
		Ent chevron22 = new Ent();
		chevron22.setName("chevron22");
		chevron22.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron22.setPosBox(new Rectangle(chevron1.getPosBox().getX()+chevron1.getImg().getTex().getWidth(),
				chevron1.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron22.getImg().getTex().getWidth(),
				chevron22.getImg().getTex().getHeight()));
		ents.add(chevron22);
		
		Ent chevron23 = new Ent();
		chevron23.setName("chevron23");
		chevron23.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron23.setPosBox(new Rectangle(chevron12.getPosBox().getX()+chevron12.getImg().getTex().getWidth(),
				chevron1.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron23.getImg().getTex().getWidth(),
				chevron23.getImg().getTex().getHeight()));
		ents.add(chevron23);
		
		Ent chevron24 = new Ent();
		chevron24.setName("chevron24");
		chevron24.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron24.setPosBox(new Rectangle(chevron13.getPosBox().getX()+chevron13.getImg().getTex().getWidth(),
				chevron1.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron24.getImg().getTex().getWidth(),
				chevron24.getImg().getTex().getHeight()));
		ents.add(chevron24);
		
		Ent chevron25 = new Ent();
		chevron25.setName("chevron25");
		chevron25.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron25.setPosBox(new Rectangle(chevron14.getPosBox().getX()+chevron14.getImg().getTex().getWidth(),
				chevron1.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron25.getImg().getTex().getWidth(),
				chevron25.getImg().getTex().getHeight()));
		ents.add(chevron25);
		
		Ent chevron26 = new Ent();
		chevron26.setName("chevron26");
		chevron26.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron26.setPosBox(new Rectangle(chevron25.getPosBox().getX()+chevron25.getImg().getTex().getWidth(),
				chevron1.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron26.getImg().getTex().getWidth(),
				chevron26.getImg().getTex().getHeight()));
		ents.add(chevron26);
		
		Ent chevron3 = new Ent();
		chevron3.setName("chevron3");
		chevron3.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron3.setPosBox(new Rectangle(chevron1.getPosBox().getX(),
				chevron2.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron3.getImg().getTex().getWidth(),
				chevron3.getImg().getTex().getHeight()));
		ents.add(chevron3);
		
		Ent chevron32 = new Ent();
		chevron32.setName("chevron32");
		chevron32.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron32.setPosBox(new Rectangle(chevron1.getPosBox().getX()+chevron1.getImg().getTex().getWidth(),
				chevron2.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron32.getImg().getTex().getWidth(),
				chevron32.getImg().getTex().getHeight()));
		ents.add(chevron32);
		
		Ent chevron33 = new Ent();
		chevron33.setName("chevron33");
		chevron33.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron33.setPosBox(new Rectangle(chevron12.getPosBox().getX()+chevron12.getImg().getTex().getWidth(),
				chevron2.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron33.getImg().getTex().getWidth(),
				chevron33.getImg().getTex().getHeight()));
		ents.add(chevron33);
		
		Ent chevron34 = new Ent();
		chevron34.setName("chevron34");
		chevron34.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron34.setPosBox(new Rectangle(chevron13.getPosBox().getX()+chevron13.getImg().getTex().getWidth(),
				chevron2.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron34.getImg().getTex().getWidth(),
				chevron34.getImg().getTex().getHeight()));
		ents.add(chevron34);
		
		Ent chevron35 = new Ent();
		chevron35.setName("chevron35");
		chevron35.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron35.setPosBox(new Rectangle(chevron14.getPosBox().getX()+chevron14.getImg().getTex().getWidth(),
				chevron2.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron35.getImg().getTex().getWidth(),
				chevron35.getImg().getTex().getHeight()));
		ents.add(chevron35);
		
		Ent chevron36 = new Ent();
		chevron36.setName("chevron36");
		chevron36.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron36.setPosBox(new Rectangle(chevron35.getPosBox().getX()+chevron35.getImg().getTex().getWidth(),
				chevron2.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron36.getImg().getTex().getWidth(),
				chevron36.getImg().getTex().getHeight()));
		ents.add(chevron36);
		
		Ent chevron4 = new Ent();
		chevron4.setName("chevron4");
		chevron4.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron4.setPosBox(new Rectangle(chevron1.getPosBox().getX(),
				chevron3.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron4.getImg().getTex().getWidth(),
				chevron4.getImg().getTex().getHeight()));
		ents.add(chevron4);
		
		Ent chevron42 = new Ent();
		chevron42.setName("chevron42");
		chevron42.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron42.setPosBox(new Rectangle(chevron1.getPosBox().getX()+chevron1.getImg().getTex().getWidth(),
				chevron3.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron42.getImg().getTex().getWidth(),
				chevron42.getImg().getTex().getHeight()));
		ents.add(chevron42);
		
		Ent chevron43 = new Ent();
		chevron43.setName("chevron43");
		chevron43.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron43.setPosBox(new Rectangle(chevron12.getPosBox().getX()+chevron12.getImg().getTex().getWidth(),
				chevron3.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron43.getImg().getTex().getWidth(),
				chevron43.getImg().getTex().getHeight()));
		ents.add(chevron43);
		
		Ent chevron44 = new Ent();
		chevron44.setName("chevron44");
		chevron44.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron44.setPosBox(new Rectangle(chevron13.getPosBox().getX()+chevron13.getImg().getTex().getWidth(),
				chevron3.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron44.getImg().getTex().getWidth(),
				chevron44.getImg().getTex().getHeight()));
		ents.add(chevron44);
		
		Ent chevron45 = new Ent();
		chevron45.setName("chevron45");
		chevron45.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron45.setPosBox(new Rectangle(chevron14.getPosBox().getX()+chevron14.getImg().getTex().getWidth(),
				chevron3.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron45.getImg().getTex().getWidth(),
				chevron45.getImg().getTex().getHeight()));
		ents.add(chevron45);
		
		Ent chevron46 = new Ent();
		chevron46.setName("chevron46");
		chevron46.setImg(Game.getGlobal().getImgByName("chevron-blue"));
		chevron46.setPosBox(new Rectangle(chevron45.getPosBox().getX()+chevron45.getImg().getTex().getWidth(),
				chevron3.getPosBox().getY()+chevron1.getImg().getTex().getHeight(),
				chevron46.getImg().getTex().getWidth(),
				chevron46.getImg().getTex().getHeight()));
		ents.add(chevron46);
		
		return ents;
	}

}
