package pt.isel.lei.pdm.counter.domain

data class CounterModel2(
    var counter: Int
)


fun CounterModel2.increment() {
    counter++
}