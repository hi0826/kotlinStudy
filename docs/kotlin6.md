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
  - this는  객체 T를 가리키는데 람다식 결과 부분을 그대로 반환한다는 뜻
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
- 