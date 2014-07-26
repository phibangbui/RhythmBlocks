package com.rhythmblocks.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;


import com.rhythmblocks.game.RhythmBlocks;


/**
 * Song Screen, will move to the gamescreen when song has been chosen.
 */
public class SongScreen implements Screen {
	final RhythmBlocks game;
	OrthographicCamera camera;

	Stage stage;
	Skin skin;

	VerticalGroup songs_list;

	
	public SongScreen(final RhythmBlocks game) {
		this.game = game;

		// Initialize 
        stage = new Stage();
        // Load up a new skin defined in assets/ui/uiskin.json
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        songs_list = new VerticalGroup();
        // List all the direct children files/directories of songs
        FileHandle[] files = Gdx.files.internal("songs/").list();
        for(FileHandle file:files){
        	final TextButton button = new TextButton(file.name(), skin);
        	button.addListener(new ChangeListener(){
        		public void changed(ChangeEvent event, Actor actor){
        			game.setScreen(new GameScreen(game, button.getText().toString()));
        			dispose();
        		}
        	});
        	songs_list.addActor(button);
        }

		table.add(new ScrollPane(songs_list));


		camera = new OrthographicCamera();
        camera.setToOrtho(false, game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
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
        game.batch.begin();
        stage.draw();
        game.batch.end();
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

    }

    @Override
    public void hide() {
    }


}
