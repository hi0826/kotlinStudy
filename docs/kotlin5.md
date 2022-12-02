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

### when 구문
- 인자를 사용하는 경우
```text
when (parameter) {
    인자에 일치하는 값 / 표현식 -> 수행할 문장
    인자에 일치하는 범위 -> 수행할 문장
    else -> 문장
}
```
```kotlin
when(x) {
  1 -> print("x == 1")
  2 -> print("x == 2")
  else -> {
      print("...")
  }
}
```
- `,`를 사용해서 판별할 수 있다.
- 함수의 반환값을 사용할 수 있다.
- in 연산자와 범위 지정자를 사용할 수 있다.
- is 키워드와 함께 사용할 수 있다.
- 인자가 없는 when
  - block 안에 조건을 직접 넣어야 한다.
  
### 흐름 제어문
- return
- break
- continue

### 예외 처리문
- try
- catch
- finally

- 람다식 함수를 사용할 때는 Return 을 조심히 사용해야 한다.
- return 으로 Unit 반환하기
  - Unit은 생략 가능함(생략시 추론 가능)
  - 엄밀히 따지면 Unit이라는 특수한 자료형을 반환 > 어떠한 데이터 타입으로도 반환하지 않는 다는 것을 표현
  - Unit 명시, 생략, return 생략등의 방법으로 추론
- 람다식에서 라벨(@) 사용하기
- `lambda functionName labelName@ {}`
- 라벨이 없다면 비이적 반환이 되어 바깥 함수도 빠져나감