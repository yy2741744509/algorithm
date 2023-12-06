package KMP算法;/*
 *author：yangyu
 *creation time：2023/6/8 23:32
 */

public class Kmp {
    public static void getNext(int[] next, String sub) {
        next[0] = -1;
        if (sub.length() == 1) {
            // 当子串只有一个数据的时候，next数组的长度为1
            return;
        }
        // 前提条件是数组长度大于1
        next[1] = 0;
        int k = 0;
        int j = 2;

        while (j < sub.length()) {
            if (k == -1 || sub.charAt(j - 1) == sub.charAt(k)) {
                next[j] = k + 1;
                j++;
                k++;
            } else {
                k = next[k];
            }
        }
    }

    public static int KMP(String str, String sub, int pos) {
        // 判断两个串不能为空
        if (str == null || sub == null) {
            return -1;
        }

        int i = pos;// i遍历主串  从pos位置开始
        int j = 0;  // j遍历字串  从0开始
        int strLength = str.length();
        int subLength = sub.length();

        if (strLength == 0 || subLength == 0) {
            return -1;
        }
        // 判断pos位置合法性
        if (pos < 0 || pos > strLength) {
            return -1;
        }

        //求字串的next数组
        int[] next = new int[subLength];
        getNext(next, sub);

        while (i < strLength && j < subLength) {
            if (j == -1 || str.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }

        }
        if (j == subLength) {
            // 字串遍历完之后 j应该等于sublength
            // 找到返回字串在主串中的起始位置
            return i - j;
        } else {
            // 找不到返回-1
            return -1;
        }

    }

    public static void main(String[] args) {
        String str = "ababcabcdabcdefg";
        String sub = "aabaabb";

        int pos = KMP(str, sub, 0);
        System.out.println(pos);
    }

}
