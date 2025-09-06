package assignment3_4.two;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {
    public static void main(String[] args) {

        long previousNum = 0;
        long nextNum = 1;
        long tempNextNum;

        try (Writer writer = new FileWriter("file.csv");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (int i = 0; i < 61; i++) {
                tempNextNum = nextNum + previousNum;
                bufferedWriter.write(String.valueOf(previousNum));
                previousNum = nextNum;
                nextNum = tempNextNum;
                bufferedWriter.write(",");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
