object exempelVego3 {

  trait Grönsak {
    val skalningsmetod: String
    val skalfaktor = 0.99
    def skala(): Unit = if (!ärSkalad) {
      println(skalningsmetod)
      vikt = skalfaktor * vikt
      ärSkalad = true
    }
    var vikt: Double
    val namn: String
    var ärSkalad: Boolean = false
    override def toString = s"$namn ${if (!ärSkalad) "o" else ""}skalad $vikt g"
  }

  class Gurka(var vikt: Double) extends Grönsak {
    val namn = "gurka"
    val skalningsmetod = "Skalas med skalare."
  }

  class Tomat(var vikt: Double) extends Grönsak {
    val namn = "tomat" //nyckelordet override behövs ej vid abstrakt medlem, men tillåtet:
    override val skalningsmetod = "Skållas."
//  override val skalningmetod = "Skållas." //kompilatorn hittar felet (stavfel, s saknas)
    override val skalfaktor = 0.95  //överskuggning: override måste anges vid ny impl.
  }
}
