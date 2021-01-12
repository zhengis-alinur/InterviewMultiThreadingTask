package ships.type;

public enum Mass {
    KG_10(10),
    KG_50(50),
    KG_100(100);

    private int mass;

    Mass(int mass) {
        this.mass = mass;
    }

    public int getMass(){
        return mass;
    }
}
