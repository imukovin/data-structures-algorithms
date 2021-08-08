import kotlin.math.sqrt

private const val ARRAY_SIZE = 10
private const val MAX_ARRAY_VALUE = 100

fun main() {
    // Создание массива
    val masForBubble = initArray()
    val masForSelection = initArray()

    printMas("For bubble sort mas: ", masForBubble)
    printMas("For selection sort mas: ", masForSelection)
    println("========================Sort results===============================")

    // Сортировка пузырьком
    bubbleSort(masForBubble)
    printMas("Bubble sort: ", masForBubble)

    // Сортировка выбором
    selectionSort(masForSelection)
    printMas("Selection sort: ", masForSelection)

    println("========================Search results===============================")
    // Бинарный поиск
    val value = 125
    val pos = binarySearch(masForBubble, value)
    println("Binary search: value $value; pos $pos")

    // Jump Search
    val valueJ = masForBubble[5]
    val posJ = jumpSearch(masForBubble, valueJ)
    println("Jump search: value $valueJ; pos $posJ")
}

private fun initArray(): Array<Int> = Array(ARRAY_SIZE) { (0..MAX_ARRAY_VALUE).random() }

private fun bubbleSort(mas: Array<Int>) {
    for (i in (mas.size - 1) downTo  0) {
        for (j in 0 until i) {
            if (mas[j] > mas[j + 1]) {
                val a = mas[j]
                mas[j] = mas[j + 1]
                mas[j + 1] = a
            }
        }
    }
}

private fun selectionSort(mas: Array<Int>) {
    for (i in (0..mas.size - 2)) {
        var minInd = i
        for (j in i..mas.size - 1) {
            if (mas[minInd] > mas[j]) {
                minInd = j
            }
        }
        val value = mas[i]
        mas[i] = mas[minInd]
        mas[minInd] = value
    }
}

private fun binarySearch(mas: Array<Int>, value: Int): Int {
    var position = mas.size / 2 // Текущая позиция для сравнения
    var first = 0 // Граничная позиция элемента слева
    var last = mas.size - 1 // Граничная позиция элемента справа
    while ((mas[position] != value) && (first <= last)) {
        if (mas[position] < value) {
            first = position + 1
        } else if (mas[position] > value) {
            last = position - 1
        }
        position = (first + last) / 2
    }
    return if (first > last) -1 else position
}

private fun jumpSearch(mas: Array<Int>, value: Int): Int {
    val step: Int = sqrt(mas.size.toDouble()).toInt()
    var i = 0
    while (i < mas.size && mas[i] <= value) {
        i += step
    }
    if (i > mas.size) {
        return -1
    }
    var position = 0
    for (j in (i - step)..i) {
        if (mas[j] == value) {
            position = j
            break
        }
    }
    return position
}

private fun printMas(text: String, mas: Array<Int>) {
    print(text)
    mas.forEach {
        print("$it ")
    }
    println()
}