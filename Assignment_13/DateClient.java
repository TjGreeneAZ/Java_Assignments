// Tara Greene
// PA 13



// Implement a client-server program similar to the Client Server Program Example video in which the client will
// print the current date, month, day of month, day of week and year given by the server.
// Two classes should be implemented: DateClient and DateServer.
// The DateServer returns the current date, month, day of month, day of week and year
// (Hint: check out java.time.LocalDate in the Java API) to the client whenever it accepts a connection
// and then closes the socket.
// After printing the information returned by the DateServer, the DateClient closes the socket.
// Use port number 5555.


import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DateClient {

    private String host;
    private int port;

    public DateClient(String dateHost, int datePort) {
        host = dateHost;
        port = datePort;
    }

    public static void main(String[] args) throws IOException {
        final String HOST = "localhost";
        final int PORT = 5555;

        String newHost = HOST;
        int newPort = PORT;

        if (args.length == 1) {
            newPort = Integer.parseInt(args[0]);
        } else if (args.length == 2) {
            newHost = args[0];
            newPort = Integer.parseInt(args[1]);
        }

        DateClient client = new DateClient(newHost, newPort);
        client.request();
    }

    public void request() {
       try {
           Socket socket = new Socket(host, port);
           System.out.println("A client has created a socket");

           Scanner in = new Scanner(socket.getInputStream());
           System.out.println("Today's Date is: " + in.nextLine());
           System.out.println("The month is: " + in.nextLine());
           System.out.println("The day is: " + in.nextLine());
           System.out.println("The week day is: " + in.nextLine());
           System.out.println("The year is: " + in.nextLine());

       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }
}

