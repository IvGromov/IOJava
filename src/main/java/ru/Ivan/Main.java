package ru.Ivan;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        /*
        try (FileInputStream in = new FileInputStream("C:\\dev\\java\\IOJava\\src\\main\\java\\ru\\Ivan\\demo.txt")) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*
        try (FileInputStream in = new FileInputStream("C:\\dev\\java\\IOJava\\src\\main\\java\\ru\\Ivan\\demo.txt")) {
            byte[] buf = new byte[64];
            int n = in.read(buf);
            while (n > 0) {
                System.out.print(new String(buf, 0, n));
                n = in.read(buf);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    */
        String data = "lmao";

        try (BufferedOutputStream out = new BufferedOutputStream( new FileOutputStream("C:\\dev\\java\\IOJava\\src\\main\\java\\ru\\Ivan\\out1.txt"))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
            out.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}