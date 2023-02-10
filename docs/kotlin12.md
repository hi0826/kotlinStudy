# 동시성 프로그래밍

- 동기적 수행
  - 순서대로 작업을 수행하여 하나의 루틴을 완료한 후 다른 루틴을 실행하는 방식
  - 다양한 기능이 한꺼번에 일어나는 다중 실행 환경에선느 성능상의 제약 발생
- 비동기적 수행
  - 다양한 기능을 동시에 수행
  - RxJava, Reactive 와 같은 서드파티 라이브러리에서 제공
  - 코틀린에서는 코루틴을 기본으로 제공

## 코루틴

- 코루틴을 사용하면 넌블로킹 또는 비동기 코들르 마치 일반적인 동기 코드처럼 쉽게 잓어하면서도 비동기 효과를 낼 수 있다.

## 프로세스와 스레드

- 프로세스
  - 프로그램이 메모리(RAM)에 올라가서 run중인 상태
- 스레드(태스크)
  - 프로세스 내부에서 돌고있는 흐름
  - 프로세스는 실행되는 메모리, 스택, 파일등을 포함하여 프로세스간 context switching 교환 비용이 큼
  - 스레드는 자신의 스택만 독립적으로 가지고 나머지는 대부분 공유, 문맥 교환 비용이 낮아 프로그래밍에서 많이 사용
    - 스레드 구성이 많아지면 코드가 복잡해진다.

### 문맥교환

- 하나의 프로세스나 스레드가 CPU를 사용하고 있는 상태에서 다른 프로세스나 스레드가 CPU를 사용하도록 하기 위해 이전의 프로세스 상태를 보고나하고 새로운 프로세스의 상태를 적재하는 과정

## 스레드 사용하기

### 생성 방법

- class
  - Thread 클래스를 상속
- interface
  - Runnable 인터페이스를 상속
- 익명 객체
  - object 키워드를 사용
- 람다식
  - 람다식에서 사용

### 스레드풀 사용하기

- 자주 재사용되는 스레드를 이용하기 위해 미리 생성된 스레드풀에서 스레드 이용
- `val myService:ExecutorService = Executors.newFixedThreadPool([numbers])`

## 코루틴 개념

- 스레드와 달리 코루틴을 통해서 복잡성을 줄이고 손쉽게 일시 중단하거나 다시 시작하는 루틴을 만들어낼 수 있다.
- 멀티태스킹을 실현하면서 가벼운 스레드라고도 불림
- 코루틴은 문맥 교환 없이 해당 루틴을 일시 중단을 통해 제어
- 스레드 내부의 여러 루틴(routine)이 협력한다(co)

### kotlinx.coroutines 의 common 패키지

- launch / async
  - coutine builder
- job / deferred
  - cancellation 지원
- dispatchers
  - default, main, io ...
  - 디스패쳐에 따라 코루틴을 구성
- delay / yield
  - 상위 레벨 지연 함수
- channel / mutex
  - 통신과 동기화를 위한 기능
- coroutineScope / supervisorScope
  - 범위 빌더
- select
  - 표현식 지원
- commonPool
  - 코루틴 컨텍스트
- produce / actor
  - 코루틴 빌더

### 코루틴 빌더

- launch
  - 실행하고 잊어버리는 형태의 코루틴
  - 메인 프로그램과 독립되 실행할 수 있다
  - 기본적으로 즉시 실행, 실행 결과는 반환하지 않음
  - Job객체를 반환, 상위 코드를 블록시키지 않음
  - join을 통해 상위 코드가 종료되지않고 완료를 기다리게할 수 있다
- async
  - 비동기 호출을 위해 만든 코루틴, 결과나 예외를 반환
  - Deffered\<T>를 통해 반환, await을 통해 받을 수 있다
  - 작업을 완료할때까지 대기
- suspend
  - 일시정지
  - 코루틴 블록외에 사용하면 오류가 난다
  - suspend가 붙은 함수는 컴파일러가 자동적으로 추출해 Continuation 클래스로부터 분리된 루틴을 만든다
  - 코루틴 빌더인 launch와 async에서 이용할 수 있다

