package org.numberprograms;

public class Numberprogams {

    public int reverseNumberUsingRecurssion(int num, int rev){
        if(num <= 0) {
            return rev;
        }
        rev = rev*10 + num % 10;
        num /= 10;
        return  reverseNumberUsingRecurssion(num , rev);
    }

    public void reverseNumber(int num) {
//        if(num == 0){
//            return num;
//        }

        int rev = 0;
        int temp = num;
        while(num > 0) {
            rev = rev*10 + num % 10;
            num /= 10;
        }
        System.out.println(rev);
    }

    public void swapTwoNumbersUsingBitwiseOperator(int num1, int num2) {
        num1 = num1 ^ num2;
        num2 = num1 ^ num2; // (num1 ^ num2) ^ num2 ==> num1 ^ ( num2 ^ num2 ) [x ^ x = 1] ==> num1 ^ 1 ==> num1.
        num1 = num1 ^ num2;// (num1 ^ num2) ^ num1 [ cause num2 bacame num1 ] ==> num1 ^ num1 ^ num2 ==> num2 ^ 1 ==> num2.
        System.out.println(num1   + " "  + num2);
    }

    public static void main(String[] args) {
        Numberprogams np = new Numberprogams();
//        np.reverseNumber(23454);
//        System.out.println(np.reverseNumberUsingRecurssion(223344, 0));
//        String str = "pavan";
//        System.out.println(str.indexOf('a'));
//        System.out.println(str.lastIndexOf('a'));
        np.swapTwoNumbersUsingBitwiseOperator(40, 50);
    }
}
