package ru.geekbrains.sprite.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;
import ru.geekbrains.screen.GameScreen;

public class PlayBtn extends ScaledTouchUpButton {

    private Rect worldBounds;
    private Vector2 point = new Vector2();
    private Game game;

    public PlayBtn(TextureAtlas atlas, Game game) {

        super(atlas.findRegion("btnPlay"));
        this.game=game;
        setHeightProportion(0.06f);
        point.set(0.32f, 0.45f);
        pos.mulAdd(point, 1f);
    }


    @Override
    public void update(float delta) {
    }

//    private void checkAndHandleBounds() {
//    }


    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        return super.touchDown(touch, pointer);
    }
}

