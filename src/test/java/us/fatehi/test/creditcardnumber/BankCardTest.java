/*
 *
 * Credit Card Number
 * https://github.com/sualeh/credit_card_number
 * Copyright (c) 2014-2021, Sualeh Fatehi.
 *
 */
package us.fatehi.test.creditcardnumber;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import us.fatehi.creditcardnumber.AccountNumber;
import us.fatehi.creditcardnumber.AccountNumbers;
import us.fatehi.creditcardnumber.BankCard;
import us.fatehi.creditcardnumber.ExpirationDate;
import us.fatehi.creditcardnumber.Name;
import us.fatehi.creditcardnumber.ServiceCode;

public class BankCardTest {

  @Test
  public void bankCard() throws IOException {
    final AccountNumber pan = AccountNumbers.accountNumber("5266092201416173");
    final ExpirationDate expirationDate = new ExpirationDate(2012, 12);
    final Name name = new Name("Sualeh", "Fatehi");
    final ServiceCode serviceCode = new ServiceCode("222");

    final BankCard bankCard = new BankCard(pan, expirationDate, name, serviceCode);

    assertThat(bankCard.hasAccountNumber(), is(true));
    assertThat(bankCard.getAccountNumber(), is(pan));

    final String bankCardToString =
        IOUtils.resourceToString("/BankCard.toString", StandardCharsets.UTF_8);
    assertThat(
        bankCard.toString().replaceAll("\\R", ""), is(bankCardToString.replaceAll("\\R", "")));
  }
}
