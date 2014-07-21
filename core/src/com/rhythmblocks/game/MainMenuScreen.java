package com.rhythmblocks.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


/**
 * Main Menu Screen which will move to the song screen when tapped.
 */
public class MainMenuScreen implements Screen{

	final RhythmBlocks game;

    OrthographicCamera camera;

    public MainMenuScreen(final RhythmBlocks game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to RhythmBlocks", 100, 150);
        game.font.draw(game.batch, "Tap to move to the songs screen!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new SongScreen(game));
            dispose();
        }
    }

    @Override
    public void dispose(){

    }

    @Override
    public void resume(){

    }

    @Override
    public void pause(){

    }

    @Override
    public void hide(){

    }

    @Override
    public void show(){

    }

    @Override
    public void resize(int width, int height){
    	
    }


}