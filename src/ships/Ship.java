package ships;

import ships.type.Mass;
import ships.type.Type;

public class Ship {
    private Mass mass;
    private Type type;

    public Mass getMass() {
        return mass;
    }

    public Type getType() {
        return type;
    }

    public Ship(Type type, Mass mass){
        this.mass = mass;
        this.type = type;
    }
}
