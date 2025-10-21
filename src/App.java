public class App {
    public static void main(String[] args) throws Exception {
        
        if (args.length == 0) {
            System.out.println("No se ha proporcionado ningún argumento");
            return;
        }

        String textLine = args[0];

        if (textLine.trim().isEmpty()) {
            System.out.println("El argumento no puede estar vacío");
            return;
        }

        String[] words = textLine.trim().split("\\s+");

        System.out.println("El número de palabras es: " + words.length);

        
       
    }
}
