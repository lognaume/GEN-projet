package ch.heigvd.server;

import ch.heigvd.protocol.Protocol;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 * @author Tony Clavien
 * @author Maxime Guillod
 *
 */
public class App extends Thread {

    private ServerSocket server;

    public App() {
        try {
            server = new ServerSocket(Protocol.PORT);
            Socket socket;
            while ((socket = server.accept()) != null) {
                /*
                Start a new thread for the communication. 
                We will have a thread (this) which listen for new communication, and one thread for every game
                 */
                new Game(socket).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();

    }

}
