### Selection Sort Logic Recap:

For every index i from 0 to n-2:

- Find the smallest element from index i to n-1

- Swap it with element at index i

```
nums = [5, 2, 8, 1, 3]
```
```
✅ Pass 1 (i = 0)
Current array: [5, 2, 8, 1, 3]
Look for min from index 0 to 4
 minIndex = 0 → 5
 Compare with 2 → minIndex = 1
 Compare with 8 → no change
 Compare with 1 → minIndex = 3
 Compare with 3 → no change
Swap nums[0] and nums[3]
Array after swap: [1, 2, 8, 5, 3]

✅ Pass 2 (i = 1)
Current array: [1, 2, 8, 5, 3]
Look for min from index 1 to 4
minIndex = 1 → 2
 Compare with 8, 5, 3 → no change
 minIndex == i, so no swap
Array remains: [1, 2, 8, 5, 3]

✅ Pass 3 (i = 2)
Current array: [1, 2, 8, 5, 3]
Look for min from index 2 to 4
minIndex = 2 → 8
 Compare with 5 → minIndex = 3
 Compare with 3 → minIndex = 4
Swap nums[2] and nums[4]
Array after swap: [1, 2, 3, 5, 8]

✅ Pass 4 (i = 3)
Current array: [1, 2, 3, 5, 8]
Look for min from index 3 to 4
minIndex = 3 → 5
 Compare with 8 → no change
 minIndex == i, so no swap
Array remains: [1, 2, 3, 5, 8]
```

 

