import java.util.Scanner;

public class Forca {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Por favor, informe seu nome:");
        String playerName = in.nextLine();
        System.out.println("Bem-vindo " + playerName);

        String secretWord = "Abraço".toUpperCase();

        CurrentState currentState = new CurrentState(secretWord);

        while(true) {
            System.out.println("Qual seu chute? ");
            String guess = in.nextLine();

            if (guess.equalsIgnoreCase("exit")) {
                System.out.println("Até a próxima!");

                System.exit(0);
            }

            currentState.handleGuess(guess);
            System.out.println(currentState.getCurrentState());
        }
    }
}
