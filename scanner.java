import java.util.Scanner;

public class scanner {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int age = scan.nextInt();

        System.out.println("Age: " + age);
    }
    
}
