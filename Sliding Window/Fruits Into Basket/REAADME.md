# Fruit Into Baskets

## Problem

You are given an integer array `fruits`, where `fruits[i]` represents the type of fruit on the `i-th` tree.

You have two baskets, and each basket can hold only one type of fruit. Starting from any tree, you want to collect fruits from a contiguous sequence of trees while using at most **two different fruit types**.

Return the maximum number of fruits you can collect.

### Example

**Input:**

```text
fruits = [1, 2, 1, 2, 3, 2, 2]
```

**Output:**

```text
4
```

The longest valid subarray is `[1, 2, 1, 2]`, which contains only two distinct fruit types.

## Approach

I used the **Sliding Window** technique with a `HashMap`.

The `HashMap` stores:

```text
fruit type → frequency
```

The window `[l, r]` represents the current sequence of trees being considered.

I chose this approach because the problem asks for the **longest contiguous subarray containing at most two distinct values**, which is a classic variable-size sliding window problem.

## Algorithm

1. Initialize two pointers `l` and `r` to `0`.
2. Use a `HashMap` to store the frequency of each fruit type inside the current window.
3. Expand the window by adding `fruits[r]` to the map.
4. If the map contains more than two distinct fruit types:

   * Decrease the frequency of `fruits[l]`.
   * Remove it from the map if its frequency becomes `0`.
   * Move `l` forward.
5. If the window contains at most two distinct fruit types, update the maximum length.
6. Move `r` forward and repeat.
7. Return the maximum window length.

## Why It Works

The sliding window always represents a contiguous range of trees.

The main condition being maintained is:

```text
Number of distinct fruit types <= 2
```

Whenever a third fruit type enters the window, the left pointer moves forward until the window becomes valid again.

Therefore, every valid window contains at most two fruit types, and by keeping track of the maximum valid window length, we obtain the answer.

## Complexity

**Time:** `O(n)`

Both `l` and `r` move from left to right through the array at most `n` times. `HashMap` operations such as `get`, `put`, and `remove` take `O(1)` average time.

**Space:** `O(1)`

The map contains at most 3 distinct fruit types temporarily before the left pointer removes one, so the extra space is effectively constant.

## Pattern

**Sliding Window + HashMap**

This is a **Variable Size Sliding Window** problem where we maintain a window containing at most two distinct elements.

## Key Learnings

* Use a **sliding window** for longest/shortest contiguous subarray problems with constraints.
* Use a `HashMap` to maintain the frequency of elements inside the current window.
* The left pointer is used to restore the required condition when the window becomes invalid.
* Both pointers move only forward, giving an `O(n)` time complexity.
* The general pattern is useful for problems involving **at most K distinct elements**.

## File Structure

```text
FruitsIntoBaskets/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```
