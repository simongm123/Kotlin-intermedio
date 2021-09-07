package com.example.kotlin_intermedio

class Visibility {
    //Funciones y variables publicas
    //Pueden ser accedidas desde cualquier parte del código

    var name:String?= null
    fun sayMyName(){
        name?.let {
            println("Mi nombre es $it")
        }?:run{
            println("No tengo nombre")
        }

    }

}

// Las funciones y las clases privadas sólo
// pueden ser accedidas desde el mismo fichero o archivo
