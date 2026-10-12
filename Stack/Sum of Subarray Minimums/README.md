# Sum of Subarray Minimums

## Problem
Given an array of integers arr, find the sum of the minimum element of every contiguous subarray.

Since the answer can be very large, return it modulo 10^9 + 7.

## Example
**Input:**
```text
arr = [3, 1, 2, 4]
```
**Output:**
```text
17
```
**Explaination**

The subarrays and their minimums are:

| Subarray | Minimum |
|---|---:|
| `[3]` | 3 |
| `[1]` | 1 |
| `[2]` | 2 |
| `[4]` | 4 |
| `[3, 1]` | 1 |
| `[1, 2]` | 1 |
| `[2, 4]` | 2 |
| `[3, 1, 2]` | 1 |
| `[1, 2, 4]` | 1 |
| `[3, 1, 2, 4]` | 1 |

**Total:** `3 + 1 + 2 + 4 + 1 + 1 + 2 + 1 + 1 + 1 = 17`


## Intuition
Instead of generating every possible subarray and finding its minimum, we can calculate how much each element contributes to the final answer.

For every element arr[i], find the nearest smaller element on its left and right. These elements determine the range within which arr[i] can be the minimum.

The number of possible starting positions is `i - psei[i]`, and the number of possible ending positions is `nsi[i] - i`.

Therefore, the contribution of each element is:
```text
arr[i] * (i - psei[i]) * (nsi[i] - i)
```

We use a monotonic stack to find these boundaries efficiently.
## Approach
- **Find Next Smaller Element (NSE):** Traverse the array from right to left using a monotonic stack. Pop indices while their corresponding values are greater than or equal to the current element. If no smaller element exists, use n as the boundary.

- **Find Previous Smaller Element (PSE):** Traverse the array from left to right. Pop indices while their corresponding values are strictly greater than the current element. If no smaller-or-equal element exists, use `-1` as the boundary.

- **Calculate contributions:** For each index `i`:
```text
left = i - psei[i]

right = nsi[i] - i
```

Add `arr[i] * left * right` to the answer.

Take the modulo `10^9 + 7` to keep the result within the required range. Use long during multiplication to prevent integer overflow.

The comparison conditions are intentionally different to handle duplicate elements without double-counting subarrays.

## Algorithm
1. Calculate the index of the next strictly smaller element for every element using a monotonic increasing stack.
2. Calculate the index of the previous smaller-or-equal element using another monotonic stack.
3. Initialize `sum = 0`.
4. For each index `i`:
   - Calculate `left = i - pse[i]`.
   - Calculate `right = nse[i] - i`.
   - Add `arr[i] * left * right` to the answer.
   - Apply the modulo operation.
5. Return the answer as an integer.


## Why It Works
For an element at index `i` to be the minimum of a subarray, the subarray must not extend past a smaller element on either side.

- The previous smaller-or-equal element limits how far the subarray can extend to the left.
- The next strictly smaller element limits how far the subarray can extend to the right.
- There are `left` possible starting positions and `right` possible ending positions.

Thus, exactly `left * right` subarrays are assigned to that element under the chosen duplicate-handling convention.

Every subarray has its minimum assigned to exactly one index. Summing all these contributions therefore gives the sum of the minimums of all subarrays.


## Complexity
- **Time Complexity:** `O(n)` — each element is pushed onto and popped from each stack at most once. The final contribution loop is also linear.
- **Space Complexity:** `O(n)` — the two result arrays and stack storage require linear space.


## Pattern

Monotonic Stack | Contribution Technique

## Key Learnings
- Use a monotonic stack to find the nearest smaller or greater element efficiently
- Use the contribution technique when a problem asks for the sum of a property over all subarrays.
- Calculate the number of valid subarrays for each element instead of enumerating every subarray.
- Handle duplicate values carefully by choosing consistent, asymmetric comparison conditions.
- Use `long` for multiplication before applying the modulo to prevent integer overflow.

## File Structure

```text
Previous Smaller Element/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```