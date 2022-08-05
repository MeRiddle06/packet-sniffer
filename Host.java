import java.io.IOException;
import java.util.Scanner;

public class Host {
    public static void main(String[] args) throws IOException, InterruptedException {// exception handling
        Scanner sc = new Scanner(System.in); // for io purposes
        System.out.println("Enter 1 to generate Normal Traffic");
        System.out.println("Enter 2 to generate Attack Traffic");
        int n = sc.nextInt();
        if (n == 1) {
            NormalTraffic nt = new NormalTraffic();
            nt.generateTraffic();

        } else if (n == 2) {
            AttackTraffic at = new AttackTraffic();
            at.generateTraffic();
        }
        sc.close();
    }
}
