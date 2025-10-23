public class firstJava_02 {
    public static void main(String[] args){
        String a="abaf";
        System.out.print(isArmstrong(153));
    }
    static String evenodd(int a){
        if (a==0){
            return "neither even nor odd";
        }
        if (a%2==0){
            return "Even";
        }else{
            return "Odd";
        }
    }
    static float simpleInterest(int p,int r,int t){
        int SI=(p*r*t)/100;
        return SI;
    }
    static float calculator(float a,float b,char op){
        switch (op){
            case '+':return a+b;
            case '-':return a-b;
            case '*':return a*b;
            case '/':return a/b;
            default:return 0;
        }
    }
    static double currencyconvertor(int rupee){
        double dollar=(rupee*0.012);
        return dollar;
    }
    static int max(int a ,int b){
        return Math.max(a,b);
    }
    static int fibo(int n){
        if(n<2){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }
    static boolean palindrome(String a){
        int n=a.length();
        int mid=n/2;
        int i=0;
        while(i<mid-1){
            if (a.charAt(i)!=a.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    static boolean isArmstrong(int n){
        int original=n;
        int ans=0;
        while(n>0){
            int a=n%10;
            n=n/10;
            ans=ans+a*a*a;
        }
        if (ans ==original){
            return true;
        }
        return false;
    }
}
