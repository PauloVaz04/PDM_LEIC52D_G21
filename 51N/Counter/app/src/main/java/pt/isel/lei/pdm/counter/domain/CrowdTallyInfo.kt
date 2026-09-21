package pt.isel.lei.pdm.counter.domain

data class CrowdTallyInfo(
    val count: Int,
    val capacity: Int,
) {
    init {
        require(capacity >= 0){
            "capacity can't be negative"
        }
    }

    val canDecrement
        get() = count > 0
    val canIncrement
        get() = capacity > count
}

fun CrowdTallyInfo.increment() =
    if (canIncrement)
        this.copy(count = count + 1)
    else
        this

fun CrowdTallyInfo.decrement() =
    if (canDecrement)
        this.copy(count = count - 1)
    else this

fun CrowdTallyInfo.changeCapacity(newCap: Int) =
    this.copy(capacity = newCap, count = Math.min(newCap, count))



