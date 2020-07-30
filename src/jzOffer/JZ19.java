package jzOffer;

import java.util.ArrayList;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/19
 * @Time:22:19
 * @description:
 */
public class JZ19 {

    public static void main(String[] args) {
        int [][] matrix = {
                {1},
                {5},
                {9},
        };


        ArrayList<Integer> arrayList = printMatrix(matrix);

        for(int a :arrayList){
            System.out.println(a);
        }

    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {


        int direction = 0;  //0为Right 1位Down 2位Left 3位UP
        int miss = 0;  //0位无效
        int x = matrix.length;
        int y = matrix[0].length;


        int totalSize = x*y;

        ArrayList arrayList = new ArrayList();

        int i = 0;
        int j = 0;
        while(arrayList.size() != totalSize){
            if(direction == 0){
                while ((i>=0&&i<x&&j>=0&&j<y)&&matrix[i][j] != 0){
//                    System.out.println(matrix[i][j]);
                    arrayList.add(matrix[i][j]);
                    matrix[i][j] = miss;
                    j++;
                }
                j--;
                i++;
                direction = 1;
            }

            if(direction == 1){
                while ((i>=0&&i<x&&j>=0&&j<y)&&matrix[i][j] != 0){
//                    System.out.println(matrix[i][j]);
                    arrayList.add(matrix[i][j]);
                    matrix[i][j] = miss;
                    i++;
                }
                i--;
                j--;
                direction = 2;
            }

            if(direction == 2){
                while ((i>=0&&i<x&&j>=0&&j<y)&&matrix[i][j] != 0){
//                    System.out.println(matrix[i][j]);
                    arrayList.add(matrix[i][j]);
                    matrix[i][j] = miss;
                    j--;
                }
                j++;
                i--;
                direction = 3;
            }

            if(direction == 3){
                while ((i>=0&&i<x&&j>=0&&j<y)&&matrix[i][j] != 0){
//                    System.out.println(matrix[i][j]);
                    arrayList.add(matrix[i][j]);
                    matrix[i][j] = miss;
                    i--;
                }
                i++;
                j++;
                direction = 0;
            }

        }

        return arrayList;


    }

}
