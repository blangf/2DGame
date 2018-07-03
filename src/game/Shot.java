package game;

import engine.AbstractGame;
import engine.GameContainer;
import engine.Renderer;
import engine.gfx.Image;
import engine.classes.ObjectB;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Shot extends ObjectB {

    private double speed = 25, rotation;
    private int lifeTime = 1 * 60;

    public Shot(double x, double y, double rotation) {
        super(x , y);
        image = new Image("/Shot.png");
        this.rotation = rotation;
    }

    @Override
    public void update(GameContainer gc, float dt, AbstractGame gm){
        if(lifeTime > 0){
            x += speed * Math.cos(Math.toRadians(rotation));
            y += speed * Math.sin(Math.toRadians(rotation));
            lifeTime--;
        }
    }

    public Image getImage() {
        return image;
    }

    public double getRotation() {
        return rotation;
    }

    public int getLifeTime() {
        return lifeTime;
    }
}
