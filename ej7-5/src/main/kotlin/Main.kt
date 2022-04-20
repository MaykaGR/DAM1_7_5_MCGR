import kotlinx.cli.*


fun calcular(datos: MutableList<String?>):Int{
    var size = 0
    if(datos[0]!=null){
        val lista = datos[0]!!.split(" ")
        size = lista[0].toInt()
    }
    var reductor = datos[1]?.toInt()?:0
    reductor = reductor/10
    var iterador = 2
    var jugadoresActivos = 0
    var bool = true
    do{
        var jugadorVivo = false
        if(datos[iterador]=="#"){bool=false}
        else{
            val jugador = datos[iterador]!!.split(" ")
            for(j in 0..reductor-1){
               if(jugador[0].toInt()!=j+1&&jugador[0].toInt()!=(size-j)+1&&jugador[1].toInt()!=j+1&&jugador[1].toInt()!=(size-j)+1)
               {jugadorVivo=true} else jugadorVivo=false
            }
                if(jugadorVivo==true){jugadoresActivos=jugadoresActivos+1}
                iterador= iterador+1}
    }while(bool)
    return jugadoresActivos
}

fun main(args: Array<String>) {
    val parser = ArgParser("Battle Royal")
    val input by parser.option(ArgType.String, shortName = "i", description = "Input file")
    val output by parser.option(ArgType.String, shortName = "o", description = "Output file name")

    parser.parse(args)
    val dir = input
    val out = output?:""

    var lectora = Leer(dir)
    var escritora = Escribir(out)
    escritora.generar(calcular(lectora.datos).toString())
}