package lab1.interpolacjaLagrangea;

public class Lagrange {
    public Lagrange(){
        double[] x = {-4,-2,0,1,3};
        double[] y = {16,4,0,1,9};
        int xp = 2;
        System.out.println("Dla x = " + xp + "\ty = " + interpolation(x, y, xp));
    }

    private double interpolation(double[] x, double[] y, double xp){
        double t;
        double yt = 0;
        for (int k=0; k<x.length; k++){
            t = 1;
            for(int j=0; j<x.length; j++){
                if(j != k){
                    t = t * ( (xp-x[j])/(x[k]-x[j]) );
                }
            }
            yt = yt + (t * y[k]);
        }
        return yt;
    }
}
