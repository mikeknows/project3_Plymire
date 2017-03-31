/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3_plymire;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Mike
 */
public class Project3_Plymire {

    public static int getKey() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key");
        try {
            int key = sc.nextInt();
            if (key <= 0 || key > 26) {
                System.out.println("Enter 1-26");
            } else {
                return key;
            }
            return key;
        } catch (Exception e) {
            System.out.println("Enter a number");
            getKey();

        }
        int key = getKey();
        return key;
    }

    public static File getFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name");
        String file1 = sc.next();
        if (file1.endsWith(".txt") || file1.endsWith(".enc")) {
            File file = new File(file1);
            return file;
        } else {
            return new File("");
        }
    }

    public static void encrypt(File inputFile, int key) {
        if (inputFile.getName().endsWith(".txt")) {
        try {
            Scanner file = new Scanner(inputFile);
            try (FileWriter fw = new FileWriter(new File(inputFile.getName().replace(".txt", ".enc")))) {
                while (file.hasNextLine()) {
                    char[] line = file.nextLine().toCharArray();
                    for (int i = 0; i < line.length; i++) {
                        line[i] = (char) ((int) line[i] + key);

                    }
                    fw.write(String.copyValueOf(line));

                }
            }

        } catch (Exception e) {
            System.out.println("File not found");
        }
        } else {
            System.out.println("error");
        }
    }

    public static void decryptFile(File inputFile, int key) {
        try {
            Scanner file = new Scanner(inputFile);
            FileWriter fw = new FileWriter(new File(inputFile.getName().replace(".enc", ".txt")));
            while (file.hasNextLine()) {
                char[] line = file.nextLine().toCharArray();
                for (int i = 0; i < line.length; i++) {
                    line[i] = (char) ((int) line[i] - key);

                }

                fw.write(String.copyValueOf(line));
                fw.close();
            }

        } catch (Exception ex) {
            System.out.println("Error.");
        }
    }

    public static int getMenuOption() {
        Scanner sc = new Scanner(System.in);
        boolean falseBool = false;
        int menu;
        try {
            System.out.print("1. Encrypt\n2. Decrypt\n3. Quit\n");
            menu = sc.nextInt();

            while (menu <= 3 && menu >= 1) {
                return menu;
            }

            if (menu != 1 && menu != 2 && menu != 3) {
                falseBool = true;

            }
            if (falseBool = true) {
                System.out.println("Enter a valid option");
                menu = sc.nextInt();
            }
            return menu;
        } catch (Exception e) {
            System.out.println("Try a num");
            menu = sc.nextInt();

        }
        return menu;
    }

    public static void main(String[] args) throws Exception {

        while (true) {

            switch (getMenuOption()) {
                case 1:
                    encrypt(getFile(), getKey());
                    continue;
                case 2:
                    decryptFile(getFile(), getKey());
                    continue;
                case 3:
                    System.exit(0);
                    continue;
            }

        }

    }
}
