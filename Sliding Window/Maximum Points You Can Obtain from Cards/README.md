# Maximum Points You Can Obtain from Cards

## Problem

You have an integer array `cardPoints` where each element represents the points of a card.

You can pick exactly `k` cards from either the **beginning** or the **end** of the array.

Return the maximum score you can obtain.

### Example

```text
Input:
cardPoints = [1, 2, 3, 4, 5, 6, 1]
k = 3

Output:
12
```

Explanation:

The maximum score can be obtained by picking:

```text
1 + 6 + 5 = 12
```

---

## Approach

The key observation is that if we pick `k` cards, we can only take some cards from the left and the remaining cards from the right.

For example, if:

```text
cardPoints = [1, 2, 3, 4, 5, 6, 1]
k = 3
```

Possible combinations include:

```text
Take 3 from left:
1 + 2 + 3

Take 2 from left, 1 from right:
1 + 2 + 1

Take 1 from left, 2 from right:
1 + 6 + 1

Take 3 from right:
5 + 6 + 1
```

Instead of checking every possible combination separately, we can use a **sliding window technique**.

---

## Sliding Window Idea

First, take the first `k` cards from the left.

This gives our initial score:

```text
cardPoints[0] + cardPoints[1] + ... + cardPoints[k-1]
```

Then gradually replace cards taken from the left with cards taken from the right.

For every step:

```text
Remove one card from the left
Add one card from the right
```

So the score can be updated in `O(1)` time instead of calculating the entire sum again.

Conceptually:

```text
Initial:
[L L L]

Then:
[L L R]

Then:
[L R R]

Finally:
[R R R]
```

where `L` represents a card taken from the beginning and `R` represents a card taken from the end.

We keep track of the maximum score encountered during these transitions.

---

## Algorithm

1. Handle invalid values of `k`.
2. If `k == 0`, return `0`.
3. If `k == n`, return the sum of all cards.
4. Calculate the sum of the first `k` elements.
5. Store this as the initial maximum score.
6. Start replacing cards from the left with cards from the right.
7. After every replacement, update the maximum score.
8. Return the maximum score.

---

## Complexity

Let `n` be the length of `cardPoints`.

### Time Complexity

Calculating the initial score takes:

```text
O(k)
```

The sliding window runs at most `k` times:

```text
O(k)
```

Therefore:

```text
O(k + k) = O(k)
```

Since `k <= n`, the worst-case complexity is:

```text
O(n)
```

### Space Complexity

Only a few variables are used apart from the input array:

```text
O(1)
```

---

## DSA Pattern

**Sliding Window**

This problem is a variation of the sliding window technique where the window can be viewed from the **complementary perspective**.

Instead of directly choosing cards from both ends, another common approach is to find the minimum-sum subarray of length `n - k` that remains in the middle.

---

## Key Learning

* When elements can be selected from both ends, consider how the selected elements form a pattern.
* Start with one valid configuration and gradually transform it into the others.
* Instead of recalculating the complete score, update it incrementally.
* Sliding window techniques can sometimes be applied indirectly rather than using a traditional fixed window.

---

## Edge Cases

### `k = 0`

No cards are selected:

```text
Score = 0
```

### `k = n`

All cards are selected:

```text
Score = sum of all elements
```

### `k = 1`

Only one card can be selected, so the answer is the maximum of the first and last card.

### Invalid `k`

If:

```text
k < 0
```

or

```text
k > n
```

the implementation returns `-1`.

---

## File Structure

```text
MaximumPointsFromCards/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```
