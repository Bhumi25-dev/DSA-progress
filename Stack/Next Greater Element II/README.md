# Next Greater Elements II

## Problem

Given a **circular integer array** `nums`, find the **next greater element** for every element.

The next greater element of `nums[i]` is the first element encountered while moving to the right that is greater than `nums[i]`.

Since the array is circular, after reaching the last element, we continue searching from the beginning.

If no greater element exists, return `-1`.

## Example

**Input:**

```text
[1, 2, 1]
```

**Output:**

```text
[2, -1, 2]
```

* For `1` at index `0`, the next greater element is `2`.
* For `2`, there is no greater element, so the answer is `-1`.
* For `1` at index `2`, we wrap around to the beginning and find `2`.

---

## First Approach

In my first approach, I used a **Monotonic Stack** and separately calculated the maximum element in the array.

When the stack became empty for an element that was not the maximum, I manually searched from the beginning of the array to find a greater element.

The main part of that approach was:

```java
for(int j = 0; j < i; j++)
{
    if(nums[j] > nums[i])
    {
        result[i] = nums[j];
        break;
    }
}
```

### Why Was This Approach Wrong?

The problem with this approach was the additional `for` loop.

Although I was using a stack, in the worst case I could scan a large part of the array for many different elements.

For example:

```text
i = n - 1  → scan n - 1 elements
i = n - 2  → scan n - 2 elements
i = n - 3  → scan n - 3 elements
...
```

Therefore, the total work can become:

```text
(n - 1) + (n - 2) + ... + 1
```

which is:

```text
O(n²)
```

So the first approach was not optimal.

The main lesson was that the circular nature of the array should be handled by the traversal itself instead of performing a separate search.

---

## Approach

I used a **Monotonic Stack** with a **Circular Array simulation**.

The main idea is similar to the normal Next Greater Element problem, but instead of traversing from `n - 1` to `0`, I traverse from:

```text
2n - 1 → 0
```

This effectively allows me to visit the array twice.

For example:

```text
[1, 2, 1]
```

is conceptually processed as:

```text
[1, 2, 1, 1, 2, 1]
```

I don't actually create a second array. Instead, I use:

```java
nums[i % n]
```

to simulate the circular traversal.

The result is stored only during the second traversal of the actual array, i.e. when:

```java
i < n
```

This avoids the extra search used in my first approach and gives an `O(n)` solution.

---

## Algorithm

1. Initialize a `result` array and an empty stack.
2. Traverse from `2 * n - 1` down to `0`.
3. Use `i % n` to map the current index back to the original array.
4. Remove elements from the stack while they are smaller than or equal to the current element:

   ```java
   while(!stack.isEmpty() && nums[i % n] >= stack.peek())
       stack.pop();
   ```
5. If `i < n`, we are processing the original occurrence of the element:

   * If the stack is empty, set `result[i] = -1`.
   * Otherwise, the top of the stack is the next greater element.
6. Push the current element onto the stack.
7. Return the `result` array.

---

## Why It Works

The stack is maintained as a **monotonic decreasing stack** from top to bottom.

Before determining the answer for the current element, all elements that are smaller than or equal to it are removed:

```java
nums[i % n] >= stack.peek()
```

These elements cannot be the next greater element because they are not greater than the current element.

After removing them:

* If the stack is empty, there is no greater element available, so the answer is `-1`.
* Otherwise, the top of the stack is the nearest greater element.

### Why Traverse `2n` Times?

Because the array is circular, an element near the end may need to find its next greater element near the beginning.

For example:

```text
nums = [1, 2, 1]
```

For the last `1`, we need to continue searching:

```text
1 → 2
```

By processing the array twice:

```text
1  2  1 | 1  2  1
```

we naturally include the elements from the beginning when searching for the next greater element.

The expression:

```java
nums[i % n]
```

allows this without creating an additional array.

---

## Complexity

**Time:** `O(n)`

The loop runs `2n` times, which is still `O(n)`.

Each element is pushed onto the stack and popped at most once during the traversal, so the total stack operations are linear.

**Space:** `O(n)`

The stack can contain up to `n` elements, and the `result` array requires `O(n)` space.

---

## Pattern

**Monotonic Stack + Circular Array**

More specifically:

* Next Greater Element
* Monotonic Stack
* Circular Array Simulation

---

## Key Learnings

* A **monotonic stack** is useful for Next Greater Element problems.
* Remove elements that cannot be the answer before checking the stack top.
* For circular arrays, traversing `2n` elements can simulate wrapping around.
* `i % n` allows us to access the original array while simulating the second traversal.
* We don't need to create a duplicate array.
* Avoid manually searching through the array when the problem can be solved using a monotonic stack.
* Even if a solution uses a stack, an additional nested loop can still make the overall complexity `O(n²)`.
* The optimized solution reduces the time complexity from **`O(n²)` to `O(n)`**.

---

## File Structure

```text
NextGreaterElementII/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```
