package jzOffer;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2018/9/11
 * @Time:14:24
 * @description:
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 *
 *
 */
public class SixtyFive65 {


    public static void main(String[] args) {

        char[] a = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        char[] b = {'A','B','C','C','E','D'};
        System.out.println(hasPath(a,3,4,b));

    }

    private static int rowss = 0;
    private static int colss = 0;

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean result = false;
        rowss = rows;
        colss = cols;

        for(int i = 0;i < rows * cols;i++){
            char[] tempMatrix = matrix;
            result = IsOnePath(i,0,tempMatrix,str);
            if(result){
                break;
            }
        }

        return result;
    }


    public static boolean IsOnePath(int index,int current_size,char[] matrix,char[] str){

        if(current_size == str.length){
            return true;
        }

        Boolean tempJudge = false;
        if(getIsNotOverBorder(index) && IsCharEqual(matrix[index],str[current_size])) {
            matrix[index] = '0';
            current_size++;
            tempJudge = IsOnePath(getDirectionIndex(index,'→'),current_size,matrix,str)
                    || IsOnePath(getDirectionIndex(index,'↓'),current_size,matrix,str)
                    || IsOnePath(getDirectionIndex(index,'←'),current_size,matrix,str)
                    || IsOnePath(getDirectionIndex(index,'↑'),current_size,matrix,str);

            if(!tempJudge){
                matrix[index] = '0';
            }
        }

        return tempJudge;


    }


    private static boolean getIsNotOverBorder(int index){
        return index != -1;
    }

    private static boolean IsCharEqual(char a, char b){
        return a != '0' && a == b;
    }


    private static int getDirectionIndex(int index,char direction){

        int rowNum = index / colss;      //
        int colNum = index % (rowss+1);

        if(direction == '←'){
            if(colNum == 0){
                index = -1;     //  出界
            }else {
                index--;
            }
        }
        else if(direction == '→'){

            if(colNum + 1 == colss){     //  出界
                index = -1;
            }else {
                index++;
            }

        }

        else if(direction == '↑'){

            if(rowNum == 0){        //  出界
                index = -1;
            }else {
                index = index - rowss;
            }

        }

        else if(direction == '↓'){

            if(rowNum + 1 == rowss){       //  出界
                index = -1;
            }else {
                index = index + rowss;
            }

        }

        return index;
    }


}
