package cn.wygplay.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {
//1. 获取通道，绑定主机和端口号
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(8090));

        //2. 切换到非阻塞模式
        socketChannel.configureBlocking(false);
        for (int i = 0; i < 3; i++) {
            //3. 创建 buffer
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

            //4. 写入 buffer 数据
            writeBuffer.put(new Date().toString().getBytes(StandardCharsets.UTF_8));

            //5. 模式切换
            writeBuffer.flip();

            //6. 写入通道
            socketChannel.write(writeBuffer);

            //7. 关闭
            writeBuffer.clear();
            int readBytes = socketChannel.read(writeBuffer);
            if (readBytes > 0) {
                System.out.println("received:" + new String(writeBuffer.array()).trim());
            }
            writeBuffer.clear();
            Thread.sleep(1000);
        }
        socketChannel.close();

    }
}
