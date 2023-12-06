package 稀疏数组;/*
 *作者：yangyu
 *创建时间：2022/8/26 21:24
 */

public class Restore {
    public static void main(String[] args) {
        int[][] sparseArray =new int[3][3];
        sparseArray[0][0]=10;
        sparseArray[0][1]=10;
        sparseArray[0][2]=10;
        sparseArray[1][0]=1;
        sparseArray[1][1]=3;
        sparseArray[1][2]=1;
        sparseArray[2][0]=2;
        sparseArray[2][1]=4;
        sparseArray[2][2]=2;


        /**
         * ==========还原==========
         */
        int[][] gobang=new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
                gobang[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }

        /**
         * ==========验证==========
         */
        for (int i = 0; i < gobang.length; i++) {
            for (int j = 0; j < gobang[i].length; j++) {
                System.out.print(gobang[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
