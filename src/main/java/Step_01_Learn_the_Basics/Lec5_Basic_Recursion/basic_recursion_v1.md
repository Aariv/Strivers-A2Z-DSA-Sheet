# 📘 Recursion Basics: Beginner Problems with Java + Stack Traces

This guide documents 8 foundational recursion problems using Java. Each problem is demonstrated using input `N = 5` (or applicable example), with visual call stack traces and clean Java code.

---

## 1. Print "Hello" N times

### Java Code

```java
void printHello(int n) {
    if (n == 0) return;
    System.out.println("Hello");
    printHello(n - 1);
}
```

### Input: `n = 5`

**Output:**

```
Hello
Hello
Hello
Hello
Hello
```

### Stack Trace:

```
printHello(5)
→ printHello(4)
→ printHello(3)
→ printHello(2)
→ printHello(1)
→ printHello(0)
```

---

## 2. Print Name N times

### Java Code

```java
void printName(int n) {
    if (n == 0) return;
    System.out.println("Arivu");
    printName(n - 1);
}
```

### Input: `n = 5`

**Output:**

```
Arivu
Arivu
Arivu
Arivu
Arivu
```

---

## 3. Print 1 to N

### Java Code

```java
void print1ToN(int i, int n) {
    if (i > n) return;
    System.out.print(i + " ");
    print1ToN(i + 1, n);
}
```

### Input: `i = 1, n = 5`

**Output:**

```
1 2 3 4 5
```

---

## 4. Print N to 1

### Java Code

```java
void printNTo1(int n) {
    if (n == 0) return;
    System.out.print(n + " ");
    printNTo1(n - 1);
}
```

### Input: `n = 5`

**Output:**

```
5 4 3 2 1
```

---

## 5. Sum of first N numbers

### Java Code

```java
int sum(int n) {
    if (n == 0) return 0;
    return n + sum(n - 1);
}
```

### Input: `n = 5`

**Output:**

```
15
```

### Stack:

```
sum(5)
→ 5 + sum(4)
→ 4 + sum(3)
→ 3 + sum(2)
→ 2 + sum(1)
→ 1 + sum(0) = 0
```

---

## 6. Factorial of N numbers

### Java Code

```java
int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}
```

### Input: `n = 5`

**Output:**

```
120
```

### Stack Trace:

```
factorial(5)
→ 5 * factorial(4)
→ 4 * factorial(3)
→ 3 * factorial(2)
→ 2 * factorial(1)
→ 1 * factorial(0) = 1
```

---

## 7. Reverse an Array

### Java Code

```java
void reverse(int[] arr, int i) {
    int n = arr.length;
    if (i >= n / 2) return;

    int temp = arr[i];
    arr[i] = arr[n - 1 - i];
    arr[n - 1 - i] = temp;

    reverse(arr, i + 1);
}
```

### Input: `arr = [1,2,3,4,5]`

**Output:**

```
5 4 3 2 1
```

---

## 8. Check if String is Palindrome

### Java Code

```java
boolean isPalindrome(String s, int i) {
    if (i >= s.length() / 2) return true;
    if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
    return isPalindrome(s, i + 1);
}
```

### Input: `s = "madam"`

**Output:**

```
true
```

### Stack Trace:

```
isPalindrome("madam", 0)
→ compare m with m
→ isPalindrome("madam", 1)
→ compare a with a
→ isPalindrome("madam", 2)
→ center reached
```
