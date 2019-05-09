package com.example.xiandu

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        fishExamples()
    }

}

fun  fishExamples(){
    val fish = Fish("splashy")
    myWith("name"){
        capitalize()
    }
    println(fish.name)
}
data class  Fish(var name:String)
fun myWith(name:String,block:String.() -> Unit){
    name.block()
}




