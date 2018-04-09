/*
*判断一个数是不是3的幂若n=3^m,两边取对数则m = logn/log3,因此判断logn/log3是否为整数.
*此处用log10而非log2因为log2在n=243会误判
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        double a = Math.log10(n)/Math.log10(3);
        int ai = (int)a;
        if(Math.abs(a - ai) <= 0.00000000000001)return true;
        else return false;
    }
}
