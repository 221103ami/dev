package main;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;

public class KhHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        //URI 에 따라 다른 동작하게 ... (join , login ...)
        URI requestURI = exchange.getRequestURI();
        String uriStr = requestURI.toString();

        HashMap<String, MyServlet> map = new HashMap<>();
        map.put("/kh/join" , new JoinServlet());
        map.put("/kh/login" , new LoginServlet());

        MyServlet obj = map.get(uriStr);
        if(obj == null){
            //404 응답
            exchange.sendResponseHeaders(404 , 0);
            return;
        }
        HashMap<String, String> paramMap = new HashMap<String, String>();

        //paramMap 채우기
        //1. 바디 데이터 읽기
        InputStream is = exchange.getRequestBody();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        while(true){
            String temp = br.readLine();
            if(temp == null){
                break;
            }
            sb.append(temp);
        }
        System.out.println("sb = " + sb.toString());

        //2. 데이터 정형화
        String data = sb.toString();
        String[] paramArr = data.split("&");
        for (int i = 0; i < paramArr.length; i++) {
            String[] param = paramArr[i].split("=");
            String key = param[0];
            String value = param[1];
            paramMap.put(key , value);
        }
        //3. paramMap 채우기


        MyRequest req = new MyRequest(paramMap);
        MyResponse resp = new MyResponse();
        obj.service(req , resp);

        //성공 응답
        exchange.sendResponseHeaders(200, 0);
    }


}
