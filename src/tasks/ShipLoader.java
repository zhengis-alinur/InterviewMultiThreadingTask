package tasks;

import tunnel.Tunnel;

public class ShipLoader implements Runnable {
    Tunnel tunnel;

    public ShipLoader(Tunnel tunnel){
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        while(true){
            tunnel.pollShip();
        }
    }
}
