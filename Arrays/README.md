# Array

## Array Initialization Examples
This file shows different ways to initialize integer arrays in Java, while preserving original variable names and styles.

#### Two-step initialization for nums2
```java
int[] nums2 = new int[5];
nums2 = new int[] {1, 2, 2, 3, 8};
```

#### One-step shorthand initialization for nums3
```java
int[] nums3 = {1, 2, 3, 4};
```

#### One-step explicit initialization for nums4
```java
int[] nums4 = new int[] {1, 2, 3, 4, 33};
```

---

## Array Sort and Print

#### Sort an array using `Arrays.sort()` and print with `Arrays.toString()`
```java
import java.util.Arrays;

int[] nums = {5, 3, 2, 4, 1};
Arrays.sort(nums);  // Sorts the array in ascending order

System.out.println(Arrays.toString(nums));  // Prints: [1, 2, 3, 4, 5]
```

- `Arrays.sort()` sorts an array in ascending order.
- `Arrays.toString(array)` prints the array as a string (e.g. `[1, 2, 3]`).
