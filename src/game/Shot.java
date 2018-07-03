package game;

import engine.GameContainer;
import engine.Renderer;
import engine.gfx.Image;
import engine.classes.ObjectB;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Shot extends ObjectB {

    private double speed = 25, rotation;
    private int lifeTime = 1 * 60;
    private ArrayList<Particle> particles = new ArrayList<Particle>();

    public Shot(double x, double y, double rotation) {
        super(x , y);
        image = new Image("/Shot.png");
        this.rotation = rotation;
    }

    @Override
    public void update(GameContainer gc, float dt){
        if(lifeTime > 0){
            x += speed * Math.cos(Math.toRadians(rotation));
            y += speed * Math.sin(Math.toRadians(rotation));
            lifeTime--;
        }

        int[] a = new SplittableRandom().ints(10, -3, 3).parallel().toArray();
        int[] b = new SplittableRandom().ints(10, -3, 3).parallel().toArray();

        for(int i = 0; i < 2; i ++){
            particles.add(new Particle(x + a[i], y + b[i]));
        }

        int particlesSize = particles.size();
        for(int i = particlesSize - 1; i >= 0; i--){
            Particle particle = particles.get(i);
            particle.update(gc, dt);
            if(particle.getLifetime() == 0){
                particles.remove(particle);
            }
        }
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        super.render(gc, renderer);
        for (Particle particle: particles) {
            particle.render(gc, renderer);
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
