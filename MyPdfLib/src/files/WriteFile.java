
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class WriteFile {

    public static void SaveFile(String text, File path, String encoding) throws IOException {
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), encoding))) {
            out.write(text);
        }
    }

}
