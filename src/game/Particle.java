package game;

import engine.GameContainer;
import engine.classes.ObjectA;
import engine.gfx.Image;

public class Particle extends ObjectA {

    private int lifetime = 3;

    public Particle(double x, double y) {
        super(x, y);
        image = new Image("/particle.png");
    }

    @Override
    public void update(GameContainer gc, float dt) {
        lifetime--;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }
}
