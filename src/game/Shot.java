package game;

import engine.gfx.Image;
import engine.classes.ObjectB;

public class Shot extends ObjectB {

    private double speed = 25, rotation;
    private int lifeTime = 1 * 60;

    public Shot(double x, double y, double rotation) {
        super(x , y);
        image = new Image("/Shot.png");
        this.rotation = rotation;
    }

    public void updateShot(){
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
