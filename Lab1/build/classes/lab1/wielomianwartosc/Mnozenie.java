package lab1.wielomianwartosc;
import java.util.Scanner;

public class Mnozenie {
    int[] TAB;
    int SIZE;
    int X;
    
    public Mnozenie(){
        getData();
        test();
        show();
    }
    
    private void getData(){
        System.out.print("Podaj stopień wielomianu -> ");
        Scanner scanner = new Scanner(System.in);
        SIZE = scanner.nextInt();
        TAB = new int[SIZE+1];
        
        for(int i=SIZE; i>=0; i--){
            System.out.print("Wspólczynnik dla x^" + i + " -> ");
            TAB[i] = scanner.nextInt();
        }
        
        System.out.print("Punkt -> ");
        X = scanner.nextInt();
    }
    
    private void test(){
        for(int i=0; i<=SIZE; i++){
            System.out.println(i + " -> " + TAB[i]);
        }
    }
    
    private int calculate(){
        int RESULT = 0;
        for(int i=0; i<=SIZE; i++){
            RESULT = RESULT + (TAB[i] * (int)Math.pow(X,i));
            System.out.println(RESULT);
        }
        return RESULT;
    }
    
    private void show(){
        System.out.println("==================================================");
        System.out.println("Wartość funkcji w punkcie x=" + X + " wynosi -> " + calculate());
    }
}
