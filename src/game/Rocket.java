package game;

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

    private ArrayList<Particle> particles = new ArrayList<Particle>();

    public Rocket(double x, double y, ObjectA target) {
        super(x, y);
        image = new Image("/Rocket.png");
        this.target = target;
    }

    @Override
    public void update(GameContainer gc, float dt) {
        targetX = target.getX();
        targetY = target.getY();
        targetAngle = Math.atan2(targetY - y, targetX - x);
        if(lifeTime > 0){
            x += speed * Math.cos(targetAngle);
            y += speed * Math.sin(targetAngle);
            lifeTime--;
        }

        int[] a = new SplittableRandom().ints(10, -7, 7).parallel().toArray();
        int[] b = new SplittableRandom().ints(10, -7, 7).parallel().toArray();

        for(int i = 0; i < 10; i ++){
            Particle particle = new Particle(x + a[i], y + b[i]);
            particle.setLifetime(10);
            particles.add(particle);
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

    public int getLifeTime() {
        return lifeTime;
    }
}
