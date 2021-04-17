import java.util.ArrayList;

public class EV extends Car{

    private int Range;
    private int chargingSpeed;

    public EV(String b, String name, int r, double p, int n, int m, int k, int R, int c) {

        super(b, name, r, p, n, m, k);
        this.Range = R;
        this.chargingSpeed = c;

    }//end constructor



}//end class
