# Longest Substring Without Repeating Characters

## Problem

Given a string `s`, find the length of the **longest substring without repeating characters**.

A substring must contain characters that are consecutive in the original string.

### Examples

```text
Input:  s = "abcabcbb"
Output: 3
```

The longest substring without repeating characters is:

```text
"abc"
```

Another example:

```text
Input:  s = "bbbbb"
Output: 1
```

The longest substring is:

```text
"b"
```

---

## Approach

The solution uses the **Sliding Window** technique with a `HashMap`.

The window is represented by two pointers:

```text
l → left boundary
r → right boundary
```

The HashMap stores the frequency of each character currently present inside the window.

```text
character → frequency
```

For example:

```text
s = "abcabcbb"
```

Initially:

```text
Window: abc

Map:
a → 1
b → 1
c → 1
```

When a duplicate character enters the window, the left pointer is moved forward until the duplicate is removed.

---

## Algorithm

1. Initialize two pointers `l` and `r` at the beginning of the string.
2. Add the character at `r` to the HashMap.
3. If its frequency becomes greater than `1`, move `l` forward.
4. Decrease the frequency of characters removed from the window.
5. Remove a character from the map when its frequency becomes `0`.
6. Once the window contains unique characters, calculate its length.
7. Update the maximum length.
8. Move `r` forward and repeat.

---

## Example Walkthrough

Consider:

```text
s = "abcabcbb"
```

The window initially grows:

```text
a
ab
abc
```

At the next `a`:

```text
abca
```

`a` appears twice, so move `l` forward:

```text
bca
```

Now all characters are unique again.

Continue the same process throughout the string.

The largest valid window has length:

```text
3
```

---

## Why Sliding Window?

A brute-force approach would generate many substrings and check whether each substring contains duplicate characters.

That can result in much higher complexity.

Instead, the sliding window maintains a range that always contains **unique characters**.

When a duplicate appears, we don't restart from the beginning. We simply move the left pointer until the window becomes valid again.

This allows each character to be processed a limited number of times.

---

## Complexity

Let `n` be the length of the string.

### Time Complexity

The right pointer moves from left to right once.

The left pointer also moves from left to right and never moves backward.

Therefore, each character is added to and removed from the window at most once.

```text
Time = O(n)
```

### Space Complexity

The HashMap stores characters currently present in the window.

For a general character set:

```text
Space = O(min(n, character_set_size))
```

In the worst case:

```text
Space = O(n)
```

---

## DSA Pattern

**Sliding Window + HashMap**

This pattern is useful for problems involving:

* Longest substring with unique characters
* Longest substring with at most `K` distinct characters
* Longest substring with exactly `K` distinct characters
* Minimum Window Substring
* Subarray/substring frequency problems

---

## Key Learnings

* Use two pointers to maintain a dynamic window.
* The HashMap keeps track of character frequencies inside the window.
* When the window becomes invalid, move the left pointer until it becomes valid again.
* The left and right pointers never move backward, giving an overall `O(n)` time complexity.
* Instead of generating every substring, maintain only the relevant window.

---

## File Structure

```text
LongestSubstringWithoutRepeating/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```
