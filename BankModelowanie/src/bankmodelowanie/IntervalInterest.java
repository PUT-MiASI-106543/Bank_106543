/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

/**
 *
 * @author E330
 */ 
public class IntervalInterest implements InterestState {
    @Override
    public ICurrency calculateInterest(Account acc){
        if((acc.getMoney().getAmount() < 10000.0f ) && (acc.getMoney().getCurrency() == CurrencyUnit.PLN)){
            BankModelowanie.dInjector.InjectCurrency(acc.getMoney().getAmount() * 4.0f * 0.01f, acc.getMoney().getCurrency());
        }
        else if ((acc.getMoney().getAmount() < 20000.0f ) && (acc.getMoney().getCurrency() == CurrencyUnit.PLN)){
            BankModelowanie.dInjector.InjectCurrency(acc.getMoney().getAmount() * 5.0f * 0.01f, acc.getMoney().getCurrency());
        }
        else if (acc.getMoney().getCurrency() == CurrencyUnit.PLN) {
            BankModelowanie.dInjector.InjectCurrency(acc.getMoney().getAmount() * 6.0f * 0.01f, acc.getMoney().getCurrency());
        }
        return null;
    }
}
