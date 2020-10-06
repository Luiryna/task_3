package validation;

public class ArgsValidation {
    public static void validateArgsNumber(String[] args) {
        if (args.length % 2 == 0 || args.length < 3) {
            System.out.println("Number of args is incorrect");
            System.exit(0);
        }
    }

    public static void validateContent (String[] args) {
        for(int i = 0; i < args.length - 1; i++)
        {
            for(int j = i + 1; j < args.length; j++)
            {
                if (args[i].equals(args[j]))
                {
                    System.out.println("Some args are the same");
                    System.exit(0);
                }
            }
        }
    }

}
