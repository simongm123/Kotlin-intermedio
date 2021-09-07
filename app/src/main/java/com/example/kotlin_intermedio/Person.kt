package com.example.kotlin_intermedio

open class Person(name:String,age:Int):Work(),  Game{
    //Cualquiar clase tiene una superclase común "Any"
    open fun work(){
        println("Esta persona está trabajando")
    }
    override fun goToWork(){
        println("Esta persona va al trabajo_abstract")
    }

    override fun saluda() {
        println("toda persona debe poder saludar gracias a abstract")
    }
    //GAME INTERFACE
    override val game: String
        get() = "Among us"

    override fun play() {
        println("Está persona está jugando $game")
    }
}