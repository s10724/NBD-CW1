//zad1.
//Stwórz 7 elementową listę zawierającą nazwy dni tygodnia. Wypisz ją używając:
//a.	Pętli for
//b.	Pętli for wypisując tylko dni z nazwami zaczynającymi się na „P”
//c.	Metody foreach
//d.	Pętli while
//e.	Funkcji rekurencyjnej
//f.	Funkcji rekurencyjnej wypisując elementy listy od końca
//g.	Metod foldl i foldr
//h.	Metody foldl wypisując tylko dni z nazwami zaczynającymi się na „P”

//zad2.
//Stwórz mapę z nazwami produktów i cenami. Na jej podstawie wygeneruj drugą, z 10% obniżką cen.
//Wykorzystaj mechanizm mapowania kolekcji.

//zad3.
//Zdefiniuj funkcję przyjmującą krotkę z 3 wartościami różnych typów i wypisującą je

//zad4.
//Zaprezentuj działanie Option na dowolnym przykładzie (np. mapy, w której wyszukujemy wartości po kluczu)

//zad5.
//Wykorzystaj Pattern Matching w funkcji przyjmującej parametr typu String.
//Dla stringów odpowiadających nazwom dni tygodnia funkcja ma zwrócić „Praca” i „Weekend”
//(odpowiednio dla dni roboczych i wolnych), dla pozostałych napisów „Nie ma takiego dnia”.

object Cw1 {
  val days = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela");

  var lastMethodName = "";
  def PrintCurrentMethodName() {
    val currentMethod = Thread.currentThread.getStackTrace()(2).getMethodName;
    if (currentMethod != lastMethodName) {
      lastMethodName = currentMethod;
      println("\r\n" + currentMethod);
    }
  }

  def main(args: Array[String]) {
    Zad1();
    Zad2();
    Zad3();
    Zad4();
    Zad5();
    Zad6();
    Zad7();
    Zad8();
    Zad9();
    Zad10();
  }

  def Zad10() {
    PrintCurrentMethodName();

    val numbers: List[Double] = List(-6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
    def absNumbers(list: List[Double]): List[Double] = {
      return list.filter(x => x >= (-5) && x <= (12)).map(_.abs);
    }
    println("Lista początkowa");
    numbers.foreach(i => println(i));
    println("Lista z wartościami bezwzględnymi <-5,12>");
    absNumbers(numbers).foreach(i => println(i));
  }

  def Zad9() {
    PrintCurrentMethodName();

    val numbers: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0);
    def addOne(list: List[Int]): List[Int] = {
      return list.map(x => x + 1);
    }
    println("Lista początkowa");
    numbers.foreach(x => println(x));
    println("Lista z +1 do każdego elementu");
    addOne(numbers).foreach(x => println(x));
  }

  def Zad8() {
    PrintCurrentMethodName();
    val numbers: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5, 6, 7, 0);

    def removeZeros(list: List[Int]): List[Int] = {
      return list.filter(x => x.!=(0));
    }
    println("Lista początkowa");
    numbers.foreach(i => println(i));
    println("Lista bez zer");
    removeZeros(numbers).foreach(i => println(i));
  }

  def Zad7() {
    PrintCurrentMethodName();

    var osoba1 = new Osoba("Jan", "Kowalski");
    var osoba2 = new Osoba("Adam", "Nowak");
    var osoba3 = new Osoba("Krzysztof", "Iksiński");
    var osoba4 = new Osoba("Jakub", "Kowal");

    def przywitanie(o: Osoba) = o match {
      case o if o.imie == "Jan" && o.nazwisko == "Kowalski" => println("Witam");
      case o if o.imie == "Adam" && o.nazwisko == "Nowak" => println("Hej");
      case o if o.imie == "Krzysztof" && o.nazwisko == "Iksiński" => println("Dzień dobry");
      case default => println("Cześć");
    }
    przywitanie(osoba1);
    przywitanie(osoba2);
    przywitanie(osoba3);
    przywitanie(osoba4);
  }

  def Zad6() {
    PrintCurrentMethodName();
    val test = new KontoBankowe(20.7f);
    test.wplata(2.3f);
    test.wyplata(1.3f);
  }

  def Zad5() {
    PrintCurrentMethodName();
    def typeOfDay(s: String): String = s match {
      case "Sobota" | "Niedziela" => "Weekend"
      case "Poniedzialek" | "Wtorek" | "Sroda" | "Czwartek" | "Piatek" => "Praca"
      case _ => "Nie ma takiego dnia"
    }
    ("Test" :: days).foreach(f => println(f + ": " + typeOfDay(f)))
  }

  def Zad4() {
    PrintCurrentMethodName();
    val numbers = Map("1" -> "One", "2" -> "Two");

    def showNumberText(x: Option[String]) = x match {
      case Some(s) => s
      case None    => "Unknown"
    }

    println(showNumberText(numbers.get("1")));
    println(showNumberText(numbers.get("3")));
  }

  def Zad3() {
    PrintCurrentMethodName();
    val t = Tuple3(3.5f, "test", 20.4d);
    tuplePrint(t);
  }

  def tuplePrint(t: Tuple3[Float, String, Double]) {
    println(t);
  }

  def Zad2() {
    PrintCurrentMethodName();
    val products = Map("Chleb" -> 2.5f, "Masło" -> 4f, "Ryż" -> 2.2f);
    val productsWithDiscount = products.mapValues(_ * 0.9);
    products.foreach(x => println(x));
    productsWithDiscount.foreach(x => println(x));
  }

  def Zad1() {
    Zad1a(days);
    Zad1b(days);
    Zad1c(days);
    Zad1d(days);
    Zad1e(days);
    Zad1f(days);
    Zad1g(days);
    Zad1h(days);
  }

  def Zad1a(days: List[String]) {
    PrintCurrentMethodName();
    for (day <- days) {
      println(day);
    }
  }

  def Zad1b(days: List[String]) {
    PrintCurrentMethodName();
    for (day <- days) {
      if (day(0) == 'P')
        println(day);
    }
  }

  def Zad1c(days: List[String]) {
    PrintCurrentMethodName();
    days.foreach { println }
  }

  def Zad1d(days: List[String]) {
    PrintCurrentMethodName();
    var i = 0;
    while (i < days.length) {
      println(days(i));
      i = i + 1;
    }
  }

  def Zad1e(days: List[String]) {
    PrintCurrentMethodName();
    if (!days.isEmpty) {
      println(days.head);
      Zad1e(days.tail);
      val a = days.head;
    }
  }

  def Zad1f(days: List[String]) {
    PrintCurrentMethodName();
    if (!days.isEmpty) {
      Zad1f(days.tail);
      println(days.head);
    }
  }

  def Zad1g(days: List[String]) {
    PrintCurrentMethodName();
    days.foldLeft(days.head)(_ + println(_));
    days.foldRight(days.last)(println(_) + _);
  }

  def Zad1h(days: List[String]) {
    PrintCurrentMethodName();
    days.foldLeft(days.head)((_, x) => x + ((if (x.startsWith("P")) println(x))));
  }

}