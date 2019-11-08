//字符串中找出连续最长的数字串
//示例1
//输入
//abcd12345ed125ss123456789
//输出
//123456789
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            int max = 0,count=0,end=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    count++;
                    if(max<count){
                        max= count;
                        end = i; }
                }else{
                    count = 0;
                } }
            System.out.println(str.substring(end-max+1,end+1));
        }
    } }