package com.example.kotlin_intermedio

interface Game {
    val game:String
    fun play() //Es abstracta ya qué sólo se puede usar mediante una clase
    fun stream(){
        println("Estoy haciendo stream de mi juego $game")
    }
}