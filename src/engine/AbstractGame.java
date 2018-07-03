package engine;

import engine.classes.Object;
import game.GameManager;

public abstract class AbstractGame {

    public abstract void update(GameContainer gc, float dt, AbstractGame gm);
    public abstract void render(GameContainer gc, Renderer renderer, AbstractGame gm);
    public abstract void addToObjects(Object object);
}
