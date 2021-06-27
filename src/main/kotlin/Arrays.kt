private const val ARRAY_SIZE = 10
private const val MAX_ARRAY_VALUE = 100

fun main() {
    // Создание массива
    val mas = initArray()
    mas.forEach {
        print("$it ")
    }
    println()

    // Сортировка пузырьком
    bubbleSort(mas)
    mas.forEach {
        print("$it ")
    }
    println()

    // Бинарный поиск
    val value = 125
    val pos = binarySearch(mas, value)
    println("Binary search: value $value; pos: $pos")
}

private fun initArray(): Array<Int> = Array(ARRAY_SIZE) { (0..MAX_ARRAY_VALUE).random() }

private fun bubbleSort(mas: Array<Int>) {
    for (i in 0..mas.size - 1) {
        for (j in i..mas.size - 1) {
            if (mas[i] > mas[j]) {
                mas[i] = mas[i] + mas[j]
                mas[j] = mas[i] - mas[j]
                mas[i] = mas[i] - mas[j]
            }
        }
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