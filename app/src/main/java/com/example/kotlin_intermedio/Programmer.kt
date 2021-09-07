package com.example.kotlin_intermedio

class Programmer(name:String,age:Int,val language:String):Person(name,age),Vehicle {
    override fun work() {
        //super.work() //hace lo mismo qué la función original
        println("Está persona está programando")
    }
    fun sayLanguage(){
        println("Esté programador usa el lenguaje $language")
    }

    override fun drive() {
        println("Está persona conduce un coche")
    }
}