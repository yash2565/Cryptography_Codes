import java.util.Scanner;


public class dfhl{

   
    public static void main(String[] args) {

       
        rsa dfhl = new rsa();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the 1st Prime Number : ");
        long p = scanner.nextInt();
        
        System.out.println("Enter the Primitive Root");
        long pr = scanner.nextInt();
        
        System.out.println("Enter the 1st Private Key: ");
        long a =scanner.nextInt();
        System.out.println("Enter the 2nd Private Key: ");
        long  b =scanner.nextInt();


        long x = (long)Math.pow(pr, a) %p;
        long y = (long)Math.pow(pr, b) %p;


     
        long m = (long)Math.pow(y, a) %p;
        long n = (long)Math.pow(x, b) %p;


        System.out.println("1st Secret Key is : " + (m));
        System.out.println("2nd Secret key is : " + (n));



        if(dfhl.isPrime(p) ){
            System.out.println("The number is prime.");
        }

        else
        {
            System.out.println("Enter the Prime Numbers Only");
        }  
    }

    public boolean isPrime(long p){
        long flag=0;
        for(long i=2;i<=p/2;i++){
            if(p%i == 0){
                break;

            }
            else{
                flag=1;

            }
        }
        if(flag==0){
            return false;
        }
        else{
            return true;
        }

     }

}



// import java.util.Scanner;

// public class dfhl {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.println("Enter the Prime Number : ");
//         long p = scanner.nextLong();

//         System.out.println("Enter the Primitive Root : ");
//         long g = scanner.nextLong();

//         System.out.println("Enter the 1st Private Key : ");
//         long a = scanner.nextLong();

//         System.out.println("Enter the 2nd Private Key : ");
//         long b = scanner.nextLong();

//         long A = calculatePublicKey(g, a, p);
//         long B = calculatePublicKey(g, b, p);

//         long secretKeyA = calculateSecretKey(B, a, p);
//         long secretKeyB = calculateSecretKey(A, b, p);

//         System.out.println("Public Key for User 1: " + A);
//         System.out.println("Public Key for User 2: " + B);

//         System.out.println("Secret Key for User 1: " + secretKeyA);
//         System.out.println("Secret Key for User 2: " + secretKeyB);

//         scanner.close();
//     }

//     public static long calculatePublicKey(long base, long exponent, long mod) {
//         return (long) Math.pow(base, exponent) % mod;
//     }

//     public static long calculateSecretKey(long publicKey, long exponent, long mod) {
//         return (long) Math.pow(publicKey, exponent) % mod;
//     }
// }
