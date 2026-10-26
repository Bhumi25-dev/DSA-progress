# Valid Anagram

## Problem

Given two strings `s` and `t`, determine whether `t` is an anagram of `s`.

An anagram is a word or phrase formed by rearranging the characters of another word or phrase, using all the original characters exactly once.

Both strings must contain the same characters with the same frequencies.

## Example

**Input:**
```text
s = "anagram", t = "nagaram"
```

**Output:**
```text
true
```

**Input:**
```text
s = "rat", t = "car"
```

**Output:**
```text
false
```

## Approach

**Pattern: Frequency Counting (Hashing)**

Initially, I solved this problem using a `HashMap<Character, Integer>` to maintain the frequency of each character.

To optimize the solution, I replaced the HashMap with a fixed-size integer array of size `26`, since the problem guarantees lowercase English letters (`a-z`).

Each index represents a character, where `index = character - 'a'`.

I increment the frequency for characters in `s` and decrement it for corresponding characters in `t`.

This approach avoids the overhead of HashMap operations and uses constant auxiliary space.

## Algorithm

1. Check whether the lengths of `s` and `t` are equal. If not, return `false`.
2. Create an integer array `freq` of size `26`, initialized with zeros.
3. Traverse both strings simultaneously:
   - Increment the frequency of the current character in `s`.
   - Decrement the frequency of the current character in `t`.
4. Traverse the frequency array:
   - If any frequency is non-zero, return `false`.
5. If all frequencies are zero, return `true`.

## Why It Works

Anagrams must contain exactly the same characters with identical frequencies.

- Incrementing frequencies for `s` records how many times each character appears.
- Decrementing frequencies for `t` cancels out matching character occurrences.
- If both strings are anagrams, every character's final frequency will be zero.
- If any frequency is non-zero, the strings contain different character counts and cannot be anagrams.

Therefore, checking whether all frequency values are zero correctly determines whether the strings are anagrams.

## Complexity

Let `n` be the length of the strings.

- **Time:** O(n) — One traversal of both strings and one traversal of the fixed-size frequency array.
- **Space:** O(1) — The frequency array always contains exactly 26 elements.

## Pattern

**Frequency Counting / Hashing**

Useful when comparing character frequencies or checking whether two strings contain the same characters.

## Key Learnings

- Frequency counting is an effective technique for solving anagram-related problems.
- A fixed-size frequency array can be more efficient than a HashMap when the character set is limited.
- Always check string lengths before comparing character frequencies.
- Recognize when a known, limited input range allows you to replace a dynamic data structure with a fixed-size array.
- Optimizing data structures can significantly improve runtime without changing the overall time complexity.

## File Structure

```text
Valid Anagram/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```