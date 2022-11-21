# chapter 5
## 조건문을 통한 분기 1
### if / if ~else
- `if(조건)`의 형태
    - 한 줄로 나타낼 수 있는 경우 `{}`을 생략 가능
    - `val max = if(a > b) a else b`
- 블록과 함께 사용하는 경우
```kotlin
val a = 12
val b = 7
val max = if(a>b) {
    a;
}
else {
    b;
}
```
- else 를 사용해서 조건을 필요한 만큼 조합 가능하다.
- 비교 연산자와 논리곱 연산자 사용
- 범위(range) 연산자를 사용할 수 있음