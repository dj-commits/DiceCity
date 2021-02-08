package com.dicecity.load;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.dicecity.Game;
import com.dicecity.objects.AudioTrack;

public class LoadMusic {

	public static void load(){
		ArrayList<AudioTrack> tracks = new ArrayList<AudioTrack>();

		
		Game.getGlobal().setTracks(tracks);
	}
}
