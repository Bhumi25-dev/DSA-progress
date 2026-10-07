# Next Greater Element I

## Problem

Given two arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`, find the **next greater element** for every element in `nums1`.

The next greater element of an element `x` is the first element to the right of `x` in `nums2` that is greater than `x`.

If no greater element exists, return `-1`.

### Example

```text
nums1 = [4, 1, 2]
nums2 = [1, 3, 4, 2]

Output = [-1, 3, -1]
```

---

## Approach

The solution uses a **Monotonic Stack + HashMap**.

### Step 1: Find NGE for `nums2`

Traverse `nums2` from right to left.

For every element:

1. Remove elements from the stack that are smaller than or equal to the current element.
2. If the stack is empty, the next greater element is `-1`.
3. Otherwise, the top of the stack is the next greater element.
4. Push the current element into the stack.

The results are stored in a `HashMap`:

```text
element → next greater element
```

For example:

```text
1 → 3
3 → 4
4 → -1
2 → -1
```

### Step 2: Process `nums1`

For every element in `nums1`, directly retrieve its next greater element from the HashMap.

This avoids searching through `nums2` repeatedly.

---

## Why Monotonic Stack?

A brute-force approach would check the elements to the right of every element to find the next greater element.

The monotonic stack avoids these repeated comparisons by removing elements that can no longer be useful.

The stack maintains potential candidates for the next greater element.

---

## Complexity

Let:

* `n1` = length of `nums1`
* `n2` = length of `nums2`

### Time Complexity

Building the NGE map:

```text
O(n2)
```

Processing `nums1`:

```text
O(n1)
```

Therefore:

```text
O(n1 + n2)
```

### Space Complexity

The stack and HashMap can contain up to `n2` elements:

```text
O(n2)
```

---

## Why Is the Stack O(n)?

The `while` loop might initially look like it makes the algorithm `O(n²)`.

However, every element:

* is pushed at most once
* is popped at most once

Therefore, the total number of stack operations is `O(n)`.

This is an example of **amortized analysis**.

---

## Optimization

### Previous Approach

The previous version calculated the NGE array but then searched through `nums2` for every element of `nums1`.

This resulted in:

```text
O(n1 × n2)
```

in the worst case.

### Current Approach

The NGE values are stored in a HashMap:

```text
element → next greater element
```

So each element of `nums1` can be looked up directly.

Average HashMap lookup:

```text
O(1)
```

Therefore, the overall complexity improves to:

```text
O(n1 + n2)
```

---

## DSA Pattern

**Monotonic Stack**

This pattern is useful for:

* Next Greater Element
* Next Smaller Element
* Previous Greater Element
* Previous Smaller Element
* Daily Temperatures
* Stock Span
* Largest Rectangle in Histogram

---

## Key Learnings

* A nested loop does not always mean `O(n²)`.
* Monotonic stacks can solve Next Greater Element problems in `O(n)`.
* Precomputing results can eliminate repeated searching.
* HashMaps provide average `O(1)` lookup.
* Always look for repeated work that can be avoided.

---

## File Structure

```text
NextGreaterElementI/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```
