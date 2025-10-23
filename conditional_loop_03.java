import java.util.Scanner;

public class conditional_loop_03 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int[] arr = {1,2,3,-1,-2,5,7,8};
        sumOfNums(arr);
        fuf(1,2,333,2,1,2,3,21,2,3);
    }

    //                        <-- Basic java program -->

    static double AreaofCircle(int r){
        double pi=Math.PI;
        return (pi*r*r);
    }
    static double AreaofTriangle(int b,int l){
        double pi=Math.PI;
        return (b*l)/2;
    }
    static double AreaofRectangle(int b,int l){
        double pi=Math.PI;
        return (b*l);
    }
    static double AreaofIsoscelesTriangle(int b,int l){
        double pi=Math.PI;
        return (b*l)/2;
    }
    static double AreaofEquilateralTriangle(int a){
        double pi=Math.PI;
        return (Math.sqrt(3)*a*a)/4;
    }
    static double PerimeterCircle(int r){
        double pi=Math.PI;
        return 2*pi*r;
    }
    static double PerimeterEquilateralTriangle(int a){
        double pi=Math.PI;
        return 3*a;
    }
    static double PerimeterParallelogram(int l,int b){
        double pi=Math.PI;
        return 2*(l+b);
    }
    static double PerimeterSquare(int a){
        double pi=Math.PI;
        return 4*a;
    }
    static double VolumeCone(int r,int h){
        double pi=Math.PI;
        return (pi*r*r*h)/3 ;
    }
    static double Volumeprism(int baseArea,int h){
        double pi=Math.PI;
        return baseArea*h;
    }
    static double VolumeCylinder(int r,int h){
        double pi=Math.PI;
        return (pi*r*r*h) ;
    }
    static double VolumeSphere(int r,int h){
        double pi=Math.PI;
        return (4*pi*r*r*r)/3 ;
    }
    static double VolumePyramid(int baseArea,int h){
        double pi=Math.PI;
        return (baseArea*h)/3;
    }
    static double CurvedSurfaceAreaOfCylinder(int r,int h){
        double pi=Math.PI;
        return (2*pi*r*h);
    }
    static double totalsurfaceareaofcube(int a){
        return 6*a*a;
    }
    static int fibo (int n){
        if (n<2){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }
    static int multiplyadd(int n){
        int mult=1;
        int add=0;
        while(n>0){
            int a=n%10;
            n=n/10;
            mult=mult*a;
            add=add+a;
        }
        return mult-add;
    }
    static int factor(int n){
        for ( int i=1;i<n;i++){
            if (n%i==0){
                System.out.println(i);
            }
        }
        return 0;
    }
    static int inputtill0(){
        int sum=0;
        while(true){
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            if (n==0){
                break;
            }

            sum=sum+n;
        }
        return sum;
    }
    static int largesttill0(){
        int max=0;
        Scanner input=new Scanner(System.in);
        while(true){
            int n=input.nextInt();
            if(n==0){
                break;
            }
            if(n>max){
                max=n;
            }
        }
        return max;
    }

    //                                    Intermediate Java Programs

    static int factorial(int n){
        if (n==1 || n==0){
            return 1;
        }
        int factor=1;
        while(n>1){
            factor=factor*n;
            n--;
        }
        return factor;
    }
    static int averageN(){
        Scanner input=new Scanner(System.in);
        int sum=0;
        int i=1;
        while(true){
            int n=input.nextInt();
            if(n==0){
                break;
            }
            sum=sum+n;
            i++;
        }
        return sum/i;
    }
    static double power(int a,int n){
        return Math.pow(a,n);
    }
    static boolean isArmstrong(int n){
        int org=n;
        int ans=0;
        while(n>0){
            int a=n%10;
            n=n/10;
            ans=ans +a*a*a;
        }
        if(ans==org){
            return true;
        }
        return false;
    }
    static int npr(int n,int r){
        int npr=factorial(n)/(factorial(n-r));
        return npr;
    }
    static int ncr(int n,int r){
        int ncr=factorial(n)/(factorial(r)*factorial(n-r));
        return ncr;
    }
    static String reversestring(String str) {
        char[] chars = str.toCharArray();
        String reversed = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }

        return reversed;
    }

    static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    static boolean ispalindrome(String str){
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != arr[arr.length -i-1]) return false;
        }
        return true;
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
    static boolean isVowel(char ch){
        char[] arr = {'a','e','o','i','u'};
        int i=0;
        while(i<arr.length-1){
            if(arr[i]==ch) return true;
            i++;
        }
        return false;
    }
    static int addDigit(int num){
        int ans=0;
        while (num>0) {
            ans+=num%10;
            num=num/10;
        }
        return ans;
    }
    static void sumOfNums(int[] arr){
        int neg = 0;
        int pe = 0;
        int po = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<0){
                neg+=arr[i];
            }
            if(arr[i]%2==0 && arr[i]>0){
                pe+=arr[i];
            }
            if(arr[i]%2!=0 && arr[i]>0){
                po+=arr[i];
            }
        }
        System.out.println(neg);
        System.out.println(pe);
        System.out.println(po);
    }

    static void fuf(int...v){
        System.out.println(v[2]);
    }
}
