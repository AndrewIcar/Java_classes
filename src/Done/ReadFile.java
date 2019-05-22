package Done;

import java.io.*;

public class ReadFile {
    public void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Entre path to file");
            FileInputStream file = new FileInputStream(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }


        //скопировать файл на диске по байтам
        //Создаем поток-чтения-байт-из-файла
        try (FileInputStream inputStream = new FileInputStream("c:/data.txt")) {
            // Создаем поток-записи-байт-в-файл
            try (FileOutputStream outputStream = new FileOutputStream("c:/result.txt")) {

                while (inputStream.available() > 0) //пока есть еще непрочитанные байты
                {
                    int data = inputStream.read(); // прочитать очередной байт в переменную data
                    outputStream.write(data); // и записать его во второй поток
                }
            }
        }
        //скопировать файл на диске блоками
        //Создаем поток-чтения-байт-из-файла
        try (FileInputStream inputStream = new FileInputStream("c:/data.txt")) {
            // Создаем поток-записи-байт-в-файл
            try (FileOutputStream outputStream = new FileOutputStream("c:/result.txt")) {

                byte[] buffer = new byte[1000];
                while (inputStream.available() > 0) //пока есть еще непрочитанные байты
                {
                    // прочитать очередной блок байт в переменную buffer и реальное количество в count
                    int count = inputStream.read(buffer);
                    outputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
                }
            }
        }
    }
}
