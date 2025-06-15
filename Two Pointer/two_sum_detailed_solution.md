# Java Two Sum Solution with Detailed Comments

This file contains the one-pass HashMap solution to the classic **Two Sum** problem, with detailed inline comments explaining each step.

---

## ✅ Problem
Given an array of integers `nums` and an integer `target`, return **indices** of the two numbers such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

---

## ✅ Code (With Comments)

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices.
        // Key = number in array, Value = index of that number
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array once
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];

            // The number we need to add to currentNum to reach the target
            int complement = target - currentNum;

            // Check if complement is already in the map
            if (map.containsKey(complement)) {
                // Found a pair! Return the indices:
                // - index of complement (previously seen)
                // - current index
                return new int[] { map.get(complement), i };
            }

            // If not found, put current number and its index into the map
            // This allows future iterations to find this as a complement
            map.put(currentNum, i);

            // Debug log: show current map status
            System.out.println("Step " + i + ": map = " + map);
        }

        // If no pair adds up to target, return an empty array or error indicator
        System.out.println("No two numbers found that add up to target");
        return new int[] { -1, -1 };
    }
}
```

---

## ✅ Time and Space Complexity

- **Time**: O(n), where n = number of elements in the array.
- **Space**: O(n), for the HashMap storing up to n elements.

---

## 🧪 Example

Input:
```java
nums = [2, 7, 11, 15], target = 9
```

Output:
```java
[0, 1]
```

Explanation:
- nums[0] + nums[1] = 2 + 7 = 9 ✅
