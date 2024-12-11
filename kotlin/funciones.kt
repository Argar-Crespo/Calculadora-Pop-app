package Utilidades_LOK
import Utilidades_LOK.*
import javax.swing.JTextArea

/**
 * This method can be used to read an Int value from the user through keyboard using java.util.Scanner in within a range
 * @author argar.crespo
 * @since 11/12/2024
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @param pMessageErrorDV Data value error message to be shown to the user
 * @param pMin Min accepted value
 * @param pMax Max accepted value
 * @return outputValue Output value
 */
fun llegir10numeros(pMessageIn: String
                    , pMessageErrorDT: String
                    , pMessageErrorDV: String
                    , pMin: Int
                    , pMax: Int
): Int{

    var valorDeSalida: Int = 0
    var correcto: Boolean = false

    do{
        println(pMessageIn)
        correcto = scan.hasNextInt()

        if (!correcto){
            println(RED_BACKGROUND_BRIGHT + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            valorDeSalida = scan.nextInt()

            if (valorDeSalida < pMin || valorDeSalida > pMax){
                println(YELLOW_BOLD_BRIGHT + "WARNING: " + pMessageErrorDV + RESET)
                correcto = false
            }
        }
        scan.nextLine()
    }while(!correcto)

    return valorDeSalida
}

/**
 * This method can be used to read an Int value from the user through keyboard using java.util.Scanner in within a range
 * @author argar.crespo
 * @since 11/12/2024
 * @param pMessageIn Input message to be shown to the user
 * @param pMessageErrorDT Data type error message to be shown to the user
 * @param pMessageErrorDV Data value error message to be shown to the user
 * @param pMin Min accepted value
 * @param pMax Max accepted value
 * @return outputValue Output value
 */
fun llegir8numeros(pMessageIn: String
                   , pMessageErrorDT: String
                   , pMessageErrorDV: String
                   , pMin: Int
                   , pMax: Int
): Int{

    var valorDeSalida: Int = 0
    var correcto: Boolean = false

    do{
        println(PURPLE_BOLD + pMessageIn + RESET)
        correcto = scan.hasNextInt()

        if (!correcto){
            println(RED_BACKGROUND_BRIGHT + "ERROR: " + pMessageErrorDT + RESET)
        }else{
            valorDeSalida = scan.nextInt()

            if (valorDeSalida < pMin || valorDeSalida > pMax){
                println(YELLOW_BOLD_BRIGHT + "WARNING: " + pMessageErrorDV + RESET)
                correcto = false
            }
        }
        scan.nextLine()
    }while(!correcto)

    return valorDeSalida
}

fun numerosCalculadoraTotal(){
    val numeroUsuario = Utilidades_LOK.llegir10numeros(
        pMessageIn = "Introduce un numero entero entre 1 y 10",
        pMessageErrorDT = "Introduce un numero entero",
        pMessageErrorDV = "Error, el valor introducido no esta entre 1 y 10",
        pMin = 1,
        pMax = 10
    )
    if (numeroUsuario == 2){
        val num1 = llegirTotsInt(pMessageIn = "Introduce el primero operario para calcular", pMessageErrorDT = "Error, eso no es un numero entero")
        val num2 = llegirTotsInt(pMessageIn = "Introduce el segundo operario para calcular", pMessageErrorDT = "Error, eso no es un numero entero")

    }
    if (numeroUsuario == 3){

    }

}

fun menu(){
    var MENU = """
              $BLUE_BOLD *********** MENU ************
               ***************************** $RESET
                       $GREEN_BOLD  1.Sumar
                         2.Restar
                         3.Multiplicar
                         4.Dividir
                         5.Cuadrado
                         6.Raíz Cuadrada
                         7.Factorial
                         8.Salir$RESET
                *****************************
            """.trimIndent()
    do {
        println(MENU)
        var opcionUsuario:Int= llegir8numeros(pMessageIn = "Seleciona que operacion desea hacer:", pMessageErrorDV = "Error, el valor introducido no esta entre 1 y 8", pMin = 1, pMax = 8, pMessageErrorDT = "Error, eso no es un numero entero")
        when(opcionUsuario){
            1 -> {
                numerosCalculadoraTotal()

            }
            2 -> {

            }
            3 -> {

            }
            4 -> {

            }
            5 -> {

            }
            6 -> {

            }
            7 -> {

            }
            8 -> {
                println("Gracias por usar el programa de la calculadora")
            }

        }
    }while (opcionUsuario != 8)
}

