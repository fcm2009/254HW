import java.math.BigInteger;
import java.util.Random;

public class Main {

    public static void main (String[]args){
        int digitNum = 1094;                                            //set the number of digits of the test numbers
        BigInteger a = new BigInteger(digitNum, new Random(14));        // random bigintgeres of length 500 for testing
        BigInteger b = new BigInteger(digitNum, new Random(17));        // random bigintgeres of length 500 for testing
        BigInteger c = new BigInteger(digitNum, new Random(13));        // random bigintgeres of length 500 for testing
        BigInteger d = new BigInteger(digitNum, new Random(10));        // random bigintgeres of length 500 for testing
        BigInteger e = new BigInteger(digitNum, new Random(8));         // random bigintgeres of length 500 for testing
        BigInteger f = new BigInteger(digitNum, new Random(4));         // random bigintgeres of length 500 for testing

        String sprater = "";        //sprat methods output
        System.out.println(sprater);    //GCD Method Testing
            System.out.println("GCD Method: ");
            System.out.println("a....................................: " + a);
            System.out.println("b....................................: " + b);
            System.out.println("gcd(a,b) Using the method in.........:\n" +
                               "BigInteger class.....................: " + a.gcd(b));
            System.out.println("gcd(a,b) Using our method............: " + Util.gcd(a,b));
            System.out.println("Are the twe number the same..........: " + (a.gcd(b)).equals(Util.gcd(a,b)));
        System.out.println(sprater + "\n");  //End of GCD Method Testing

        System.out.println(sprater);    //Modular Exponentiation Testing
            System.out.println("Modular Exponentiation Method: ");
            System.out.println("base.................................: " + a);
            System.out.println("power................................: " + b);
            System.out.println("modulus..............................: " + c);
            System.out.println("Using BigInteger method..............:\n" +
                               "base^power (mod modulus).............: " + a.modPow(b, c));
            System.out.println("Using our method.....................:\n" +
                               "base^power (mod modulus).............: " + Util.modPow(a, b, c));
            System.out.println("Are the twe number the same..........: " + a.modPow(b, c).equals(Util.modPow(a, b, c)));
        System.out.println(sprater + "\n");  //End of Modular Exponentiation Testing

        System.out.println(sprater);    //Extended Euclidean Algorithm Testing
            System.out.println("Extended Euclidean Algorithm Method: ");
            System.out.println("a....................................: " + a);
            System.out.println("b....................................: " + b);
            BigInteger[] result = Util.extendedEA(a, b);
            System.out.println("GCD(a,b) Using BigInteger method.....: " + a.gcd(b));
            System.out.println("Using our method.....................: " + result[0]);
            System.out.println("Are the twe number the same..........: " + a.gcd(b).equals(result[0]));
            System.out.println("s....................................: " + result[1]);
            System.out.println("t....................................: " + result[2]);
            System.out.println("Check that gcd(a, b) = sa + tb.......: " + result[0].equals((result[1].multiply(a)).add(result[2].multiply(b))));
        System.out.println(sprater + "\n");  //End of Extended Euclidean Algorithm Testing

        System.out.println(sprater);    //Modulus Inverse Testing
            System.out.println("Modulus Inverse Using Method: ");
            System.out.println("a....................................: " + a);
            System.out.println("modulus..............................: " + b);
            System.out.println("Inverse Using BigInteger method......: " + a.modInverse(b));
            System.out.println("Using our method.....................: " + Util.modInverse(a, b));
            System.out.println("Are the twe number the same..........: " + (a.modInverse(b)).equals(Util.modInverse(a, b)));
        System.out.println(sprater + "\n");  //End of Modulus Inverse Testing

        System.out.println(sprater);
            System.out.println("Chinese Remainder Theorem Method: ");
            BigInteger[] s = {a, b, c};
            BigInteger[] moduli = {d, e, f};
            BigInteger x = Util.CRT(s, moduli);                                 //the solution of the liner congruence
            System.out.println("a1...................................: " + a);
            System.out.println("a2...................................: " + b);
            System.out.println("a3...................................: " + c);
            System.out.println("m1...................................: " + d);
            System.out.println("m2...................................: " + e);
            System.out.println("m3...................................: " + f);
            System.out.println("Using our method.....................: " + Util.CRT(s, moduli));
            boolean check = ((x.mod(d)).equals(a.mod(d)) && (x.mod(e)).equals(b.mod(e)) && (x.mod(f)).equals(c.mod(f)));
            System.out.println("Check the result of CRT method.......:\n" +
                               "result mod m1 = a1 mod m1 and\n" +
                               "result mod m2 = a2 mod m2 and \n" +
                               "result mod m3 = a3 mod m3............: " +check);
        System.out.println("-------------------------------------------------------------------------------------------------\n");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		PART 2
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        a = new BigInteger(500, new Random(14));        // random bigintgeres of length 500 for testing
        b = new BigInteger(500, new Random(17));        // random bigintgeres of length 500 for testing
        c = new BigInteger(500, new Random(13));        // random bigintgeres of length 500 for testing

        System.out.println(sprater);    //bigIntToDigits and digitsToBigInt Method testing
            System.out.println("BigInteger to Digits Method:");
            System.out.println("a....................................: " + a);
            System.out.println("b....................................: " + b);
            System.out.print("bigIntTodigits on a base b...........: [ " );
            BigInteger [] h = Util.bigIntToDigits(a,b);
            for(int i=0;i<h.length;i++){
                System.out.print(h[i]);
            }
            System.out.println(" ]");
            System.out.println("digitsToBigInteger on the array......: ");
            BigInteger value = Util.digitsToBigInt(h,b);
            System.out.println("The original number..................: " + value);
            System.out.println("Are the two numbers the same.........: " + a.equals(value));
        System.out.println(sprater + "\n");  //End of bigIntToDigits Method Testing

        System.out.println(sprater);    //strToBigInt and bigIntToStr
            System.out.println("strToBigInt method:");
            String str = "THIS IS A TESTING FOR THE THIRD AND FOURTH METHODS";
            System.out.println("String converted to BigInteger.......: " + Util.strToBigInt(str));
            System.out.println("String After converting back.........: " + Util.bigIntToStr(Util.strToBigInt(str)));
            System.out.println("Are the twe Strings the same.........: " + Util.bigIntToStr(Util.strToBigInt(str)).equals(str));
        System.out.println(sprater + "\n");  //End strToBigInt and bigIntToStr*/

        System.out.println(sprater);    //genRSAParams method test
        System.out.println("genRSAParams method:");
        int bitSize = 1024;
            BigInteger[] tmp = Util.genRSAParams(bitSize);

            BigInteger p = tmp[0];
            BigInteger q = tmp[1];
            BigInteger n = tmp[2];
            BigInteger v = tmp[3];
            System.out.println("p....................................: " + p + "\nq....................................: " + q + "\nn....................................: " + n + "\nphi of n.............................: " + v);
            System.out.println("n == p * q...........................: " + n.equals(p.multiply(q)) + "\nphi n == (p-1)(q-1)..................: " + v.equals((p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")))));
            System.out.println(sprater + "\n");  //end of genRSAParams method test


        System.out.println(sprater);    //all methods test
            System.out.println("encrypting and decrypting a number method:");
            System.out.println("p....................................: " + p + "\nq....................................: " + q + "\nn....................................: " + n + "\nphi of n.............................: " + v);
            System.out.println("bit size of n, e, and d..............: " + bitSize);

            BigInteger[] key = Util.genRSAKeyPair(tmp);
            e = key[0];
            d = key[1];
            System.out.println("e....................................: " + e + "\nd....................................: " + d);

            BigInteger m = new BigInteger(bitSize + ((int) (Math.random() * 1000)), new Random());
            c = Util.encRSA(m, e, n);
            System.out.println("m....................................: " + m + "\nbitsize of m.........................: " + m.bitLength());
            System.out.println("c....................................: " + c);

            System.out.println("decrypting c.........................: " + Util.decRSA(c, d, n));
            System.out.println("check the numbers....................: " + m.equals(Util.decRSA(c, d, n)));
        System.out.println(sprater + "\n");
    }
}
