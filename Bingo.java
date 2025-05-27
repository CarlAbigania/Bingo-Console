import java.util.Random;
import java.util.Scanner;

public class Bingo {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
    	char choice;
    	do {
    	       //Prompt the user to type start to generate Bingo Card
    	        System.out.println("Type 'Start' to generate the Bingo card");
    	        String start =in.next();

    	        if (start.equalsIgnoreCase("Start")) {
    	            bingoCard();//Call the bingocard if the user type "Start"
    	        } else {
    	            System.out.println("Try Again");//Prompt the user to try again if they type something else
    	        }
    	        
    	        System.out.print("\nWant to play again? (Yes(Y) | No(N)): ");
    	        choice = in.next().charAt(0);
    	}while(choice == 'Y' || choice == 'y');//it is used to re run the program without exiting or terminating
    	   }

     public static void bingoCard() {

    	        int[][] bingoCard = new int[5][5];//Create a 2d array that represent bingo card
    	        int row, column;
    	        String key;
    	          
    	        //Create an array of number ranges for each column (B, I, N, G, O)
    	        int[][] numberRange = {
    	                {1, 15},  // B
    	                {16, 30}, // I
    	                {31, 45}, // N
    	                {46, 60}, // G
    	                {61, 75}  // O
    	        };
    	     // Fill each column with unique random numbers within the given range
    	        for (int col = 0; col < 5; col++) {
    	            for (int row1 = 0; row1 < 5; row1++) {
    	                int min = numberRange[col][0]; // Get the minimum value for the current column
    	                int max = numberRange[col][1];// Get the maximum value for the current column.
    	                int num = RandomNumbersinRange(min, max);
    	                // Check if the number is already in the column
    	                while (check(bingoCard, col, num)) {
    	                    num = RandomNumbersinRange(min, max);// Generate a new random number within the range.
    	                }
    	                bingoCard[row1][col] = num;// Assign the generated number to the current cell in the bingo card.
    	            }
    	        }
    	        // Print the bingo card using nested for loop
    	        System.out.println("B\tI\tN\tG\tO");
    	        System.out.println("____________________________");
    	        for (int row1 = 0; row1 < 5; row1++) {
    	            for (int col = 0; col < 5; col++) {
    	                if (row1 == 2 && col == 2) {
    	                    System.out.print("FREE\t");
    	                } else {
    	                    System.out.print(bingoCard[row1][col] + "\t");
    	                    
    	                }
    	                 
    	            }
    	            System.out.println(); 
    	            System.out.println("____________________________");
    	        }
    	        
    	     // Draw a random number from 1 to 75 for each specific letter (B/I/N/G/O)
    	        System.out.println("Press '1' to draw a number");
    	        
    	        Scanner in = new Scanner(System.in);
				key = in.next();
				// Check if the value of 'key' is equal to "1"
    	        if(key.equalsIgnoreCase("1")) {
    	        // Execute the following block of code if 'key' is equal to "1"
    	        do {
    	        	// Initialize the row and column values for the bingo card
    	         int row1 = 5, col = 5;
    	         for (column = 0; column < 5; column++) {
    	        	// Calculate the minimum and maximum values for the current column
    	                     int min = column * 15 + 1;
    	                     int max = min + 14;
    	                   
    	                      // Generate a random number within the range of the current column
    	                         int randomNum = (int)(Math.random() * (max - min + 1)) + min;
    	                      // Generate a random index to select a column to draw from
    	                        int randomRange = (int)(Math.random() * (5 - 1 + 1)) + 0;
    	                         
    	                         if (column == randomRange && column == 0) {
    	                         String letter = "B";
    	                         System.out.println("Drawn number for letter " + letter + ": " + randomNum);
    	                         numberCheck(randomNum,row1,col,bingoCard);
    	                         System.out.println("Press '1' again to draw the numbers");
    	                     key =in.next();
    	                         }
    	                         else if (column == randomRange && column == 1) {
    	                         String letter = "I";
    	                         System.out.println("Drawn number for letter " + letter + ": " + randomNum);
    	                         numberCheck(randomNum,row1,col,bingoCard);
    	                     System.out.println("Press '1' again to draw a number");
    	                     key = in.next();
    	                         }
    	                         else if (column == randomRange && column == 2) {
    	                         String letter = "N";
    	                         System.out.println("Drawn number for letter " + letter + ": " + randomNum);
    	                         numberCheck(randomNum,row1,col,bingoCard);
    	                     System.out.println("Press '1' again to draw a number");
    	                     key = in.next();
    	                         }
    	                         else if (column == randomRange && column == 3) {
    	                         String letter = "G";
    	                         System.out.println("Drawn number for letter " + letter + ": " + randomNum);
    	                         numberCheck(randomNum,row1,col,bingoCard);
    	                     System.out.println("Press '1' again to draw a number");
    	                     key = in.next();
    	                         }
    	                         else if (column == randomRange && column == 4) {
    	                         String letter = "O";
    	                         System.out.println("Drawn number for letter " + letter + ": " + randomNum);
    	                         numberCheck(randomNum,row1,col,bingoCard);
    	                     System.out.println("Press '1' again to draw a number");
    	                     key = in.next();
    	                         }
    	                     }
    	        }while(key.equalsIgnoreCase("1"));
    	        }
    	        else {
    	         System.out.println("Invalid key!");
    	        }    
    	    }

    	    // Check if the number is already in the given column
    	    public static boolean check(int[][] bingoCard, int col, int num) {
    	        for (int row = 0; row < 5; row++) {
    	            if (bingoCard[row][col] == num) {
    	                return true;//Return true if the number is already in the column
    	            }
    	        }
    	        return false;//return false if the number is not in the column
    	    }

    	    // Generate a random number within the given range
    	    public static int RandomNumbersinRange(int min, int max) {
    	        Random rand = new Random();
    	        return min + rand.nextInt(max - min + 1);
    	        
    	    } public static void numberCheck(int random, int row1,int col,int bingo[][]) {
    	    
    	    System.out.println("B\tI\tN\tG\tO");
    	    System.out.println("____________________________");
    	    for ( row1 = 0; row1 < 5; row1++) {
    	            for ( col = 0; col < 5; col++) {
    	            
    	                if (row1 == 2 && col == 2) {
    	                
    	                    System.out.print("FREE\t");// Print "FREE" instead of a number
    	                }else if(random == bingo[row1][col]) {
    	                System.out.print("X\t");// if the current element matches the random number, it prints an "X"
    	                
    	                } else {
    	                    System.out.print(bingo[row1][col] + "\t");
    	                    
    	                }
    	                 
    	            }
    	            System.out.println(); 
    	            System.out.println("____________________________");
    	        }
    	    
    	    }
    	    
    	}