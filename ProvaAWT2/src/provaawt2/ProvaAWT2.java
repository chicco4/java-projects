package provaawt2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author federico.scaggiante
 */
public class ProvaAWT2 {

    public static void main(String[] args) {
        ListaConcatenata c = load("input.txt");
        FrameLista f = new FrameLista("ProvaLista",c);
        f.setVisible(true);
    }

    public static ListaConcatenata load(String fileName) {
        File inFile = new File(fileName);
        Scanner inScan;
        try {
            inScan = new Scanner(inFile);
            String b = inScan.nextLine();
            ListaConcatenata c = new ListaConcatenata();
            int q = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == ',' || b.charAt(i) == ' ' || b.charAt(i) == ';') {
                    c.addTail(b.substring(q, i));
                    q = i + 1;
                }
                if (b.charAt(i) == '.') {
                    c.addTail(b.substring(q, i));
                    q = i + 1;
                } else {
                    if (i + 1 == b.length()) {
                        c.addTail(b.substring(q, i + 1));
                    }
                }
            }
            System.out.println(c.toString());
            return c;
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
            return null;
        }
    }
}
