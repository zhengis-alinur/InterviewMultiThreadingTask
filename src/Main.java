import ships.*;
import tasks.ShipGenerator;
import tasks.ShipLoader;
import tunnel.Tunnel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Tunnel tunnel = new Tunnel();
        Thread sg = new Thread(new ShipGenerator(tunnel));
        Thread sl = new Thread(new ShipLoader(tunnel));
        sg.start();
        sl.start();

    }
}
