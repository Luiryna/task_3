package generation;

public class MenuGeneration {
    public static void generateMenu (String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println((i + 1) + " - "  + args[i]);
        }
        System.out.println("0 - Exit");
    }
}
