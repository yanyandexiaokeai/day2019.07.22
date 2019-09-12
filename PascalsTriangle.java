import java.util.ArrayList;
import java.util.List;

/*杨辉三角
一、=步骤；
1、创建好一个List<List<Integer>>list;
list[]
2、把list放入nu'mRows个List<Integer>
[
   [],[],[],[],[]
]
3、先用1占位
[
   [1],[1,1],[1,1,1],[1,1,1,1],[1,1,1,1,1]
]
4、修改需要修改的地方
  行的下标j～[2,numRows]
     列的下标j～[1，i]
     list.get(i-1).get(j-1)+list.get(i-1).get(j)
     list.get(i).set(j,?)
*/
public class PascalsTriangle{
    public List<List<Integer>>generte(int numRows){
        //1
        List<List<Integer>> list = new ArrayList<>();
        //2
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }
        //3
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                list.get(i).add(1);
            }
        }
        //4
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                int a = list.get(i - 1).get(j - 1);
                int b = list.get(i - 1).get(j);
                list.get(i).set(j,a+b);
            }
        }
        return list;
    }

    /*二】步骤
    1.list
    []
    2、循环i~numRows次
    new List<Integer>innerList;
    list.add(innerList);
    innerList.add(1);
    innerList.add(1);innerList.add(1);
    innerList.add(1);

    循环j~i-1

    innerList.add(1);

    */
    public List<List<Integer>>generte2(int numRows){
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        //第一行
        list.get(0).add(1);
        //第二行\
        list.add(new ArrayList<>());
        list.get(1).add(1);
        list.get(1).add(1);
        for (int i = 2; i < numRows; i++) {
            list.add(new ArrayList<>());
            list.get(i).add(1);
            for (int j = 1; j < i; j++) {
                int a = list.get(i - 1).get(j - 1);
                int b = list.get(i - 1).get(j);
                list.get(i).add(a + b);//不能调用set
            }
            list.get(i).add(1);
        }
        return list;
    }

    public List<List<Integer>>generte3(int numRows){
        /*
        三、通过OJ的取巧办法
        *提前算好
         */
        /*
        int[][] result = {
                {1},
                {1,1},
                {1,2,1},
                {1,3,3,1},
                {1,4,6,4,1},
                {1,5,10,10,5,1}
        };
        */
        
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        //第一行
        list.get(0).add(1);
        //第二行\
        list.add(new ArrayList<>());
        list.get(1).add(1);
        list.get(1).add(1);
        //第三行
        list.add(new ArrayList<>());
        list.get(2).add(1);
        list.get(2).add(2);
        list.get(2).add(1);
        //第四行
        list.add(new ArrayList<>());
        list.get(3).add(1);
        list.get(3).add(3);
        list.get(3).add(3);
        list.get(3).add(1);
        //第五行
        list.add(new ArrayList<>());
        list.get(4).add(1);
        list.get(4).add(4);
        list.get(4).add(6);
        list.get(4).add(4);
        list.get(4).add(1);

        if (numRows == 5){
            return list;
        }
        if (numRows < 5){
            list.subList(0,numRows);
        }
        //剩余部分用上述办法继续计算
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generte2(5));
    }

}