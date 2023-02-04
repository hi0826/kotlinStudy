# 컬렉션

- 자주 사용되는 기초적인 자료구조를 모아놓은 프레임워크
- 자바와는 다르게 불변형과 가변형으로 나눠서 다룰 수 있다.
- List, Set, Map

## 컬렉션 인터페이스

- 코틀린 컬렉션
- 다이어그램의 가장 상위의 Iterable 인터페이스는 컬렉션이 연속적인 요소를 표현할 수 있게 한다
  - MutableIterable
  - Collection

## Collection Interface

- Iterable로부터 확장
- 불변형이므로 Collection으로부터 확장된 Set, List는 읽기 전용의 컬렉션
- member
  - size
  - isEmpty
  - contains
  - containsAll

## MutableIterable, ButableCollection Interface

- 가변형 컬렉션을 지원
- 요소를 추가, 제거등의 기능 수행
- add, remove, addAll, removeAll, retainAll, clear

## List

- 순서에따라 정렬된 요소를 가지는 컬렉션
- listOf
  - 불변형
- mutableListOf
  - 가변형
- 원하는 만큼의 가변 인자를 가지도록 vararg로 선언 가능
- 헬퍼함수
  - 객체 생성시 직접 선언하기보다 특정 함수의 도움을 받음

### 불변형 List 생성

- `public fun <T> listOf(vararg elements: T): List<T>`

## 컬렉션에 접근하기

- for, .indices 멤버를 통한 접근
- indices 를 사용하면 index에 접근할 수 있다

## 기타 list 생성 함수

- emptyList()
  - 빈 리스트
- listOfNotNull()
  - null을 제외한 요소만 반환

## List 추가 멤버 메서드 사용

- get
  - 특정 인덱스를 받아 해당 요소 반환
- indexOf
  - 인자로 받은 요소가 첫 번쨰로 나타나는 인덱스 반환 없으면 -1
- lastIndexOf
  - 인자로 받은 요소가 마지막으로 나타나는 인덱스 반환 없으면 -1
- listIterator
  - 목록에 있는 iterator반환
- subList
  - from ~ to에 있는 요소 리스트 반환

## 가변형 list 생성

- arrayListOf()
  - 가변형 헬퍼 함수를 사용하면 손쉽게 요소를 추가하거나 삭제 가능
  - 가변형 리스트를 생성하지만 반환 자료형은 ArrayList
- mutableListOf()
  - 반환형 MutableList\<T>

## List와 배열의 차이

- Array 클래스는 내부 구조상 고정된 크기
  - 무변성
- List, MutableList는 인터페이스로 설계, 이것을 하위 자료구조로 구현
  - 공변성

## set

- 정해진 순서가 없는 요소들의 집합
- 동일한 요소를 중복해서 가질 수 없다
  - 중복된 데이터는 하나로 취급함
- setOf, mutableSetOf 사용하여 생성

### hashSetOf()

- 해시 테이블에 요소를 저장할 수 있는 HashSet
- 해시값을 통해 요소를 결정하므로 bigO(1)의 탐색시간
- 순서가 없어 정렬은 불가능

### TreeSet

- sortedSetOf()
- 저장된 데이터의 값에 따라 정렬
- 이진 탐색 트리(RB Tree) 알고리즘 사용
- HashSet보다 성능이 떨어지고 데이터를 추가하거나 삭제하는데 시간이 걸리지만 검색과 정렬이 뛰어나다

### LinkedHashSet

- linkedSetOf()
- 링크드 리스트를 사용해 구현된 해시 테이블
- HashSet, TreeSet보다 느리지만, 데이터 구조상 포인터 연결을 통해 메모리를 효율적으로 사용함
