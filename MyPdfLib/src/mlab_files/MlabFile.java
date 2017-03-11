package mlab_files;

import static files.ReadFile.OpenFile;
import static files.WriteFile.SaveFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.UserPrincipal;

/**
 *
 * @author stavros
 */
public class MlabFile {

    private final File file;

    public MlabFile(String filename) {
        file = new File(filename);
    }

    public String open() throws IOException {
        String text = OpenFile(file, "UTF-8");
        return text;
    }

    public void save(String textToSave) throws IOException {
        SaveFile(textToSave, file, "UTF-8");
    }

    public static MlabFile saveAs(String newFilename, String textToSaveAs) throws IOException {
        MlabFile mlab = new MlabFile(newFilename);
        mlab.save(textToSaveAs);
        return mlab;
    }

    public void close() {
    }

    public void delete() {
        file.delete();
    }

    public String getStatus() throws IOException {
        //long sizeInBytes = file.length();
        //Path filepath = FileSystems.getDefault().getPath(file.getAbsolutePath());
        Path filepath = Paths.get(file.getAbsolutePath());
        BasicFileAttributes bfa = Files.readAttributes(filepath, BasicFileAttributes.class);
        PosixFileAttributes pfa = Files.readAttributes(filepath, PosixFileAttributes.class);
        long size = bfa.size();
        FileTime creationDate = bfa.creationTime();
        FileTime modifiedDate = bfa.lastModifiedTime();
        UserPrincipal author = pfa.owner();

        StringBuilder sbs = new StringBuilder();
        sbs.append("Size: ").append(size).append(" bytes\n");
        sbs.append("Creation Date: ").append(creationDate.toString()).append('\n');
        sbs.append("Last Modified Date: ").append(modifiedDate.toString()).append('\n');
        sbs.append("User Name: ").append(author.getName()).append('\n');
        String status = sbs.toString();
        return status;
    }

    public String getName() {
        return file.getName();
    }

}
