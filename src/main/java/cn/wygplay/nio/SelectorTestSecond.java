package cn.wygplay.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class SelectorTestSecond {
    public static void main(String[] args) throws IOException {
        //1. 获取服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //2. 切换非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //3. 创建 buffer
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        writeBuffer.put("收到了。。。。".getBytes(StandardCharsets.UTF_8));

        //4. 绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(8090));

        //5. 获取 selector 选择器
        Selector selector = Selector.open();

        //6. 通道注册到选择器，进行监听
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //7. 选择器进行轮训，进行后续操作
        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
            // 循环
            while (selectionKeyIterator.hasNext()) {
                // 获取就绪状态
                SelectionKey k = selectionKeyIterator.next();

                // 操作判断
                if (k.isAcceptable()) {
                    // 获取连接
                    SocketChannel accept = serverSocketChannel.accept();

                    // 切换非阻塞模式
                    accept.configureBlocking(false);

                    // 注册
                    accept.register(selector, SelectionKey.OP_READ);
                } else if (k.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) k.channel();
                    readBuffer.clear();
                    socketChannel.read(readBuffer);

                    readBuffer.flip();
                    System.out.println("received:" + new String(readBuffer.array(), StandardCharsets.UTF_8));
                    k.interestOps(SelectionKey.OP_WRITE);
                } else if (k.isWritable()) {
                    writeBuffer.rewind();

                    SocketChannel socketChannel = (SocketChannel) k.channel();
                    socketChannel.write(writeBuffer);
                    k.interestOps(SelectionKey.OP_READ);
                }
                selectionKeyIterator.remove();
            }
        }

    }
}
