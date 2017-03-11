/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

/**
 *
 * @author sbirmpilis
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFile {

    public static String OpenFile(File path, String encoding) throws IOException {
        BufferedReader textReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), encoding));
        String aLine;
        StringBuilder sbout = new StringBuilder();
        while ((aLine = textReader.readLine()) != null) {
            sbout.append(aLine).append('\n');
        }
        String text = sbout.toString();
        return text;
    }

}
