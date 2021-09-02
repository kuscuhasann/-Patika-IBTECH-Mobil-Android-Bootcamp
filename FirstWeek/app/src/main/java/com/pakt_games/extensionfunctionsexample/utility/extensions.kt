package com.pakt_games.extensionfunctionsexample.utility

fun Array<Int>.reverseAfterSelectedIndex(startsOfIndex:Int=0)
{
    var arraySize:Int =this.size-1
    var startedValue:Int=startsOfIndex



    while (startedValue < arraySize) {
        var temp = this[startedValue]
        this[startedValue] = this[arraySize]
        this[arraySize] = temp
        startedValue = startedValue + 1
        arraySize = arraySize - 1
    }
}