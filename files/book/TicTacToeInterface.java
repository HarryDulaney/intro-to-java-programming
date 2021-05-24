import java.rmi.*;

public interface TicTacToeInterface extends Remote {
  /** 
   * Connect to the TicTacToe server and return the token.
   * If the returned token is ' ', the client is not connected to
   * the server
   */
  public char connect(CallBack client) throws RemoteException;

  /** A client invokes this method to notify the server of its move*/
  public void myMove(int row, int column, char token)
    throws RemoteException;
}
