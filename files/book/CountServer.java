import java.io.*;
import java.net.*;

public class CountServer {
  private RandomAccessFile raf;
  private int count; // Count the access to the server

  public static void main(String[] args) {
    new CountServer();
  }

  public CountServer() {
    try {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(8000);
      System.out.println("Server started ");

      // Create or open the count file
      raf = new RandomAccessFile("count.dat", "rw");

      // Get the count
      if (raf.length() == 0)
        count = 0;
      else
        count = raf.readInt();

      while (true) {
        // Listen for a new connection request
        Socket socket = serverSocket.accept();

        // Create a DataOutputStream for the socket
        DataOutputStream outputToClient =
          new DataOutputStream(socket.getOutputStream());

        // Increase count and send the count to the client
        count++;
        outputToClient.writeInt(count);

        // Write new count back to the file
        raf.seek(0);
        raf.writeInt(count);
      }
    }
    catch(IOException ex) {
      ex.printStackTrace();
    }
  }
}

