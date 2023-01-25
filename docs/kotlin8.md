## 프로퍼티와 초기화

### 2.1 프로퍼티의 접근 1) 접근 메서드: 세터 게터

- 코틀린은 기본적인 접근 메서드를 내부적으로 생성하여 가지고 있다.
- 프로퍼티에 대한 것만 신경쓰면된다.
- 게터와 세터의 동작 방식

```kotlin
fun main() {
    val user = User(1, "Sean", 30)

    // getter에 의한 값 획득
    val name = user.name

    // setter에 의한 값 지정
    user.age = 41

    println("name : $name, ${user.age}")
}
```

- 프로퍼티에 직접 접근하는 것 처럼 보이지만 getter와 setter가 동작

### 2.1 프로퍼티의 접근 2) 커스텀: 내맘대로 세터 게터

- 기본 게터와 세터 직접 지정
- val 은 게터만 설정 가능 (읽기 전용)
- `field` 라는 키워드를 사용
  - 프로퍼티를 참조하는 변수로 `backing field`라고 불림
  - 프로퍼티를 직접 사용하게되면 게터 세터를 호출해 무한 재귀에 빠진다.
- `backing field`대신에 보조 프로퍼티를 만들어서 사용할 수 있다.

  - `var tempName: String? = null`

- 프로퍼티의 오버라이딩 사용하기
  - override 를 사용하여 부모와 구현을 다르게 할 수 있다.

### 2.2 지연 초기화와 위임 1) lateinit의 지연 초기화

- 지연초기화가 필요한 이유
  - 객체의 정보가 나중에 나타나는 경우 나중에 초기화 할 수 있는 방법 필요
  - 지연 초기화를 위해 lateinit과 lazy 키워드 사용
- lateinit을 사용한 지연초기화
  - 의존성 있는 초기화, unit테스트를 위한 코드 작성시
    - 의존성 있는 경우 의존하고 있는 객체의 초기화가 일어나야 초기화를 해야함
    - 단위 테스트의 경우 임시적으로 객체를 생성해야하는 경우
  - 프로퍼티 지연 초기화
    - 프로퍼티는 null선언을 허용하지 않음
    - 지연 초기화를 위한 lateinit 키워드를 사용하면 값이 바로 할당되지 않아도 됨
  - lateinit의 제한
    - var로 선언된 프로퍼티만 가능
    - 프로퍼티에 대한 게터와 세터 사용 불가능
- 객체 생성시 lateinit을 통한 지연 초기화 가능
  - 객체 자체도 lateinit가능

### 2.2 지연 초기화와 위임 2) by lazy를 통한 늦은 초기화

- lazy를 통한 지연 초기화
  - 호출 시점에 `by lazy {...}` 정의에 의해 블록 부분의 초기화를 진행
    - 람다식 형태
  - val에서만 사용 가능
    - 값을 변경할 수 없음
- by lazy를 사용한 객체 생성
  - 위임 변수를 사용한 초기화
    - `val personDelegate = lazy { Person("Hong", 40) }`
    - `.value`를 사용하여 객체에 접근
- by lazy의 모드
  - 3가지 모드 지정 가능
    - SYNCHRONIZED
      - 락을 사용해 단일 스레드만이 사용하는 것을 보장
    - PUBLICATION
      - 여러 군데서 호출될 수 있으나 처음 초기화된 후 반환 값을 사용
    - NONE
      - 락을 사용하지 않기 때문에 빠르지만 다중 스레드 접근 가능
      - 일관성을 보장할 수 없음

### 2.2 지연 초기화와 위임 3) 너에게 위임 하노라

- by를 이용한 위임
- 위임(delegation)
  - 하나의 클래스가 다른 클래스에 위임하도록 선언
  - 위임된 클래스가 가지는 멤버를 참조없이 호출
- 클래스 위임
  - 다른 클래스의 멤버를 사용하도록 위임

```kotlin
interface Animal {
    fun eat() {}
}
class Cat: Animal {}

val cat = Cat()
class Robot: Animal by Cat // animal에 정의된 cat의 모든 멤버를 robot에 위임
```

- 위임을 사용하는 이유?
  - 코틀린의 기본 라이브러리는 open되어있지 않음
    - 상속이나 기능의 확장이 어렵다.
  - 위임을 통해 상속과 비슷하게 추가, 확장이 가능하다.
- 위임을 받아도 같은 것이 내부에 선언되어있다면 위임 받은 것 보다 먼저 접근
- 프로퍼티 위임가 by lazy 다시보기
  - by lazy 도 위임
    - 사용된 프로퍼티는 람다식 함수에 전달되어 함수에 의해 사용
- observable과 vetoable의 위임
- observable
  - 프로퍼티를 감시하고 있다가 특정 코드의 로직에서 변경이 일어날 경우 호출
- vetoable
  - 반환값에 따라 프로퍼티 변경을 허용하거나 취소

```kotlin
class User {
    var name: String by Delegates.observable("NONAME") {
        prop, old, new ->
        println("$old -> new")
    }
}
```

### 정적 변수와 메서드

- 정적 변수와 컴패니언 객체
  - 사용 범위에 따른 분류
    - 지역, 전역
  - 보통 클래스는 동적으로 객체를 생성하는데 정적으로 고정하는 방법은?
    - 동적인 초기화 없이 사용할 수 있는 개념, 자바에서는 static 변수 또는 객체
    - 코틀린에서는 컴패니언 객체(Companion object)
    - 프로그램 실행시 고정적으로 메모리를 가져감
      - 메모리 낭비에 유의

```kotlin
class Person {
  var id: Int = 0
  var name: String = "Youngdeok"
  companion object {
    var language: String = "Korean"
    fun work() {
        println("working...")
    }
  }
}
fun main() {
  println(Person.language)
  Person.language = "English"
  println(Person.language)
  Person.work()
  // person.name은 접근 불가
}
```

- 자바에서 코틀린 컴패니언 객체 사용
  - @JvmStatic
- 최상위 함수 정리
  - 최상위 함수
    - 클래스 없이 만든 최상위 함수들은 객체 생성 없이도 어디에서든 실행
    - 패키지 레벨 함수
    - 자바에서는 `static final`로 선언된 함수
  - 자바에서 코틀린 최상위 함수 접근
    - 코틀린의 최상위 함수는 클래스가 없으나 자바와 연동시 내부적으로 파일명에 kt 접미사가 붙은 클래스를 자동 생성
    - 자동 변환되는 클래스명을 명시적으로 지정하고자 하는 경우 코틀린 파일에 @file:JvmName("ClassName")을 코드 상단에 명시
- object와 싱글톤
  - 상속할 수 없는 클래스에서 내용이 변경된 객체를 생성할 때
    - 자바의 경우 익명 내부 클래스를 사용해 새로운 클래스 선언
    - 코틀린에서는 object 표현식이나 object 선언으로 이 경우를 좀 더 쉽게 처리
  - object 선언 방식은 접근 시점에 객체가 생성
    - 생성자 호출을 하지 않으므로 object 선언에는 주/부 생성자를 사용할 수 없다.
- object 표현식
  - 선언과 달리 이름이 없으며 싱글턴이 아님
  - 표현식이 사용될 때마다 새로운 인스턴스가 생성
  - 이름이 없는 익명 내부 클래스로 불리는 형태를 object 표현식으로 만들수 있다.
