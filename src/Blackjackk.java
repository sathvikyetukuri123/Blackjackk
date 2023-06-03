import java.util.*;

public class Blackjackk {
    public static void main(String[] args) {
        int bankroll = 1000;
        boolean megaendgame = false;
        while (!megaendgame) {
            boolean multiplier = false;

            boolean win = false;
            boolean lose = false;
            Scanner input = new Scanner(System.in);
            System.out.println("Your balance: " + bankroll);
            System.out.println("How much would you like to wager?");
            int wager = input.nextInt();
            input.nextLine();
            int[] dealer = new int[2];
            int[] player = new int[2];
            int ace = 11;
            int[] deck = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, ace,
                    2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, ace };
            boolean endgame = false;

            int index = Draw(deck);
            player[0] = SetAce(deck[index], player);
            deck = ArrayHelper.removeMiddle(deck, index);
            int index2 = Draw(deck);
            player[1] = SetAce(deck[index2], player);
            deck = ArrayHelper.removeMiddle(deck, index2);
            int index3 = Draw(deck);
            dealer[0] = SetAce(deck[index3], dealer);
            deck = ArrayHelper.removeMiddle(deck, index3);
            int index4 = Draw(deck);
            dealer[1] = SetAce(deck[index4], dealer);
            deck = ArrayHelper.removeMiddle(deck, index4);

            displayCards(player, dealer);

            while (Sum(player) <= 21 && (!endgame)) {

                System.out.println("Hit or Stand?");
                String response = input.nextLine();
                if (response.equals("Hit")) {
                    int a = Draw(deck);
                    player = ArrayHelper.addEnd(player, (SetAce((deck[a]), player)));
                    deck = ArrayHelper.removeMiddle(deck, a);

                    displayCards(player, dealer);
                    if (Sum(player) > 21) {
                        System.out.println("Player busts!");
                        lose = true;
                        endgame = true;
                    } else if (Sum(player) == 21) {
                        multiplier = true;
                        System.out.println("Player has reached blackjack!");
                    }

                } else if (response.equals("Stand")) {
                    if (Sum(dealer) > Sum(player)) {
                        displayCards2(player, dealer);

                        System.out.println("Dealer has a greater total and wins!");
                        lose = true;
                        endgame = true;
                        break;
                    }
                    while (Sum(dealer) <= 17) {
                        int b = Draw(deck);
                        dealer = ArrayHelper.addEnd(dealer, (SetAce((deck[b]), dealer)));
                        deck = ArrayHelper.removeMiddle(deck, b);
                        displayCards2(player, dealer);
                        if (Sum(dealer) > 21) {
                            System.out.println("Dealer busts! Player wins!");
                            win = true;
                            endgame = true;
                            break;
                        } else if (Sum(dealer) == 21 && Sum(player) == 21) {
                            System.out.println("Player and Dealer get a blackjack and tie!");
                            endgame = true;
                            break;
                        } else if (Sum(dealer) == 21) {
                            System.out.println("Dealer get a blackjack! Dealer wins!");
                            lose = true;
                            endgame = true;
                            break;
                        } else if (Sum(dealer) > Sum(player)) {
                            System.out.println("Dealer total exceeds player total! Dealer wins!");
                            lose = true;
                            endgame = true;
                            break;
                        }

                    }

                }
            }
            if (win && multiplier) {
                bankroll += (wager * 1.5);
            } else if (win && (!multiplier)) {
                bankroll += wager;
            } else if (lose) {
                bankroll -= wager;
            }

            if (bankroll <= 0) {
                System.out.println("You have lost all your money!");
                megaendgame = true;
                break;
            }
            System.out.println("Would you like to continue playing?");
            String response2 = input.nextLine();
            if (response2.equals("No")) {
                System.out.println("Final balance: " + bankroll);
                megaendgame = true;

            }
        }

    }

    public static void displayCards(int[] player, int[] dealer) {
        System.out.println("Dealer's cards: " + dealer[0]);
        System.out.print("Player's cards: ");
        ArrayHelper.display(player);

    }

    public static void displayCards2(int[] player, int[] dealer) {
        System.out.print("Dealer's cards: ");
        ArrayHelper.display(dealer);
        System.out.print("Player's cards: ");
        ArrayHelper.display(player);

    }

    public static int Sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int Draw(int[] deck) {
        double n = Math.random();
        int index = ((int) (n * ((deck.length))));

        return index;
    }

    // public static int Hit(int[] deck, int[] player) {

    // }

    public static int SetAce(int num, int[] player) {
        if (num == 11) {

            if ((Sum(player) + 11) >= 21) {
                return 1;
            } else {
                return 11;
            }

        }

        return num;

    }
}

