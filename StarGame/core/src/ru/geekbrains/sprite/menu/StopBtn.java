package ru.geekbrains.sprite.menu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;

public class StopBtn extends ScaledTouchUpButton {

    private Rect worldBounds;
    private Vector2 point = new Vector2();

    public StopBtn(TextureAtlas atlas) {
        super(atlas.findRegion("btnStop"));
        setHeightProportion(0.06f);
        point.set(-0.32f, 0.45f);
        pos.mulAdd(point, 1f);
    }

    @Override
    public void update(float delta) {
    }



    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    @Override
    public void action() {
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        return super.touchDown(touch, pointer);
    }
}

