package com.rhythmblocks.ui;


import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import com.rhythmblocks.game.RhythmBlocks;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Tile widget that extends the Image widget.
 */
public class Tile extends Image{
	public final static int SIZE = RhythmBlocks.SCREEN_WIDTH / 3;
	final int TILE_NUMBER;	// tile number from 1 - 9 (1 2 3, 4 5 6, 7 8 9)

	final Texture regular_texture;
	final Texture pressed_texture;
	
	TextureRegion region;

	/**
	 * Create a new Tile actor.
	 */
	public Tile(int number){
		TILE_NUMBER = number;
		// Initialize textures
		regular_texture = new Texture(Gdx.files.internal("ui/tile_up.png"));
		pressed_texture = new Texture(Gdx.files.internal("ui/tile_down.png"));

		// Initialize texture image as regular_texture
		region = new TextureRegion(regular_texture, SIZE, SIZE);
		setDrawable(new TextureRegionDrawable(region));

		setInputListener();
	}

	/**
	 * Things to the Tile should do based on time.
	 */
	@Override
	public void act(float delta){
		// TODO
	}

	private void setInputListener(){
		this.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				tilePressed();
				return true;
			}
			@Override
			public void touchUp(InputEvent event, float x, float y, int pointer, int button){
				tileReleased();
			}
		});
	}

	/** STUFF TO DO WHEN THE TILE IS PRESSED */
	protected void tilePressed(){
		region.setRegion(pressed_texture);
	}
	/** STUFF TO DO WHEN THE TILE IS RELEASED */
	protected void tileReleased(){
		region.setRegion(regular_texture);
	}
	

}