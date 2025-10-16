import java.util.Scanner; //The Scanner class which is inside the java.util library is for taking input from the users. For example, reading numbers/strings etc. 

public class MazeRunner {
    public static void main(String[] args) throws Exception {

        Scanner myObj = new Scanner(System.in); // Scanner is a class so we need to make an object first to use it. It
                                                // acts like a reader that listens to what the user types into the
                                                // keyboard.

        // Making the main menu:
        System.out.print("Enter a choice:");
        int choice = myObj.nextInt();

        if (choice == 1) {
            System.out.print("Play Game");
        } else if (choice == 2) {
            System.out.print("Instructions");
        } else if (choice == 3) {
            System.out.print("Credits");
        } else if (choice == 4) {
            System.out.print("High Score");
        } else if (choice == 5) {
            System.out.print("Exit");
        } else {
            System.out.print("You entered the wrong value!");
        }

    }
}
