package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.screen.BaseScreen;

public class MenuScreen extends BaseScreen {
    private static final float V_LEN = 0.05f;
    private Texture img;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 point;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        pos = new Vector2();
        v = new Vector2(1,1);
        point = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if (point.dst(pos) > V_LEN) {
            pos.add(v);
        } else {
            pos.set(point);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        point.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(point.cpy().sub(pos)).scl(V_LEN);
        return false;
    }
}
