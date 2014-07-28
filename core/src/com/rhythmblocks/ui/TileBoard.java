package com.rhythmblocks.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.Input.Keys;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Table that holds tiles.
 */
public class TileBoard extends Table{
	final int size;
	Tile[] tiles;
	final int[] KEYS = new int[]{Keys.valueOf("T"),
								 Keys.valueOf("Y"),
								 Keys.valueOf("U"),
							 	 Keys.valueOf("G"),
								 Keys.valueOf("H"),
								 Keys.valueOf("J"),
								 Keys.valueOf("B"),
								 Keys.valueOf("N"),
								 Keys.valueOf("M")};
	
	/**
	 * Initialize a TileBoard with n rows and n columns.
	 */
	public TileBoard(int n){
		size = n;
		initTiles();
		organizeTiles();
		setUpInputListenerDelegator();
	}

	/**
	 * Initialize tiles and each Tile object.
	 * @param n [description]
	 */
	private void initTiles(){
		tiles = new Tile[size * size];
		for(int i = 0; i < tiles.length; i++){
			tiles[i] = new Tile(KEYS[i]);
		}
	}	

	/**
	 * Add the tiles to the this table.
	 */
	private void organizeTiles(){
		for(int i = 1; i <= size * size; i++){
			if(i % size == 0){
				add(tiles[i - 1]);
				row();
			}else{
				add(tiles[i - 1]);
			}
		}
	}

	private void setUpInputListenerDelegator(){
		addListener(new InputListener(){
			@Override
			public boolean keyDown(InputEvent event, int keyCode){
				switch (keyCode) {
					case 48 : tiles[0].tilePressed(); break;
					case 53 : tiles[1].tilePressed(); break;
					case 49 : tiles[2].tilePressed(); break;
					case 35 : tiles[3].tilePressed(); break;
					case 36 : tiles[4].tilePressed(); break;
					case 38 : tiles[5].tilePressed(); break;
					case 30 : tiles[6].tilePressed(); break;
					case 42 : tiles[7].tilePressed(); break;
					case 41 : tiles[8].tilePressed(); break;
					default: return false;
				}
				return event.isHandled();

			}
			@Override
			public boolean keyUp(InputEvent event, int keyCode){
				switch (keyCode) {
					case 48 : tiles[0].tileReleased(); break;
					case 53 : tiles[1].tileReleased(); break;
					case 49 : tiles[2].tileReleased(); break;
					case 35 : tiles[3].tileReleased(); break;
					case 36 : tiles[4].tileReleased(); break;
					case 38 : tiles[5].tileReleased(); break;
					case 30 : tiles[6].tileReleased(); break;
					case 42 : tiles[7].tileReleased(); break;
					case 41 : tiles[8].tileReleased(); break;
					default: return false;
				}
				return event.isHandled();
			}
		});
	}
}