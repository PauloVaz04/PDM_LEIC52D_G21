package pt.isel.lei.pdm.counter.domain

data class CrowdTallyInfoMutable(
    var counter: Int
) {

}

fun CrowdTallyInfoMutable.increment() {
    counter++
}

fun CrowdTallyInfoMutable.decrement() {
    counter--
}