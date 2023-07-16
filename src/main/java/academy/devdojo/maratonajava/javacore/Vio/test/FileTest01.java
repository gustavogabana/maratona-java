package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try {

            boolean isCreated = file.createNewFile();
            System.out.println("Created: " + isCreated);
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Directory: " + file.isDirectory());
            System.out.println("File: " + file.isFile());
            System.out.println("Is a hidden file: " + file.isHidden());
            System.out.println("Last modified: " + Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDateTime());
            boolean exists = file.exists();
            if (exists) {
                System.out.println("Deleted: " + file.delete());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
