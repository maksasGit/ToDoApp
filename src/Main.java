import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App mainApp = new App();
        System.out.println("Shopping Cart Application Start...");
        System.out.println("---------------------------------");
        System.out.println("Some helpful info:");
        System.out.println("/help --- help info");
        System.out.println("/show --- show menu");
        System.out.println("---------------------------------");

        Scanner scanner = new Scanner(System.in);
        while (mainApp.isOpen()) {
            String inputString = scanner.nextLine();
            mainApp.inputCheck(inputString);
        }

        System.out.println("---------------------------------");
        System.out.println("Goodbye:)");
    }
}
