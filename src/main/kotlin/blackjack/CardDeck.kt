package blackjack

class CardDeck {
    private val cards: MutableList<Card> = init()

    fun pickCard(): Card {
        return cards.take(1).first().apply {
            cards.remove(this)
        }
    }

    private fun init(): MutableList<Card> {
        val cards = mutableListOf<Card>()
        Type.values().forEach { type ->
            Value.values().forEach { value ->
                cards.add(Card(type, value))
            }
        }
        return cards.shuffle() as MutableList<Card>
    }

    private fun List<Card>.deepCopy(): List<Card> = map { it.copy() }
}
