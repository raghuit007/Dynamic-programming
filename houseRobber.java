/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint 
stopping you from robbing each of them is that adjacent houses have security system connected 
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

*/

// dp solution 

public class Solution {
    public int rob(int[] nums) {
        // M(k) = money at the kth house
        // P(0) = 0
        // P(1) = M(1)
        // P(k) = max(P(k−2) + M(k), P(k−1))
        
        if (nums.length==0) { return 0;}
        if (nums.length==1) { return nums[0]; }
        int [] max_profit = new int[nums.length+1];
        max_profit[0] =0;
        max_profit[1] = nums[0];
        for (int i=1;i<nums.length;i++) {
            max_profit[i+1] = Math.max(max_profit[i-1]+nums[i],max_profit[i]);
        }
        return max_profit[nums.length];
        
    }
}

// non dp without extra space
//divide numbers into even and odd. 
// just keep adding evens and odds and get max every time alternatively.

public int rob(int[] num) {
	if(num==null || num.length == 0)
		return 0;
 
	int even = 0;
	int odd = 0;
 
	for (int i = 0; i < num.length; i++) {
		if (i % 2 == 0) {
			even += num[i];
			even = even > odd ? even : odd;
		} else {
			odd += num[i];
			odd = even > odd ? even : odd;
		}
	}
 
	return even > odd ? even : odd;
}
