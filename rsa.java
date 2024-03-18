import java.util.Scanner;

public class rsa {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        rsa rsa = new rsa();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the 1st Prime Number : ");
        int p = scanner.nextInt();
        System.out.println("Enter the 2nd Prime Number: ");
        int q = scanner.nextInt();
        System.out.println("Enter the Encryption Key :");
        int e = scanner.nextInt();
        System.out.println("Enter the Message");
        int m = scanner.nextInt();
        if(rsa.isPrime(p) && rsa.isPrime(q)){

        
        int n = p * q;
        int phi = rsa.phi(p, q);
        int d = rsa.modularInverse(e, phi);

        int c = rsa.encrypt(m, e, n);
        System.out.println("\nThe Encrypted Message : " + c);
        
        int me = rsa.decrypt(c, d, n);
        System.out.println("\nThe Decrypted Message is : " + me);

        }
        else
        {
            System.out.println("Enter the Prime Numbers Only");
        }
    }

    public int phi(int p, int q) {
        return (p - 1) * (q - 1);
    }

    public int modularInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        return 1;
    }

    public int encrypt(int m, int e, int n) {
        return modPow(m, e, n);
    }

    public int decrypt(int c, int d, int n) {
        return modPow(c, d, n);
    }

    private int modPow(int base, int exponent, int modulus) {
        if (modulus == 1) return 0;
        int result = 1;
        base = base % modulus;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }
        return result;



    }

    public boolean isPrime(int p){
        int flag=0;
        for(int i=2;i<=p/2;i++){
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

    public boolean isPrime(long p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPrime'");
    }
}