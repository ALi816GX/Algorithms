package 剑指offer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/8/18
 * @Time:14:12
 * @description:
 *
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 *
 */
public class Ten {


    public int RectCover(int target) {

        if(target <= 3){
            return  target;
        }else {
            return  RectCover(target-1)+RectCover(target-2);
        }

    }

}