### Job

- Job 객체
  - 코루틴의 생명주기를 관리, 부모-자식 같은 관계를 가질 수 있다
- Job 규칙
  - 부모가 취소되거나 실패하면 하위 자식들은 모두 취소
  - 자식의 실패는 부모에 전달되면 부모또한 취소 > 다른 모든 자식들도 취소
- SupervisorJob
  - 자식의 실패가 부모나 다른 자식에 전달되지 않으므로 실행 유지
- join() 결과 기다리기
  - Job객체의 join()을 사용해 완료를 기다릴 수 있다.
  - launch에서 반환 값을 받으면 Job 객체가 되기 때문에 이것을 이용해 main 메서드에서 join을 호출할 수 있다
- Job의 상태
  - new
  - active
    - 기본값 상태
  - completing
    - join을 이용해서 기다릴 수 있음
    - 부모와 다른 자식들의 작업을 기다림
  - cancelling
  - cancelled
    - 최종 상태
  - completed
    - 최종 상태

### 코루틴의 중단과 취소

- 중단
  - delay([timevalue])
    - 일정 시간을 지연하며 중단
    - Thread.sleep()
  - yield()
    - 특정 값을 산출하기 위해 중단
- 취소
  - Job.cancel()
    - 지정된 코루틴 작업을 즉시 취소
  - Job.cancelAndJoin()
    - 지정된 코루틴 작업을 취소(완료시까지 대기)
- 기본적으로 부모 자식 관계에 적용, 부모 블록이 취소되면 모든 자식 작업이 취소

### async coroutine builder

- launch와 다른 점은 Deffered\<T>를 통해 결과값을 반환
- 지연된 결과 값을 받기 위해 await()을 사용

### coroutine context

- 코루틴을 실행하기 위한 다양한 설정값을 가진 정보
  - 이름, 디스패처, 상세사항, 예외 핸들러
- 디스패처는 문맥을 보고 어떤 스레드에서 실행되고 있는지 식별이 가능해진다
- 코루틴 문맥은 + 연사을 통해 조합될 수 있다.
- CoroutineName
  - 코루틴에 이름을 주며 디버깅에 사용
- Job
  - 작업 객체를 지정할 수 있으며 취소가능 여부에따라 SupervisonJob 사용
- CoroutineDispatcher
  - Dispatchers.Default, ...IO, 등을 지정할 수 있으며 필요에 따라 스레드 생성 가능
- CoroutineExceptionHandler
  - 코루틴 문맥을 위한 예외처리 담당
  - 코루틴에서 예외가 던져지면 처리
  - 상위 코루틴에 전달되어 처리
  - 예외처리가 자식에만 있고 부모에 없으면 부모에 예외가 전달되므로 주의
    - crash
  - 예외가 다중으로 발생하면 최초 하나만 처리하고 나머지 무시

### coroutine scope

- global scope
  - 독립형 코루틴을 생성
  - 생명주기는 프로그램 전체에 해당하는 범위를 가지며 main 생명 주기가 끝나면 같이 종료
  - Dispatchers.Unconfined와 함께 작업이 서로 무관한 전역 범위 실행
  - 보통 GlobalScope 상에서는 launch나 async 사용이 권장되지 않음
- coroutine scope
  - 특정 목적의 디스패처를 지정한 범위를 블록으로 구성할 수 있다
  - 모든 코루틴 빌더는 CoroutneScope의 인스턴스를 갖는다
  - launch 와 같이 인자가 없는 경우 defulat 사용
    - coroutine scope에서 상위의 문맥이 상속되어 결정
  - launch(Dispatcher.options) 와 같이 디스패처의 스케줄러 지정가능

### Thread Pool

