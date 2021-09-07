package com.example.kotlin_intermedio
import java.text.SimpleDateFormat
import java.util.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.net.Proxy
import kotlin.collections.ArrayList
import kotlin.reflect.typeOf
typealias MyMapList=MutableMap<Int,ArrayList<String>>
typealias MyFun=(Int,String,MyMapList)->Boolean
typealias MyNestedClass= MyNestedAndInnerClass.myNestedClass

const val EXTRA_MESSAGE = "com.example.kotlin_intermedio.MESSAGE"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //clasesEnum()
        //  Clases anidades e internas
        //nestedAndInnerClasses()
        //Herencia de clases
        //classInheritance()
        //interfaces()
        //Visibility modifiers
        //visibilityModifiers()
        //Data clases
        //dataClasses()
        //typeAliases()
        //destructuringDeclarations()
        //extensions()
        lamdas()


    }

    enum class direcciones(var dir: Int) {
        NORTH(1), SOUTH(-1), EAST(2), WEST(-2);

        fun description(): String {
            return when (this) {
                NORTH -> "LA DIRECCIÓN ES NORTE"
                EAST -> "LA DIRECCIÓN ES ESTE"
                SOUTH -> "LA DIRECCIÓN ES SUR"
                WEST -> "LA DIRECCIÓN ES OCCIDENTE"
            }

        }

    }

    private fun clasesEnum() {
        var userDirection: direcciones? = null
        println("Direccion:$userDirection")
        userDirection = direcciones.EAST
        println("Direccion:$userDirection")
        println("Nombre:${userDirection.name}")
        println("Nombre:${userDirection.ordinal}")
        println(userDirection.description())
        println(userDirection.dir)
    }

    private fun nestedAndInnerClasses() {
        //Clase anidada
        val myNestedClass = MyNestedAndInnerClass.myNestedClass()
        var sum = myNestedClass.sum(10, 5)
        println("El resultadoe de la suma es $sum")
        //clase interna
        val myInnerClass: MyNestedAndInnerClass.myInnerclass =
            MyNestedAndInnerClass().myInnerclass()
        val sumTwo = myInnerClass.sumTwo(10)
        println("el resultado de sumar dos es $sumTwo")

    }

    private fun classInheritance() {
        val person = Person("sara", 32)
        var diseñador = Designer("Simon", 19)
        diseñador.work()
        diseñador.goToWork()
        var programador = Programmer("pedro", 123, "JAVA")
        programador.work()
        programador.sayLanguage()
        programador.goToWork()
        programador.drive()
        programador.saluda()
    }

    private fun interfaces() {
        val gamer = Person("Simon", 27)
        gamer.play()
        gamer.stream()
    }

    private fun visibilityModifiers() {
        val visibility = Visibility()
        //visibility.name="Simón"
        visibility.sayMyName()
    }

    /** Called when the user taps the Send button_> llamado cuando el usuario toca el botón enviar */
    fun sendMessage(view: View) {
        // Do something in response to button
        val editText = findViewById<EditText>(R.id.editTextTextPersonName3)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }

    private fun dataClasses() {
        val simon = Worker("simon garcia", 31, "Aprendiz Biomédico")
        simon.lastWork = "Comer empanadas"
        val sara = Worker(name = "Sara")
        //Equals & hashCode
        if (simon.equals(sara)) {
            println("${sara.name} y ${simon.name} son iguales")
        } else {
            println("${sara.name} y ${simon.name} NO son iguales")
        }
        val Pimon = Worker("simon2 garcia", 30, "Aprendiz Biomédico")
        Pimon.lastWork = "hacer pereza"
        if (simon.equals(Pimon)) {
            println("${Pimon.name} y ${simon.name} son iguales")
        } else {
            println("${Pimon.name} y ${simon.name} NO son iguales")
        }
        println(simon.toString())

        var simonCopy = simon.copy(name = "SimónCopy")
        println(simonCopy.toString())
        val (name, age, o) = simon
        println("$name y $age y $o")
        println(println("${name::class.simpleName}"))
        println(println("${age::class.simpleName}"))
    }

    private fun typeAliases() {
        // Los alias se hacen para simplificar los nombres de una variable
        //Función a clase qué vamos a implementar
    }

    private fun destructuringDeclarations() {
        val (name, age, work) = Worker("simon garcia", 27, "Aprendiz Biomédico")
        println("$name,$age,$work")
        val (name1, age1, work1) = Worker("simon garcia", 27, "Aprendiz Biomédico")
        val simo = Worker("simon garcia", 27, "Aprendiz Biomédico")
        println("${simo.component1()}")
        val (nombre, edad) = myWorker()
        println("$nombre,$edad")

        val myMap = mapOf(1 to "brais", 2 to "perro", 3 to "Daniel")
        for (element in myMap) { //Forma común
            println("${element.key},${element.value}")
        }
        for ((clave, nombre) in myMap) { // usando desestructuración
            println("$clave,$nombre")
        }
        //Variables subrayadas--- se usan cuando sólo quiero desestructurar
        // algunas varibles
        val (name2, _, work2) = Worker("Daniel garcia", 31, "profesional de equipos")
        println("$name2,$work2")


    }

    private fun myWorker(): Worker {
        return Worker("perrito", 23, "tecnologo")
    }

    private fun extensions() {
        val myDate = Date()
        println(myDate.customFormat())
        println(myDate.formatSize)

        var myDateNullable: Date? = null
        println(myDateNullable.customFormat())
        println(myDateNullable.formatSize)

    }

    private fun lamdas() {
        val arrayList = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        var myFilterList = arrayList.filter {
            println(it)
            if(it==1){
                return@filter true
            }
            it> 5

        }
        println(myFilterList)
        val suma= fun (x:Int,y:Int):    Int=x+y
        val mult= fun (x:Int,y:Int): Int=x*y

        println(funcionDeOperarNum(5,10) { x,y->x-y })



    }
    private fun funcionDeOperarNum(x:Int,y:Int,myFun:(Int,Int)->Int):Int{
        return myFun(x,y)
    }


}