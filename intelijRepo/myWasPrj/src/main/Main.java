package main;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {

        // 서버 생성
        HttpServer server = HttpServer.create(new InetSocketAddress(8765), 0);

        // 컨텍스트 설정
        server.createContext("/app" , new KhHandler());

        // 서버 실행
        server.start();

    }
}