import generation.MenuGeneration;
import validation.ArgsValidation;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

//        Mac hmac = Mac.getInstance("HMAC/SHA3-256");

        ArgsValidation.validate(args);
        ArgsValidation.validateContent(args);

        String key = generateKey();
        System.out.println(key);

        int x = (int) ( Math.random() * args.length  + 1);

        MenuGeneration.generateMenu(args);
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int mov = in.nextInt();
        while (mov < 0 || mov > args.length)
        {
            mov = in.nextInt();
        }
        if (mov == 0)
        {
            System.exit(0);
        }
        decideResult(x, mov, args);



    }

    public static void decideResult(int computersMove, int playersMove, String[] args) {
//

        if (playersMove == computersMove) {
            System.out.println("Ничья");
            System.out.println("Comp " + computersMove);
            System.out.println("Player " + playersMove);
          System.exit(0);
        }
        for (int i = 1; i <= (args.length / 2) ; i++) {
            if (((playersMove + i) % args.length == computersMove) || (((playersMove + i) % args.length == 0))) {
                System.out.println("comp wins");
            System.out.println("Comp " + computersMove);
            System.out.println("Player " + playersMove);
            System.exit(0);
            }
        }
        System.out.println("player wins");
            System.out.println("Comp " + computersMove);
            System.out.println("Player " + playersMove);
            System.exit(0);

    }

    public static String generateKey() throws NoSuchAlgorithmException {

        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] values = new byte[32];
        random.nextBytes(values);

        StringBuilder sb = new StringBuilder();
        for (byte b : values) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }


}
