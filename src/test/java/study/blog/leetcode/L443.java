package study.blog.leetcode;

import org.junit.jupiter.api.Test;

public class L443 {

    @Test
    void compressString() {

        char[] chars = new char[] {'a','a','b','b','c','c','c','c'};

        char value = chars[0];
        int count = 1;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=1; i<chars.length; i++) {
            char c = chars[i];

            if (c == value) {
                count++;
            } else {
                stringBuffer.append(value);

                if (count != 1) {
                    stringBuffer.append(count);
                }
                value = c;
                count = 1;
            }
        }

        if (count ==1) {
            stringBuffer.append(value);
        } else {
            stringBuffer.append(value);
            stringBuffer.append(count);
        }

        for (int i=0; i<stringBuffer.length(); i++) {
            chars[i] = stringBuffer.charAt(i);
        }

        for (char aChar : chars) {
            System.out.println(aChar);
        }

        System.out.println(stringBuffer.length());
    }

    private int addResult(int result, int count) {
        if (count == 1) {
            result +=1;
        } else {
            result +=1;
            int numberCount = findNumberCount(count);
            result +=numberCount;
        }

        return result;
    }

    private int findNumberCount(int count) {
        if (count/1000 != 0) {
            return 4;
        } else if (count/100 != 0) {
            return 3;
        } else if (count/10 != 0) {
            return 2;
        } else {
            return 1;
        }
    }

}
