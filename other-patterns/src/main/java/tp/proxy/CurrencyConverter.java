package tp.proxy;

public interface CurrencyConverter {
	Double convert(String sourceCurrencyCode,String targetCurrencyCode,Double amount);
}
