# Valid Parentheses

## Problem

Given a string `s` containing only the characters:

```text
( ) { } [ ]
```

determine whether the string is valid.

A string is valid if:

1. Every opening bracket is closed by the same type of bracket.
2. Brackets are closed in the correct order.
3. Every closing bracket has a corresponding opening bracket.

### Examples

```text
Input:  s = "()"
Output: true
```

```text
Input:  s = "()[]{}"
Output: true
```

```text
Input:  s = "(]"
Output: false
```

```text
Input:  s = "([)]"
Output: false
```

```text
Input:  s = "{[]}"
Output: true
```

---

## Approach

The problem can be solved using a **Stack**.

The important observation is that brackets follow a **Last In, First Out (LIFO)** order.

For example:

```text
([{}])
```

The last opening bracket is `{`, so it must be the first one to close.

### Step 1: Store opening brackets

Whenever an opening bracket is encountered:

```text
(   [   {
```

push it onto the stack.

For example:

```text
Input: ([{

Stack:
[
(
```

Conceptually, the top of the stack contains the most recently opened bracket.

### Step 2: Match closing brackets

When a closing bracket is encountered:

```text
)   ]   }
```

check the top of the stack.

The expected pairs are:

```text
( → )
[ → ]
{ → }
```

If the top of the stack does not match the closing bracket, the string is invalid.

### Step 3: Remove the matched opening bracket

If the brackets match, remove the opening bracket from the stack.

### Step 4: Check the stack at the end

After processing the entire string, the stack must be empty.

If any opening brackets remain, they were never closed.

---

## Implementation Detail

Instead of using Java's `Stack<Character>`, this solution implements the stack manually using an integer array:

```text
int[] stack
```

and a pointer:

```text
ptr
```

The pointer represents the **top of the stack**.

Initially:

```text
ptr = -1
```

When pushing:

```text
ptr++;
```

When popping:

```text
ptr--;
```

This avoids creating a separate `Stack` object and gives direct control over the stack operations.

---

## Complexity

Let `n` be the length of the string.

### Time Complexity

Each character is processed exactly once.

Therefore:

```text
O(n)
```

### Space Complexity

In the worst case, the string can contain only opening brackets:

```text
((([[[{{{
```

All of them will be stored in the stack.

Therefore:

```text
O(n)
```

---

## Edge Cases

### Empty string

```text
s = ""
```

There are no unmatched brackets, so the result is:

```text
true
```

### Closing bracket without an opening bracket

```text
s = ")"
```

The stack is empty when the closing bracket is encountered, so:

```text
false
```

### Unclosed opening bracket

```text
s = "((("
```

The stack is not empty at the end, so:

```text
false
```

### Wrong order

```text
s = "([)]"
```

When `)` is encountered, the top of the stack is `[` instead of `(`.

Therefore:

```text
false
```

---

## DSA Pattern

**Stack — LIFO (Last In, First Out)**

This pattern is useful for:

* Valid Parentheses
* Next Greater Element
* Min Stack
* Daily Temperatures
* Stock Span
* Evaluate Reverse Polish Notation
* Largest Rectangle in Histogram

---

## Key Learnings

* Bracket matching is naturally suited to a stack because brackets must be closed in reverse order of opening.
* The most recently opened bracket must be the first one closed.
* A stack can be implemented manually using an array and a pointer.
* Every character is processed only once, giving `O(n)` time complexity.
* Always check for both:

  * an invalid closing bracket while processing
  * unmatched opening brackets remaining at the end

---

## File Structure

```text
ValidParentheses/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```
