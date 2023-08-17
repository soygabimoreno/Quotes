package soy.gabimoreno.quotes.data.repository

import soy.gabimoreno.quotes.data.model.Quote

object QuotesRepository {

    private val defaultQuote = Quote(
        id = 1,
        text = "La ignorancia es la madre de todos los males",
        author = "Francois Rabelais"
    )

    private val list = listOf(
        defaultQuote,
        Quote(
            id = 2,
            text = "El hallazgo afortunado de un buen libro puede cambiar el destino de un alma",
            author = "Marcel Proust"
        ),
        Quote(
            id = 3,
            text = "640 K deberían bastar a todo el mundo",
            author = "Bill Gates"
        ),
        Quote(
            id = 4,
            text = "Es genial trabajar con ordenadores. No discuten, lo recuerdan todo y no se beben tu cerveza",
            author = "Paul Leary"
        ),
        Quote(
            id = 5,
            text = "Nunca confíes en un ordenador que no puedas lanzar por una ventana",
            author = "Steve Wozniak"
        ),
        Quote(
            id = 6,
            text = "¿Internet? ¿Todavía anda eso por ahí?",
            author = "Homer Simpson"
        ),
        Quote(
            id = 7,
            text = "Controlar la complejidad es la esencia de la programación",
            author = "Brian Kernigan"
        ),
        Quote(
            id = 8,
            text = "Hay dos maneras de diseñar software: una es hacerlo tan simple que sea obvia su falta de deficiencias, y la otra es hacerlo tan complejo que no haya deficiencias obvias",
            author = "C.A.R. Hoare"
        ),
        Quote(
            id = 9,
            text = "La función de un buen software es hacer que lo complejo aparente ser simple",
            author = "Grady Booch"
        ),
        Quote(
            id = 10,
            text = "Medir el progreso del desarrollo de software por líneas de código es como medir el progreso de la construcción de un avión por su peso",
            author = "Bill Gates"
        )
    )

    fun get(): List<Quote> = list

    fun find(id: Long): Quote = list.find { it.id == id } ?: defaultQuote
}
