package com.rhythmblocks.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Table that holds tiles.
 */
public class TileBoard extends Table{
	final int size;
	Tile[] tiles;
	
	/**
	 * Initialize a TileBoard with n rows and n columns.
	 */
	public TileBoard(int n){
		super();
		size = n;
		initTiles();
		organizeTiles();
	}

	/**
	 * Initialize tiles and each Tile object.
	 * @param n [description]
	 */
	private void initTiles(){
		tiles = new Tile[size * size];
		for(int i = 0; i < tiles.length; i++){
			tiles[i] = new Tile();
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
}