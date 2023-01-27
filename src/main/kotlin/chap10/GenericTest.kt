package chap10

open class Parent

class Child: Parent()

class Cup<T>

fun main() {
    // 다운 캐스팅은 안됨
    // val obj1: Child = Parent()
    val obj2: Parent = Child()

    // 타입 미스매칭
    // 형식 매개변수는 업/다운 캐스팅에 대해 관련이 없음
    // in, out 을 사용
    // val obj3: Cup<Child> = Cup<Parent>()
    // val obj4: Cup<Parent> = Cup<Child>()

}