package game;

import engine.AbstractGame;
import engine.GameContainer;
import engine.Renderer;
import engine.gfx.Image;
import engine.classes.Object;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.SplittableRandom;

public class GameManager extends AbstractGame {

    Boat boat = new Boat();

    //All updatable objects in the game are stored here
    ArrayList<Object> objects = new ArrayList<Object>(){
        {
            add(boat);
        }
    };

    int shootTime = 0;

    public GameManager() {

    }

    //Gets called from the Mainloop
    @Override
    public void update(GameContainer gc, float dt, AbstractGame gm) {
        for(int i = 0; i < objects.size(); i++){
            Object object = objects.get(i);
            object.update(gc, dt, this);
            if(object.isDead()){
                objects.remove(object);
            }
        }
    }

    //Gets called from the Mainloop
    @Override
    public void render(GameContainer gc, Renderer renderer, AbstractGame gm) {
        for(int i = 0; i < objects.size(); i++){
            Object object = objects.get(i);
            object.render(gc, renderer, this);
        }
    }

    public static void main(String[] args){
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }

    @Override
    public void addToObjects(Object object){
        objects.add(object);
    }
}
