package com.slyvronline.game.load;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.slyvronline.game.Game;
import com.slyvronline.game.objects.AudioTrack;

public class LoadMusic {

	public static void load(){
		ArrayList<AudioTrack> tracks = new ArrayList<AudioTrack>();
		
		AudioTrack knock = new AudioTrack(Gdx.audio.newMusic(Gdx.files.internal("data/music/Knock_Knock.mp3")), "knock");
		knock.setArtistName("Teknoaxe");
		knock.setContactText("http://teknoaxe.com");
		knock.setTrackName("Knock Knock");
		knock.setLoop(true);
		knock.setPan(1);
		knock.setPosition(0);
		knock.setPitch(1);
		knock.setVolume(0.5f);
		tracks.add(knock);
		
		Game.getGlobal().setTracks(tracks);
	}
}
