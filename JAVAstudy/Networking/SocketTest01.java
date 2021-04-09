package Networking;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class SocketTest01 {
    public static void main(String[] args) {
        try(Socket socket=new Socket("www.credu.co.kr",80);
        OutputStream out=socket.getOutputStream();
        InputStream in=socket.getInputStream();
        ) {
            out.write("GET / HTTP/1.0\n\n".getBytes());

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = in.read(buf)) != -1) {
                bytes.write(buf, 0, length);
            }
            System.out.println(new String(bytes.toByteArray()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
