import java.util.Scanner; //The Scanner class which is inside the java.util library is for taking input from the users. For example, reading numbers/strings etc. 

//Static (Variable or Method) = Belongs to the class itself e.g main. It does not belong to any particular object. 
//Non Static (Variable or Method) = Belongs to an object (instance) of the class when we create it using new. 
public class MazeRunner {

    public String MazeArray[][]; // MazeArray is a global class level variable. We can only declare global class
                                 // variables outside the main method.
    public int PlayerRow = 1;
    public int PlayerColumn = 1;

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
        } else if (MoveDirection.equals("A")) {
            PlayerColumn = PlayerColumn - 1; // Left
        } else if (MoveDirection.equals("S")) {
            PlayerRow = PlayerRow + 1; // Down
        } else if (MoveDirection.equals("D")) {
            PlayerColumn = PlayerColumn + 1; // Right
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

    public void playGame() {
        inititalizeMaze(); // We need to initialize the maze first as it needs to exist before we can make
                           // a move.

        while (!MazeArray[PlayerRow][PlayerColumn].equals("E")) {

            // To quit the game:
            System.out.print("Press 'Q' to quit the game or any other key to continue:");
            String QuitChoice = myObj.nextLine();

            if (QuitChoice.toUpperCase().equals("Q")) {
                System.out.print(exitGame());
                break;

            }

            // Enter a letter for the next move:
            System.out.print("Enter a letter to move character:");
            String LetterChoice = myObj.nextLine();

            if (LetterChoice.toUpperCase().equals("W")) {

                if (isValidMove("W").equals("Hit a wall")) {
                    System.out.println("Hit a wall");
                } else {
                    System.out.println("Moved");
                    movePlayer("W");
                    if (hasPlayerWon().equals("You have Won!")) {
                        System.out.println("You have Won!");
                        break;
                    }
                    printMaze();
                }

            } else if (LetterChoice.toUpperCase().equals("A")) {

                if (isValidMove("A").equals("Hit a wall")) {
                    System.out.println("Hit a wall");
                    printMaze();
                }

                else {
                    System.out.println("Moved");
                    movePlayer("A");
                    if (hasPlayerWon().equals("You have Won!")) {
                        System.out.println("You have Won!");
                        break;
                    }
                    printMaze();
                }

            } else if (LetterChoice.toUpperCase().equals("S")) {

                if (isValidMove("S").equals("Hit a wall")) {
                    System.out.println("Hit a wall");
                    printMaze();
                }

                else {
                    System.out.println("Moved");
                    movePlayer("S");
                    if (hasPlayerWon().equals("You have Won!")) {
                        System.out.println("You have Won!");
                        break;
                    }
                    printMaze();
                }

            } else if (LetterChoice.toUpperCase().equals("D")) {
                if (isValidMove("D").equals("Hit a wall")) {
                    System.out.println("Hit a wall");
                    printMaze();
                }

                else {
                    System.out.println("Moved");
                    movePlayer("D");
                    if (hasPlayerWon().equals("You have Won!")) {
                        System.out.println("You have Won!");
                        break;
                    }
                    printMaze();
                }

            } else {
                System.out.print("Invalid Entry");
            }
        }

    }

    public static void main(String[] args) throws Exception {

        MazeRunner game = new MazeRunner(); // Object

        // Making the main menu:
        System.out.print("Enter a choice:");
        int choice = game.myObj.nextInt(); // Reads the number.
        game.myObj.nextLine(); // Reads the leftover newline (we need to erase it) so that String LetterChoice
        // = myObj.nextLine(); reads the actual letter instead of the new line which
        // will result in invalid entry (notebook analogy).

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

        game.playGame();
    }
}
