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
public class LinearInterest implements InterestState{
    float percent;
    public LinearInterest(float percent){
        this.percent = percent;
    }
    
    @Override
    public ICurrency calculateInterest(Account acc){
        return BankModelowanie.dInjector.InjectCurrency(acc.getMoney().getAmount() * percent * 0.01f, acc.getMoney().getCurrency());
    }
}
