package tp.proxy;

import tp.dto.MoneyExchangeRate;

public class CurrencyConverterProxy implements CurrencyConverter{
	
	private MyHttp2Util myHttp2Util = MyHttp2Util.INSTANCE;

	@Override
	public Double convert(String sourceCurrencyCode, String targetCurrencyCode, Double amount) {
		MoneyExchangeRate.Response moneyExchangeRates = 
				myHttp2Util.fetch(MoneyExchangeRate.buildCurrentRatesURL(),
						MoneyExchangeRate.Response.class);
		Double nbSourceCurrencyUnitsFor1Euro = moneyExchangeRates.rates().get(sourceCurrencyCode);
		Double nbTargetCurrencyUnitsFor1Euro = moneyExchangeRates.rates().get(targetCurrencyCode);
		return amount * nbTargetCurrencyUnitsFor1Euro / nbSourceCurrencyUnitsFor1Euro;
	}

}
