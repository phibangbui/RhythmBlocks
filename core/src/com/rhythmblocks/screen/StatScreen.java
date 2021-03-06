package com.rhythmblocks.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.rhythmblocks.game.RhythmBlocks;


/**
 * Stat Screen, when stats is finished, will move to song screen
 */
public class StatScreen implements Screen {
	final RhythmBlocks game;

	OrthographicCamera camera;
	
	public StatScreen(final RhythmBlocks game) {
		this.game = game;
		camera = new OrthographicCamera();
        camera.setToOrtho(false, game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
	}

	/* 
		This method is called every time the game screen is re-sized and the game is not in the paused state. 
	    It is also called once just after the create() method.
        The parameters are the new width and height the screen has been resized to in pixels. 
     */
	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render (float delta) {
		//Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Stats Screen", 100, 150);
        game.font.draw(game.batch, "Tap to move to song screen!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new SongScreen(game));
            dispose();
        }
	}

	/*
		On Android this method is called when the Home button is pressed or an incoming call is received. 
		On desktop this is called just before dispose() when exiting the application.
		A good place to save the game state.
	 */
	@Override
	public void pause() {

	}

	/* 
		This method is only called on Android, when the application resumes from a paused state. 
	 */
	@Override
	public void resume() {

	}

	/* 
		Called when the application is destroyed. It is preceded by a call to pause().
	 */
	@Override
	public void dispose() {

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
