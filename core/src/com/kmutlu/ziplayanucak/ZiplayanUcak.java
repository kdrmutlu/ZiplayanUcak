package com.kmutlu.ziplayanucak;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;


public class ZiplayanUcak extends ApplicationAdapter {

	private SpriteBatch oyunSayfasi;
	private OrthographicCamera hareketliKamera;
	private Texture bgResmi;
	private Animation ucak;
	private Vector2 ucakPozisyonu;
	private float gecenZaman = 0;
	private Texture ucakFrame1, ucakFrame2, ucakFrame3;
	private static final float UCAK_BASLANGIC_X_KONUM = 50;
	private static final float UCAK_BASLANGIC_Y_KONUM = 240;

	@Override
	public void create () {
		oyunSayfasi = new SpriteBatch();

		hareketliKamera = new OrthographicCamera();
		hareketliKamera.setToOrtho(false, 800, 480);

		bgResmi = new Texture("background.png");

		ucakFrame1 = new Texture("ucak1.png");
		ucakFrame2 = new Texture("ucak2.png");
		ucakFrame3 = new Texture("ucak3.png");

		ucak = new Animation(0.05f, new TextureRegion(ucakFrame1), new TextureRegion(ucakFrame2), new TextureRegion(ucakFrame3));
		ucak.setPlayMode(Animation.PlayMode.LOOP);

		ucakPozisyonu = new Vector2();

		dunyayiResetle();
	}

	private void dunyayiResetle() {
		ucakPozisyonu.set(UCAK_BASLANGIC_X_KONUM, UCAK_BASLANGIC_Y_KONUM);
		hareketliKamera.position.x = 400;

	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		dunyayiGuncelle();
		dunyayiCizdir();

	}

	private void dunyayiGuncelle() {
		//oyunun frame değişimleri arasındaki geçen zaman
		float deltaTime = Gdx.graphics.getDeltaTime();
		gecenZaman += deltaTime;
	}

	private void dunyayiCizdir() {
		hareketliKamera.update();

		//oyun sayfasını hareketli kameraya ayarla
		oyunSayfasi.setProjectionMatrix(hareketliKamera.combined);

		oyunSayfasi.begin();

		oyunSayfasi.draw(bgResmi, 0, 0);

		oyunSayfasi.draw(ucak.getKeyFrame(gecenZaman), ucakPozisyonu.x, ucakPozisyonu.y);

		oyunSayfasi.end();
	}
}
