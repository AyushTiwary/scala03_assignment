class t extends Thread{

  override def run()  ={

    println("Thread is running")

  }

}

object DemoThread extends App{

  val obj = new t()

  obj.start()

}