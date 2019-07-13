package Done;


/*
Прайсы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        if (args[0] != null && args[0].equals("-c")) {
            addProduct(args, name);
        }
    }

    public static String fillParamtr(String parametr, int requiredLength) {
        while (parametr.length() < requiredLength) {
            parametr.concat(" ");
        }
        return parametr;
    }

    public static int getMaxId(String fileName) {
        int maxId = 0;
        try (Scanner sc = new Scanner(fileName)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String lineId = line.substring(0, 8).trim();
                int id = Integer.parseInt(lineId);
                if (id > maxId) maxId = id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxId;
    }

    public static void writeToFile(String fileName, int maxId, String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        try  {

            String productId = String.valueOf(++maxId);
            fileWriter.write("\n"
                    + fillParamtr(productId, 8)
                    + fillParamtr(args[1], 30)
                    + fillParamtr(args[2], 8)
                    + fillParamtr(args[3], 4));
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWriter.close();
    }

    public static void addProduct(String[] args, String fileName) throws IOException {
        int maxId = getMaxId(fileName);
        writeToFile(fileName, maxId, args);
    }
}
