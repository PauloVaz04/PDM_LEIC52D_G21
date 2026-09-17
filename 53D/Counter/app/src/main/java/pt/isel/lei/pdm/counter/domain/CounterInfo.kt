package pt.isel.lei.pdm.counter.domain

data class CounterInfo(
    val counter: Int
) {

}

fun CounterInfo.increment(): CounterInfo {
    return CounterInfo(counter + 1)
}


