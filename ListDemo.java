//list的使用

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class ListDemo {
    public static void main(String[] args) {
        List<String> courses=new ArrayList<>();
        courses.add("a");
        courses.add("b");
        courses.add("c");
        courses.add("d");
        //和数组一样允许添加重复元素
        courses.add("a");
        //按照添加顺序打印
        System.out.println(courses);
        //类似数组下标的访问方式
        System.out.println(courses.get(1));
        System.out.println(courses);
        //截取（左闭右开）
        List<String> subCourses=courses.subList(1,3);
        System.out.println(subCourses);
        //更改0号下标的数
        courses.set(0,"f");
        System.out.println(courses);
        //重新构造
        List<String> courses2 = new ArrayList<>(courses);
        System.out.println(courses2);

        List<String> courses3 = new LinkedList<>(courses);
        System.out.println(courses3);
    }
}
