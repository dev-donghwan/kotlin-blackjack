package blackjack.domain

class CardDeck {
    private val _cards = create()
    val cards: List<Card>
        get() = _cards.deepCopy()

    fun pickCard(): Card {
        return _cards.shuffled().take(1).last().apply {
            _cards.remove(this)
        }
    }

    private fun create(): MutableList<Card> {
        val cards = mutableListOf<Card>()
        CardType.values().forEach { cardType ->
            CardValue.values().forEach {
                cards.add(Card(cardType = cardType, cardValue = it))
            }
        }
        return cards
    }

    private fun List<Card>.deepCopy(): List<Card> = map { it.copy() }
}
