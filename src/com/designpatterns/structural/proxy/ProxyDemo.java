package com.designpatterns.structural.proxy;

import java.util.Scanner;

public class ProxyDemo {
    public static void main(String[] args) {
        // 3. The client deals with the wrapper
        SocketInterface socket = new SocketProxy("127.0.0.1", 8080, args[0].equals("first"));
        String str;
        boolean skip = true;
        while (true) {
            if (args[0].equals("second") && skip) {
                skip = false;
            } else {
                str = socket.readLine();
                System.out.println("Receive - " + str);
            }
            System.out.print("Send ---- ");
            str = new Scanner(System.in).nextLine();
            socket.writeLine(str);
            if (str.equals("quit")) {
                break;
            }
        }
        socket.dispose();
    }
}
