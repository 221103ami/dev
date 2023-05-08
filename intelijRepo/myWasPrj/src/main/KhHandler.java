package main;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KhHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("호출됨 ~~~");


        //요청 받기

        //요청라인 (메소드)
        String requestMethod = exchange.getRequestMethod();
        System.out.println("requestMethod = " + requestMethod);

        //요청라인 (경로)
        URI requestURI = exchange.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        //요청라인 (프로토콜)
        String protocol = exchange.getProtocol();
        System.out.println("protocol = " + protocol);

        //헤더
        Headers requestHeaders = exchange.getRequestHeaders();
        Iterator<String> iterator = requestHeaders.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            String value = requestHeaders.getFirst(key);
            System.out.println(key + " : " + value);
        }

        //바디
        InputStream is = exchange.getRequestBody();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String data = br.readLine();
        System.out.println("data = " + data);


        //응답하기
        String str = "hello";

        //헤더
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("k01" , "v01");

        //상태코드 + 헤더(Content-Length)
        exchange.sendResponseHeaders(200 , 5);

        //바디
        OutputStream os = exchange.getResponseBody();
        os.write(str.getBytes());
        os.close();
    }


}
