import java.util.Scanner;
public class Calculatorapp{

    public static void main(String[] args) {
        double num1,num2,result;

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number : ");
        num1 = sc.nextDouble();

        System.out.print("Enter second number : ");
        num2 = sc.nextDouble();

        System.out.println("Select an Operator (+,-,*,/)");
        char operator = sc.next().charAt(0);

        switch(operator){
            case'+':
                result = num1 + num2;
                System.out.println("Addition for the numbers is : " + num1 + " + " + num2 + " = " + result);
                break;

            case'-':
                result = num1 - num2;
                System.out.println("Subtraction of the numbers is : " + num1 + " - " + num2 + " = " + result);
                break;
            
            case'*':
                result = num1 * num2;
                System.out.println("Multiplication of the numbers is : " + num1 + " * " + num2 + " = " + result);
                break;
                
            case'/':
                result = num1 / num2;
                System.out.println("Division of the numbers is : " + num1 + " / " + num2 + " = " + result);
                break;

            default:
                System.out.println("Error Wrong input !!");
        
            }
    }
    
}
