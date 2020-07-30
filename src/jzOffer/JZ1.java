package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/15
 * @Time:18:41
 * @description:
 *
 *
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 * 要查找的数值如果比右上角的值大，那么它将大于整个行；
 * 要查找的数值比如果右上角的值小，那么它将小于整个列。
 *
 */
public class JZ1 {


    public static void main(String[] args) {

        int[][] array = {{1,2,8,9},{4,7,10,13}};
        int target = 7;

        System.out.println(Find(target,array));

    }

    public static boolean Find(int target, int[][] array) {


        int judgeX = array.length;
        int judgeY = array[0].length-1;


        int x = 0;int y = judgeY;

        while (x < judgeX && y >= 0){

            if(target == array[x][y]){
                return true;
            }else if(target > array[x][y]) {
                x++;
            }else{
                y--;
            }

        }

        return false;

    }


}
