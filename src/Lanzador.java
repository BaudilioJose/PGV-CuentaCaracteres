import java.io.File;
import java.io.IOException;


public class Lanzador {
    private static Process startProcess(String textLine, String fileNamePath) {
        String classPath = System.getProperty("java.class.path");
        String className = "App";

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", classPath, className, textLine);
            processBuilder.redirectOutput(new File(fileNamePath));
            return processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }   
    } 
}
