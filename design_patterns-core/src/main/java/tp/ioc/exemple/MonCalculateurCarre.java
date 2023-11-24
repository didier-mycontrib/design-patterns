package tp.ioc.exemple;

public class MonCalculateurCarre implements MonCalculateur {

	@Override
	public double calculer(double x) {
		return x*x;
	}

}
