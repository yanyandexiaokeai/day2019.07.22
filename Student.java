public class Student {
    String sn;//学号
    String name;
    int age;
    int gender;


    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Student)){
            return false;
        }
        if (obj == this){
            return true;
        }

        //在equals方法中，不一定要把所有属性进行比较，要根据语义来判断
        return sn.equals(((Student) obj).sn);
    }
}
