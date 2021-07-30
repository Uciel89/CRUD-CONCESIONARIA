package com.ucielcorp.crudsimpleporconsola

class Automovil {

    //Establecemos todas las propiedades de la clase Automovil
    var marca: String? = null
    var patenteDeAuto: String? = null
    var color: String? = null
    var modelo: String? = null
    var precio: String? = null

    //Ponemos este constructo para generar el automovil sin atributos
    constructor(){ }

    //Ahora bien, creamos otro costructor para que el Automovil contenga todos sus atributos
    constructor(
        marca: String?, patente: String?, color: String?, modelo: String?, precio: String?
    ) {
        this.marca = marca
        this.modelo = modelo
        this.patenteDeAuto= patente
        this.color = color
        this.precio = precio

    }

    fun setPatente(pat: String?) {
        patenteDeAuto = pat
    }


}