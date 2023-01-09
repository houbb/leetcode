package com.github.houbb.leetcode.F000T100;

public class T067_AddBinary {

    public static void main(String[] args) {
        T067_AddBinary addBinary = new T067_AddBinary();

//        String result = addBinary.addBinary("1010", "1011");
        String result = addBinary.addBinary("1", "111");
        System.out.println(result);
    }

    /**
     * 添加二进制
     *
     * Input: a = "11", b = "1"
     * Output: "100"
     *
     * 11
     * 11
     *
     * 这里代码写的不是很优雅，其实可以优化。
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        // 字符串最后的结果
        StringBuilder stringBuilder = new StringBuilder();

        int minLength = Math.min(a.length(), b.length());

        int aPos = a.length()-1;
        int bPos = b.length()-1;

        // 是否需要进位
        boolean needAddOne = false;

        // 从后往前对比
        for(int i = 0; i < minLength; i++) {
            int aNum = Integer.parseInt(a.charAt(aPos) + "");
            int bNum = Integer.parseInt(b.charAt(bPos) + "");

            //1. 累加
            int sum = aNum + bNum;
            if(needAddOne) {
                sum++;
                needAddOne = false;
            }
            if(sum >= 2) {
                // 保留进位
                needAddOne = true;
            }
            int currentNum = sum % 2;
            // 插入在开始
            stringBuilder.insert(0, currentNum);

            // 更新位置
            aPos--;
            bPos--;
        }

        // 二者一样长，且最后有 1 个进位
        if(a.length() == b.length()
            && needAddOne) {
            stringBuilder.insert(0, '1');
        } else {
            // 长度不同
            // 剩余的比较长的字符串处理
            if(aPos >= 0) {
                updateString(aPos, a, stringBuilder, needAddOne);
            }
            if(bPos >= 0) {
                updateString(bPos, b, stringBuilder, needAddOne);
            }
        }

        // 返回结果
        return stringBuilder.toString();
    }

    /**
     * 处理最后的信息
     *
     * pos
     *
     * 也是从后往前对比
     *
     * @param pos 位置
     * @param string 字符串
     * @param temp 临时结果
     * @param needAddOne 是否需要进位
     */
    private void updateString(int pos,
                              String string,
                              StringBuilder temp,
                              boolean needAddOne) {

        for(int i = pos; i >= 0; i--) {
            int num = Integer.parseInt(string.charAt(i) + "");

            if(needAddOne) {
                needAddOne = false;
                num++;
            }

            if(num >= 2) {
                // 保留进位
                needAddOne = true;
            }

            int currentNum = num % 2;
            // 插入在开始
            temp.insert(0, currentNum);
        }

        // 如果最后还有一位
        if(needAddOne) {
            temp.insert(0, '1');
        }
    }

}
