package seonjae.console;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Example {
    @SneakyThrows
    public static void main(String[] args) {
        Console.show();

        Thread.sleep(100);
        System.out.println(System.in.getClass().getName());

        try {
            @Cleanup BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            while (true) {
                if ((line = reader.readLine()) == null) continue;
                System.out.println("line : " + line);
                Console.log(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
