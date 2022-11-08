### 람다식

- 일반 변수에 람다식을 할당할 수 있다.
  - 람다식이 할당된 변수는 함수처럼 사용 가능
  - `val multi: (Int, Int) -> Int = {x: Int, y: Int -> x * y}`
  - 표현식에 자료형을 추론할 수 있도록 해야 한다.
  - 표현식이 여러 줄인 경우 마지막 표현식이 반환
    - 표현식이 2줄 이상일 때
- 람다식 안에 람다식이 있는 경우
  - `val nestedLambda: ()->()->Unit = { { println("nested") } }`
- 값에 의한 호출
  - 함수가 인자로 전달될 경우
    - 람다식 함수는 값으로 처리, 그 즉시 함수가 수행된 후 값을 전달
- 람다식 이름을 사용한 호출
  - 인자가 없는 람다식을 사용할 경우
  - 이름을 인자로 전달하면 함수 자체가 parameter로 전달되게 된다.
- 다른 함수의 참조에 의한 호출
  - `::sum`를 통해서 내부의 함수를 참조해서 사용한다.
- 람다식 함수의 매개변수
  - 매개변수 개수에 따라 람다식을 구성하는 방법
- 매개변수가 한 개인 경우
  - 중괄호로 내부의 람다를 구성할 수 있다.
- 매개변수가 두 개인 경우
  - 매개변수명 생략 불가
- 매개변수를 딱 하나만 사용할 경우
  - 생략할 수 있음
  - `_`를 사용해서 n번째 인자를 생략할 수 있다.
- 두 개의 람다식을 가진 함수의 사용
  - 람다식 하나를 쓰고, 하나는 소괄호 바깥의 중괄호로 빼낼 수 있음

### 익명함수

- 함수에 이름이 없는 것
  - `fun (x: Int, y: Int): Int = x + y`
  - `val add: (Int, Int) -> Int = fun(x, y) = x + y`
  - `val result = add(10, 2)`
  - `val add = fun(x: Int, y: Int) = x + y`
  - `val add = {x: Int, y: Int -> x + y}`
- 인라인 함수
  - 함수가 호출되는 곳에 내용을 모두 복사
  - 함수의 분기 없이 처리함 -> 성능 증가
  - 내용에 return이나 break 가 들어가면 예기치못한 동작이 발생할 수 있다.
- 인라인 함수의 단점
  - 코드가 복사되는 특징
    - 내용이 많아지면 코드 사이즈가 늘어남
  - noninline
    - 일부 람다식 함수를 인라인되지 않게 하기 위함
    - `inline fun sub(out1: () -> Unit, noninline out2: () -> Unit) {... }`
  - return을 잘못사용하면, 비지역 반환이 일어날 수 있다.
    - 람다식 함수를 인자로 사용하는 함수는 의도치않게 람다식 함수 바깥에 있는 함수가 같이 Return 됨
    - 방지하려면 crossinline을 사용하면됨

### 확장함수

- 클래스의 멤버 함수를 외부에서 더 추가할 수 있다.
- `fun className.funName(parameter, ...): returnType { return returnValue}`
- 너무 많이 만들어내면, 호환성이 떨어질 수 있음

```kotlin
fun main() {
    val source = "Hello World!"
    val target = "Kotlin"
    println(source.getLongString(target))
}

fun String.getLongString(target: String): String =
    if (this.length > target.length) this else target
```

### 중위함수

- 중위 표현법 사용(infix notation)
  - 클래스의 멤버 호출 시 사용하는 `.` 을 생략하고 함수 이름 뒤에 소괄호를 생략해 직관적인 이름을 사용할 수 있음
- 조건
  - 멤버 메서드 또는 확장 함수여야 한다.
  - 하나의 매개변수를 가져야 한다.
  - `infix` 키워드를 사용하여 정의한다.

```kotlin
fun main() {
    // val multi = 3.multiply(10)
    val multi = 3 multiply 10
    println("multi: $multi")
}

infix fun Int.multiply(x: Int): Int {
    return this * x
}
```

### 꼬리 재귀 함수

- 자기 자신을 다시 참조
  - 자기 자신을 계속 호출하는 특징
  - 스택 프레임이 계속 쌓이게됨 -> 스택오버플로우가 발생할 수 있다.
  - 호출 횟수를 무리하게 많이 지정하지 않도록 주의
  - 코드를 복잡하지 않게 한다.
- 꼬리 재귀 함수
  - 스택에 계속 쌓이는 방식이 함수가 계속 씌워지는 꼬리를 무는 형태
  - 호출 스택이 쌓여도 오버플로우 위험이 적음
  - `tailrec` 키워드 사용

```kotlin
fun main() {
    val number = 4
    val result: Long

    result = factorial(number)
    println("Factorial: $number -> $result")
}

fun factorial(n: Int): Long {
    return if (n == 1) n.toLong() else n * factorial(n-1)
}
```

```kotlin
fun main() {
    val number = 5

}

tailrec fun factorial(n: Int, run: Int = 1): Long {
    return if (n == 1) run.toLong() else factorial(n-1, run*n)
}
```
