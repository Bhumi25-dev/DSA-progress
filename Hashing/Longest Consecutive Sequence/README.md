# Longest Consecutive Sequence

## Problem

Given an unsorted integer array `nums`, return the length of the longest consecutive elements sequence.

A consecutive sequence consists of numbers that follow each other without any gaps.

The algorithm must run in O(n) time complexity.

## Example

**Input:**
```text
nums = [100, 4, 200, 1, 3, 2]
```

**Output:**
```text
4
```

**Explanation:**

The longest consecutive sequence is `[1, 2, 3, 4]`, and its length is `4`.

**Input:**
```text
nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
```

**Output:**
```text
9
```

**Explanation:**

The longest consecutive sequence is `[0, 1, 2, 3, 4, 5, 6, 7, 8]`, and its length is `9`.

## Approach

**Pattern: HashSet + Sequence Start Detection**

I used a `HashSet<Integer>` to store all unique elements from the input array.

A HashSet provides average O(1) lookup time, which makes checking whether consecutive elements exist efficient.

Instead of starting a sequence from every element, I first check whether the current element is the beginning of a sequence.

An element is considered a starting point if its previous element (`num - 1`) does not exist in the HashSet.

Only when an element is a starting point do I expand the sequence using a `while` loop, checking whether the next consecutive element (`x + 1`) exists.

For every sequence:
- Initialize `count = 1`.
- Keep checking for the next consecutive number.
- Increment `count` and `x` whenever the next number exists.
- Update `maxCount` with the maximum sequence length found.

This avoids repeatedly traversing the same sequence and allows the algorithm to achieve O(n) average time complexity.

## Algorithm

1. Create a `HashSet<Integer>` to store unique elements.
2. Traverse the input array and insert every element into the HashSet.
3. Initialize `maxCount = 0` to track the longest consecutive sequence.
4. Iterate through every element in the HashSet:
   - Check whether `num - 1` exists in the HashSet.
   - If it exists, skip the current element because it is not the beginning of a sequence.
   - Otherwise:
     1. Initialize `x = num` and `count = 1`.
     2. Use a `while` loop to check whether `x + 1` exists in the HashSet.
     3. If it exists, increment `count` and `x`.
     4. Continue until the next consecutive element is not found.
   - Update `maxCount = Math.max(maxCount, count)`.
5. Return `maxCount`.

## Why It Works

Every consecutive sequence has exactly one starting element: the element whose previous consecutive number does not exist in the set.

By checking `!set.contains(num - 1)`, we ensure that sequence expansion only begins from these starting elements.

- The HashSet allows efficient checking of whether an element exists.
- Starting only from the first element prevents unnecessary repeated traversal.
- The `while` loop counts all consecutive elements in the current sequence.
- `maxCount` maintains the maximum sequence length encountered.

Since every sequence is expanded only from its starting element, the same sequence is not repeatedly traversed.

Therefore, the algorithm correctly finds the length of the longest consecutive sequence in average O(n) time.

## Complexity

Let `n` be the total number of elements in the input array and `m` be the number of unique elements.

- **Time:** O(n) average — Building the HashSet takes O(n). Iterating through unique elements and expanding consecutive sequences takes O(m) overall because each unique element is visited at most once during sequence expansion.
- **Space:** O(m) — The HashSet stores all unique elements from the input array.

Since `m` can be at most `n`, the overall complexity is:

- **Time:** O(n) average
- **Space:** O(n)

## Pattern

**Hashing + Sequence Start Detection**

Useful when working with:
- Consecutive elements in an unsorted array.
- Finding sequences without sorting.
- Problems involving efficient membership checking.
- Avoiding repeated traversal using a starting-point condition.

## Key Learnings

- HashSets provide average O(1) lookup time, making them useful for checking whether elements exist.
- Identifying the starting point of a sequence can prevent unnecessary repeated operations.
- A nested `while` loop does not necessarily mean O(n²) time complexity.
- Always analyze how many times each element is processed across the entire algorithm.
- HashSet-based solutions can sometimes achieve O(n) time complexity where sorting-based solutions require O(n log n).
- Recognizing sequence boundaries is an important optimization technique.

## File Structure

```text
Longest Consecutive Sequence/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```