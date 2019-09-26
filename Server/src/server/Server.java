//parei em 10:50

package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    
    private void criarServerSocket(int porta) throws IOException
    {
        serverSocket = new ServerSocket(porta);    
    }
    
    private Socket esperaConexao() throws IOException
    {
        Socket socket = serverSocket.accept();
        return socket;
    }
    
    private void trataConexao(Socket socket)
    {
        try{
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        } catch(IOException e)
        {
            //tratamento de falha
        }
    }
    
    public static void main(String[] args) {
        try{
        Server server = new Server();
        server.criarServerSocket(5555);
        Socket socket = server.esperaConexao();
        } catch (IOException e){
            //tratar exceção        
        }
        
    }
    
}
