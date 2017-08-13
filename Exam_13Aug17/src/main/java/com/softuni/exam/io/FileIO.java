package com.softuni.exam.io;

import com.softuni.exam.exceptions.ReadFileException;
import com.softuni.exam.exceptions.WriteOnFileException;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created on 3.8.2017 г..
 */
@Component
public class FileIO {
    public String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        try(InputStream is = this.getClass().getResourceAsStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            String line = "";
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new ReadFileException(e.getMessage(), e.getCause());
        }
        return sb.toString();
    }

    public void writeOnFile(String path, String content) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/" + path);
        if(!file.exists()){
            file.getParentFile().mkdir();
            file.createNewFile();
        }
        try(OutputStream os = new FileOutputStream(path);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))) {
            bw.write(content);
        } catch (IOException e) {
            throw new WriteOnFileException(e.getMessage(), e.getCause());
        }
    }
}
