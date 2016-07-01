package com.kmutlu.ziplayanucak;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Kadir on 1.7.2016.
 */
public class Kaya {

    Vector2 pozisyon = new Vector2();
    TextureRegion resim;
    boolean gecildi;

    public Kaya(float x, float y, TextureRegion resim) {

        this.pozisyon.x = x;
        this.pozisyon.y = y;
        this.resim = resim;
    }
}
