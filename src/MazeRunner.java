import java.util.Scanner; //The Scanner class which is inside the java.util library is for taking input from the users. For example, reading numbers/strings etc. 

//Static (Variable or Method) = Belongs to the class itself e.g main. It does not belong to any particular object. 
//Non Static (Variable or Method) = Belongs to an object (instance) of the class when we create it using new. 
public class MazeRunner {

    public String MazeArray[][]; // MazeArray is a global class level variable. We can only declare global class
                                 // variables outside the main method.
    public int PlayerRow = 1;
    public int PlayerColumn = 1;

    public int stepsTaken = 0;

    long startTime; // Using long ensures you can store large millisecond values.
    long endTime;

    int highScore; // To store the high score depending upon the time taken to reach exit.

    Scanner myObj = new Scanner(System.in); // Scanner is a class so we need to make an object first to use it. It
                                            // acts like a reader that listens to what the user types into the
                                            // keyboard.

    // Methods cannot be inside other methods (in this case main method) so we
    // declare these outside of main method but inside class.
    public void inititalizeMaze() { // Void as it does not return anything. Public is used so that the method can be
                                    // called from outside the class. In private, the method can only be accessed
                                    // inside the same class.

        MazeArray = new String[][] { // This will assign a new array object to the existing global MazeArray
                                     // variable. So the class variable points to this new array updating the global
                                     // array.
                { "#", "#", "#", "#", "#", "#", "#" },
                { "#", "P", ".", ".", ".", ".", "#" },
                { "#", "#", "#", "#", ".", "#", "#" },
                { "#", ".", ".", ".", ".", ".", "#" },
                { "#", "#", "#", ".", "#", "#", "#" },
                { "#", ".", ".", ".", ".", "E", "#" },
                { "#", "#", "#", "#", "#", "#", "#" }

        };

    }

    public void printMaze() { // Void because it doesn't return anything.

        for (int i = 0; i <= MazeArray.length - 1; i++) { // Need to wite int otherwise java won't know what the
                                                          // variables i and j are. It MazeArray.length provides the
                                                          // number of rows.
            for (int j = 0; j <= MazeArray[i].length - 1; j++) { // This MazeArray[i].length will fetch the number of
                                                                 // columns for that particular row.
                System.out.print(MazeArray[i][j]);

            }
            System.out.println();
        }
    }

    public String isValidMove(String DirectionMovedLetter) {
        // First we will have to update PlayerRow and PlayerColumn creating temporary
        // variables, and then check the new position. Otherwise it will check the
        // current position of P.
        int newRow = PlayerRow;
        int newColumn = PlayerColumn;

        if (DirectionMovedLetter.equals("W")) {
            newRow = newRow - 1; // Up
        } else if (DirectionMovedLetter.equals("A")) {
            newColumn = newColumn - 1; // Left
        } else if (DirectionMovedLetter.equals("S")) {
            newRow = newRow + 1; // Down
        } else if (DirectionMovedLetter.equals("D")) {
            newColumn = newColumn + 1; // Right
        }

        if (MazeArray[newRow][newColumn].equals("#")) {
            return "Hit a wall";
        }
        if (MazeArray[newRow][newColumn].equals("E")) {
            return "Exit reached, you won!";

        } else {

            return "Moved";
        }
    }

    public void movePlayer(String MoveDirection) {

        MazeArray[PlayerRow][PlayerColumn] = "."; // Clear the old position.

        if (MoveDirection.equals("W")) {
            PlayerRow = PlayerRow - 1; // Up
            stepsTaken += 1;
        } else if (MoveDirection.equals("A")) {
            PlayerColumn = PlayerColumn - 1; // Left
            stepsTaken += 1;
        } else if (MoveDirection.equals("S")) {
            PlayerRow = PlayerRow + 1; // Down
            stepsTaken += 1;
        } else if (MoveDirection.equals("D")) {
            PlayerColumn = PlayerColumn + 1; // Right
            stepsTaken += 1;
        }
        if (!MazeArray[PlayerRow][PlayerColumn].equals("E")) { // P will only be placed if it is not on E. Because if P
                                                               // is placed on E, player won method will never be able
                                                               // to check win since E has gone. So we will have to
                                                               // check the condition before placing P.
            MazeArray[PlayerRow][PlayerColumn] = "P"; // Update player position.
        }

    }

    public String hasPlayerWon() {

        if (MazeArray[PlayerRow][PlayerColumn].equals("E")) {
            return "You have Won!";
        } else {
            return "Continue";
        }
    }

    public String exitGame() {

        String message;
        message = "Exiting the game";
        return message;

    }

    public void displayResults() {
        endTime = (System.currentTimeMillis() - startTime) / 1000; // This will convert it into seconds.
        System.out.println("The number of steps taken:" + stepsTaken);
        System.out.println("Time played:" + endTime + " seconds");
    }

    public void showInstructions() {
        System.out.println("Instructions");
        System.out.println("Reach the exit in the least amount of time for maximum score!");
        System.out.println("Press 'W' to move up");
        System.out.println("Press 'A' to move left");
        System.out.println("Press 'S' to move down");
        System.out.println("Press 'D' to move right");
    }

    public void showCredits() {
        System.out.println("Created by Rafay Hasnain");
    }

    public void playGame() {

        // Timer:
        startTime = System.currentTimeMillis(); // System.currentTimeMillis() returns the current time in milliseconds
                                                // stored in startTime.

        inititalizeMaze(); // We need to initialize the maze first as it needs to exist before we can make
                           // a move.
        printMaze();

        boolean running = true;
        while (running) {

            // To quit the game:
            System.out.print("Press 'Q' to quit the game or W/A/S/D to move the player:");
            String Choice = myObj.nextLine().toUpperCase();

            if (Choice.equals("Q")) {
                System.out.print(exitGame());
                displayResults();
                running = false;

            }

            else if (Choice.equals("W") || Choice.equals("A") || Choice.equals("S") || Choice.equals("D")) {

                if (isValidMove(Choice).equals("Hit a wall")) {
                    System.out.println("Hit a wall");
                    printMaze();
                } else {
                    movePlayer(Choice);
                    printMaze();
                    System.out.println("Moved");

                    if (hasPlayerWon().equals("You have Won!")) {
                        System.out.println("You have Won!");
                        displayResults();
                        running = false;
                    }

                }
            }

            else {
                System.out.print("Invalid Entry");
                printMaze();
            }
        }

    }

    public static void main(String[] args) throws Exception {

        MazeRunner game = new MazeRunner(); // Object

        System.out.println("Press '1' to start the game");
        System.out.println("Press '2' to see the instructions");
        System.out.println("Press '3' to show the credits");
        System.out.println("Press '4' to show the high score");
        System.out.println("Press '5' to exit");

        boolean running = true;
        while (running) {
            // Making the main menu:
            System.out.print("Press '1' to play game or 2/3/4/5 (5 to exit):");
            int choice = game.myObj.nextInt(); // Reads the number.
            game.myObj.nextLine(); // Reads the leftover newline (we need to erase it) so that String LetterChoice
            // = myObj.nextLine(); reads the actual letter instead of the new line which
            // will result in invalid entry (notebook analogy).

            if (choice == 1) {
                game.playGame();
                ;
            } else if (choice == 2) {
                game.showInstructions();
                ;
            } else if (choice == 3) {
                game.showCredits();
            } else if (choice == 4) {
                System.out.print("High Score");
            } else if (choice == 5) {
                System.out.print("Exiting");
                running = false;
            } else {
                System.out.print("You entered the wrong value!");
            }

        }
    }
}
