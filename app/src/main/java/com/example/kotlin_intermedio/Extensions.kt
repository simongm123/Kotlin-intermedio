package com.example.kotlin_intermedio
import java.text.SimpleDateFormat
import java.util.*

fun Date?.customFormat():String?{

    val formatter=SimpleDateFormat("yyyy-MM-dd'T' HH:mm:ssZZZ' ' MM/dd/yyyy",Locale.getDefault())
    if(this!=null) {
        return formatter.format(this)
    }else{
        return null
    }

}

 val Date?.formatSize: Int
    get() = this.customFormat()?.length ?: 0

