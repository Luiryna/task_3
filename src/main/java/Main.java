import generation.Game;
import generation.KeyGeneration;
import generation.MenuGeneration;
import validation.ArgsValidation;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {

        ArgsValidation.validateArgsNumber(args);
        ArgsValidation.validateContent(args);

        String key = KeyGeneration.getKey();

        int x = (int) ( Math.random() * args.length  + 1);

        System.out.println("HMAC: " + KeyGeneration.getHmac(key, args[x - 1]));

        MenuGeneration.generateMenu(args);
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int mov = in.nextInt();
        while (mov < 0 || mov > args.length)
        {
            System.out.println("Try again");
            mov = in.nextInt();
        }
        if (mov == 0)
        {
            System.exit(0);
        }
        int result = Game.getGameResult(x, mov, args);
        if (result == 0) {
            System.out.println("Draw!");
            System.out.println("Computer's move - " + args[x - 1]);
            System.out.println("Player's move - " + args[mov - 1]);
        } else if (result == 1) {
            System.out.println("Player's win");
            System.out.println("Computer's move - " + args[x - 1]);
            System.out.println("Player's move - " + args[mov - 1]);
        } else {
            System.out.println("Computer's win");
            System.out.println("Computer's move - " + args[x - 1]);
            System.out.println("Player's move - " + args[mov - 1]);
        }

        System.out.println("HMAC key: " + key);
    }
}
