package lab1.horner;
import java.util.Scanner;

public class Horner {
    int[][] HORNER;
    int n;
    int c;
    
    public Horner(){
        getData();
        System.out.println("--------------------");
        System.out.print("Wprowadzone dane -> ");
        showEquation(0);
        System.out.println("Dzielnik -> (x - " + c + ")");
        calculate();
        showResult();
    }
    
    // POBIERZ DANE O RÓWNANIU OD USERA
    private void getData(){
        System.out.print("Podaj stopień wielomianu, który chcesz podzielić -> ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        
        HORNER = new int[2][n+1];
        
        for(int i=n; i>=0; i--){
            System.out.print("Podaj wspolczynnik dla x^" + i + " -> ");
            HORNER[0][i] = scanner.nextInt();
        }
        
        System.out.print("Uzupełnij brakujący współczynnik dzielnika ->     x - ");
        c = scanner.nextInt();
        System.out.println();
    }
    
    // POKAŻ DANE
    private void showEquation(int lvl){
        System.out.print("[   y = ");
        for(int i=n; i>0; i--){
            System.out.print("(" + HORNER[lvl][i] + "x^" + i + ") + ");
        }
        System.out.print("(" + HORNER[lvl][0]+ ")");
        System.out.print("  ]\n");
    }
    
    // OBLICZ METODA HORNERA
    private void calculate(){
        HORNER[1][n] = HORNER[0][n];
        
        for(int i=n; i>0; i--){
            HORNER[1][i-1] = (HORNER[1][i] * c) - HORNER[0][i-1];
        }
    }
    
    // POKAŻ WYNIK
    private void showResult(){
        System.out.println("====================");
        System.out.print("Wynik -> ");
        showEquation(1);
    }
}
