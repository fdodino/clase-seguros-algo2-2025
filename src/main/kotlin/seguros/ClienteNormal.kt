package seguros

abstract class Cliente {
    var saldo: Int = 0
    abstract fun puedeCobrarSiniestro(): Boolean

    fun esMoroso() = saldo > 0

    fun facturar(monto: Int) {
        saldo = saldo + monto
    }
}

class ClienteNormal : Cliente() {
    override fun puedeCobrarSiniestro() = !esMoroso()
}

class Flota(var cantidadDeAutos: Int) : Cliente() {
    override fun puedeCobrarSiniestro() =
        saldo <= montoMaximoDeudaPermitido()

    fun montoMaximoDeudaPermitido() = if (cantidadDeAutos > 5)
        10000
    else
        5000
}