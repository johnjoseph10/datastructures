### 📘 Problem: Container With Most Water

#### 🧠 Question:
Given an array `height` of length `n`, where each element represents a vertical line drawn at coordinate `i` with height `height[i]`, find two lines that, together with the x-axis, form a container that holds the most water.

Return the maximum amount of water a container can store.

```java
class Solution {
    public int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int min = 0;
        int diff = 0;
        int tarea = 0;
        int area = 0;

        while (first < last) {
            diff = last - first;
            min = Math.min(height[first], height[last]);
            tarea = diff * min;
            if (tarea > area) {
                area = tarea;
            }

            if (height[first] < height[last]) {
                first++;
            } else {
                last--;
            }
        }

        return area;
    }
}
```

---

### ✅ Answer:
This solution uses a **two-pointer approach** to find the maximum area efficiently.

#### 🔍 Explanation:
- **Initialize two pointers**: `first` at the beginning and `last` at the end of the array.
- Loop until `first` and `last` meet:
  - Compute the width: `last - first`
  - Compute the height using the smaller of the two values: `min(height[first], height[last])`
  - Calculate the area: `width * height`
  - Update the maximum area seen so far.
  - Move the pointer pointing to the shorter line to try and find a taller one.

#### ⏳ Time Complexity:
- **O(n)** where `n` is the number of vertical lines (array length).

#### 📈 Space Complexity:
- **O(1)** since we only use constant space.

#### ✨ Key Insight:
To maximize area, move the pointer pointing to the shorter line because that side limits the container's height. Moving the taller one won’t help.

---
