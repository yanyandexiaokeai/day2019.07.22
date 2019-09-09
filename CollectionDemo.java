//collection的一些方法（集合）

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        //返回集合中的元素个数
        System.out.println(list.size());
        //判断集合是否为空
        System.out.println(list.isEmpty());
        //将元素放入集合
        list.add("我");
        list.add("爱");
        list.add("小李子");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        //强行将list转化为Object类型
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        for (String s : list) {
            System.out.println(s);
        }
        list.remove("爱");
        for (String s : list) {
            System.out.println(s);
        }
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}