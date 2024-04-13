import java.util.Scanner;
import java.util.Random;
public class NumberGame {
    public static void main(String arg[]){
        Random rd = new Random();
        int RandomNumber = rd.nextInt(100)+1;
        Scanner sc = new Scanner(System.in);
        
      
        int tryCount=0;
        while(true){
            
            
            System.out.println("Enter your number (1-100):");
            //System.out.println("you are cheatting "+RandomNumber);
            int PlayerNumber=sc.nextInt();
            tryCount++;
            
            if(PlayerNumber==RandomNumber){
                System.out.println("Wow! Correct Guess, you Win!");
                System.out.println("You try "+tryCount+" Times");
                break;
            }
            else if(PlayerNumber>RandomNumber){
                System.out.println("Not Correct Guess, Correct Number is Smaller. Guess again ");
            }
            else{
                System.out.println("Not Corect Guess, Correct Number is Greater. Guess again ");

            }
        }

           
    }

}
