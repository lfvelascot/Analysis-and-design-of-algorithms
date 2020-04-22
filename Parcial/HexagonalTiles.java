package usb;

import java.util.Scanner;

public class Hexagonos {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        while (num != 0) {
            int x = 0, y = 1, r = 0;
            for (int i = 1; i <= num; i++) {
                r = x + y;
                x = y;
                y = r;
            }
            System.out.println(r);
            num = s.nextInt();
        }
    }
}
