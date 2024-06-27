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
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;


public class DateServer {

    private int port;

    public DateServer(int datePort) {
        port = datePort;
    }

    public static void main(String[] args) throws IOException {
        final int PORT = 5555;
        int newPort;

        if (args.length > 0) {
            newPort = Integer.parseInt(args[0]);
        } else {
            newPort = PORT;
        }

        DateServer server = new DateServer(newPort);
        server.start();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server open on port: " + port);

        while (true) {
            Socket s = server.accept();
            System.out.println("Waiting for clients to connect...");
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            System.out.println("Client has connected");

            // Generate Date and time
            LocalDate now = LocalDate.now();
            out.println(now); // Send full date
            out.println(now.getMonth()); // Send month name
            out.println(now.getDayOfMonth()); // Send day of the month
            out.println(now.getDayOfWeek()); // Send day of the week
            out.println(now.getYear()); // Send year

            s.close();
        }
    }
}
