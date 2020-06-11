package com.zzg.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable {

    Selector selector = null;

    public MultiplexerTimeServer() throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(12345), 1024);
        selector = Selector.open();
        ssc.configureBlocking(false);
        ssc.register(selector, ssc.validOps());
    }

    @Override
    public void run() {
        try {
            while (selector.select() > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();

                    if (selectionKey.isValid()) {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                            SocketChannel sc = ssc.accept();
                            sc.configureBlocking(false);
                            sc.register(selectionKey.selector(), SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        }
                        if (selectionKey.isReadable()) {
                            SocketChannel sc = (SocketChannel) selectionKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            if (sc.read(byteBuffer) > 0) {
                                byteBuffer.flip();
                                byte[] bytes = new byte[byteBuffer.remaining()];
                                byteBuffer.get(bytes);
                                System.out.println("--->" + new String(bytes));
                            }
                            byteBuffer.clear();
                            String time = LocalDateTime.now().toString();
                            byteBuffer.put(time.getBytes());
                            byteBuffer.flip();
                            sc.write(byteBuffer);
                        }
                    }
                    iterator.remove();
                }

            }
        } catch (Exception e) {

        }

    }
}
