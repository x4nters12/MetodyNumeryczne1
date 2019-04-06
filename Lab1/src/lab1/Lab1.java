package lab1;
import java.util.Scanner;
import lab1.horner.AutoHorner;
import lab1.horner.Horner;
import lab1.wielomianwartosc.HornerOptimized;
import lab1.wielomianwartosc.Mnozenie;
import lab1.interpolacjaLagrangea.Lagrange;

public class Lab1 {
    public static void main(String[] args) {
        int option = 1;
        Scanner scanner = new Scanner(System.in);
        while(option != 0){
            System.out.println("Lab1 -> Menu");
            System.out.println(" [ 1 ] Schemat Hornera (prosty)");
            System.out.println(" [ 2 ] Schemat Hornera (autohorner)");
            System.out.println(" [ 3 ] Wartosc wielomianu w punkcie");
            System.out.println(" [ 4 ] -");
            System.out.println(" [ 5 ] Interpolacja Newtona");
            System.out.println(" [ 6 ] Interpolacja Lagrange'a");
            System.out.println(" [ 0 ] Zamknij");
            System.out.println("------------------------------------");
            System.out.print("Menu>");
            option = scanner.nextInt();
            
            switch(option){
                case 1: Horner horner = new Horner(); break;
                case 2: AutoHorner ahorner = new AutoHorner(); break;
                case 3: Mnozenie multi = new Mnozenie(); break;
                case 4: HornerOptimized hopti = new HornerOptimized(); break;
                case 6: Lagrange lgr = new Lagrange(); break;
                
                case 0: break;
                default: System.out.println("[ ! ] Nieprawidlowa opcja");
            }
        }
    }
}
