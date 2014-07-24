package com.rhythmblocks.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.rhythmblocks.screen.MainMenuScreen;

/**
 * Load up all resources necessary into this Game object
 * which then gets passed into each of the screen objects for use.
 */
public class RhythmBlocks extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();	// use default arial font



		/* After loading, move to MainMenuScreen */
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
