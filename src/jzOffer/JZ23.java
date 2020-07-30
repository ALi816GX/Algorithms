package jzOffer;

import java.util.ArrayList;


/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/24
 * @Time:20:35
 * @description:
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 */
public class JZ23 {


    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};

        System.out.println(VerifySquenceOfBST(a));
    }


    public static boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence == null || sequence.length == 0){
            return false;
        }

        ArrayList<Integer> arrayList = new ArrayList();
        for(int a:sequence){
            arrayList.add(a);
        }

        return IsBST(arrayList);

    }


    public static boolean IsBST(ArrayList<Integer> list){

        if(list.size() <= 3) {
            int judge = list.size();
            if(judge == 3){
                if(list.get(0)>list.get(2)&&list.get(1)<list.get(2)){
                    return false;
                }else {
                    return true;
                }
            }else {
                return true;
            }
        }

        else {

            int root = list.get(list.size() - 1);
            list.remove(list.size() - 1);

            ArrayList<Integer> left = new ArrayList<>();
            for(int a :list){
                if(a < root){
                    left.add(a);
                }else {
                    break;
                }
            }

            ArrayList<Integer> right = new ArrayList<>();
            int judge = 0;
            for(int b :list){
                if(b > root){
                    right.add(b);
                    judge = 1;
                }else {
                    if(judge == 1) {
                        break;
                    }
                }
            }




            if(left.size() + right.size()== list.size()) {
                return IsBST(left) && IsBST(right);
            }else {
                return false;
            }

        }

    }


}
