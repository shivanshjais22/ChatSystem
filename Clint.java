
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Clint {

    Socket socket;
    BufferedReader br;
PrintWriter out;

    public Clint(){
        try {
            System.out.println("sending this line to server");
            socket=new Socket("127.0.0.1",8888);
            System.out.println("connection is done");
            
  br=new BufferedReader(new InputStreamReader(socket.getInputStream()));


       out=new PrintWriter(socket.getOutputStream());

       startreading();
       startwritting();


        } catch (Exception e) {
        }
    }
    public void startreading(){
        // thread  - resd kar ta rahinga
    
        Runnable r1=()->{
            System.out.println("Reader start");
    
            while(true){
                try{
                String msg =br.readLine();
                if(msg.equals("exist")){
                    System.out.println("u end the  chat ");
                    break;
    
                }
                System.out.println("Client :-"+msg);
            }catch(Exception ex){
                System.out.println(ex);
            }
    
            }
    
    
        };
        new Thread(r1).start();
    
      }
    
      public void   startwritting(){
        // thread  - wrting kar ta rahinga
        System.out.println("Reader writter");
    
        Runnable r2=()->{
    
            while (true) { 
    
                try {
    
                BufferedReader br1=new 
                BufferedReader(new InputStreamReader(System.in));
    
                String contant=br1.readLine();
                out.println(contant);
                out.flush();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
    
        };
    
        new Thread(r2).start();
    
      }

    public static void main(String[] args) {
        System.out.println("hello is clint");
        new Clint();
    }

    
}
