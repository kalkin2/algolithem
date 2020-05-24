import com.sun.corba.se.spi.ior.IdentifiableContainerBase;

/**
 A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

 For example, number 9 has binary representation 1001 and contains a binary gap of length 2.

 The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
 The number 20 has binary representation 10100 and contains one binary gap of length 1.
 The number 15 has binary representation 1111 and has no binary gaps.
 The number 32 has binary representation 100000 and has no binary gaps.

 Write a function:

 class Solution { public int solution(int N); }

 that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

 For example,
 given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
 Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

 Write an efficient algorithm for the following assumptions:

 N is an integer within the range [1..2,147,483,647].
 Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */

class Step1 {
    public static int binaryTest(int N) {
        // write your code in Java SE 8
        String result = Integer.toBinaryString(N);
        char[] resultChar = result.toCharArray();
        int maxBinaryLen = 0;

        //SECOND LOGIC
        int gapLen = 0;//사이값
        for(int i = 0; i < result.length() ; i++){
            //0일때 값 증가
            if(resultChar[i]=='0'){
                gapLen++;
            }else{
                //1을 만났을때만 최대값을 바꿔준다. 100100000 이런경우를 대비해서..
                if(gapLen>maxBinaryLen){
                    maxBinaryLen = gapLen;
                }
                gapLen = 0;
            }
        }
        return maxBinaryLen;
    }

    public static void main(String[] args) {

        int result1 = binaryTest(9);
        int result2 = binaryTest(529);
        int result3 = binaryTest(20);
        int result4 = binaryTest(15);
        int result5 = binaryTest(1041);



        if(result1 == 2) {
            System.out.println("SUCCESS");
        }else{
            System.out.println("Fail : "+result1);
        }

        if(result2 == 4) {
            System.out.println("SUCCESS");
        }else{
            System.out.println("Fail : "+result2);
        }

        if(result3 == 1) {
            System.out.println("SUCCESS");
        }else{
            System.out.println("Fail : "+result3);
        }

        if(result4 == 0) {
            System.out.println("SUCCESS");
        }else{
            System.out.println("Fail : "+result4);
        }


        if(result5 == 5) {
            System.out.println("SUCCESS");
        }else{
            System.out.println("Fail : "+result5);
        }

    }
}