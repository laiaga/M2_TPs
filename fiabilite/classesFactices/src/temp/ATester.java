package temp;

public class ATester {
	private Conversion conversion;
	
	public ATester(Conversion conversion) {
		this.conversion = conversion;
	}
	
	public double convertit(double temperature, String sens) {
		if (sens.equals("F2C")) {
			return conversion.convF2C(temperature);
		} else if (sens.equals("C2F")) {
			return conversion.convC2F(temperature);
		} else {
			throw new IllegalArgumentException("A conversion must be either F2C (Farenheit to Celcius) "
					+ " or C2F (Celsius to Farenheit) but you tried " + sens + ".");
		}
	}
}
