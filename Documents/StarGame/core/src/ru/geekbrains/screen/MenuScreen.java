package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Base2DScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Star;
import ru.geekbrains.sprite.menu.PlayBtn;
import ru.geekbrains.sprite.menu.StopBtn;

public class MenuScreen extends Base2DScreen {

    private TextureAtlas atlas;
    private Texture bg;
    private Background background;
    private Star star[];
    private StopBtn stopBtn;
    private PlayBtn playBtn;
    private boolean playPressed;
    private boolean stopPressed;



    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/test.pack");
//        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        stopBtn = new StopBtn(atlas);
        playBtn = new PlayBtn(atlas);
        star = new Star[256];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(atlas);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    public void update(float delta) {
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
    }

    public void draw() {
        Gdx.gl.glClearColor(0.5f, 0.2f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        stopBtn.draw(batch);
        playBtn.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if (touch.x >= playBtn.getLeft() && touch.x <= playBtn.getRight() && touch.y >= playBtn.getBottom() && touch.y <= playBtn.getTop()) {
            this.playPressed = true;
            playBtn.setHeightProportion(0.1f);
        }

        if (touch.x >= stopBtn.getLeft() && touch.x <= stopBtn.getRight() && touch.y >= stopBtn.getBottom() && touch.y <= stopBtn.getTop()) {
            stopPressed = true;
            stopBtn.setHeightProportion(0.1f);
        }

        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        this.playPressed = false;
        playBtn.setHeightProportion(0.06f);

        if (touch.x >= stopBtn.getLeft() && touch.x <= stopBtn.getRight() && touch.y >= stopBtn.getBottom() && touch.y <= stopBtn.getTop()) {
            stopPressed = true;
            System.exit(0);
        } else {
            stopPressed = false;
            stopBtn.setHeightProportion(0.06f);
        }
        return super.touchUp(touch, pointer);
    }
}
