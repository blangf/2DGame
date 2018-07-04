package game;

import engine.AbstractGame;
import engine.GameContainer;
import engine.Renderer;
import engine.audio.SoundClip;
import engine.gfx.Image;
import engine.classes.ObjectA;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class Boat extends ObjectA {

    private double speed, turnTime, shootTime;
    private double rotation;
    private float boostTime;
    private boolean isBoost;
    private int availableBoosts;
    SoundClip gunClip = new SoundClip("/audio/gunShot.wav");
    SoundClip rocketClip = new SoundClip("/audio/missile.wav");

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
        super(0,0);
        image = images.get(0.0);
        x = 150;
        y = 150;
        speed = 5;
        rotation = 0;
        availableBoosts = 3;
    }

    @Override
    public void update(GameContainer gc, float dt, AbstractGame gm) {

        if(gc.getInput().isKey(KeyEvent.VK_W)){
            goForward(gc);
        }

        if(gc.getInput().isKey(KeyEvent.VK_D)){
            turnRight();
        } else if(gc.getInput().isKey(KeyEvent.VK_A)){
            turnLeft();
        }

        if(gc.getInput().isKeyDown(KeyEvent.VK_SPACE)){
            if(availableBoosts > 0 && !isBoost){
                isBoost = true;
                availableBoosts--;
                System.out.println(availableBoosts);
            }
        }

        shootTime += dt;

        if(gc.getInput().isButton(MouseEvent.BUTTON1)){
            if(shootTime > 0.2){
                gm.addToObjects(new Shot(getX(), getY(), getRotation()));
                gunClip.play();
                shootTime = 0;
            }
        }

        if(gc.getInput().isButtonUp(MouseEvent.BUTTON1)){
            shootTime = 1;
        }

        if(gc.getInput().isButtonDown(MouseEvent.BUTTON3)){
            gm.addToObjects(new Rocket(getX() + 50, getY() + 50, this));
            rocketClip.play();
        }

        if(isBoost){
            boostTime += dt;
            if(boostTime < 3){
                setSpeed(10);
            } else {
                setSpeed(5);
                boostTime = 0;
                isBoost = false;
            }
        }

    }

    public void goForward(GameContainer gc){
        if(!isOutOfBounds(gc, getX(), getY())){
            x += speed * Math.cos(Math.toRadians(rotation));
            y += speed * Math.sin(Math.toRadians(rotation));
        }

        if(x < 0){
            x = 1;
        } else if(x >= gc.getWidth()){
            x = gc.getWidth() - 1;
        }

        if(y < 0){
            y = 1;
        } else if(y >= gc.getHeight()){
            y = gc.getHeight() - 1;
        }

    }

    public void turnLeft(){
        if (turnTime == 2){
            if(rotation == 0.0){
                rotation = 360.0;
            }
            rotation -= 11.25;
            image = images.get(rotation);
            turnTime = 0;
        }
        turnTime++;
    }

    public void turnRight(){
        if (turnTime == 2){
            if(rotation == 360.0){
                rotation = 0.0;
            }
            rotation += 11.25;
            image = images.get(rotation);
            turnTime = 0;
        }
        turnTime++;
    }

    public Image getImage() {
        return image;
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
