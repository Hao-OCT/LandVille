//import

import java.util.Scanner;

public class LandVille {

    private int[][] land;
    private boolean hasHouse;//add the variable 'hasHouse'

    public LandVille(int row, int col) {
        land = new int[row][col];
        for (int i = 0; i < land.length; ++i) {
            for (int j = 0; j < land[i].length; ++j) {
                land[i][j] = 0;
            }
        }

        hasHouse = false;//A: constructor method (create and initialize land array, hasHouse variable)
    }

    public void displayLand() {
        //B: displayLand method
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                System.out.print(land[i][j] + " ");

            }
            System.out.println();
        }
    }

    public void clearLand() {//C:
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++)
                land[i][j] = 0;
            hasHouse = false;

        }
        System.out.println("land cleared!");

    }

    public void buildHouse(int hrow, int hcol) {
        //F: buildHouse method. check the conditions on input, write code for house and border. At the end of the buildHouse method, call displayLand method and update 'hasHouse'
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Please enter the row of house: ");
            hrow = keyboard.nextInt();
            System.out.println("Please enter the col of house: ");
            hcol = keyboard.nextInt();
            if (land.length - hrow < 2 || land[0].length - hcol < 2 || hrow < 0 || hcol < 0) {
                System.out.println("Error enter");
            }
        }
        while (land.length - hrow < 2 || land[0].length - hcol < 2 || hrow < 0 || hcol < 0);
        for (int i = 0; i < (hrow + 2); i++) {
            for (int j = 0; j < (hcol + 2); j++) {
                land[i][j] = 1;
            }
        }
        for (int i = 0; i < hrow; i++) {
            for (int j = 0; j < hcol; j++) {
                land[i + 1][j + 1] = 8;
            }
        }
        hasHouse = true;

    }

    public static void main(String[] args) {
        //Scanner object for input
        int row = 0;
        int col = 0;


        //D: Input row and column number, check for valid input. Create an object of LandVille class

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Please enter the row of land: ");
            row = input.nextInt();
            if (row > 10 || row <= 0) {
                System.out.println("Wrong enter");
            }
        }
        while (row <= 0 || row > 10);
        do {
            System.out.println("Please enter the col of land: ");
            col = input.nextInt();
            if (col > 10 || col <= 0) {
                System.out.println("Wrong enter, Please try again");
            }
        }
        while (col <= 0 || col > 10);
        LandVille landville = new LandVille(row, col);

        // E: Show menu. take the menu option as input. If the input is 1, take input for house and call buildHouse method. Show the menu as long as user does not select menu option 4.

        int option;
        do {// keep showing menu and take input to call different methods.
            System.out.println("choose from the menu\n1.Build a house\n2.Display land\n3.Clear the land\n4.Quit");
            option = input.nextInt();
            if (option < 1 || option > 4) {
                System.out.println("Wrong enter,please try again;)");
            } else if (option == 2) {
                landville.displayLand();
            } else if (option == 3) {
                landville.clearLand();
                landville.displayLand();
            } else if (option == 1 && landville.hasHouse == false) {
                int i = 0;
                int j = 0;
                landville.buildHouse(i, j);
                landville.displayLand();
            } else if (option == 1 && landville.hasHouse == true) {
                System.out.println("House already exists!");

            }
        }
        while (option != 4);
        if (option == 4) {
            System.out.println("Program ends, see you next time!");// exit the program.

        }
    }


}
	



