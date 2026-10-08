# Asteroid Collision

## Problem

You are given an array `asteroids` where each integer represents an asteroid.

* The **absolute value** represents its size.
* A **positive** value means the asteroid is moving to the right.
* A **negative** value means the asteroid is moving to the left.
* All asteroids move at the same speed.

When two asteroids moving toward each other collide:

* The smaller asteroid is destroyed.
* If both have the same size, both are destroyed.
* If one is larger, the larger asteroid survives.

Return the state of the asteroids after all collisions have occurred.

## Example

**Input:**

```text
[5, 10, -5]
```

**Output:**

```text
[5, 10]
```

`10` and `-5` collide, and `10` survives because it is larger.

Another example:

```text
[8, -8]
```

Output:

```text
[]
```

Both asteroids have the same size, so both are destroyed.

## Intuition

A collision can only happen when a **positive asteroid is followed by a negative asteroid**.

For example:

```text
5 →    ← -3
```

These two asteroids move toward each other.

A stack is useful because the most recently encountered asteroid moving to the right is the first one that can collide with a new negative asteroid.

For every asteroid, I first check whether it can collide with the asteroid at the top of the stack.

If the top asteroid is smaller, I remove it and continue checking because the current asteroid may collide with another asteroid behind it.

## Approach

I used a **Stack** to keep track of the surviving asteroids.

For every asteroid:

1. If the current asteroid cannot collide with the stack's top, push it directly.
2. If the stack top is positive and the current asteroid is negative, a collision can occur.
3. Compare their sizes:

   * If the stack top is smaller, pop it and continue checking.
   * If both have the same size, pop the stack top and destroy the current asteroid.
   * If the stack top is larger, destroy the current asteroid.
4. Push the current asteroid only if it survives all possible collisions.
5. Finally, convert the stack into the result array.

The `destroyed` variable keeps track of whether the current asteroid was destroyed during a collision.

## Algorithm

1. Initialize an empty stack.
2. Traverse every asteroid in the input array.
3. Set `destroyed = false` for the current asteroid.
4. While:

   * the stack is not empty,
   * the stack top is moving right (`> 0`),
   * and the current asteroid is moving left (`< 0`):

   process the collision.
5. If the stack asteroid is smaller than the current asteroid, pop it and continue.
6. If both asteroids have the same size, pop the stack asteroid and mark the current asteroid as destroyed.
7. If the stack asteroid is larger, mark the current asteroid as destroyed.
8. If the current asteroid was not destroyed, push it onto the stack.
9. Convert the remaining stack elements into the result array.
10. Return the result.

## Why It Works

The stack contains the asteroids that have survived all collisions processed so far.

A collision is possible only when:

```text
stack.peek() > 0 && asteroid < 0
```

because the asteroids must be moving toward each other.

When a smaller asteroid is popped, it can never participate in another collision because it has been destroyed.

This is why each asteroid can be pushed and popped at most once.

The stack therefore always represents the current surviving asteroids in their original order.

## Complexity

**Time:** `O(n)`

Although there is a `while` loop inside the `for` loop, the solution is still `O(n)` amortized.

Each asteroid is pushed onto the stack at most once and popped at most once.

Therefore:

```text
Total pushes <= n
Total pops   <= n
```

The final conversion from the stack to the result array also takes `O(n)`.

Overall:

```text
O(n) + O(n) = O(n)
```

**Space:** `O(n)`

In the worst case, none of the asteroids collide, so the stack can contain all `n` asteroids.

## Pattern

**Stack / Monotonic Stack**

More specifically:

**Asteroid Collision + Stack**

The stack is used to repeatedly resolve collisions with the most recent surviving right-moving asteroid.

## Key Learnings

* A collision can happen only between a positive asteroid and a negative asteroid.
* The stack keeps track of surviving asteroids.
* When a smaller asteroid is destroyed, continue checking because another collision may occur.
* Use a `destroyed` flag to track whether the current asteroid survives.
* A nested `while` loop does not automatically mean `O(n²)`.
* When elements are pushed and popped at most once, the overall complexity can be **amortized `O(n)`**.
* The final stack preserves the order of the surviving asteroids.

## File Structure

```text
AsteroidCollision/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```
