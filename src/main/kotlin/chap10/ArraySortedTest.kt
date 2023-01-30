package chap10

fun main() {
    val arr = arrayOf(8,4,3,2,5,9,1)

    val sortedArr = arr.sortedArray()
    println(sortedArr.contentToString())

    val sortedArrDesc = arr.sortedArrayDescending()
    println(sortedArrDesc.contentToString())

    // 부분적으로 정렬을 시도할 수 있음
    arr.sort(1, 3)
    println(arr.contentToString())

    arr.sortDescending()
    println(arr.contentToString())

    // List로 변환
    val listSorted: List<Int> = arr.sorted()
    val listDesc: List<Int> = arr.sortedDescending()
    println(listSorted.toString())
    println(listDesc.toString())

    // sortby를 사용한 특정 표현식에 따른 정렬
    val items = arrayOf<String> ("Dog", "cat", "lion", "kangaroo", "po")
    items.sortBy { item -> item.length }
    println(items.contentToString())
}