import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        try {
            System.out.println("test");
            // create a server on port 8000
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

            // set routes
            server.createContext("/guestbook", new GuestBook());
            server.createContext("/static", new Static());
            server.setExecutor(null); // creates a default executor

            // start listening
            server.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}