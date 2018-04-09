/*长度为n的数组本应保存1-n,n个数,现在有一个数重复了,有一个数缺失了,找出这两个数.
*trick:数组的下标也是int,在数组中数有范围时可以利用下标
*用每个nums[i]做下标,将其对应位置上的数变为对应负数,在这个过程中若该下标对应的数已经是负数,代表这个下标之前访问过,记录下来
*再遍历一遍数组,此时为正数的下标之前没访问过,是遗漏的数,记录
*/
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] re = new int[2];
        int j = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[Math.abs(nums[i]) - 1] < 0)re[j++] = Math.abs(nums[i]);
            else nums[Math.abs(nums[i]) -1] *= -1;
        }
        for(int i = 0;i< nums.length;i++){
            if(nums[i] > 0)re[j++] = i+1;
        }
        return re;
    }
}
