import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {
ServerSocket server;
Socket socket;
BufferedReader br;
PrintWriter out;

// construtar
    public Server(){
        try{
       server = new ServerSocket(8888);

       System.out.println("Server ready to accept connection");
       socket= server.accept();

       br=new BufferedReader(new InputStreamReader(socket.getInputStream()));


       out=new PrintWriter(socket.getOutputStream());

       startreading();
       startwritting();           

        }catch(Exception e){
          e.printStackTrace();
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
                System.out.println("user end the  chat ");
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
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

    };

    new Thread(r2).start();

  }
    public static void main(String args[]){
        System.out.println("hello java");
        new Server();
    }
    
}