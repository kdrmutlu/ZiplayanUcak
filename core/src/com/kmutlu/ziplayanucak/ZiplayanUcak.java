package com.kmutlu.ziplayanucak;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ZiplayanUcak extends ApplicationAdapter {

	private SpriteBatch oyunSayfasi;
	private OrthographicCamera hareketliKamera;
	private Texture bgResmi;
	
	@Override
	public void create () {
		oyunSayfasi = new SpriteBatch();

		hareketliKamera = new OrthographicCamera();
		hareketliKamera.setToOrtho(false, 800, 480);

		bgResmi = new Texture("background.png");
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		dunyayiCizdir();

	}

	private void dunyayiCizdir() {
		hareketliKamera.update();

		//oyun sayfasını hareketli kameraya ayarla
		oyunSayfasi.setProjectionMatrix(hareketliKamera.combined);

		oyunSayfasi.begin();

		oyunSayfasi.draw(bgResmi, 0, 0);

		oyunSayfasi.end();
	}
}
