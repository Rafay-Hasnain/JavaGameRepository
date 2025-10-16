import java.util.Scanner; //The Scanner class which is inside the java.util library is for taking input from the users. For example, reading numbers/strings etc. 

<<<<<<< HEAD
//Static (Variable or Method) = Belongs to the class itself e.g main.
//Non Static (Variable or Method) = Belongs to an object (instance) of the class when we create it using new. 
public class MazeRunner {

    public char MazeArray[][]; // MazeArray is a global class level variable. We can only declare global class
                               // variables outside the main method.

    // Methods cannot be inside other methods (in this case main method) so we
    // declare these outside of main method but inside class.
    public void inititalizeMaze() { // Void as it does not return anything. Public is used so that the method can be
                                    // called from outside the class. In private, the method can only be accessed
                                    // inside the same class.

        MazeArray = new char[][] { // This will assign a new array object to the existing global MazeArray
                                   // variable. So the class variable points to this new array updating the global
                                   // array.
                { '#', '#', '#', '#', '#', '#', '#' },
                { '#', 'P', '.', '.', '.', '.', '#' },
                { '#', '#', '#', '#', '.', '#', '#' },
                { '#', '.', '.', '.', '.', '.', '#' },
                { '#', '#', '#', '.', '#', '#', '#' },
                { '#', '.', '.', '.', '.', 'E', '#' },
                { '#', '#', '#', '#', '#', '#', '#' }

        };
    }

    public void printMaze() { // Void because it doesn't return anything.

        for (int i = 0; i <= MazeArray.length - 1; i++) { // Need to wite int otherwise java won't know what the
                                                          // variables i and j are.
            for (int j = 0; j <= MazeArray.length - 1; j++) {
                System.out.print(MazeArray[i][j]);

            }
            System.out.println();
        }
    }

=======
public class MazeRunner {
>>>>>>> cf64832ac51e029fefbef8a23db6777ab8b80ec9
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
<<<<<<< HEAD
        MazeRunner game = new MazeRunner();
        game.inititalizeMaze();
        game.printMaze();
=======
>>>>>>> cf64832ac51e029fefbef8a23db6777ab8b80ec9

    }
}
