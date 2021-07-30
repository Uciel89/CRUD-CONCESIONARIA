package com.ucielcorp.crudsimpleporconsola

//Utilizamos java.util.Scanner para obtener los datos que ingresa el usuario.
//Ademas tenemos implementado .nextLine() que nos sirve para generar las separaciones correspondiente entre cada linea de texto

import kotlin.jvm.JvmStatic
import java.util.Scanner

object CrudMain {
    @JvmStatic

    //Creamos la funcion main
    fun main(args: Array<String>) {

        println("CRUD para Concesionaria\n")

        //Variable que almacena los valores de entrada del usuario
        val valorEntrada = Scanner(System.`in`)

        //Establecemos la lista donde se van a almacenar los automoviles
        val listaDeAutomoviles = arrayListOf<Automovil>()

        //Variable que segun su valor (booleano) va a permitir que funcione o no el while principal del programa
        var salir = false

        //Generamos una while que permita seleccionar opcciones
        while (!salir) {

            //Con el numero que ingreso el usuario, realizamos una accion
            println("Seleccione una opción: ")
            println("1: Crear auto ")
            println("2: Listar autos ingresados")
            println("3: Eliminar Automovil ")
            println("4: Modificar Automovil ")
            println("0: Salir\n ")

            /*Acciones segun el numero*/

            //Variable que almacene ese numero ingresado por el usuario
            val opcionesUsuario = valorEntrada.nextLine().toInt()

            //Creamos un when, para que segun el numero seleccionado, realizar una tarea
            when (opcionesUsuario) {

                /*Crear Automovil*/

                1 -> {
                    //Creamos la variable a (Este seria un automovil sin atributos)
                    val a = Automovil()
                    println("Ingrese la patente: ")

                    // Obtenemos la patente que el usuario escribió y la guardamos en el vehiculo.
                    a.setPatente(valorEntrada.nextLine())
                    println("Ingrese la marca: ")

                    // Guardamos la marca
                    a.marca = valorEntrada.nextLine()
                    println("Ingrese el modelo: ")

                    //Guardamos el modelo del auto
                    a.modelo = valorEntrada.nextLine()
                    println("Ingrese el color: ")

                    // guardamos el color que el usuario ingresó
                    a.color = valorEntrada.nextLine()
                    println("Ingrese el precio: ")

                    //Y por utlimo almacenamos el precio del automovil
                    a.precio = valorEntrada.nextLine()

                    //Paso muy importante, tomamos auto que establecimos (en este caso es a) y lo ingresamos
                    //en la lista de Automoviles con la palabra reservada .add(a) --> a es la variable
                    listaDeAutomoviles.add(a)

                    // Le avisamos al usuario del vehiculo creado
                    println("VEHICULO CREADO: ")
                    println("Patente: " + a.patenteDeAuto)
                    println("Marca: " + a.marca)
                    println("Modelo: " + a.modelo)
                    println("Color: " + a.color)
                    println("Precio: $${a.precio}\n")
                }

                /*Listar autos ingresados*/

                2 -> {
                    //Creamos una variable que nos permita recorrer la lista de atributos del auto
                    var indice: Int = 0

                    //Vamos un bucle while para recorrer la lista
                    while (indice < listaDeAutomoviles.size) {

                        //Esto es para poder ver especificamente a que auto nos estamos refiriendo
                        //Porque al tener variaos autos almacenados, hay que tener una orden
                        println("Auto N°${(indice + 1)}")

                        //La variable auto almacena todos los elementos que obtine de la lista mediante el get() - []
                        //Es una de las mas importante porque contiene el registro completo de los autos
                        val auto = listaDeAutomoviles[indice]

                        //Imprime esos elementos
                        println("N° de patente: " + auto.patenteDeAuto)
                        println("Marca: " + auto.marca)
                        println("Modelo: " + auto.modelo)
                        println("Color: " + auto.color)
                        println("Precio: $${auto.precio}\n")


                        //Aumentamos el numero del indice, para ir a listar otro Automovil
                        indice++

                    }

                }

                /*Eliminar Automovil*/

                3 -> {
                    println("Ingreser la patente del vehiculo a eliminar: ")
                    val patente = valorEntrada.nextLine()
                    var indice = 0

                    while (indice < listaDeAutomoviles.size) {

                        val auto = listaDeAutomoviles[indice]

                        // buscamos cual de las patentes en la lista coincide con lo que el usuario escribió:
                        if (patente == auto.patenteDeAuto) {

                            // Eliminamos un elemento de la lista utilizando .remove()
                            listaDeAutomoviles.removeAt(indice)

                            println("Auto eliminado exitosamente\n")
                        }
                        indice++
                    }

                }

                /*Modificar Automovil*/

                4 -> {

                    println("Ingrese la patente del vehiculo a modificar: ")

                    val patente = valorEntrada.nextLine()

                    //En esta opcion, primero pedimos que el usuario ingrese la patente, y rapidamente buscamos es nuestro
                    //array el auto que contenga esa patente, y procedemos a modificar sus valores

                    var indice = 0

                    while (indice < listaDeAutomoviles.size) {

                        val auto = listaDeAutomoviles[indice]

                        if (patente == auto.patenteDeAuto) {

                            //Mostramos los valores originales
                            println("marca: " + auto.marca)
                            println("modelo: " + auto.modelo)
                            println("color: " + auto.color)
                            println("precio: $${auto.precio}\n")

                            //Creamos una seleccion para que el usuario pueda elegir especificamente que valor modificar
                            println("Que valor quiere modificar: ")

                            var seleccion = readLine().toString()

                            when (seleccion) {

                                "marca" -> {

                                    println("Ingresar nuevo valor de Marca: ")
                                    val marca = valorEntrada.nextLine()
                                    //Agrego el nuevo valor de marca
                                    auto.marca = marca
                                    println("\n")
                                    println("La $seleccion a sido modificada con exito")
                                }

                                "modelo" -> {

                                    println("Ingresar nuevo valor de Modelo: ")
                                    val modelo = valorEntrada.nextLine()
                                    //Agrego el nuevo valor de modelo
                                    auto.modelo = modelo
                                    println("\n")
                                    println("El $seleccion a sido modificada con exito")
                                }

                                "color" -> {

                                    println("Ingresar nuevo valor de color: ")
                                    val color = valorEntrada.nextLine()
                                    //Agrego el nuevo valor de color
                                    auto.color = color
                                    println("\n")
                                    println("El $seleccion a sido modificada con exito")
                                }

                                "precio" -> {

                                    println("Ingrese nuevo valor de precio:  ")
                                    val precio = valorEntrada.nextLine()
                                    //Agrego el nuevo valor de precio
                                    auto.precio = precio
                                    println("\n")
                                    println("El $seleccion a sido modificada con exito")
                                }

                            }
                            println("\n")
                        }
                        indice++
                    }

                }
                0 -> {

                    //Al momento que la variable salir contiene el valor true, se termina el programa, porque
                    //detiene el while principal

                    salir = true
                    println("Saliendo del programa")

                }

                else -> println("!-- Opcion incorrecta --!")

            }

        }

    }

}





