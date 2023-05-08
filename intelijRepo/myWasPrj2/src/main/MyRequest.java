package main;

import java.util.HashMap;
import java.util.Map;

public class MyRequest {

    public MyRequest(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    private final Map<String, String> paramMap;
    private final Map<String, String> attrMap = new HashMap<>();

    public String getParameter(String k){
        return paramMap.get(k);
    }

    public String getAttribute(String k){
        return attrMap.get(k);
    }

    public void setAttribute(String k, String v){
        attrMap.put(k, v);
    }



}
