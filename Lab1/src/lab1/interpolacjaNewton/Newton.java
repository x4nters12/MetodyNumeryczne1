package lab1.interpolacjaNewton;
import java.util.Scanner;

public class Newton {
 
    private static int n,p,q;
    private static double a[];
 
//  algorytm Hornera - obliczanie wartosci wielomianu
    private static double w(int k, double x) {
        if (k==n) return a[n];
        else return w(k+1,x)*x+a[k];
    }
 
 
//  Algorytm Show-Trauba funkcja pomocnicza s(j)
    private static double s(int j)  {
        return (n-j)%q;
    }
 
//  Algorytm Show-Trauba funkcja pomocnicza r(j)
    private static double r(int j)  {
        if (j%q==0) return q;
        else return 0;
    }
 
//  Algorytm Show-Trauba - glowna funkcja
    private static double T(int i, int j, double x) {
        if (x==0) return a[j];   //by mozna bylo obliczyc pochodna w punkcie x=0        
        else if (j==-1) return a[n-i-1]*Math.pow(x,s(i+1));
        else if (i==j) return a[n]*Math.pow(x,s(0));
        else return T(i-1, j-1, x)+T(i-1, j, x)*Math.pow(x,r(i-j));
}
 
 
    private static double pochodna(int stopien, double punkt) {
        if (punkt==0) return T(n,stopien,punkt);
        else return T(n,stopien,punkt)/Math.pow(punkt,stopien%q);
}

    public static void main(String[] args) {
        int k,l;
        double y,z,c;
        
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Metoda Newtona (metoda stycznych) - obliczanie zer funkcji nie liniowych\nna przykladzie wielomianow\nPodaj stopien wielomianu\n");
        //n = Console.readInt("?");
        n = scanner.nextInt();
        a = new double[n+1];
 
        if (n<2) {
            System.out.println("Za maly stopien wielomianu");
            return;
        }
 
        System.out.println("Podaj teraz kolejne wspolczynniki wielomianu.\nZaczynij od tego z najwieksza potega.\n");
        for(k=n; k>=0; k--)  {
            a[k] = Console.readDouble("a" + k);
        }
 
        System.out.println("Podaj poczatek przedzialu");
        //y = Console.readInt("?");
        y = scanner.nextInt();
        System.out.println("Podaj koniec przedzialu");
        //z = Console.readInt("?");
        z = scanner.nextInt();
        if (z<y) {
            System.out.println("Koniec przedzialu jest mniejszy od poczĄtku");
            return;
        }
 
        System.out.println("Podaj liczbe iteracji");
        //l = Console.readInt("?");
        l = scanner.nextInt();
        p=1; q=n+1;
 
        if (pochodna(2,y)*w(0,y)>0) {
            c=y;
        }
        else {
            c=z;
        }
        for (k=1; k<=l; k++) {
            c=c-(w(0,c)/pochodna(1,c));
            if (w(0,c)==0) {
                break;
            }
        }
 
        if (w(0,c)==0) {
            System.out.println("Dokladny pierwiastek wynosi " + c);
        }
        else {
            System.out.println("Przyblizony pierwiastek wynosi " + c);
        }
 
        return;
    }
}