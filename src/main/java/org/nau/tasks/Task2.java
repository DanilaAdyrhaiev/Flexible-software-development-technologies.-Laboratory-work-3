package org.nau.tasks;

import java.io.File;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        // а) Обрати довільний початковий каталог та створити об’єкт классу File з використанням абсолютного шляху.
        File initialDirectory = new File("src/main/resources/laba3");
        System.out.println("Існує каталог? " + initialDirectory.exists());

        try {
            // б) З поточного каталогу виконати послідовність переходів та створити 3 текстових файли за обраною темою.
            File currentDirectory = new File(".");
            File dir1 = new File(currentDirectory, "1");
            File dir2_1 = new File(dir1, "2.1");
            File dir2_1_2 = new File(dir2_1, "2.1.2");
            File dir2_2 = new File(dir1, "2.2");
            File dir1_2_2_1 = new File(dir2_1_2, "2.2.1");
            File dir1_2_1_1_1 = new File(dir1_2_2_1, "2.1.1.1");
            File dir2_1_2_1_1_2_2_2_1 = new File(dir1_2_1_1_1, "2.1.2.1.1.2.2.2.1");

            createTextFiles(dir2_1_2_1_1_2_2_2_1, 3);

            // в) З поточного каталогу (2.1.1.1) виконати послідовність переходів та створити 2 текстових файли за обраною темою.
            File dir2_1_1_1_2_1_3 = new File(dir1_2_1_1_1, "2.1.1.1.2.1.3");

            createTextFiles(dir2_1_1_1_2_1_3, 2);

            // г) З поточного каталогу (1.3) виконати послідовність переходів та створити 2 текстових файли за обраною темою.
            File dir1_3 = new File(dir1, "1.3");
            File dir2_1_D_1_1_1_2_2_2 = new File(dir1_3, "2.1-D:-1.1-1.1-2.1.1-2.2.2");

            createTextFiles(dir2_1_D_1_1_1_2_2_2, 2);

            // д) З поточного каталогу (2.2.2) виконати послідовність переходів та створити 2 текстових файли за обраною темою.
            File dir2_2_2 = new File(dir2_2, "2.2.2");
            File dir2_2_D_1_2_2_1 = new File(dir2_2_2, "2.2.2-D:-1.2-2.1-2.2.1");

            createTextFiles(dir2_2_D_1_2_2_1, 2);

            // е) З поточного каталогу (2.2.1) виконати послідовність переходів та створити 4 текстових файли за обраною темою.
            File dir2_2_1 = new File(dir1, "2.2.1");
            File dir1_2_2_1_1_3_2_1_1_1_1_2_2_2_2_1 = new File(dir2_2_1, "1-2.2.1-1.3-2.1.1.1-2-2-2-1");

            createTextFiles(dir1_2_2_1_1_3_2_1_1_1_1_2_2_2_2_1, 4);

            // є) Використовуючи методи класу File, видалити по одному зі створених у попередніх пунктах текстовому файлу.
            deleteOneFile(dir2_1_2_1_1_2_2_2_1);
            deleteOneFile(dir2_1_1_1_2_1_3);
            deleteOneFile(dir2_1_D_1_1_1_2_2_2);
            deleteOneFile(dir2_2_D_1_2_2_1);
            deleteOneFile(dir1_2_2_1_1_3_2_1_1_1_1_2_2_2_2_1);

            // ж) Використовуючи методи класу File, визначити чи існує каталог з пункту а).
            System.out.println("Існує каталог? " + initialDirectory.exists());

            // з) Обрати по одному файлу з пунктів б)-е) та використати до них по одному методу з табл. 3.2.
            printFileInfo(dir2_1_2_1_1_2_2_2_1);
            printFileLength(dir2_1_1_1_2_1_3);
            printFileLastModified(dir2_1_D_1_1_1_2_2_2);
            printFileAbsolutePath(dir2_2_D_1_2_2_1);
            printFileCanonicalPath(dir1_2_2_1_1_3_2_1_1_1_1_2_2_2_2_1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createTextFiles(File directory, int numFiles) throws IOException {
        if (!directory.exists()) {
            directory.mkdirs();
        }

        for (int i = 1; i <= numFiles; i++) {
            File file = new File(directory, "file" + i + ".txt");
            file.createNewFile();
        }
    }

    private static void deleteOneFile(File file) {
        if (file.exists()) {
            file.delete();
            System.out.println("Файл видалено: " + file.getName());
        } else {
            System.out.println("Файл не існує: " + file.getName());
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("Інформація про файл " + file.getName() + ":");
        System.out.println("Шлях: " + file.getPath());
        System.out.println("Існує: " + file.exists());
        System.out.println("Дозволи на читання: " + file.canRead());
        System.out.println("Дозволи на запис: " + file.canWrite());
    }

    private static void printFileLength(File file) {
        System.out.println("Довжина файлу " + file.getName() + ": " + file.length() + " байт");
    }

    private static void printFileLastModified(File file) {
        System.out.println("Останні зміни у файлі " + file.getName() + ": " + file.lastModified());
    }

    private static void printFileAbsolutePath(File file) {
        System.out.println("Абсолютний шлях до файлу " + file.getName() + ": " + file.getAbsolutePath());
    }

    private static void printFileCanonicalPath(File file) throws IOException {
        System.out.println("Канонічний шлях до файлу " + file.getName() + ": " + file.getCanonicalPath());
    }

}
