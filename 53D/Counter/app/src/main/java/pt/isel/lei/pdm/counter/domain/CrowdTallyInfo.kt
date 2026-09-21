package pt.isel.lei.pdm.counter.domain

import androidx.compose.runtime.retain.retain


data class CrowdTallyInfo(
    val counter: Int,
    val maxCounter: Int
) {
    init {
        require(maxCounter > 0)
    }

    val canDecrement
        get() = counter > 0
    val canIncrement
        get() = counter < maxCounter
}

fun CrowdTallyInfo.increment() =
    if (canIncrement)
        CrowdTallyInfo(counter + 1, maxCounter)
    else
        this


fun CrowdTallyInfo.decrement() =
    if (canDecrement)
        CrowdTallyInfo(counter - 1, maxCounter)
    else
        this

fun CrowdTallyInfo.changeMax(newMax: Int): CrowdTallyInfo {
    if (newMax < 0)
        throw IllegalStateException("newMax can't be negative")

    return this.copy(maxCounter = newMax, counter = Math.min(newMax, counter))
}