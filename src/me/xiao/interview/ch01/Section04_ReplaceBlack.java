package me.xiao.interview.ch01;

/**
 * 替换空白字符
 *
 * @author pacman
 * @version 1.0
 * date: 2018/5/11 14:08
 */

public class Section04_ReplaceBlack {

    public static void main(String[] args) {
        char[] str = new char[50];
        buildStr(str);

        int length = new Section04_ReplaceBlack().replaceBlank(str, 12);

        System.out.println(new String(str, 0, length));
    }

    private int replaceBlank(char[] str, int len) {
        if (str == null || str.length < len) {
            return -1;
        }

        int whiteCount = 0;
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ') {
                whiteCount++;
            }
        }

        int targetLen = len + whiteCount * 2;
        int resLen = targetLen;

        if (targetLen > str.length) {
            return -1;
        }

        if (whiteCount == 0) {
            return len;
        }

        len--;
        targetLen--;

        while (len >= 0 && len < targetLen) {
            if (str[len] == ' ') {
                str[targetLen--] = '0';
                str[targetLen--] = '2';
                str[targetLen--] = '%';
            } else {
                str[targetLen--] = str[len];
            }
            len--;
        }

        return resLen;
    }

    private static void buildStr(char[] str) {
        str[0] = ' ';
        str[1] = 'e';
        str[2] = ' ';
        str[3] = ' ';
        str[4] = 'r';
        str[5] = 'e';
        str[6] = ' ';
        str[7] = ' ';
        str[8] = 'a';
        str[9] = ' ';
        str[10] = 'p';
        str[11] = ' ';
    }
}
