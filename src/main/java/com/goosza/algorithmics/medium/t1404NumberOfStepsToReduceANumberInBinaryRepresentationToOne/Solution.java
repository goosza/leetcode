package com.goosza.algorithmics.medium.t1404NumberOfStepsToReduceANumberInBinaryRepresentationToOne;

public class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int digit = (s.charAt(i) - '0') + carry;

            if (digit == 0) {
                carry = 0;
                steps++;
            } else if (digit == 2) {
                carry = 1;
                steps++;
            } else {
                carry = 1;
                steps += 2;
            }
        }
        steps += carry;
        return steps;
//        if (s.equals("1")) return 0;
//        char[] str = s.toCharArray();
//        int numSteps = 0;
//        while (!(str[0] == '1' && str.length == 1)) {
//            if (isEven(str[str.length - 1])) {
//                str = divideByTwo(str);
//            } else {
//                str = addOne(str);
//            }
//            numSteps++;
//        }
//        return numSteps;
//        long result = parseToInt2(s);
//        return findSteps(result);
    }

//    public char[] addOne(char[] str) {
//        int i = str.length - 1;
//        while (i >= 0 && str[i] == '1') {
//            str[i--] = '0';
//        }
//        if (i < 0) {
//            char[] newStr = new char[str.length + 1];
//            newStr[0] = '1';
//            System.arraycopy(str, 0, newStr, 1, str.length);
//            return newStr;
//        }
//        str[i] = '1';
//        return str;
//    }
//
//    public char[] divideByTwo(char[] str) {
////        char[] newStr = new char[str.length - 1];
////        System.arraycopy(str, 0, newStr, 0, str.length - 1);
////        return newStr;
//        return Arrays.copyOf(str, str.length - 1);
//    }
//
//    public boolean isEven(char c){
//        return c == '0';
//    }

//    public int findSteps(long result) {
//        int numSteps = 0;
//        while (result != 1) {
//            if (isEvenNum(result)) {
//                result = result/2;
//            } else {
//                result++;
//            }
//            numSteps++;
//        }
//        return numSteps;
//    }

//    public boolean isEvenNum(long num) {
//        return ((num & 1)) == 0;
//    }
//
//    public long parseToInt1(String num) {
//        char[] str = num.toCharArray();
//        long result = 0;
//        for (int i = 0; i < str.length; i++) {
//            int power = str.length - 1 - i;
//            result += (str[i] - '0') * (1L << power);
//        }
//        return result;
//    }
//
//    public long parseToInt2(String num) {
//        char[] str = num.toCharArray();
//        long result = 0;
//        for (char c : str) {
//            result = result * 2 + (c - '0');
//        }
//        return result;
//    }
}

// 10010011110 -> steps = 1
// 10010011110 -> steps
//
//1010100101 + 1 = 1010100110
//        10011111 + 1 = 10100000
//
//        1110 / 2 = 111
//        10000 / 2 = 1000
//1010100110

//Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:
//
//If the current number is even, you have to divide it by 2.
//
//If the current number is odd, you have to add 1 to it.
//
//It is guaranteed that you can always reach one for all test cases.
//
//
//
//        Example 1:
//
//Input: s = "1101"
//Output: 6
//Explanation: "1101" corressponds to number 13 in their decimal representation.
//Step 1) 13 is odd, add 1 and obtain 14.
//Step 2) 14 is even, divide by 2 and obtain 7.
//Step 3) 7 is odd, add 1 and obtain 8.
//Step 4) 8 is even, divide by 2 and obtain 4.
//Step 5) 4 is even, divide by 2 and obtain 2.
//Step 6) 2 is even, divide by 2 and obtain 1.
//Example 2:
//
//Input: s = "10"
//Output: 1
//Explanation: "10" corresponds to number 2 in their decimal representation.
//Step 1) 2 is even, divide by 2 and obtain 1.
//Example 3:
//
//Input: s = "1"
//Output: 0
//
//
//Constraints:
//
//        1 <= s.length <= 500
//s consists of characters '0' or '1'
//s[0] == '1'