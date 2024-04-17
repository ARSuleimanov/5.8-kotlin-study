package ru.sar.l1

public object NewsList {
    public val news = arrayOf(
        News("Тигр проглотил мяч", "Elvis","Самое странное событие произошло вчера в Лондонском зоопарке, на рассвете тигр взял и слопал мяч у молодой посетительницы. В отличие от мяча, девочка не пострадала" ),
        News("Заголовок 2", "Автор 2", "Содержание новости 2"),
        News("Заголовок 3", "Автор 3", "Содержание новости 3"),
        News("Заголовок 4", "Автор 4", "Содержание новости 4"),
        News("Заголовок 5", "Автор 5", "Содержание новости 5"),
        News("Заголовок 6", "Автор 6", "Содержание новости 6"),
        News("Заголовок 7", "Автор 7", "Содержание новости 7"),
        News("Заголовок 8", "Автор 8", "Содержание новости 8"),
        News("Заголовок 9", "Автор 9", "Содержание новости 9"),
        News("Заголовок 10", "Автор 10", "Содержание новости 10")
    )
    val forwardStack  = mutableListOf<Int>()
    class IntStack {
        private val stack = mutableListOf<Int>()

        // Добавление элемента в стек
        fun push(element: Int) {
            stack.add(element)
        }

        // Удаление и возврат последнего добавленного элемента из стека
        fun pop(): Int? {
            if (stack.isNotEmpty()) {
                return stack.removeAt(stack.size - 1)
            }
            return null
        }

        // Проверка, пуст ли стек
        fun isEmpty(): Boolean {
            return stack.isEmpty()
        }

        // Получение размера стека
        fun size(): Int {
            return stack.size
        }
    }
}