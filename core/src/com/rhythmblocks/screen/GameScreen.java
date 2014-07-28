package com.rhythmblocks.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import com.rhythmblocks.game.RhythmBlocks;
import com.rhythmblocks.ui.Tile;
import com.rhythmblocks.ui.TileBoard;

import com.badlogic.gdx.audio.Music;

import java.lang.Math;

/**
 * Game Screen, when game is finished, will move to stats screen
 */
public class GameScreen implements Screen {
	final int NUM_TILES = 9;
	final RhythmBlocks game;
	final String song;

	OrthographicCamera camera;

	Stage stage;
	Skin skin;

	Music music;

	Table rootTable;
	Table dashTable ;
	TileBoard boardTable;
	
	public GameScreen(final RhythmBlocks game, String song) {
		this.game = game;
		this.song = song;

		stage = new Stage();
		skin = new Skin(Gdx.files.internal("ui/uiskin.json"));


		rootTable = new Table();
		dashTable = new Table();
		boardTable = new TileBoard((int) Math.sqrt(NUM_TILES));

		stage.setKeyboardFocus(boardTable);
		Gdx.input.setInputProcessor(stage);

		rootTable.add(dashTable).expand();
		rootTable.row();
		rootTable.add(boardTable).bottom();
		rootTable.setFillParent(true);
		stage.addActor(rootTable);

		startSong();
		
		camera = new OrthographicCamera();
        camera.setToOrtho(false, game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
	}

	private void startSong(){
		music = Gdx.audio.newMusic(Gdx.files.internal("songs/" + song + "/" + song + ".mp3"));
		music.play();
        music.setVolume(0.5f);
	}

	/* 
		This method is called every time the game screen is re-sized and the game is not in the paused state. 
	    It is also called once just after the create() method.
        The parameters are the new width and height the screen has been resized to in pixels. 
     */
	@Override
	public void resize(int width, int height){

	}

	@Override
	public void render (float delta) {
		//Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        // Start batch rendering
        game.batch.begin();
        stage.draw();
        game.batch.end();

        if(Gdx.input.isTouched()){
        	// Clicked outside of board
        	if(Gdx.input.getY() <= (Tile.SIZE)){
        		game.setScreen(new StatScreen(game));
        		dispose();
        	}
        }
	}

	/*
		On Android this method is called when the Home button is pressed or an incoming call is received. 
		On desktop this is called just before dispose() when exiting the application.
		A good place to save the game state.
	 */
	@Override
	public void pause(){

	}

	/* 
		This method is only called on Android, when the application resumes from a paused state. 
	 */
	@Override
	public void resume(){

	}

	/* 
		Called when the application is destroyed. It is preceded by a call to pause().
	 */
	@Override
	public void dispose(){

	}

	/**
	 * Stuff that happens when the screen is shown.
	 */
	@Override
    public void show() {
    	Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
    	Gdx.input.setInputProcessor(stage);
    }



}
