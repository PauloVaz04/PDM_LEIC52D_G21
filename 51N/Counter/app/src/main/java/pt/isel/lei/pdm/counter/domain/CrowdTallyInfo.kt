package pt.isel.lei.pdm.counter.domain

data class CrowdTallyInfo(
    val count: Int
)

fun CrowdTallyInfo.increment() = CrowdTallyInfo(count + 1)
fun CrowdTallyInfo.decrement() = CrowdTallyInfo(Math.max(0, count - 1))
