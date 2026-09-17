package pt.isel.lei.pdm.counter.domain


data class CounterInfo2(
    var counter: Int
) {
    fun incremenmt() {
        counter++
    }
}