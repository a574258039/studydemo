package com.zzg.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClientHandler implements Runnable {
    Selector selector;
    SocketChannel sc;

    public TimeClientHandler() throws IOException {

        sc = SocketChannel.open();
        sc.configureBlocking(false);
        sc.connect(new InetSocketAddress(12345));
        selector = Selector.open();
    }

    @Override
    public void run() {

        try {
            if (sc.connect(new InetSocketAddress(12345))) {
                sc.register(selector, SelectionKey.OP_READ);
                doWrite(sc);
            } else {
                sc.register(selector, SelectionKey.OP_CONNECT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                selector.select(1000);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterato = selectionKeys.iterator();
            if (iterato.hasNext()) {
                SelectionKey selectionKey = iterato.next();
                try {
                    handlerInput(selectionKey);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                iterato.remove();
            }
        }

    }

    private void handlerInput(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()) {
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            if (channel.isConnected()) {
                if (channel.finishConnect()) {
                    sc.register(selector, SelectionKey.OP_READ);
                    byte[] bytes = "give me time!".getBytes();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
                    byteBuffer.put(bytes);
                    byteBuffer.flip();
                    channel.write(byteBuffer);
                    if (byteBuffer.hasRemaining()) {
                        System.out.printf("error!!!!!!");
                    }
                }
            }
            if (selectionKey.isReadable()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int size = channel.read(byteBuffer);
                if (size > 0) {
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);
                    System.out.printf("--->" + new String(bytes));
                }
            }
        }

    }

    private void doWrite(SocketChannel sc) throws IOException {
        String msg = "get time!";
        ByteBuffer byteBuffer = ByteBuffer.allocate(msg.length());
        byteBuffer.put(msg.getBytes());
        byteBuffer.flip();
        sc.write(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            System.out.printf("send success!");
        }
    }
}
