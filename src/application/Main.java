package application;

import components.Container;
import components.Particle;

public class Main {
    static void main(String[] args) throws InterruptedException{
        Container container = new Container();
        container.addParticle(new Particle(3, 8));
        container.addParticle(new Particle(9, 5));
        container.addParticle(new Particle(13, 9));
        container.addParticle(new Particle(19, 3));
        container.addParticle(new Particle(6, 8));
        container.addParticle(new Particle(1, 4));
        container.addParticle(new Particle(3, 9));
        container.addParticle(new Particle(15, 3));

        while (true) {
            container.updatePosition();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            container.showContainer();
            Thread.sleep(50);
        }
    }
}
