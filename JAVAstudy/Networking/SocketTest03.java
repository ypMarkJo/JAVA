package Networking;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest03 {
    public static void main(String[] args) {
        ServerSocket server=null;
        try {
            server = new ServerSocket(8080);
            System.out.println("***server starts***");
            while (true){
                Socket client = server.accept();

                Thread thread = new Thread(){
                    public void run() {
                        try (OutputStream out = client.getOutputStream();
                             InputStream in = client.getInputStream()) {
                            out.write("HTTP/1.0 200 OK\n".getBytes());
                            out.write("Content-Type: text/html\n\n".getBytes());
                            for (int i = 0; i < 5; i++){
                                out.write("<h1>Have a nice day!!!<h1>".getBytes());
                                Thread.sleep(1000);
                            }
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                client.close();
                            } catch (Exception e){}
                        }

                    }

                };
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
