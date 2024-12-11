import Utilidades_LOK.*

/*Ja hem vist que podem crear una aplicació de calculadora fent servir programació lineal (el que haguéssim fet a les RAs 1 i 3), però estem en un procés de millorar el nostre codi, així que farem servir programació modular.
Necessitem desenvolupar una aplicació que inicialment mostra un menú d’operacions:
Sumar
Restar
Multiplicar
Dividir
Quadrat
Arrel quadrada
Factorial
Sortir
Cada opció fara (evidentment) el que el nom indica, demanant un o dos elements (el quadrat, l’arrel quadrada o el factorial només necessiten d’un número). Però, com?
Cada operació haurà de ser una funció que rep el número d’elements corresponents a la operació, i retorna el resultat (no el mostra!). A més, segurament us interessi desenvolupar una funció de recollida d’un element, i/o una funció de recollida de dos elements.
Per exemple, se m’acudeixen les funcions:
mostraMenu
triaOpcioMenu
suma
resta
multiplicacio
divisio
quadrat
arrelQuadrada
factorial
llegirUnElement
llegirDosElements
…
A més, després de tot el que estem veient, volem anar “un pas més enllà”, així doncs, caldrà documentar en format Kdoc totes les funcions, generant finalment una documentació dokkaHtml.
Puntuació:
Desenvolupament fent ús de programació modular: 3 punts
Ús de valors per defecte: 1 punt
Ús de paràmetres anomenats (named parameters): 1 punt
Ús de funcions com a paràmetre: 1 punt
Ús de sobrecàrrega: 1 punt
Documentació en format Kdoc: 2 punt
Generació de documentació dokkaHtml: 1 punt
*/
/*
fun main() {

    println("$PURPLE_BOLD Bienvenido!!, preparad@ para calcular tus numeros favoritos o las dudas matematicas que puedas tener. $RESET")
    println("$BLUE_BOLD *******************************************************************************************************$RESET")
    menu()

}
*/

import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.JScrollPane
import javax.swing.SwingUtilities
import javax.swing.JOptionPane

fun main() {
    SwingUtilities.invokeLater {
        val frame = JFrame("Calculadora")
        val textArea = JTextArea()
        val scrollPane = JScrollPane(textArea)

        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setSize(600, 400)
        frame.add(scrollPane)
        frame.isVisible = true

        textArea.append("Benvingut!! Preparat per calcular els teus números favorits o resoldre dubtes matemàtiques?\n")
        textArea.append("**********************************************************************\n")
        menu(textArea)
    }
}

/**
 * Mostra el menú de calculadora.
 */
fun mostraMenu(): String {
    return """
        Menú d'Operacions:
        1. Sumar
        2. Restar
        3. Multiplicar
        4. Dividir
        5. Quadrat
        6. Arrel Quadrada
        7. Factorial
        8. Sortir
    """.trimIndent()
}

/**
 * Lògica per manejar opcions del menú.
 */
fun triaOpcioMenu(opcio: Int, textArea: JTextArea) {
    when (opcio) {
        1 -> {
            val nums = llegirDosElements()
            textArea.append("Resultat de la suma: ${suma(nums)}\n")
        }
        2 -> {
            val nums = llegirDosElements()
            textArea.append("Resultat de la resta: ${resta(nums)}\n")
        }
        3 -> {
            val nums = llegirDosElements()
            textArea.append("Resultat de la multiplicació: ${multiplicacio(nums)}\n")
        }
        4 -> {
            val nums = llegirDosElements()
            textArea.append("Resultat de la divisió: ${divisio(nums)}\n")
        }
        5 -> {
            val num = llegirUnElement()
            textArea.append("Resultat del quadrat: ${quadrat(num)}\n")
        }
        6 -> {
            val num = llegirUnElement()
            textArea.append("Resultat de l'arrel quadrada: ${arrelQuadrada(num)}\n")
        }
        7 -> {
            val num = llegirUnElement()
            textArea.append("Resultat del factorial: ${factorial(num)}\n")
        }
        8 -> textArea.append("Sortint de l'aplicació...\n")
        else -> textArea.append("Opció no vàlida. Torna-ho a provar.\n")
    }
}

/**
 * Recull dos valors numèrics de l'usuari mitjançant JOptionPane.
 */
fun llegirUnElement(missatge: String): Double {
    while (true) {
        val entrada = JOptionPane.showInputDialog(missatge)
        if (entrada == null) throw RuntimeException("L'usuari ha cancel·lat l'entrada.")
        val numero = entrada.toDoubleOrNull()
        if (numero != null) return numero
        JOptionPane.showMessageDialog(null, "Entrada no vàlida. Torna-ho a intentar.")
    }
}

fun llegirDosElements(): Pair<Double, Double> {
    val a = llegirUnElement("Introdueix el primer número:")
    val b = llegirUnElement("Introdueix el segon número:")
    return Pair(a, b)
}

/**
 * Recull un valor numèric de l'usuari mitjançant JOptionPane.
 */
fun llegirUnElement(): Double {
    return JOptionPane.showInputDialog("Introdueix un número:").toDoubleOrNull() ?: 0.0
}

/**
 * Operacions matemàtiques.
 */
fun suma(elements: Pair<Double, Double>): Double = elements.first + elements.second
fun resta(elements: Pair<Double, Double>): Double = elements.first - elements.second
fun multiplicacio(elements: Pair<Double, Double>): Double = elements.first * elements.second
fun divisio(elements: Pair<Double, Double>): Double = if (elements.second != 0.0) elements.first / elements.second else Double.NaN
fun quadrat(element: Double): Double = element * element
fun arrelQuadrada(element: Double): Double = kotlin.math.sqrt(element)
fun factorial(element: Double): Double {
    if (element < 0 || element != element.toInt().toDouble()) return Double.NaN
    val num = element.toInt()
    return if (num == 0) 1.0 else num.toDouble() * factorial((num - 1).toDouble())
}

fun menu(textArea: JTextArea) {
    val menuText = mostraMenu()
    textArea.append(menuText + "\n")
    var sortir = false
    while (!sortir) {
        val input = JOptionPane.showInputDialog("Selecciona una opció del menú (1-8):").toIntOrNull()
        if (input != null) {
            if (input == 8) sortir = true
            triaOpcioMenu(input, textArea)
        } else {
            textArea.append("Entrada no vàlida. Torna-ho a provar.\n")
        }
    }
}
