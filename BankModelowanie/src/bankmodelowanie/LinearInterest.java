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
        return BankModelowanie.getInjector().injectCurrency(acc.getMoney().getAmount() * percent * 0.01f, acc.getMoney().getCurrency());
    }
}
