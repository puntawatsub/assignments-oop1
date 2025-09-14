package assignment3_4.one;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UlkoTalo {
    public static void main(String[] args) {
        final String LINKNAME = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        FileReader file;
        BufferedReader bfStream = null;
        String line;
        String[] columnNames;
        boolean header = true;

        int indexOfUlkoTalo = 0;

        URL url;
        try {
            url = new URL(LINKNAME);
        } catch (MalformedURLException e) {
            System.err.println(e);
            e.printStackTrace();
            return;
        }

        try {
            InputStream inputStream = url.openStream();

            InputStreamReader isr = new InputStreamReader(inputStream);

            BufferedReader reader = new BufferedReader(isr);

            int tempAmount = 0;
            float tempTotal = 0;

            while ((line = reader.readLine()) != null) {
                if (header) {
                    columnNames = line.split(";");
                    ArrayList<String> columnList = new ArrayList<>(List.of(columnNames));
                    indexOfUlkoTalo = columnList.indexOf("UlkoTalo");
                    header = false;
                } else {
                    columnNames = line.split(";");
                    if (columnNames[0].contains("01.01.2023")) {
                        tempAmount++;
                        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
                        tempTotal += nf.parse(columnNames[indexOfUlkoTalo]).floatValue();
                    }
                }
            }
            System.out.println(tempAmount);
            System.out.println(tempTotal);
            System.out.printf("Average: %f", (double) tempTotal / (double) tempAmount);

        } catch (IOException e) {
            System.err.println(e);
        } catch (ParseException e) {
            System.err.println(e);
        }

    }
}
