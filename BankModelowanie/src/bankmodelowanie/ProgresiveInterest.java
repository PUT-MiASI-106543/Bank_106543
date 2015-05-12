package bankmodelowanie;

/**
 *
 * @author E330
 */
public class ProgresiveInterest implements InterestState {
    int no;
    public ProgresiveInterest(){
        this.no = 0;
    }
    @Override
    public ICurrency calculateInterest(Account acc){
        this.no++;
        float percent = Math.max(this.no * 0.5f, 4.00f);
        return BankModelowanie.dInjector.InjectCurrency(acc.getMoney().getAmount() * percent * 0.01f, acc.getMoney().getCurrency());
    }
}
