import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8888;
        int backlog = 0;

        //http 서버 생성
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(port), backlog);

        //컨텍스트 경로 설정
        httpServer.createContext("/main" , new MyHandler());

        //서버 실행
        httpServer.start();

        System.out.println("서버 실행 ...");
    }
}
