import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la calculadora Postfix\n");
        System.out.println("Porfavor ingrese la ruta del archivo a calcular: \n");
        Scanner input = new Scanner(System.in);
        String filePath = input.nextLine();
        ArrayList<String> fileData = FileReader(filePath);
        System.out.println(fileData);

    }

    public static ArrayList FileReader(String path) {
        ArrayList<String> data = null;
        try {
            File rawData = new File(path);
            Scanner reader = new Scanner(rawData);
            String line;
            data = new ArrayList<String>();
            while (reader.hasNext()) {
                line = reader.nextLine();
                data.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
        return data;
    }
}
