# Previous Smaller Element

## Problem

Given an integer array `arr`, find the **Previous Smaller Element (PSE)** for every element.

The Previous Smaller Element of an element is the first element to its left that is **strictly smaller** than it.

- If a smaller element exists, return that element.
- If no smaller element exists, return `-1`.

## Example

**Input:**
```text
arr = [1, 6, 2]
```

**Output:**
```text
[-1, 1, 1]
```

**Explanation:**
- `1`: No element exists to its left, so the answer is `-1`.
- `6`: The previous smaller element is `1`.
- `2`: The previous smaller element is `1`.

Another example:

**Input:**
```text
arr = [1, 5, 0, 3, 4, 5]
```

**Output:**
```text
[-1, 1, -1, 0, 3, 4]
```

## Approach

**Pattern: Monotonic Increasing Stack**

I used a stack to efficiently find the previous smaller element for every array element.

For each element `arr[i]`:

- Remove elements from the stack while they are greater than or equal to `arr[i]`.
- If the stack becomes empty, no previous smaller element exists, so store `-1`.
- Otherwise, the top of the stack is the previous smaller element.
- Push the current element onto the stack.

**Why did I choose this approach?**

A brute-force approach would check every element to the left, taking `O(n²)` time in the worst case.

Using a monotonic stack allows us to process each element efficiently in `O(n)` time because every element is pushed onto and popped from the stack at most once.

## Algorithm

1. Initialize an empty stack and an empty result list.
2. Traverse the array from left to right.
3. For each element `arr[i]`:
   - While the stack is not empty and `stack.peek() >= arr[i]`, pop the stack.
   - If the stack is empty, add `-1` to the result.
   - Otherwise, add `stack.peek()` to the result.
   - Push `arr[i]` onto the stack.
4. Return the result list.

## Why It Works

The stack maintains elements in **strictly increasing order from bottom to top**.

When processing the current element, all elements greater than or equal to it are removed because they cannot be the previous smaller element for the current element or for any future element that is smaller than or equal to them.

After removing these elements:

- If the stack is empty, no valid previous smaller element remains.
- If the stack is not empty, its top is smaller than the current element and is the nearest valid candidate to its left.

Therefore, the stack's top gives the correct Previous Smaller Element for every position.

## Complexity

- **Time:** `O(n)` — Each element is pushed onto and popped from the stack at most once.
- **Space:** `O(n)` — The stack and result list can each store up to `n` elements.

Here, `n` is the length of the array.

## Pattern

**Monotonic Stack — Previous Smaller Element**

This pattern is useful for problems involving:
- Previous or next smaller elements.
- Previous or next greater elements.
- Finding nearest elements that satisfy a comparison condition.
- Histogram and span problems.

## Key Learnings

- A monotonic stack helps find the nearest qualifying element efficiently.
- Traverse from left to right when finding previous elements.
- Pop elements that cannot be valid candidates.
- Use `>=` when the required element must be strictly smaller, because equal elements are not valid answers.
- Each element is pushed and popped at most once, resulting in linear time complexity.

## File Structure

```text
Previous Smaller Element/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```