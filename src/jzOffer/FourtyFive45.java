package jzOffer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/26
 * @Time:16:02
 * @description:
 *
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,
 * 他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 *
 */
public class FourtyFive45 {


    public static void main(String[] args) {
        int[] a = {1,3,2,5,4};
        System.out.println(isContinuous(a));
    }

    public static boolean isContinuous(int [] numbers) {

        if(numbers == null||numbers.length!= 5){
            return false;
        }

        ArrayList<Integer> ghost = new ArrayList<>();
        ArrayList<Integer> number = new ArrayList<>();

        for (int a:numbers){
            if(a == 0){
                ghost.add(a);
            }else {
                number.add(a);
            }
        }

        if(number.size() == 1 && ghost.size() == 4){
            return true;
        }

        Comparator c = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return 1;
                }else {
                    return -1;
                }
            }
        };


        number.sort(c);

        int firstNum = number.get(0);
        for(int i = 0;i < numbers.length;i++){
            if(!number.isEmpty()){
                if(firstNum == number.get(0)){
                    firstNum++;
                    number.remove(0);
                }else {
                    if(!ghost.isEmpty()){
                        ghost.remove(0);
                        firstNum++;
                    }else {
                        return false;
                    }
                }
            }else {
                if(!ghost.isEmpty()){
                    ghost.remove(0);
                    firstNum++;
                }else {
                    return false;
                }
            }
        }

        return true;

    }


}
