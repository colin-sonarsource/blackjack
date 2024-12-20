package Cards;

public class PlayerCardHand extends CardHand {
	public PlayerCardHand() {
		super();
	}

	/**
	 * Add a Card to the players hand and calculate the hands new total.
	 *
	 * @param card A card to add to the players hand.
	 *
	 * @return If the card was added or not successfully.
	 */
	public boolean add(Card card) {
		if(isBust() || hasBlackJack()){
			return false
		}

		boolean cardAdded = super.add(card);

		if (isBust()) {
			adJustAces();
		}

		return cardAdded;
	}

	private void adJustAces(){
		for (Card eachCard : this) {
			eachCard.getFace().switchAce();
			if (!isBust()) {
				break;
			}
		}
	}
}