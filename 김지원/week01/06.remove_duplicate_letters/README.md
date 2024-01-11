# remove_duplicate_letters

### SortSet 사용법

- Element의 `비교 기준` 을 구현해야 한다.
  - Element를 비교하는 Comparator 구현 및 Element에 Comparable를 상속받아 구현

```java
TreeSet<Character> set = new TreeSet<>(new Comparator<Character>() {
    @Override
    public int compare(Character o1, Character o2) {
        return o1 - o2;
    }
});
```

### String.charAt(int indxex): String 에서 각 index의 Character를 얻는 함수

```java
String s = "abcd";
for (int i = 0; s.length(); i++) {
    char ch = s.charAt(i);
}
```

### String.valueOf(ch): char 를 String으로 변환

```java
char ch = 'a';
String s = String.valueOf(ch);
```


### ArrayDeque의 이해

- stack과 queue를 동시에 사용할 수 있다.

- Stack
    - 값을 List의 앞쪽 부터 넣는다.
    - 1, 2, 3, 4 를 차례로 push 한다면, list에는 4, 3, 2, 1 순서로 저장된다.
    - push(): addFirst()
    - pop(): removeFirst() -> 4, 3, 2, 1 순으로 제거
    - pollLast(): removeLast(), pop()의 반대 1, 2, 3, 4 순으로 제거

- Queue
    - 값을 List의 뒤쪽 부터 넣는다.
    - 1, 2, 3, 4 를 차례로 offer 한다면, list에는 1, 2, 3, 4 순서로 저장된다.
    - offer(): addList()
    - poll(): removeFirst() : 1, 2, 3, 4 순으로 제거