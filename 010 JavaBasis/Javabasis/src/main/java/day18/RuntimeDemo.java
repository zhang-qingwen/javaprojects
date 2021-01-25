package day18;

import java.io.IOException;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();

        Process p = r.exec("notepad.exe");

    }
}
