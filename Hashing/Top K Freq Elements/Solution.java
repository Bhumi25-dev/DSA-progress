import java.util.*;

class Solution {
	public int[] topKFrequent(int[] nums,int k)
	{
		if(nums.length<k || k<=0) return new int[0];
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i: nums)
		{
			map.put(i,map.getOrDefault(i,0)+1);
		}
		int[] result = new int[k];
		Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(map.get(a),map.get(b)));
		for(int key: map.keySet())
		{
			minHeap.add(key);
			if(minHeap.size() > k) minHeap.poll();
		}
		while(k-- >0)
		{
			result[k] = minHeap.poll();
		}
		return result;		
	}
}