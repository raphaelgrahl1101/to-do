
fun main() {


    var running = true
    val toDoFunctions = ToDo()

    while (running){

        val input = readLine() ?: ""
        val splittedInput = input.split(" ", limit = 2)
        val keyword = splittedInput.getOrNull(0)
        val value = splittedInput.getOrNull(1)

        when (keyword) {
            "add" -> {
                if (value != null) {
                    toDoFunctions.add(value)
                } else {
                    println("You need to add a value.")
                }
            }
            "remove" -> {
                if (value != null) {
                    val indexValue = value.toIntOrNull()

                    if (indexValue != null) {
                        toDoFunctions.remove(indexValue)
                    }
                } else {
                    println("You need to add a value.")
                }
            }
            "list" -> {
                toDoFunctions.list()
            }
            "complete" -> {
                if (value != null) {
                    val indexValue = value.toIntOrNull()

                    if (indexValue != null) {
                        toDoFunctions.complete(indexValue)
                    }
                } else {
                    println("You need to add a value.")
                }
            }
            "incomplete" -> {
                if (value != null) {
                    val indexValue = value.toIntOrNull()

                    if (indexValue != null) {
                        toDoFunctions.incomplete(indexValue)
                    }
                } else {
                    println("You need to add a value.")
                }
            }
            "exit" -> {
                running = false
            } else -> {
            println("This is no valid command.")
        }
        }
    }

}

class ToDo() {
    val list: MutableList<String> = mutableListOf()
    val completeList: MutableList<String> = mutableListOf()
    val completed = "completed"
    val incompleted = "incomplete"

    fun add(value: String) {
        completeList.add(incompleted)
        list.add(value)
        println("Added $value to your list.")
    }

    fun remove(value: Int) {
        val index = value - 1
        if(index in 0 until list.size) {
            val removedItem = list.removeAt(index)
            val removedStatus = completeList.removeAt(index)
            println("Removed $removedItem from your list.")
        } else {
            println("The index number $value does not exist.")
        }
    }

    fun list() {
        var index = 0
        if (list.isEmpty()) {
            println("No existing exercises.")
        } else {
            for (item in list) {
                println("${list.indexOf(item) + 1}. $item [${completeList[index]}]")
                index++
            }
        }
    }

    fun complete(value: Int) {
        val index = value - 1

        if(index in 0 until list.size && index in 0 until completeList.size) {
            completeList[index] = completed
            println("Set the status of ${list[index]} to ${completeList[index]}")
        } else {
            println("The index number $value does not exist.")
        }
    }
    fun incomplete(value: Int) {
        val index = value - 1

        if(index in 0 until list.size && index in 0 until completeList.size) {
            completeList[index] = incompleted
            println("Set the status of ${list[index]} to ${completeList[index]}")
        } else {
            println("The index number $value does not exist.")
        }
    }
}