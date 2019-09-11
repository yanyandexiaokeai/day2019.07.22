//关于三角形的类
//要求：已知三条边，判断能否构成三角形，并求出三角形的面积
public class Triangle {
    //属性
    private double a;
    private double b;
    private double c;

    //无参构造
    public  Triangle(){

    }

    //有参构造
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //get和set方法
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    //普通方法
    public boolean isTriangle(){
       if ((a+b>c && a-b<c) && (a+c>b && a-c<b) && (b+c>a&&b-c<a)){
           return true;
       }
       return false;
    }

    //普通方法
    public double calArea(){
        double s;
        double p;
        if ((a+b>c && a-b<c) && (a+c>b && a-c<b) && (b+c>a&&b-c<a)) {
            p = (a + b + c) / 2;
            s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return s;
        }
        return -1;
    }

    //因为定义了有参方法和无参方法，所以下面两种赋值方法都可以用
    public static void main(String[] args) {
//        Triangle triangle = new Triangle(4,3,5);
//        System.out.println(triangle.isTriangle());
//        double area = triangle.calArea();
//        System.out.println(area);
        Triangle triangle = new Triangle();
        triangle.setA(1);
        triangle.setB(4);
        triangle.setC(5);
        System.out.println(triangle.isTriangle());
        double area = triangle.calArea();
        System.out.println(area);
    }
}
