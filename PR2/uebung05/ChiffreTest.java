package uebung05;

import java.io.*;
import java.util.StringTokenizer;

import org.junit.Test;

import static org.junit.Assert.*;

import java.lang.invoke.MethodHandles;

public class ChiffreTest {

    // Ausgabe eines CesarWriters in einen String

    StringWriter sw;
    StringReader sr;
    String str    = "ABCäÄßabcxyzZYX"; // Teststring
    String strenc = "DEFAäßdefÄÖÜcba"; // Teststring 2

    @Test
    public void encrytingASimpleString() throws Exception {
        try { // hier sind 2 CesarWriter-Filter hintereinander geschaltet !!!

            sw = new StringWriter(20);
            Writer w = new BufferedWriter(new CaesarWriter(new CaesarWriter(sw, 1), 2)); // shift
                                                                                       // =
                                                                                       // 1
                                                                                       // and
                                                                                       // 2

            Reader r = new BufferedReader(new StringReader(str));

            // -------- encoding string from String str to Stringwriter sw
            // ---------

            int res = r.read();

            while (res != -1) {
                w.write((char) res);
                res = r.read();
            }

            w.flush(); // muss sein, wenn der geschriebene String kürzer ist als
                       // die Länge von sw;

            w.close();
            r.close();

        } catch (IOException e) {
            System.out.println("IO-Fehler");
            e.printStackTrace();
        }

        assertEquals(sw.toString(), strenc);
    }

    @Test
    public void decrytingASimpleString() throws Exception {
        try { // hier sind 2 CesarWriter-Filter hintereinander geschaltet
              // (symmetrisch zur Verschlüsselung!!!

            sr = new StringReader(strenc);
            sw = new StringWriter(20);
            Reader r = new BufferedReader(new CaesarReader(new CaesarReader(sr, 1), 2)); // shift
                                                                                       // =
                                                                                       // 1
                                                                                       // and
                                                                                       // 2
            Writer w = new BufferedWriter(sw); // shift = 1 and 2

            // -------- decoding string from String sr to Stringwriter sw
            // ---------

            int res = r.read();

            while (res != -1) {
                w.write((char) res);
                res = r.read();
            }

            w.flush(); // muss sein, wenn der geschriebene String kürzer ist als
                       // die Länge von sw;

            r.close();
            w.close();

        } catch (IOException e) {
            System.out.println("IO-Fehler");
            e.printStackTrace();
        }

        assertEquals(sw.toString(), str);
    }
}
