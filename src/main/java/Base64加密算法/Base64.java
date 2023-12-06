package Base64加密算法;

import java.util.Arrays;

public class Base64 {
    private static char[] codingTable = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '+', '/'
    };

    public static void main(String[] args) {
        String str = "pF4jGcTTdik=";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            String temp = Integer.toBinaryString(str.charAt(i));

            switch (temp.length()) {
                case 6:
                    temp = "00" + temp;
                    break;
                case 7:
                    temp = "0" + temp;
                    break;
            }
            sb.append(temp);
        }


        int[] base64 = new int[str.length() * 4 / 3];
        for (int i = 0; i < str.length() * 4 / 3; i++) {
            base64[i] = Integer.parseInt(sb.substring(i * 6, i * 6 + 6), 2);
        }
        System.out.println(Arrays.toString(base64));

        StringBuilder data = new StringBuilder();
        for (int i = 0; i < base64.length; i++) {
            data.append(codingTable[base64[i]]);
        }
        System.out.println(data);

    }
}
