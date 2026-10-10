import java.util.*;

class Solution
{
	public ArrayList<Integer> previousSmallerElement(int[] nums)
	{
		int n=nums.length;
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			while(!stack.isEmpty() && nums[i]<stack.peek()) stack.pop();
			if(stack.isEmpty()) result.add(-1);
			else result.add(stack.peek());
			stack.push(nums[i]);
		}
		return result;
	}
}