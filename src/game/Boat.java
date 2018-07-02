package game;

import engine.Renderer;
import engine.gfx.Image;

import java.util.HashMap;

public class Boat{

    Image image = new Image("/BoatRed.png");
    private double x, y, speed, turnRightTime;
    private double rotation;

    private HashMap<Double, Image> images = new HashMap<Double, Image>(){
        {
            put(0.0, new Image("/BoatRed.png"));
            put(11.25, new Image("/BoatRed11_25.png"));
            put(22.5, new Image("/BoatRed22_5.png"));
            put(33.75, new Image("/BoatRed33_75.png"));
            put(45.0, new Image("/BoatRed45_00.png"));
            put(56.25, new Image("/BoatRed56_25.png"));
            put(67.5, new Image("/BoatRed67_5.png"));
            put(78.75, new Image("/BoatRed78_75.png"));
            put(90.0, new Image("/BoatRed90_00.png"));
            put(101.25, new Image("/BoatRed101_25.png"));
            put(112.5, new Image("/BoatRed112_5.png"));
            put(123.75, new Image("/BoatRed123_75.png"));
            put(135.00, new Image("/BoatRed135_00.png"));
            put(146.25, new Image("/BoatRed146_25.png"));
            put(157.5, new Image("/BoatRed157_5.png"));
            put(168.75, new Image("/BoatRed168_75.png"));
            put(180.0, new Image("/BoatRed180_00.png"));
            put(191.25, new Image("/BoatRed191_25.png"));
            put(202.5, new Image("/BoatRed202_5.png"));
            put(213.75, new Image("/BoatRed213_75.png"));
            put(225.0, new Image("/BoatRed225_00.png"));
            put(236.25, new Image("/BoatRed236_25.png"));
            put(247.5, new Image("/BoatRed247_5.png"));
            put(258.75, new Image("/BoatRed258_75.png"));
            put(270.0, new Image("/BoatRed270_00.png"));
            put(281.25, new Image("/BoatRed281_25.png"));
            put(292.5, new Image("/BoatRed292_5.png"));
            put(303.75, new Image("/BoatRed303_75.png"));
            put(315.0, new Image("/BoatRed315_00.png"));
            put(326.25, new Image("/BoatRed326_25.png"));
            put(337.5, new Image("/BoatRed337_5.png"));
            put(348.75, new Image("/BoatRed348_75.png"));
            put(360.0, new Image("/BoatRed.png"));
        }
    };

    public Boat() {
        x = 150;
        y = 150;
        speed = 5;
        rotation = 0;
    }

    public void goForward(){
        x += speed * Math.cos(Math.toRadians(rotation));
        y += speed * Math.sin(Math.toRadians(rotation));
    }

    public void turnLeft(){
        if (turnRightTime == 2){
            if(rotation == 0.0){
                rotation = 360.0;
            }
            rotation -= 11.25;
            image = images.get(rotation);
            turnRightTime = 0;
        }
        turnRightTime++;
    }

    public void turnRight(){
        if (turnRightTime == 2){
            if(rotation == 360.0){
                rotation = 0.0;
            }
            rotation += 11.25;
            image = images.get(rotation);
            turnRightTime = 0;
        }
        turnRightTime++;
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

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
