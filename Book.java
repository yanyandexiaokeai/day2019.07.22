//编写一个Book类，该类至少有name和price两个属性。
// 该类要实现Comparable接口，在接口的compareTo（）方法中
// 规定两个Book类实例的大小关系为二者的price属性的大小关系。在主函数中，
// 选择合适的集合类型存放Book类的若干个对象，然
// 后创建一个新的Book类的对象，并检查该对象与集合中的哪些对象相等
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Book implements Comparable {


    private String name;
    private float price;

        public Book(String name,float price){
            this.name = name;
            this.price = price;  }


    public static void main(String[] args){
    List<Book> list = new ArrayList<Book>();


    Book b1 = new Book("Java基础教程",29.0f);
    Book b2 = new Book("数据库技术",29.0f);
    Book b3 = new Book("C++基础教程",29.0f);
    Book b4 = new Book("C++",27.0f);
    Book b5 = new Book("C语言",26.0f);
    Book b6 = new Book("数据结构",28.0f);
    Book book = new Book("模式识别", 29.0f);


    list.add(b6);
    list.add(b5);
    list.add(b4);
    list.add(b3);
    list.add(b2);
     list.add(b1);


     Collections.sort(list);
     System.out.println("新书："+book.name+"价格相同的是：");
     for(int i = 0; i<list.size();i++){


      if(book.compareTo(list.get(i))==0){
      System.out.println(list.get(i).name);
      }


     }
     System.out.println("价格是"+book.price); }
     @Override
     public int compareTo(Object o) {
     Book b = (Book)o;
     if(b.price>this.price){
      return 1;
     }else if(b.price<this.price){
      return -1;
     }else{
      return 0;
     }


    }
}
