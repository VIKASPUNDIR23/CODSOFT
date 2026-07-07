import java.util.Scanner;

public class Gradecalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter sub 1 marks ");
        int m1 = input.nextInt();
        System.out.print("Enter sub 2 marks ");
        int m2 = input.nextInt();
        System.out.print("Enter sub 3 marks ");
        int m3 = input.nextInt();
        System.out.print("Enter sub 4  marks ");
        int m4 = input.nextInt();
        System.out.print("Enter sub 5 marks ");
        int m5 = input.nextInt();
       float sum = m1+m2+m3+m4+m5;
        System.out.println("TOTAL MARKS OBTAINED = " +sum + "/500");
        float avgp = (sum*100)/500;
        System.out.println("AVERAGE PERCENTAGE  = " +avgp + "%");
          if(avgp>=95){
            System.out.print("YOUR GRADE IS A+");
        }
        else if(avgp>=90 && avgp<95 ){
              System.out.print("YOUR GRADE IS A");
        }
        else if(avgp>=85 && avgp<90) {
              System.out.print("YOUR GRADE IS B+");
          }
              else if(avgp>=80 && avgp<85) {
              System.out.print("YOUR GRADE IS B");
          }
                  else if(avgp>=75 && avgp<80) {
              System.out.print("YOUR GRADE IS C+");
          }

          else if(avgp>=65 && avgp<70) {
              System.out.print("YOUR GRADE IS C");
          }

          else if(avgp>=60 && avgp<65) {
              System.out.print("YOUR GRADE IS D");
          }
          else if(avgp>=55 && avgp<60) {
              System.out.print("YOUR GRADE IS E+");
          }

          else if(avgp>=50 && avgp<55) {
              System.out.print("YOUR GRADE IS E");
          }
         else{
              System.out.print("YOU ARE FAIL :( ");
        }
    }
}
    
