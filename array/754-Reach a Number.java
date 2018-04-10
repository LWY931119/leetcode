/*题目要求:给出一个target,第i次操作可以加i也可以减i,问n次操作后可以等于target
*这里讨论的题解不涉及任何算法.将1-n个数分为两个部分,一部分P为正数,一部分N为负数,此时有如下关系
*P+N = ALL;P-N = T;==> 2N = ALL - T;==> N%2 == 0;
*利用这个思想先使其不断累加直到比target大,然后在不断累加直到满足N%2==0;
*类似:494-Target Sum
*/
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int tmp = 0;
        int all = 0;
        while(all < target){
            tmp++;
            all += tmp;
        }
        while((all - target)%2 != 0){
            tmp++;
            all += tmp;
        }
        return tmp;
    }
}
