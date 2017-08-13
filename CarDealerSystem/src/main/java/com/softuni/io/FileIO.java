package com.softuni.io;

import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created on 3.8.2017 г..
 */
@Component
public class FileIO {
    public String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try(InputStream is = this.getClass().getResourceAsStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            String line = "";
            while((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void writeOnFile(String path, String content) {
        try(OutputStream os = new FileOutputStream(path);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
