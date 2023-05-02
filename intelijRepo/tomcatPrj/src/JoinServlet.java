public class JoinServlet extends MyServlet {

    public void processService(){
        System.out.println("MyServlet.processService called...");
        System.out.println("복잡한 로직을 처리하는 코드 ~~~~");
    }

    public void processGetMethod(){
        System.out.println("MyServlet.processGetMethod called...");
    }

    public void processPostMethod(){
        System.out.println("MyServlet.processPostMethod called...");
    }

}
