package com.zzg.study.nio;

import java.io.IOException;

public class TimeServer {


    public static void main(String[] args) throws IOException, InterruptedException {


        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer();

        new Thread(multiplexerTimeServer).start();

    }
}