- 보통 CommonPool이 지정되어 코루틴이 사용할 스레드의 공동 풀을 사용
- 이미 초기화되어있는 스레드 중 하나 혹은 그 이상이 선택되며 초기화하기 떄문에 스레드를 생성하는 오버헤드가 없어 빠름
- 하나의 스레드에 다수의 코루틴이 동작할 수 있다

### 빌더의 특정 속성 지정

- launch의 원형

```kotlin
public fun launch(
  context: CoroutineContext,
  start: CoroutineStart,
  parent: Job?,
  onCompletion: CompletionHandler?,
  block: suspend CoroutineScope.() -> Unit): Job {...}
)
```

- CoroutineStart
  - DEFAULT: 즉시 시작(문맥에 따라 즉시 스케줄링)
  - LAZY: 코루틴을 느리게 시작(처음에는 중단된 상태, start(), await()으로 시작)
  - ATOMIC: 원자적으로 즉시 시작(DEFAULT 와 비슷, 코루틴 실행전에는 취소 불가)
  - UNDISPATCHED: 현재 스레드에서 즉시 시작(첫 지연함수까지, 이후 재개시 디스패치)

### 완료를 기다리기 위한 블로킹

- runBlocking의 사용
  - 새로운 코루틴을 실행하고 완료되기 전까지는 현재 스레드를 블로킹
  - 코루틴 빌더와 마찬가지로 CoroutineScope의 인스턴스를 가짐
- withContext()를 사용하면 특정 문맥과 함께 실행
  - 인자로 코루틴 문맥을 지정, 해당 문맥에 따라 코드 블록 실행
  - 다른 스레드에서 수행되며 결과를 반환
  - 부모 스레드는 블록하지 않는다
- 완료보장
  - `withContext(NonCancellable)`
  - `try .. catch .. finally` 블록의 finally실행을 보장하기 위해 취소불가 블록구성

### ScopeBuilder

- coroutineScope 빌더
  - 자신만의 코루틴 스코프를 선언하고 생성
  - 몯느 자식이 완료되기 전까지는 생성된 코루틴 스코프는 종료되지 않음
  - runBlocking과 유사, runBlocking은 단순 함수로 현재 스레드를 블로킹
  - coroutineScope는 다순히 지연함수 형태로 넌블로킹으로 사용
  - 자식 코루틴이 실패하면 이 스코프도 실패하고 남은 모든 자식은 취소(cancel)
    - supervisorScope는 취소되지 않음
    - 외부에 의해 작업이 취소되는 경우 CancellationException 발생

### 범위 빌더

- supervisorScope 빌더
  - 마찬가지로 코루틴 스코프를 생성, SupervisorJob과 함께 생성하여 기존 문맥의 Job을 오버라이드
  - launch를 사용해 생성한 작업의 실패는 CoroutineExceptionsHandler를 통해 핸들링
  - async를 사용해 생성한 작업의 실패는 Deffered.await의 결과에 따라 핸들링
  - parent를 통해 부모작업이 지정되면 자식작업이 되며 이떄 부모에 따라 취소 여부 결정
- 자식이 실패하더라도 이 스코프는 영향을 받지 않으므로 실패하지 않음
  - 실패를 핸드링하는 정책을 구현할 수 있다
- 예외나 의도적인 취소에의해 이 스코프의 자식들을 취소하지만 부모의 작업은 취소하지 않음

### 부모와 자식 코루틴과의 관계

- 병렬 분해
  - 1번 작업이 네트워크 불안정 등으로 취소된다면?
  - async에 대한 코루틴 빌더를 묶는다(coroutineScope)
    - 둘중 하나가 취소되면 coroutineScope에 전달되어 다른 자식들이 취소됨
    - 구조화 된 코루틴

### 스코프 취소와 예외처리

- scope.cancel()
- scope.cancelChildren()

### 코루틴의 실행 시간 지정

- 실행시간 제한
- withTimeout([timevalue]) { ... }
  - 시간동안만 수행되고 블록 종료
  - TimeoutCancellationException 예외 발생
- withTimeoutOrNull([timevalue]) { ... }
  - 예외 없이 null 반환
