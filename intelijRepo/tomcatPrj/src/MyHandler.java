import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;
import java.util.HashMap;

public class MyHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        //클라이언트의 요청 확인
        URI requestURI = exchange.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        String requestMethod = exchange.getRequestMethod();
        System.out.println("requestMethod = " + requestMethod);

        String protocol = exchange.getProtocol();
        System.out.println("protocol = " + protocol);

        Headers requestHeaders = exchange.getRequestHeaders();
        System.out.println("requestHeaders = " + requestHeaders);
//        for (String s : requestHeaders.keySet()) {
//            String headerValue = requestHeaders.getFirst(s);
//            System.out.println(s + "/" + headerValue);
//        }

        InputStream is = exchange.getRequestBody();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data = br.readLine();
        System.out.println("data = " + data);

        //응답하기
        String str = "hello zzz";

        //응답하기1) 헤더
        exchange.getResponseHeaders().set("k01" , "v01");
        exchange.getResponseHeaders().set("atk" , "777");
        exchange.getResponseHeaders().set("def" , "123");
        exchange.sendResponseHeaders(200 , str.getBytes().length);

        //응답하기2) 바디
        OutputStream os = exchange.getResponseBody();
        os.write(str.getBytes());
        os.close();

        System.out.println("응답 완료");
    }

}//class




















