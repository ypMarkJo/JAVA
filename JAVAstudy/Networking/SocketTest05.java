package Networking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SocketTest05 {

    public static void main(String[] args) {
        try (ServerSocketChannel server = ServerSocketChannel.open()){
            System.out.println(server);
            server.bind(new InetSocketAddress(8000));
            System.out.println(server);
            server.configureBlocking(false);

            System.out.println("Server starts");
            //Selector: manager of channels
            Selector selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);//register socket channel into selector
            System.out.println(selector);
            while (selector.select() > 0){
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()){
                    SelectionKey key = it.next();
                    System.out.println(key);
                    it.remove();
                    //check whether channel reactions: isConnectable? isReadable? isWritable?
                    if (key.isAcceptable()) {
                        ServerSocketChannel serverChannel = (ServerSocketChannel)key.channel();
                        SocketChannel client = serverChannel.accept();
                        System.out.println("key is acceptable!");
                        System.out.println(client);
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE);

                    } else if (key.isWritable()){
                        try (SocketChannel client = (SocketChannel) key.channel()){
                            System.out.println("key is writable!!!");
                            System.out.println(client);
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            buffer.put("HTTP/1.0 200 OK\n".getBytes());
                            buffer.put("Content-Type: text/html\n\n".getBytes());
                            for (int i = 0; i < 5; i++){
                                buffer.put("<h1>have a nice  day!!!</h1>".getBytes());
                                System.out.println("http***");
                                Thread.sleep(3000);
                            }
                            buffer.flip();
                            System.out.println(buffer);
                            client.write(buffer);
                            Thread.sleep(1000);
                        }
                    }

                }

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}