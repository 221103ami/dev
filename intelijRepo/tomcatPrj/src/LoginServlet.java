
public class LoginServlet extends MyServlet {

    public void processService(){
        System.out.println("MyServlet.processService called...");
        System.out.println("~~~로그인처리 ~~~");
    }

    public void processGetMethod(){
        System.out.println("MyServlet.processGetMethod called...");
    }

    public void processPostMethod(){
        System.out.println("MyServlet.processPostMethod called...");
    }

}
