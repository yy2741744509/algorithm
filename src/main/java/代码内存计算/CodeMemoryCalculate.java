package 代码内存计算;

import java.util.Scanner;

public class CodeMemoryCalculate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String[] str = new String[T];
        in.nextLine();

        for (int i = 0; i < T; i++) {
            str[i] = in.nextLine();
        }
        in.close();
        Long sum = 0L;

        for (String s : str) {
            //如果是数组
            if (s.contains("[]")) {
                if (s.contains(",")) {
                    //如果有多个变量

                    String[] types = s.split(",");
                    //int[]
                    if (s.indexOf("i") == 0) {
                        for (String type : types) {
                            sum += Long.parseLong(type.substring(type.lastIndexOf("[") + 1, type.lastIndexOf("]"))) * 4L;
                        }
                    } else {
                        //long[]
                        for (String type : types) {
                            sum += Long.parseLong(type.substring(type.lastIndexOf("[") + 1, type.lastIndexOf("]"))) * 8L;
                        }
                    }

                } else {
                    //如果只有一个变量
                    if (s.indexOf("i") == 0) {
                        sum += Long.parseLong(s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"))) * 4L;
                    } else {
                        sum += Long.parseLong(s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"))) * 8L;
                    }
                }
            } else {
                //如果不是数组
                if (s.contains(",")) {
                    //如果有多个变量
                    String[] strs = s.split(",");
                    if (s.indexOf("i") == 0) {
                        sum += strs.length * 4L;
                    } else if (s.indexOf("l") == 0) {
                        sum += strs.length * 8L;
                    } else {
                        for (String str1 : strs) {
                            sum += str1.substring(str1.indexOf("\"") + 1, str1.lastIndexOf("\"")).length();
                        }
                    }

                } else {
                    //如果只有一个变量
                    if (s.indexOf("i") == 0) {
                        sum += 4L;
                    } else if (s.indexOf("l") == 0) {
                        sum += 8L;
                    } else {
                        sum += s.substring(s.indexOf("\"") + 1, s.lastIndexOf("\"")).length();
                    }
                }
            }
        }

        if(sum>=Math.pow(2, 30)) {//GB
            System.out.print((int)(sum/Math.pow(2, 30))+"GB");
            sum%=(long)Math.pow(2, 30);
            if((int)(sum/Math.pow(2, 20))!=0) {
                System.out.print((int)(sum/Math.pow(2, 20))+"MB");
            }
            sum%=(long)Math.pow(2, 20);
            if((int)(sum/Math.pow(2, 10))!=0) {
                System.out.print((int)(sum/Math.pow(2, 10))+"KB");
            }
            sum%=(long)Math.pow(2, 10);
            if(sum!=0) {
                System.out.println(sum+"B");
            }
            System.exit(0);
        }
        if(sum>=Math.pow(2, 20)) {//MB
            System.out.print((int)(sum/Math.pow(2, 20))+"MB");
            sum%=(long)Math.pow(2, 20);
            if((int)(sum/Math.pow(2, 10))!=0) {
                System.out.print((int)(sum/Math.pow(2, 10))+"KB");
            }
            sum%=(long)Math.pow(2, 10);
            if(sum!=0) {
                System.out.println(sum+"B");
            }
            System.exit(0);
        }
        if(sum>=Math.pow(2, 10)) {//KB
            System.out.println(sum/Math.pow(2, 10)+"KB");
            sum%=(long)Math.pow(2, 10);
            if(sum!=0) {
                System.out.println(sum+"B");
            }
            System.exit(0);
        }
        System.out.println(sum+"B");

    }

}


