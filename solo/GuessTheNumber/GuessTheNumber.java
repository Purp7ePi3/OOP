import java.util.Scanner;

class Number{
    int number = 0;
    int nTry = 0;

    void build(int diff){
        switch (diff) {
            case 1:
                System.out.println("You choose easy one");
                this.number = (int)(Math.random() * 10 + 1);
                this.nTry = 5;
                break;
            case 2:
                System.out.println("You choose medium one");
                this.number = (int)(Math.random() * 25 + 1);
                this.nTry = 5;
                break;
            case 3:
                System.out.println("You choose medium one");
                this.number = (int)(Math.random() * 50 + 1);
                this.nTry = 5;
                break;
            default:
                System.out.println("1. Easy\n2. Medium\n3.Hard");
                break;
        }
    }
}


public class GuessTheNumber{
    public static void main(String[] args){
        Number guess = new Number();  // Crea un oggetto di tipo Number
        Scanner scanner = new Scanner(System.in);  // Scanner per input utente
        int difficult = 0;


        while (difficult < 1 || difficult > 3) {  // Condizione per la scelta valida
            System.out.println("Choose difficulty level: \n1. Easy\n2. Medium\n3. Hard");
            if (scanner.hasNextInt()) {
                difficult = scanner.nextInt();
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }   
        guess.build(difficult);

        System.out.println("Try to guess the number! " + guess.nTry + " attempts.");
        for (int i = 1; i <= guess.nTry; i++) {
            System.out.println("Attempt " + i + ": Enter your guess.");
            int userGuess = scanner.nextInt();

            if (userGuess == guess.number) {
                System.out.println("Good Booooi! You guessed the right number: " + guess.number);
                break;
            } else if (userGuess < guess.number) {
                System.out.println("Higher");
            } else {
                System.out.println("Lower");
            }

            if (i == guess.nTry) {
                System.out.println("Niubbo you lose: " + guess.number);
            }
        }

        scanner.close();  // Chiude lo scanner per evitare perdite di memoria
    }
}
