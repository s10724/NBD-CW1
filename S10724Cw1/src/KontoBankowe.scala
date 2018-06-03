

class KontoBankowe(private var stanKonta: Float) {
  def this() {
    this(0);
  }

  def wplata(ile: Float) {
    println("Zlecono wpłatę " + ile);
    stanKonta += ile;
    println("Stan konta po wpłacie " + stanKonta);
  }

  def wyplata(ile: Float) {
    println("Zlecono wypłatę " + ile);
    stanKonta -= ile;
    println("Stan konta po wypłacie " + stanKonta);
  }
}