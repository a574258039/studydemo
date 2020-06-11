package com.zzg.study.nio;

import java.io.IOException;

public class TimeClient {

    public static void main(String[] args) throws IOException, InterruptedException {

        TimeClientHandler timeClientHandler = new TimeClientHandler();
        new Thread(timeClientHandler).start();

    }
}
