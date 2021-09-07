package com.example.kotlin_intermedio

class MyNestedAndInnerClass {
    //Clase Anidada-->Una clase con otra adentro
    private val one=1
    private fun returnOne():Int{
        return one
    }
    class myNestedClass{
        fun sum(first:Int , second:Int):Int{
            return first+second
        }
    }
    //Clase interna(Inner class)
    inner class myInnerclass{

        fun sumTwo(number: Int):Int{
            return number+one+returnOne()

        }
    }
}