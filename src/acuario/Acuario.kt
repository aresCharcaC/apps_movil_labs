package acuario

import kotlin.math.PI

open class Acuario (open var largo: Int = 30,open var  ancho: Int = 20,open var  alto: Int = 40){

    open var volumen: Int
        get() = ancho * alto * largo / 1000  // 1000 cm^3 = 1 l
        set(valor) {
            alto = (valor * 1000) / (ancho * largo)
        }
    open val forma = "Rectángulo"
    open var agua: Double = 0.0
        get() = volumen * 0.9

    fun imprimirTamano() {
        println(forma)
        println("Ancho: $ancho cm " +
                "Largo: $largo cm " +
                "Alto: $alto cm ")
        println("Volumen: $volumen l Agua: $agua l (${agua/volumen*100.0}% lleno)")
    }

    init{
        println("\nInicializanod acuario")
    }

    constructor(numeroDePeces: Int): this(){
        val tanque = numeroDePeces * 200* 1.1
        alto = (tanque / (largo * ancho)).toInt()
    }



}

class TanqueTorre (override var alto: Int, var diametro: Int): Acuario(alto = alto, ancho = diametro, largo = diametro) {
    override var volumen: Int
        // área elíptica = π * r1 * r2
        get() = (ancho/2 * largo/2 * alto / 1000 * PI).toInt()
        set(valor) {
            alto = ((valor * 1000 / PI) / (ancho/2 * largo/2)).toInt()
        }

    override var agua = volumen * 0.8
    override val forma = "cilindro"
}
