package engine.classes;

import engine.AbstractGame;
import engine.GameContainer;
import engine.Renderer;
import engine.gfx.Image;

public class Object {

    protected Image image;
    protected double x,y;
    protected boolean isDead = false;

    public Object(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(GameContainer gc, float dt, AbstractGame gm){

    }

    public void render(GameContainer gc, Renderer renderer, AbstractGame gm){
        renderer.drawImage(image, (int) x - (image.getW() / 2), (int) y - (image.getH() / 2));
    }

    public boolean isOutOfBounds(GameContainer gc, int x, int y){
        if(x < 0 || x >= gc.getWidth() || y < 0 || y >= gc.getHeight()){
            return true;
        }

        return false;

    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return (int) x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getY() {
        return (int) y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
