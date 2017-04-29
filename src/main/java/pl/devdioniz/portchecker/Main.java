package pl.devdioniz.portchecker;

/**
 * @author TheDioniz, created on 29.04.2017.
 */
public class Main {

    public static void main(String[] args) {

        String host = "";
        Integer port = 0;

        // validate arguments
        if (args.length != 2) {
            System.err.println("Program requires 2 arguments.");
            System.err.println("Example:");
            System.err.println("java -cp <path_to_jar> " + Main.class.getName() + " <host> <port>");
            System.exit(1);
        }

        // assign hostname
        host = args[0];

        // check if port is a number
        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Port argument could be numbers only!");
            e.printStackTrace();
            System.exit(1);
        }


        PortChecker portChecker = new PortChecker(host, port);
        portChecker.connect();

    }


}
