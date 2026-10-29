# Top K Frequent Elements

## Problem

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

You may return the answer in any order.

## Example

**Input:**
```text
nums = [1,1,1,2,2,3], k = 2
```

**Output:**
```text
[1,2]
```

**Input:**
```text
nums = [1], k = 1
```

**Output:**
```text
[1]
```

## Approach

**Pattern: HashMap + Min Heap (Priority Queue)**

I used a `HashMap<Integer, Integer>` to calculate the frequency of each element in the array.

After building the frequency map, I used a **Min Heap** (`PriorityQueue`) to keep track of the `k` most frequent elements.

The heap stores the elements based on their frequencies, with the element having the lowest frequency at the top.

For every unique element in the HashMap:
- Add the element to the Min Heap.
- If the heap size exceeds `k`, remove the element with the lowest frequency.

This ensures that the heap never contains more than `k` elements and always retains the `k` most frequent elements.

Finally, I extract the elements from the heap and store them in the result array in reverse index order.

## Algorithm

1. Check whether `k` is valid. If `nums.length < k` or `k <= 0`, return an empty array.
2. Create a `HashMap<Integer, Integer>` to store the frequency of each element.
3. Traverse the input array:
   - Increment the frequency of each element using `getOrDefault()`.
4. Create a Min Heap (`PriorityQueue`) with a custom comparator that compares elements based on their frequencies in the HashMap.
5. Traverse all unique keys in the HashMap:
   - Add the current element to the heap.
   - If the heap size exceeds `k`, remove the element with the lowest frequency using `poll()`.
6. Create a result array of size `k`.
7. Extract all elements from the heap:
   - Store each extracted element in the result array from right to left.
8. Return the result array.

## Why It Works

The HashMap maintains the frequency of every unique element, allowing us to compare elements based on how frequently they occur.

The Min Heap ensures that we only retain the `k` elements with the highest frequencies.

- The smallest frequency is always at the top of the Min Heap.
- Whenever the heap size exceeds `k`, removing the root eliminates the element with the lowest frequency.
- After processing all unique elements, the heap contains the `k` most frequent elements.
- Extracting elements from the Min Heap gives them in increasing order of frequency, so inserting them from right to left produces the result in decreasing order of frequency.

Therefore, the algorithm correctly returns the `k` most frequent elements.

## Complexity

Let:
- `n` be the total number of elements in the input array.
- `m` be the number of unique elements in the array.

- **Time:** O(n + m log k) — Building the frequency map takes O(n). Processing all `m` unique elements with heap insertion and removal takes O(m log k).
- **Space:** O(m + k) — The HashMap stores up to `m` unique elements, and the Min Heap stores at most `k` elements. The result array also requires O(k) space.

Since `k` cannot exceed the number of unique elements in a valid input, the overall auxiliary space complexity is O(m).

## Pattern

**Hashing + Min Heap (Priority Queue)**

Useful when we need to find the top `k` elements based on frequency, priority, or some other ranking criterion.

Other problems where this pattern can be useful:
- Kth Largest Element
- K Closest Points to Origin
- Top K Frequent Words

## Key Learnings

- HashMaps are useful for maintaining the frequency of elements efficiently.
- A Min Heap is useful when we need to maintain only the top `k` elements.
- Removing the smallest element whenever the heap size exceeds `k` helps maintain the required heap size.
- A custom comparator allows a Priority Queue to order elements based on values stored in another data structure.
- Using a Min Heap of size `k` is more efficient than sorting all unique elements when `k` is relatively small.
- Extracting elements from a Min Heap gives them in increasing order of priority, so the result can be filled backwards when descending order is required.

## File Structure

```text
Top K Frequent Elements/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```