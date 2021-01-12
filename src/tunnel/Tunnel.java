package tunnel;

import ships.Ship;
import java.util.concurrent.*;

public class Tunnel {
    private BlockingQueue<Ship> queue;

    public BlockingQueue<Ship> getQueue() {
        return queue;
    }

    public Tunnel(){
        this(5);
    }

    public Tunnel(int capacity){
        super();
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    public synchronized void putShip(Ship ship){
        if(queue.size()<5){
            try {
                queue.put(ship);
                System.out.println("Создали шип");
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void pollShip(){
        while (getQueue().size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Ship pollingShip = queue.poll();
            System.out.println("Выгружаем " + pollingShip.getMass().getMass() + "-килограммовый " + pollingShip.getType() + "\n Ждем " + pollingShip.getMass().getMass()/10 + " секунд.");
            Thread.currentThread().sleep(pollingShip.getMass().getMass()*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
