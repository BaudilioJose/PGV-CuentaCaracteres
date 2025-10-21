import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;



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

    public static void main(String[] args) {
        List<Process> processList = new ArrayList<>();
        List<String> outputFiles = new ArrayList<>();
        int lineCount = 0;
        int totalWords = 0;


        try (BufferedReader reader = new BufferedReader(new FileReader(new File("data/Citas_R&J.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                String outputFileName = "output_linea_" + lineCount + ".txt";
                outputFiles.add(outputFileName);

                Process process = startProcess(line, outputFileName);
                if (process != null) {
                    processList.add(process);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer el fichero");
        }

        for (String outputFile : outputFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(outputFile)))) {
                String line = reader.readLine();
                if (line != null && line.startsWith("El número de palabras es: ")) {
                    int wordCount = Integer.parseInt(line.replace("El número de palabras es: ", "").trim());
                    System.out.println("Archivo " + outputFile + ": " + line);
                    totalWords += wordCount;
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al leer el archivo: " + outputFile);
            }
        }
    }
    
    
}
