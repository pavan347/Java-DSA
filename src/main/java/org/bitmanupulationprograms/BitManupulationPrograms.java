package org.bitmanupulationprograms;

public class BitManupulationPrograms {

    public static int getBit (int num, int pos) {

        int maskedbit = 1 << pos;
        if((maskedbit & num) == 0) {
            return 0;
        }else {
            return 1;
        }
    }

    public static int setBit(int num, int pos) {
        int maskedbit = 1 << pos;
        return maskedbit | num;
    }

    public static int clearBit(int num, int pos) {
        int maskedBit = 1 << pos;

        return ~maskedBit & num;
    }

    public static int updateBit(int num, int pos) {
        int maskedBit = 1 << pos;

        if(getBit(num, pos) == 0) {
            return setBit(num, pos);
        }else {
            return clearBit(num, pos);
        }
    }

    public static void main(String[] args) {

        System.out.println(getBit(5,2));
        System.out.println(Integer.toBinaryString(8));
//        System.out.println(Integer.toBinaryString(clearBit(7, 1)));
        System.out.println(Integer.toBinaryString(updateBit(8, 1)));
    }

}
