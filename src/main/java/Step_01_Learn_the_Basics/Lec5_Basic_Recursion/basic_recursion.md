### Print name N times using recursion

```java
printName(5) - Ariv
 printName(4) - Ariv
  printName(3) - Ariv
   printName(2) - Ariv
    printName(1) - Ariv
     printName(0)
```
### Print 1 to N using recursion
```
Ex: n = 5 => 1 2 3 4 5
```
```java
print1toN(5)     - 5
 print1toN(4)    - 4
  print1toN(3)   - 3
   print1toN(2)  - 2 
    print1toN(1) - 1
     print1toN(0) - return
```
```
🪜 Execution Walkthrough
print(5) calls print(4)

print(4) calls print(3)

print(3) calls print(2)

print(2) calls print(1)

print(1) calls print(0) → base case hit

Stack starts to unwind and prints: 1, 2, 3, 4, 5
```

### Print N to 1

##### 🪜 Execution Walkthrough

```

print(5) → prints 5, calls print(4)

print(4) → prints 4, calls print(3)

print(3) → prints 3, calls print(2)

print(2) → prints 2, calls print(1)

print(1) → prints 1, calls print(0) (base case)

Done!
```
##### 🔁 Call Stack Trace
```
| Stack    | Action  | Output |
| -------- | ------- | ------ |
| print(5) | print 5 | 5      |
| print(4) | print 4 | 4      |
| print(3) | print 3 | 3      |
| print(2) | print 2 | 2      |
| print(1) | print 1 | 1      |
| print(0) | return  |        |
```
### Sum of First N Numbers

##### Stack Trace for n = 5:
```
sum(5)
 -> 5 + sum(4)
      -> 4 + sum(3)
           -> 3 + sum(2)
                -> 2 + sum(1)
                     -> 1 + sum(0)
                          -> 0  ← base case
Then it returns
sum(0) = 0
sum(1) = 1 + 0 = 1
sum(2) = 2 + 1 = 3
sum(3) = 3 + 3 = 6
sum(4) = 4 + 6 = 10
sum(5) = 5 + 10 = 15

```
### Factorial of N

##### Stack Trace for n = 5:
```
factorial(5)
 -> 5 * factorial(4)
      -> 4 * factorial(3)
           -> 3 * factorial(2)
                -> 2 * factorial(1)
                     -> 1 * factorial(0)
                          -> 1  ← base case

Then unwinds:
factorial(0) = 1
factorial(1) = 1 * 1 = 1
factorial(2) = 2 * 1 = 2
factorial(3) = 3 * 2 = 6
factorial(4) = 4 * 6 = 24
factorial(5) = 5 * 24 = 120
```
### Reverse an Array

##### Stack Trace for input {1, 2, 3, 4, 5}:

```
reverse(arr, 0) → swap arr[0] & arr[4] → [5, 2, 3, 4, 1]
reverse(arr, 1) → swap arr[1] & arr[3] → [5, 4, 3, 2, 1]
reverse(arr, 2) → i == 2 → stop (middle reached)
```

### Check if a String is a Palindrome

##### Stack Trace for input "madam":

```
isPalindrome("madam", 0) → compare m and m ✅
isPalindrome("madam", 1) → compare a and a ✅
isPalindrome("madam", 2) → middle reached ✅
```

### Fibonacci Number 

##### call stack tree for fib(5):

```
                                fib(5)
                               /      \
                          fib(4)       fib(3)
                         /     \       /     \
                   fib(3)     fib(2) fib(2)  fib(1)
                  /    \     /   \   /   \
             fib(2) fib(1) fib(1) fib(0) fib(1)
            /   \
        fib(1) fib(0)
```

