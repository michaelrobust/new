import java.util.Scanner;

public class PlayerRoster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int numPlayers = 5;
        int[] jerseyNumbers = new int[numPlayers];
        int[] ratings = new int[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + "'s jersey number:");
            jerseyNumbers[i] = sc.nextInt();
            System.out.println("Enter player " + (i + 1) + "'s rating:");
            ratings[i] = sc.nextInt();
            System.out.println();
        }

        outputRoster(jerseyNumbers, ratings);

        char option = ' ';
        while (option != 'q') {
            System.out.println("\nMENU");
            System.out.println("u - Update player rating");
            System.out.println("a - Output players above a rating");
            System.out.println("r - Replace player");
            System.out.println("o - Output roster");
            System.out.println("q - Quit");
            System.out.print("\nChoose an option:\n");
            option = sc.next().charAt(0);

            switch (option) {
                case 'u':
                    updatePlayerRating(sc, jerseyNumbers, ratings);
                    break;
                case 'a':
                    outputPlayersAboveRating(sc, jerseyNumbers, ratings);
                    break;
                case 'r':
                    replacePlayer(sc, jerseyNumbers, ratings);
                    break;
                case 'o':
                    outputRoster(jerseyNumbers, ratings);
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        sc.close();
    }

    public static void outputRoster(int[] jerseyNumbers, int[] ratings) {
        System.out.println("ROSTER");
        for (int i = 0; i < jerseyNumbers.length; i++) {
            System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseyNumbers[i] + ", Rating: " + ratings[i]);
        }
    }

    public static void updatePlayerRating(Scanner sc, int[] jerseyNumbers, int[] ratings) {
        System.out.println("Enter a jersey number:");
        int jerseyNumber = sc.nextInt();
        System.out.println("Enter a new rating for player:");
        int newRating = sc.nextInt();
        
        for (int i = 0; i < jerseyNumbers.length; i++) {
            if (jerseyNumbers[i] == jerseyNumber) {
                ratings[i] = newRating;
                break;
            }
        }
    }

    public static void outputPlayersAboveRating(Scanner sc, int[] jerseyNumbers, int[] ratings) {
        System.out.println("Enter a rating:");
        int rating = sc.nextInt();
        System.out.println("\nABOVE " + rating);
        
        for (int i = 0; i < jerseyNumbers.length; i++) {
            if (ratings[i] > rating) {
                System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseyNumbers[i] + ", Rating: " + ratings[i]);
            }
        }
    }

    public static void replacePlayer(Scanner sc, int[] jerseyNumbers, int[] ratings) {
        System.out.println("Enter a jersey number:");
        int jerseyNumber = sc.nextInt();
        
        for (int i = 0; i < jerseyNumbers.length; i++) {
            if (jerseyNumbers[i] == jerseyNumber) {
                System.out.println("Enter a new jersey number:");
                jerseyNumbers[i] = sc.nextInt();
                System.out.println("Enter a rating for the new player:");
                ratings[i] = sc.nextInt();
                break;
            }
        }
    }
}
