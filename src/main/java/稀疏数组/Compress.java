package 稀疏数组;/*
 *作者：yangyu
 *创建时间：2022/8/26 21:23
 */

/**   10行10列
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 1 0 0 0 0 0 0
 * 0 0 0 0 2 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 */
public class Compress {
    public static void main(String[] args) {

        int gobang[][]=new int[10][10];
        gobang[1][3]=1;
        gobang[2][4]=2;

        int sum=0;// 原始二维数组中的棋子个数
        for (int []row : gobang){
            for (int data : row){
                if (data!=0){
                    sum++;
                }
            }
        }

        int sparseArray[][]=new int[sum+1][3];
        sparseArray[0][0]=gobang.length;   //行数
        sparseArray[0][1]=gobang[0].length;   //列数
        sparseArray[0][2]=sum;   //棋子个数

        int count=0;    //记录第几个棋子

        /**
         * ==========压缩==========
         */
        for (int i=0;i<gobang.length;i++){
            for (int j=0;j<gobang[i].length;j++){
                if (gobang[i][j]!=0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=gobang[i][j];
                }
            }
        }

        /**
         * ==========验证==========
         */
        System.out.println("行\t列\t值");
        for (int []row : sparseArray){
            for (int data : row){
                System.out.print(data+"\t");
            }
            System.out.println();
        }

    }
}
