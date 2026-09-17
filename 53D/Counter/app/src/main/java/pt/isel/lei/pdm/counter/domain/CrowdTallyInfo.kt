package pt.isel.lei.pdm.counter.domain

data class CrowdTallyInfo(
    val counter: Int
) {

}

fun CrowdTallyInfo.increment() = CrowdTallyInfo(counter + 1)
fun CrowdTallyInfo.decrement() = CrowdTallyInfo(counter - 1)
