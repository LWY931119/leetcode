/*
*将一个数组A在不改变数字的先后顺序的情况下分为K份,要求每份取平均值后,所有平均值的累加和最大.
*一开始想用递归来做,以为A的长度为100,数据量不大,可是就在数据量为50的时候超时了.
*仔细分析原因,发现在计算平均值时,对于数组元素的累加和进行了多次重复的运算.如果能用一个Sum[i]数组保存0-i和数的累加和就能避免重复计算.
*进一步的,联想的dp的做法.考虑到一种最简单的情况:若将A中前i个数分为1份最大的平均值显而易见为sum[i]/(i+1).
*不断推进,若将A中的数分为2份,最大的平均和可以利用到分为1份的结果.将分隔板分别插入A[i]的后面,0-i的数为一份,后面的数为一份,平均值加和简单可计算.而最大的平均值需要统计i从0到n-
这n个情况.
*综上:状态转移方程的设计:double[][] avr用来保存历史的平均值加和,avr[i][k]代表将A[i]分为k份的最大平均值累加和.
*对于将i个数分为k份,其等于将0-i个数分为两部分,0-j分为k-1份,j-i为1份.
*/
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[][] avr = new double[A.length][K+1];
        int[] sum = new int[A.length];
        sum[0] = A[0];
        avr[0][1] = A[0];
        for(int i = 1;i<A.length;i++){
            sum[i] = sum[i-1] + A[i];
            avr[i][1] = (1.0*sum[i])/((i+1)*1.0);
            //System.out.print(avr[i][1]+" ");
        }
        for(int k = 2;k <= K;k++){
        for(int i = 0;i < A.length;i++){
            double max = -1.0;
            for(int j = 0;j <i;j++){
                double tmp = avr[j][k-1] + (1.0*sum[i] - 1.0*sum[j])/(1.0*i - 1.0*j);
                max = Math.max(max,tmp);
            }
            avr[i][k] = max;
        }
        }
        return avr[A.length - 1][K];
    }
}
