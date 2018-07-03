package engine.gfx;

import engine.GameContainer;
import engine.Renderer;

public class ObjectA {

    protected Image image;
    protected double x,y;

    public ObjectA(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(GameContainer gc, float dt){

    }

    public void render(GameContainer gc, Renderer renderer){
        renderer.drawImage(image, (int) x - (image.getW() / 2), (int) y - (image.getH() / 2));
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
}
