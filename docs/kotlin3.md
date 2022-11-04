# 함수

## 3.1 함수

- 선언방법

```kotlin
fun name(paramete: dataType): returnType {
    function body
}
```

- 반환 값이 없을 경우 자동으로 Unit
- 코틀린에서 반환되지 않는 타입은 unit을 사용
  - void 와 흡사하지만 반환 값이 없음을 의미
  - `return Unit`이 생략되어있음
- 함수가 return 문 하나라면 생략 가능
  - `fun sum(a: Int, b: Int): Int = a + b`
  - `fun sum(a: Int, b: Int) = a + b`
- 최상위 함수는 어디있어도 읽을 수 있다.
  - 호출시 선언순서가 중요하지 않다.
- 함수 안에 함수선언도 가능하다.
- 지역함수
  - 특정 지역내에만 존재
  - 호출시 순서 중요
- 가변 변수
  - vararg 키워드 사용
  - 인자를 1개 이상 받을 수 있음
- 함수와 스택 프레임 이해하기
  - main 함수의 프레임 생성
  - 지역변수들, 항스택, 상수 풀 등이 생성
  -
