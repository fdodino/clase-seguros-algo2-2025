package seguros

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CobroSiniestroSpec : DescribeSpec({
    describe("Dado un cliente normal") {
        it("Si un cliente no es moroso se le paga un siniestro") {
            // Arrange
            val clienteNoMoroso = ClienteNormal()
            // Assert
            clienteNoMoroso.puedeCobrarSiniestro() shouldBe true
        }

        it("Si un cliente es moroso no se le paga un siniestro") {
            // Arrange
            val clienteMoroso = ClienteNormal()
            // Act
            clienteMoroso.facturar(1)
            // Assert
            clienteMoroso.puedeCobrarSiniestro() shouldBe false
        }
    }
    describe("Dada una flota con muchos autos") {
        it("Si debe poco se le paga el siniestro") {
            // Arrange
            val flotaConMuchosAutos = Flota(cantidadDeAutos = 6)
            // Act
            flotaConMuchosAutos.facturar(10000)
            // Assert
            flotaConMuchosAutos.puedeCobrarSiniestro() shouldBe true
        }

        it("Si debe mucho no se le paga el siniestro") {
            // Arrange
            val flotaConMuchosAutos = Flota(cantidadDeAutos = 6)
            // Act
            flotaConMuchosAutos.facturar(10000)
            // Assert
            flotaConMuchosAutos.puedeCobrarSiniestro() shouldBe false
        }
    }

    describe("Dada una flota con pocos autos") {
        it("Si debe poco se le paga el siniestro") {
            // Arrange
            val flotaConPocosAutos = Flota(cantidadDeAutos = 5)
            // Act
            flotaConPocosAutos.facturar(5000)
            // Assert
            flotaConPocosAutos.puedeCobrarSiniestro() shouldBe true
        }

        it("Si debe mucho no se le paga el siniestro") {
            // Arrange
            val flotaConPocosAutos = Flota(cantidadDeAutos = 5)
            // Act
            flotaConPocosAutos.facturar(5001)
            // Assert
            flotaConPocosAutos.puedeCobrarSiniestro() shouldBe false
        }
    }

})