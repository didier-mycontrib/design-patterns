package tp.proxy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.dto.MoneyExchangeRate;

public class TestProxyCurrencyConverter {
	
    private static Logger logger = LoggerFactory.getLogger(TestProxyCurrencyConverter.class);
	
	private MyHttp2Util myHttp2Util = MyHttp2Util.INSTANCE;
	
	@Test
	public void testMoneyExchangeRate() {
		MoneyExchangeRate.Response moneyExchangeRates = 
				myHttp2Util.fetch(MoneyExchangeRate.buildCurrentRatesURL(),
						MoneyExchangeRate.Response.class);
		assertNotNull(moneyExchangeRates);
		logger.debug("moneyExchangeRates="+moneyExchangeRates);
		logger.debug("1 euro="+moneyExchangeRates.rates().get("USD") + "USD");
	}
	
	@Test
	public void testCurrencyConverter() {
		CurrencyConverter currencyConverter = new CurrencyConverterProxy();
		Double resConv = currencyConverter.convert("USD", "GBP", 100.0);
		System.out.println("100 USD = " + resConv + " GBP");
		
		resConv = currencyConverter.convert("EUR", "GBP", 100.0);
		System.out.println("100 EUR = " + resConv + " GBP");
	}

}
