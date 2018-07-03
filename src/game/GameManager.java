package game;

import engine.AbstractGame;
import engine.GameContainer;
import engine.Renderer;
import engine.gfx.Image;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.SplittableRandom;

public class GameManager extends AbstractGame {

    Boat boat = new Boat();

    int shootTime = 0;

    public GameManager() {

    }

    @Override
    public void update(GameContainer gc, float dt) {
        boat.update(gc, dt);
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        boat.render(gc, renderer);
    }

    public static void main(String[] args){
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
