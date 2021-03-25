package com.github.houbb.leetcode.medium.F100T200;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class GasStation {


    public static void main(String[] args) {
        int[] gas = new int []{1,2,3,4,5};
        int[] cost = new int []{3,4,5,1,2};

        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 参数校验
        if(gas == null || cost == null) {
            return -1;
        }
        if(gas.length != cost.length) {
            return -1;
        }

        // 是否为越界??
        int total = 0;
        int current = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++) {
            int remain = gas[i] - cost[i];
            total += remain;
            current += remain;

            // 连续的多个站也可以等效地看做一个站，如果其累积收益小于0，就跳过，寻找下一个
            if(current < 0) {
                current = 0;
                start = i+1;
            }
        }

        if(total < 0) {
            return -1;
        }
        return start;
    }

}
