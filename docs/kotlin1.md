# kotlin 1장

## 1.1

- kotlin/jvm
  - 자바 가상 머신 상에서 동작하는 앱 만들 수 있음
    - android
- kotlin/js
  - 웹 앱으로서 동작시킬 수 있음
- kotlin/native
  - 특정 기계에 맞춰진 코드를 만들어냄 (native)
  - 우리가 사용하는 cpu기반 (arm, x86)
  - 특정 중간코드 llvm 기반의 네이티브 컴파일을 지원 (여러가지 기반 환경 지원)
  - 멀티 플랫폼용 코드
  - 타깃
    - ios (arm32, arm64, emulator x86_64)
    - mac os (x86_64)
    - android (arm32, arm64)
    - windows (mingw x86_64)
    - linux (x86_64, arm32, mips, mips little endian)
    - webAssembly (wasm32)
- kotlin의 장점
  - statically typed
    - 정적 형식
      - 정적타입 언어
      - 컴파일러가 타입을 검증해준다.
    - 대부분의 스크립트 언어는 interpreter가 타입 검증
      - 동적타입 언어
      - 런타임에 타입을 검증
  - nullpointer로 인한 프로그램의 중단을 예방할 수 있다.(NPE에서 자유로움)
  - null이 가능한 형식, 불가능한 형식 지원
    - `?`을 붙여서 nullable로 만들 수 있음
  - JAVA와 완벽하게 상호운영이 가능하다.
    - kotlin은 jvm상에서 돌기 때문
  - 간결하고 효율적으로 작성이 가능
  - 함수형 프로그래밍 / 객체지향 프로그래밍 모두 가능
  - 세미콜론 생략 가능

## 1.3

- main, tab키를 이용하여 main 함수 생성
- main 함수는 kotlin 파일의 진입점
- maina로 정의할 경우 args를 받을 수 있다.
  - args가 없는 경우 컴파일 에러
  - 배열 인덱스 접근으로 arg를 읽어올 수 있다.
- decompile된 소스 확인이 가능
- ctrl + b (cmd + b) 로 메서드흐름을 따라갈 수 있음
