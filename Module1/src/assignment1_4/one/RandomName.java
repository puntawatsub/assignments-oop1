package assignment1_4.one;

import java.util.Scanner;

public class RandomName {

    static int randomNumberGenerator(int end) {
        return (int) (Math.random() * end);
    }

    public static void main(String[] args) {
        String[] firstNames = {
                "Aino", "Matti", "Veikko", "Liisa", "Kaisa",
                "Oskari", "Helmi", "Juhani", "Sanna", "Eero",
                "Emilia", "Antti", "Outi", "Pekka", "Marja",
                "Ville", "Tarja", "Ilkka", "Riikka", "Tuomas"

        };
        String[] lastNames = {
                "Korhonen", "Virtanen", "Mäkinen", "Nieminen", "Hämäläinen",
                "Laine", "Heikkinen", "Koski", "Kallio", "Salonen",
                "Lehtonen", "Leppänen", "Rantanen", "Seppälä", "Aalto",
                "Savolainen", "Karjalainen", "Järvinen", "Ahonen", "Koivisto"
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("How many names?: ");
        int nameCount = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < nameCount; i++) {
            int indexFirstName = randomNumberGenerator(firstNames.length);
            int indexLastName = randomNumberGenerator(lastNames.length);

            String randomFullName = firstNames[indexFirstName] + " " + lastNames[indexLastName];

            System.out.printf("Name: %s\n", randomFullName);
        }
        
        sc.close();
    }
}
