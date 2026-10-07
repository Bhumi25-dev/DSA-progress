import java.util.*;

class Solution {
    HashMap<Integer,Integer> nge(int[] nums)
    {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> nge = new HashMap<>();
        for(int i=nums.length-1;i>-1;i--)
        {
            while(!stack.isEmpty() && stack.peek()<=nums[i]) stack.pop();
            if(stack.isEmpty()) nge.put(nums[i],-1);
            else {
				nge.put(nums[i],stack.peek());
			}
			stack.push(nums[i]);
        }
        return nge;
    }

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
		HashMap<Integer,Integer> nge2 = nge(nums2);
        int[] result = new int[n1];
        int ptr1 = 0;
		while(ptr1<n1)
        {
            result[ptr1] = nge2.get(nums1[ptr1]);
            ptr1++;
        }
        return result;
    }
}