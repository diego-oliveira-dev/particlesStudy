package components;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private int height;
    private int width;

    private List<Particle> particles = new ArrayList<>();

    public Container() {
        this.height = 10;
        this.width = 20;
    }

    public void addParticle(Particle particle) {
        particles.add(particle);
    }

    public void showContainer() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (
                        (i == 0 && j == 0) ||
                                (i == 0 && j == width - 1) ||
                                (i == height - 1 && j == 0) ||
                                (i == height - 1 && j == width - 1)
                ) {
                    IO.print("+");
                } else if (i == 0 || i == height - 1) {
                    IO.print("-");
                } else if (j == 0 || j == width - 1) {
                    IO.print("|");
                } else {
                    boolean isThereAParticle = false;
                    for (Particle particle : particles) {
                        if (particle.x == j && particle.y == i) {
                            isThereAParticle = true;
                            break;
                        }
                    }
                    if (isThereAParticle) {
                        IO.print("o");
                    } else {
                        IO.print(" ");
                    }
                }
            }
            IO.println();
        }
    }

    public void updatePosition() {

        for (Particle particle : particles) {
            particle.x += particle.vx;
            particle.y += particle.vy;

            if (particle.x < 1) {
                particle.x = 1;
                particle.vx *= -1;
            }
            if (particle.x > width - 2) {
                particle.x = width - 2;
                particle.vx *= -1;
            }

            if (particle.y <= 1) {
                particle.y = 1;
                particle.vy *= -1;
            }
            if (particle.y >= height - 2) {
                particle.y = height - 2;
                particle.vy *= -1;
            }
        }
    }
}
