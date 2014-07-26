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

/**
 * Tile widget that extends the Image widget.
 */
public class Tile extends Image{
	public final static int SIZE = RhythmBlocks.SCREEN_WIDTH / 3;
	final Texture regular_texture;
	final Texture pressed_texture;
	
	TextureRegion region;
	ClickListener cl;

	/**
	 * Create a new Tile actor with origin x and y.
	 */
	public Tile(){
		super();
		// Initialize textures
		regular_texture = new Texture(Gdx.files.internal("ui/tile_up.png"));
		pressed_texture = new Texture(Gdx.files.internal("ui/tile_down.png"));
		// Set the dimensions of this actor
		//setWidth(SIZE);
		//setHeight(SIZE);
		// Initialize texture image as regular_texture
		region = new TextureRegion(regular_texture, SIZE, SIZE);
		setDrawable(new TextureRegionDrawable(region));

		cl = new ClickListener();
		addListener(cl);
	}

	/**
	 * Things to do if this Tile is clicked.
	 */
	@Override
	public void act(float delta){
		if(cl.isPressed()){
			region.setRegion(pressed_texture);
		}else{
			region.setRegion(regular_texture);
		}
	}
	

}