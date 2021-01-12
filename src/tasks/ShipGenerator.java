package tasks;

import ships.Ship;
import ships.type.*;
import tunnel.*;

import java.util.Random;

public class ShipGenerator implements Runnable {
    Random random = new Random();
    Tunnel tunnel;

    public ShipGenerator(Tunnel tunnel) {
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        while (true) {
            tunnel.putShip(new Ship(randType(), randMass()));
        }
    }

    private Type randType(){
        int randType = random.nextInt(Type.values().length);
        return Type.values()[randType];
    }

    private Mass randMass(){
        int randMass = random.nextInt(Type.values().length);
        return Mass.values()[randMass];
    }
}
