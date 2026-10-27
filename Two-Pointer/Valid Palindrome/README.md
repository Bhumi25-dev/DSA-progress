# Valid Palindrome

## Problem

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

## Example

**Input**
```text
s = "A man, a plan, a canal: Panama"
```

**Output**
```text
true
```

**Explanation**
```text
"amanaplanacanalpanama" is a palindrome.
```

## Approach

The approach uses an `ArrayList` to store only the valid characters of the string and then compares characters from opposite ends to determine whether the string is a palindrome.

First, convert the entire string into lowercase. Then, traverse the string and add only alphanumeric characters to an `ArrayList` using `Character.isLetterOrDigit()`.

Once the filtered list is created, compare the elements from the beginning and the end, moving towards the center. If any pair of characters does not match, return `false`. Otherwise, return `true` after all comparisons are completed.

## Algorithm

1. Convert the given string to lowercase and store it in a new String `snew`.
2. Create an `ArrayList<Character>` named `arr` to store valid characters.
3. Iterate through the new string and add only alphanumeric characters to `arr` using `Character.isLetterOrDigit()`.
4. Iterate from index `0` to half the size of the list.
5. Compare the character at index `i` with the character at index `arr.size() - 1 - i`.
6. If the characters are not equal, return `false`.
7. If all corresponding characters match, return `true`.

## Why It Works

A palindrome reads identically from both directions. Therefore, its first character must match its last character, its second character must match its second-last character, and so on.

By converting the string to lowercase and removing all non-alphanumeric characters, we ensure that the comparison follows the problem's requirements.

The algorithm compares corresponding characters from opposite ends of the filtered list. If even one pair does not match, the string cannot be a palindrome. If every pair matches, the string is a palindrome.

Since we only need to compare half of the list, every pair is checked exactly once.

## Complexity

Let `n` be the length of the original string.

- **Time Complexity: O(n)**
  - Converting the string to lowercase takes O(n).
  - Traversing the string and building the ArrayList takes O(n).
  - Comparing the characters takes O(n) in the worst case.
  - Overall time complexity is O(n).

- **Space Complexity: O(n)**
  - A new lowercase string is created.
  - The ArrayList stores up to `n` characters in the worst case.
  - Overall auxiliary space complexity is O(n).

## Pattern

**String Manipulation + Two Pointers (Opposite-End Comparison)**

The solution filters and normalizes the string before comparing elements from opposite ends using two indices.

## Key Learnings

- Use `String.toLowerCase()` to perform case-insensitive comparisons.
- Use `Character.isLetterOrDigit()` to check whether a character is a letter or a digit.
- Use `ArrayList<Character>` to dynamically store filtered characters.
- Use `Objects.equals()` to compare objects safely for equality.
- For opposite-end comparisons, the corresponding index from the end is calculated using `arr.size() - 1 - i`.
- Only half of the list needs to be traversed because each comparison checks two corresponding positions.

## File Structure

```text
Valid Palindrome/
├── Solution.java    # Implementation
└── README.md        # Explanation and complexity analysis
```