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

## Map

- key, value로 구성된 요소를 저장
- 키는 중복될 수 없으나, value는 중복 가능
- mapOf(), mutableMapOf()
- `mapOf(key to value)`
- `for((key, value) in map)`
- `[]`으로 key에 접근가능하다
- keys
  - 모든 키 반환
- values
  - 모든 값 반환
- put
  - 맵에 추가
- remove
  - 키에 해당하는 요소 제거
- putAll
- clear
- hashMap, sortedMap, linkedHashMap
- sortedMap의 경우 key를 기준으로 정렬

## 컬렉션의 확장 함수

- 확장 함수 범주
  - 연산자(operators)
  - 집계(aggregators)
  - 검사(checks)
  - 필터(filtering)
  - 변환(transformers)

### 요소의 처리와 집계에 대한 연산

- forEach, forEachIndexed, onEach, count, max, min, maxBy, minBy, fold, reduce, sumBy
- forEach
  - 각 요소를 람다식으로 처리한 후 컬렉션을 반환하지 않음
- onEach
  - 각 요소를 람다식으로 처리한 후 컬렉션으로 반환
- fold (foldRight)
  - 초기값과 정해진 식에 따라 처음부터 끝까지 적용해 값 반환
- reduce (reduceRight)
  - fold와 동일하나 초기값을 사용하지 않음

## 매핑관련 연산

- map()
  - 일괄적으로 모든 요소에 식을 적용해 **새로운** 컬렉션을 만듬
- flatMap()
  - 각 요소에 식을 적용한 후 하나로 합쳐 새로운 컬렉션 반환
- groupBy()
  - 주어진 식에 따라 그루화하고 Map으로 반환

### 요소 관련 연산

- element 관련 연산
- elementAt, elementAtOrElse, elementAtOrNull

### 순서와 정렬 연산

- reversed, sorted, sortedDescending, sortedBy, sortedDescendingBy

### 시퀀스

- sequence
  - 요소의 크기를 특정하지 않고 추후에 결정하는 특수한 컬렉션
  - 특정 파일에서 줄 단위로 읽어서 요소를 만들 떄
- generateSequence
  - seed 에 의해 시작 요소의 값이 결정
  - take()를 사용해 원하는 요소 개수만큼 획득
  - toList를 사용해 List컬렉션으로 변환
- asSequence()
  - 중간 연산 결과 없이 한 번에 끝까지 연산한 후 결과를 반환
  - 요소 개수가 많을경우 asSequence를 사용해서 메서드 체이닝을 처리하자
