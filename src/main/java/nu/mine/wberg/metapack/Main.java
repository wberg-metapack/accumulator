package nu.mine.wberg.metapack;

import com.sun.net.httpserver.HttpServer;
import nu.mine.wberg.metapack.servlet.AccumulatorServlet;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String... args) throws IOException {
        String path = System.getProperty("path");

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext(path, new AccumulatorServlet());
        server.setExecutor(null);
        server.start();
    }

}
