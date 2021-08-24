package codecracker;

import java.util.Scanner;

public class Codecracker {

    public Scanner scanner;

    Codecracker() {
    }

    public String parseInput() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public static void main(String[] args) {
        System.out.println("Enter encrypted word:");
        Codecracker codecracker = new Codecracker();
        Decipher decipher = new Decipher();
        String output = decipher.decrypt(codecracker.parseInput());
        System.out.println("The encrypted code means:\n" + output);
    }
}
