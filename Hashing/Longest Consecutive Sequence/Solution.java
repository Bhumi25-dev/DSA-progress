import java.util.*;

class Solution
{
	public int longestConsecutive(int[] nums) 
	{
        HashSet<Integer> set = new HashSet<>();
    	for(int i: nums)
       	{
    		set.add(i);
       	}
      	int maxCount = 0;
    	for(int num: set)
        {
			if(!set.contains(num-1))
			{
				int currentNum = num;
				int count = 1;
				while(set.contains(currentNum+1))
				{
					currentNum++;
					count++;
				}
				maxCount = Math.max(count, maxCount);
			}	
		}
    	return maxCount;
	}
}