import java.io.IOException;

public class ClientServerDemo
{
   public static void main(String[] args) throws InterruptedException
   {
      // Starts the Server
      // Implements the Runnable interface
      class ServerRunnable implements Runnable
      {
         public void run()
         {
            try
            {
               // Calls the server's Main method passing in no args
               DateServer.main(new String[] {});
            }
            // Catches any IOException thrown by the DateServer
            catch (IOException ex)
            {
               ex.printStackTrace();
            }
         }
      }
      // Creates and starts a new thread
      Thread t1 = new Thread(new ServerRunnable());
      t1.start();
      
      
      // Starts the Client
      // Implements the Runnable interface
      class ClientRunnable implements Runnable
      {
         public void run()
         {
            try
            {
               // Calls the client's main method passing in no args 
               DateClient.main(new String[] {});
            }
            catch (IOException ex)
            {
               // Catches any IOException thrown by the DateClient
               ex.printStackTrace();
            }
         }
      }
      
      // Creates and starts a new thread
      Thread t2 = new Thread(new ClientRunnable());
      t2.start();
      // Waits for the thread to die.
      t2.join();
      System.exit(0);
   }
}
