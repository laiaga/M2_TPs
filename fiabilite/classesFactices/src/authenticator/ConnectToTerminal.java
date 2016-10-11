package authenticator;

import model.ICard;
import model.IValidator;
import model.IllegalCardException;
import model.NumberOfTryExceededException;

public class ConnectToTerminal {
	private static int MAX_CODE_ATTEMPTS = 4;
	
	private ICard connectedCard;
	private IValidator validator;
	private int secretCodeAttempts;
	
	public ConnectToTerminal (IValidator validator) {
		this.validator = validator;
		connectedCard = null;
		secretCodeAttempts = 0;
	}

	/**
	 * On regarde si le numéro de carte est valide. Si tel n'est pas le cas on renvoie une exception.
	 * Si le numéro est valide, on retourne true et, seulement si la carte est différente de la denrière connectée,
	 * on remet à 0 le nombre d'essais de code et on change l'état de la carte pour la passer à validée 
	 * (l'ancienne carte devient non-valide) 
	 * @param cardNumber le numéro de la carte à tester
	 * @return true si et seulement si le numéro de la carte est valide
	 * @throws IllegalCardException si le numéro de la carte est invalide
	 */
	public boolean validateCardNumber(int cardNumber) throws IllegalCardException {
		ICard card = validator.validateCard(cardNumber);
		if (card == null) {
			throw new IllegalCardException("THe given card number (" + cardNumber 
					+ ") is not linked to a known card.");
		} else {
			if (connectedCard == null || !connectedCard.equals(card)) {
				if (connectedCard != null) {
					connectedCard.setValidation(false);
				}
				connectedCard = card;
				secretCodeAttempts = 0;
			}
			return true;
		}
	}
	
	/**
	 * Si la carte est valide mais non encore connectée, on vérifie la justesse du code et s'il est vrai,
	 * la carte passe dans l'état connectée.
	 * Si la carte est déjà connectée on ne fait rien.
	 * Si le code est invalide, on incrémente le nombre d'essais erronés
	 * @param secretCode le code secret à tester pour se connecter
	 * @throws NumberOfTryExceededException levée si le nombre d'essais erronés dépasse MAX_CODE_ATTEMPTS
	 * la carte passe dans l'état invalide
	 * @throws IllegalCardException si la carte est invalide
	 */
	public void authenticateCode(int secretCode) throws NumberOfTryExceededException, IllegalCardException {
		if (connectedCard.isValid()) {
			if (!connectedCard.isConnected()) {
				boolean validCode = connectedCard.checkSecretCode(secretCode);
				if (validCode) {
					connectedCard.setConnection(true);
				} else {
					secretCodeAttempts++;
					if (secretCodeAttempts >= MAX_CODE_ATTEMPTS) {
						connectedCard.setValidation(false);
						throw new NumberOfTryExceededException("Card locked : you tried a wrong code 4 times in a row.");
					}
				}
			}
		} else {
			throw new IllegalCardException("Trying to authenticate a non-valid card ; "
					+ "try using validateCardNumber(int cardNumber) first.");
		}
	}
}
