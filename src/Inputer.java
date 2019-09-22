import java.io.*;
import java.util.Scanner;

public class Inputer {
    private static Inputer inputer = new Inputer();
    private static Integer SIZE = 1024;
    private static Scanner sc = new Scanner(System.in);

    private Inputer() {
    }

    public static char read() {
        return (char) sc.nextInt();
    }

    public static String read(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        byte[] buffer = new byte[SIZE];
        is.read(buffer);
        return new String(buffer);
    }
}
