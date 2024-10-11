
fun main() {


    var running = true
    val toDoFunctions = ToDo()

    fun addfunc(value: String?) {
        if (value != null) {
            toDoFunctions.add(value)
        } else {
            println("You need to add a value.")
        }
    }
    fun removefunc(value: String?) {
        if (value != null) {
            val indexValue = value.toIntOrNull()

            if (indexValue != null) {
                toDoFunctions.remove(indexValue)
            }
        } else {
            println("You need to add a value.")
        }
    }
    fun completefunc(value: String?) {
        if (value != null) {
            val indexValue = value.toIntOrNull()

            if (indexValue != null) {
                toDoFunctions.complete(indexValue)
            }
        } else {
            println("You need to add a value.")
        }
    }
    fun incompletefunc(value: String?) {
        if (value != null) {
            val indexValue = value.toIntOrNull()

            if (indexValue != null) {
                toDoFunctions.incomplete(indexValue)
            }
        } else {
            println("You need to add a value.")
        }
    }

    while (running){

        val input = readLine() ?: ""
        val splittedInput = input.split(" ", limit = 2)
        val keyword = splittedInput.getOrNull(0)
        val value = splittedInput.getOrNull(1)

        when (keyword) {
            "add" -> {
                addfunc(value)
            }
            "remove" -> {
                removefunc(value)
            }
            "list" -> {
                toDoFunctions.list()
            }
            "complete" -> {
                completefunc(value)
            }
            "incomplete" -> {
                incompletefunc(value)
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
    private data class Task(val value: String, var status: String)

    private val list: MutableList<Task> = mutableListOf()
    private val completed = "completed"
    private val incompleted = "incomplete"

    fun add(value: String) {
        list.add(Task(value, incompleted))
        println("Added $value to your list.")
    }

    fun remove(value: Int) {
        val index = value -1

        if(index in list.indices) {
            println("Removed ${list[index].value} from your list.")
            list.removeAt(index)
        } else {
            println("The index number $value does not exist.")
        }
    }

    fun list() {
        if (list.isEmpty()) {
            println("No existing exercises.")
        } else {
            list.forEachIndexed {
                index, task -> println("${index + 1}. ${task.value} [${task.status}]")
            }
        }
    }

    fun complete(value: Int) {
        val index = value - 1

        if(index in list.indices) {
            list[index].status = completed
            println("Set the status of ${list[index].value} to ${list[index].status}")
        } else {
            println("The index number $value does not exist.")
        }
    }
    fun incomplete(value: Int) {
        val index = value - 1

        if(index in list.indices) {
            list[index].status = incompleted
            println("Set the status of ${list[index].value} to ${list[index].status}")
        } else {
            println("The index number $value does not exist.")
        }
    }
}