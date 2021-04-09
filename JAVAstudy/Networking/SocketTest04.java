package Networking;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class SocketTest04 {
    public static void main(String[] args) {
        InetSocketAddress target = new InetSocketAddress("www.credu.co.kr", 80);
        try (SocketChannel socketChannel = SocketChannel.open(target)){
            ByteBuffer send = ByteBuffer.allocate(1024);
            send.put("GET / HTTP/1.0\n\n".getBytes());
            send.flip();
            socketChannel.write(send);
            WritableByteChannel out = Channels.newChannel(System.out);
            ByteBuffer receive =  ByteBuffer.allocate(1024);

            while(socketChannel.read(receive) != -1){
                receive.flip();
                out.write(receive);
                receive.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}