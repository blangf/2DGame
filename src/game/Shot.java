package game;

import engine.gfx.Image;

public class Shot {
    Image image = new Image("/Shot.png");

    private double x,y,speed = 15, rotation;
    private int lifeTime = 1 * 60;

    public Shot(double x, double y, double rotation) {
        this.x = x;
        this.y = y;
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

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public double getRotation() {
        return rotation;
    }

    public int getLifeTime() {
        return lifeTime;
    }
}
