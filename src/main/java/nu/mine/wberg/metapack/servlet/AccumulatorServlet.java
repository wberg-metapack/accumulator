package nu.mine.wberg.metapack.servlet;

import com.google.inject.Inject;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import nu.mine.wberg.metapack.accumulator.Accumulator;

import java.io.IOException;
import java.io.OutputStream;

public class AccumulatorServlet implements HttpHandler {

    @Inject
    private Accumulator accumulator;

    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "0";
        if ("GET".equals(httpExchange.getRequestMethod())) {
            response = Integer.toString(accumulator.getTotal());
        }
//        else if ("POST".equals(httpExchange.getRequestMethod())) {
//            response
//        }

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
