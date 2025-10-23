import java.util.Scanner;

public class flowchartpractice_01 {
    public static void main(String[] args){
        System.out.println(gcd(6,10)==1);
        System.out.println(gcd(10,15)==1);
        System.out.print(gcd(6,15)==1);
    }
    static boolean leapyear(int year){
        if (year%4==0){
            if(year%100==0){
                return year%400==0;
            }
            return true;
        }
        return false;
    }
    static int sum(int a,int b){
        return a+b;
    }

    static int multiplication(int number,int last){
        for (int i=1;i<=last;i++){
            System.out.println(number*i);
        }
        return 0;
    }
    static int lcm(int a ,int b){
        int ans = (a>b)?a:b;
        while(true){
            if (ans%a==0 && ans%b==0)
                break;

            ans++;
        }
        return ans;
    }
    static int gcd(int a,int b){
        int ans=(a<b)?a:b;
        while(ans>0){
            if(a%ans==0 && b%ans==0)
                break;
            ans--;
        }
        return ans;
    }
}
