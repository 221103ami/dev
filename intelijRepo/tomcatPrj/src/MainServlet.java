public class MainServlet extends MyServlet {

    public void processService(){
        System.out.println("MyServlet.processService called...");
    }

    public void processGetMethod(){
        System.out.println("MyServlet.processGetMethod called...");
    }

    public void processPostMethod(){
        System.out.println("MyServlet.processPostMethod called...");
    }

}
