package lab1.horner;
import java.util.Scanner;

public class AutoHorner {
    int[][] HORNER;
    int SIZE;
    
    public AutoHorner(){
        getData();
        showData();
    }
    
    private void getData(){
        Scanner scanner = new Scanner(System.in);
        boolean ifNext;
        
        HORNER = new int[2][0];
        SIZE = 0;
        
        System.out.println("Wprowadz wartosci kolejnych współczynników wielomianu");
        System.out.println("=====================================================");
        
        while(true){
            int[][] TEMP = new int[2][HORNER.length+1];
            for(int i=0; i<SIZE; i++){
                TEMP[0][i] = HORNER[0][i];
            }
            HORNER = TEMP;
            
            System.out.print("Współczynnik -> ");
            HORNER[0][0] = scanner.nextInt();
        }
    }
    
    private void showData(){
        for(int i=0; i<=SIZE; i++){
            System.out.println(i + " -> " + HORNER[0][i]);
        }
    }
    
    private void calculate(){
        
    }
    
    private void showResult(){
        
    }
}
