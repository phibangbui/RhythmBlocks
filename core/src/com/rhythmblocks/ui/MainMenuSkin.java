package com.rhythmblocks.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

// testing change
public class MainMenuSkin extends Skin {


	public MainMenuSkin(){
		super();

		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();

        add("white", new Texture(pixmap));
        add("default", new BitmapFont());

        TextButtonStyle tbs = new TextButtonStyle();

        tbs.up = newDrawable("white", Color.DARK_GRAY);
        tbs.down = newDrawable("white", Color.DARK_GRAY);
        tbs.checked = newDrawable("white", Color.BLUE);
        tbs.over = newDrawable("white", Color.LIGHT_GRAY);
        tbs.font = getFont("default");
        add("default", tbs);
	}

}