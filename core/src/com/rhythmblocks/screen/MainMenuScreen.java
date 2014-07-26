package com.rhythmblocks.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.audio.Music;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import com.rhythmblocks.game.RhythmBlocks;

/**
 * Main Menu Screen which will move to the song screen when tapped.
 */
public class MainMenuScreen implements Screen{
	final RhythmBlocks game;
    OrthographicCamera camera;

    Stage stage;
    SpriteBatch batch;
    Skin skin;
    Music bg_music;
    
    TextButton start_button;
    TextButton options_button;
    TextButton credits_button;


    public MainMenuScreen(final RhythmBlocks game) {
        this.game = game;

        // Initialize 
        batch = new SpriteBatch();
        stage = new Stage();
        // Load up a new skin defined in assets/ui/uiskin.json
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        Gdx.input.setInputProcessor(stage);

        // add table to stage
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // Initialize buttons and add to the table
        start_button = new TextButton("Start", skin);
        options_button = new TextButton("Options", skin);
        credits_button = new TextButton("Credits", skin);
        table.add(start_button).width(300).height(30);
        table.row();    // start a new row
        table.add(options_button).width(300).height(30);
        table.row();    
        table.add(credits_button).width(300).height(30);
        table.drawDebug(stage);

        // Initialize music
        bg_music = Gdx.audio.newMusic(Gdx.files.internal("ui/rhythmblocksbg.mp3"));
        bg_music.play();
        bg_music.setVolume(0.5f);
        bg_music.setLooping(true);

        // Set Camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.SCREEN_WIDTH, game.SCREEN_HEIGHT);

    }

    @Override
    public void render(float delta) {
        // Set the background color to gray
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Set the camera
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        // Set the time for each refresh
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        // Draw each element in stage
        game.batch.begin();
        stage.draw();
        game.batch.end();

        if(start_button.getClickListener().isPressed()) {
            game.setScreen(new SongScreen(game));
            dispose();   
        }else if(options_button.getClickListener().isPressed()){

        }else if(credits_button.getClickListener().isPressed()){

        }

    }

    @Override
    public void dispose() {
        //
        stage.dispose();
        skin.dispose();
        bg_music.dispose();
        //
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        //
    	stage.getViewport().update(width, height, true);
        //
    }


}