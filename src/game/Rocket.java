package game;

import engine.AbstractGame;
import engine.GameContainer;
import engine.Renderer;
import engine.classes.ObjectA;
import engine.gfx.Image;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Rocket extends ObjectA {


    private ObjectA target;
    private int targetX;
    private int targetY;
    private double targetAngle;
    private double speed = 3;
    private int lifeTime = 5 * 60;
    private double distance;
    private boolean isExploding = false;
    private float explodeTime = 0;

    public Rocket(double x, double y, ObjectA target) {
        super(x, y);
        image = new Image("/Rocket.png");
        this.target = target;
    }

    @Override
    public void update(GameContainer gc, float dt, AbstractGame gm) {
        targetX = target.getX();
        targetY = target.getY();
        targetAngle = Math.atan2(targetY - y, targetX - x);
        if(lifeTime > 0 && !isExploding){
            x += speed * Math.cos(targetAngle);
            y += speed * Math.sin(targetAngle);
            lifeTime--;
            distance = getDistance(getX(), getY(), targetX, targetY);
            if(distance < 25){
                isExploding = true;
            }
        } else {
            isExploding = true;
        }

        if(isExploding){
            if(explodeTime >= 0.1 && explodeTime < 0.2){
                image = new Image("/Explosion1.png");
            } else if(explodeTime >= 0.2 && explodeTime < 0.3){
                image = new Image("/Explosion2.png");
            } else if(explodeTime >= 0.3 && explodeTime < 0.4){
                image = new Image("/Explosion3.png");
            } else if(explodeTime >= 0.4){
                isDead = true;
            }

            explodeTime += dt;
        }

    }

    public static double getDistance(int x1, int y1, int x2, int y2)
    {
        // using long to avoid possible overflows when multiplying
        double dx = x2 - x1;
        double dy = y2 - y1;

        // return Math.hypot(x2 - x1, y2 - y1); // Extremely slow
        // return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)); // 20 times faster than hypot
        return Math.sqrt(dx * dx + dy * dy); // 10 times faster then previous line
    }

    public int getLifeTime() {
        return lifeTime;
    }
}
