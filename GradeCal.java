import java.util.Scanner;
class GradeCal{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int numSubject;
        Double sum=0.0,AvrageofNum;
        Double SubMarks[] = new Double[20];
        System.out.println("Enter the number of Subject");
        numSubject=sc.nextInt();
        for(int i=1;i<=numSubject;i++){
            System.out.println("Enter the marks(0-100) of the subject  "+ i +" = " );
            SubMarks[i]=sc.nextDouble();
        }
        //for(int i=1;i<=numSubject;i++){
          //  System.out.print(SubMarks[i]+" , " );
        //}

        for(int i=1;i<=numSubject;i++){
            sum=sum+SubMarks[i];

        }
        System.out.println("\nTotal of the marks is : "+sum);
        AvrageofNum=sum/numSubject;
        if(AvrageofNum<65){
            System.out.println("The grade is 'F' " );
 
        }
        else if(AvrageofNum>=65 && AvrageofNum<75){
            System.out.println("The Grade is 'C' ");
        } 
        else if(AvrageofNum>=75 && AvrageofNum<85){
            System.out.println(" The Grade is 'B' ");
        }
        else if(AvrageofNum>=85 && AvrageofNum<100){
            System.out.println("The Grade is 'A' ");
        }
        System.out.println("Avrege of a marks : "+AvrageofNum);
     

    }
}