### ElementFrequencyList - How it Works – Execution Trace

```
| Step | num | freqMap         |
| ---- | --- | --------------- |
| 1    | 1   | {1=1}           |
| 2    | 2   | {1=1, 2=1}      |
| 3    | 2   | {1=1, 2=2}      |
| 4    | 1   | {1=2, 2=2}      |
| 5    | 3   | {1=2, 2=2, 3=1} |
```

### HighestLowestFrequency - How it Works – Execution Trace

```
| Step | num | freqMap           |
| ---- | --- | ----------------- |
| 1    | 10  | {10=1}            |
| 2    | 5   | {10=1, 5=1}       |
| 3    | 10  | {10=2, 5=1}       |
| 4    | 15  | {10=2, 5=1, 15=1} |
| 5    | 10  | {10=3, 5=1, 15=1} |
| 6    | 5   | {10=3, 5=2, 15=1} |
```

##### Then we analyze:

```
10 → 3 ✅ (max)

5 → 2

15 → 1 ✅ (min)
```

