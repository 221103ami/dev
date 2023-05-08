package main;

import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {

        //서버 생성
        HttpServer server = HttpServer.create(new InetSocketAddress(8765), 0);

        //컨텍스트 설정
        server.createContext("/kh" , new KhHandler());

        //서버 실행
        server.start();

    }
    
}