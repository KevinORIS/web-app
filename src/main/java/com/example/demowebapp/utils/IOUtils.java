package com.example.demowebapp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class IOUtils {


    public static String read(File file) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("D:\\demo-web-app\\src\\jobOne\\webapp\\index.html");
        String indexContent = read(f);
        indexContent = indexContent.replace("${action.link}", "login"); //
        indexContent = indexContent.replace("${action.name}", "Login");
        System.out.println(indexContent);

    }


}
