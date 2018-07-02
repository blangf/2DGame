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
    ArrayList<Shot> shots = new ArrayList<Shot>();

    public GameManager() {

    }

    @Override
    public void update(GameContainer gc, float dt) {
        if(gc.getInput().isKey(KeyEvent.VK_W)){
            boat.goForward();
        }

        if(gc.getInput().isKey(KeyEvent.VK_D)){
            boat.turnRight();
        }

        if(gc.getInput().isKey(KeyEvent.VK_A)){
            boat.turnLeft();
        }

        if(gc.getInput().isKeyDown(KeyEvent.VK_SPACE)){
            boat.setSpeed(10);
        }

        if(gc.getInput().isKeyUp(KeyEvent.VK_SPACE)){
            boat.setSpeed(5);
        }

        if(gc.getInput().isButtonDown(MouseEvent.BUTTON1)){
            shots.add(new Shot(boat.getX(), boat.getY(), boat.getRotation()));
        }

        int shotsSize = shots.size();
        for(int i = shotsSize - 1; i >= 0; i--){
            Shot shot = shots.get(i);
            shot.updateShot();
            if(shot.getLifeTime() == 0){
                shots.remove(shot);
            }
        }

    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawImage(boat.getImage(), boat.getX() - 32, boat.getY() - 32);
        for (Shot shot: shots){
            renderer.drawImage(shot.getImage(), shot.getX(), shot.getY());
        }
    }

    public static void main(String[] args){
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
