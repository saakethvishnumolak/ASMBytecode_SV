import java.util.Scanner;

public class GenAccumulator {
    public static void main (String [] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scan.nextInt();

        int i = 0;

        while(i < 5) {
            i++;
            num += num;
        }
        System.out.println(num);
    }
    
}
