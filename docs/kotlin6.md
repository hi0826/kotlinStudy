# chapter 6

## 람다식과 고차함수 요약

## 클로저

- 람다식으로 표현된 내부 함수에서 외부 범위에 선언된 변수에 접근할 수 있는 개념

## 코틀린의 기본 라이브러리 함수

- 표준 라이브러리
  - let, apply, with, also, run
  - 대략적인 확장 함수의 형태로 구성
  - it, this 를 사용
    - it 은 복사형태
    - this 는 참조 형태

### let

- 함수를 호출하는 객체 T를 이어지는 block의 인자로 넘기고 block의 결과값 R을 반환
- `public inline fun <T, R> T.let(block: (T) -> R): R { ... return block(this) }`
- 매개변수 block은 T를 매개변수로 받아 R을 반환하는 람다식
- let 함수 역시 R을 반환
- this는 객체 T를 가리키는데 람다식 결과 부분을 그대로 반환한다는 뜻
- 다른 메서드를 실행하거나 연산을 수행해야 하는 경우 사용
- 체이닝과 중첩 사용 가능
- let의 중첩 사용
  - it 을 사용하기 힘들다
  - 명시적이름을 사용해줄것
  - 반환값은 바깥쪽의 람다식에만 적용

### also

- 함수를 호출하는 객체 T를 이어지는 block에 전달하고 객체 T자체를 반환
  `public inline fun <T> T.also(block: (T) -> Unit) : T { block(this); return this }`
- also는 블록 안의 코드 수행 결과와 상관없이 T인 바로 객체 this를 반환

```kotlin
var m = 1
m = m.also { it + 3 }
println(m) // 원본 값 1
```

### apply

- also와 비슷하게 호출하는 T를 block으로 넘겨주고 객체 자체인 this를 반환
  `public inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }`
- T를 인자로 받아서 처리하는 것이 아닌 확장 함수로서 처리
  - T.()
  - 반환 값이 없음
  - it 을 사용하지 않음, this로서 처리할 수 있음
    - this 라서 생략 가능
- 레이아웃을 초기화할 때 apply 활용하기
  - android
- 디렉터리 생성 시 apply() 적용하기

```kotlin
fun makeDir(path: String): File {
  val result = File(path)
  result.mkdirs()
  return result
}
// 로 함축가능
File(path).apply { mkdirs() }
```

### run

- run()함수는 인자가 없는 익명 함수처럼 동작하는 형태와 객체에서 호출하는 확장 함수의 형태 두 가지로 사용
- `public inline fun <R> run(block: () -> R): R = return block()`
- `public inline fun <T, R> T.run(block: T.() -> R): R = return block()`

```kotlin
var skills = "Kotlin"
println(skills) // Kotlin

val a = 10
skills = run {
  val level = "Kotlin Level:" + a
  level // 마지막 표현식이 반환
}
println(skills) // Kotlin Level: 10
```

### with

- 인자로 받는 객체를 이어지는 block의 receiver로 전달하여 결과값을 반환
  - run() 함수와 기능이 거의 동일, run의 경우 receiver가 없지만, with의 경우 receiver로 전달할 객체를 처리
- `public inline fun <T, R> with(receiver: T, block: T.() -> R): R = receiver.block()`
- with는 세이프 콜(?.)을 지원하지 않기 때문에 let과 같이 사용
  - let과 with 표현을 병합하면 run과 동일

### use

- user()를 사용하면 객체를 사용한 후 close() 등을 자동적으로 호출해 닫아준다.
- `public inline fun <T: Closeable?, R> T.use(block: (T) -> R): R`
- `public inline fun <T: AutoCloseable?, R> T.use(block: (T) -> R: R`
- T의 제한된 자료형을 보면 block은 닫힐 수 있는 객체를 지정해야함
- java 7이후로는 AutoCloseable?로 사용된다.
- FileReader, BufferReader 등과 같은 객체에서 사용함
- use 의 구현부에는 try, catch, finally 존재
  - finally 부분에서 close

### takeIf, takeUnless

- takeIf 람다식이 true이면 객체 T 반환, 아니면 null (takeUnless는 반대)
- `public inline fun <T> T.takeIf(predicate: (T) -> Boolean): T? = if (predicate(this)) this else null`

```kotlin
// 기존 코드
if(someObject != null && someObject.status) {
    doThis()
}
// 개선 1
if(someObject?.status == true) {
    doThis()
}
// takeIf 사용하여 개선
someObject?.takeIf { it.status }?.apply { doThis() }
```

- 엘비스 연산자와 함께 사용

```kotlin
val input = "Kotlin"
val keywork = "in"

// 입력 문자열에 키워드가 있으면 인덱스를 반환하는 함수
// takeIf
input.indexOf(keyword).takeIf { it >= 0 } ?: error("keyword not found")
// takeUnless
input.indexOf(keyword).takeUnless { it < 0 } ?: error("keyword not found")
```

### 시간 측정

### 난수 생성
