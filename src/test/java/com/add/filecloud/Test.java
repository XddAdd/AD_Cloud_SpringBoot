package com.add.filecloud;

import org.apache.tomcat.jni.File;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    @org.junit.jupiter.api.Test
    void test1() throws IOException {
        Scanner sc = new Scanner(new FileInputStream("C:\\Users\\Administrator\\Desktop\\input.txt"));
        BufferedWriter output = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\output.txt"));


        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String t = line.toUpperCase();
            if (!t.contains(".JPG") && !t.contains(".JPEG") && !t.contains(".PNG")) {
                //System.out.println(line);
                output.append(line + "\n");
                output.flush();
            }
        }
    }




}
