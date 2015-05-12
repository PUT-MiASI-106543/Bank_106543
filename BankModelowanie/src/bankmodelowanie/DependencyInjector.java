package bankmodelowanie;

import com.google.inject.AbstractModule;

/**
 *
 * @author MeloneQ
 */
public class DependencyInjector extends AbstractModule{
    @Override
    protected void configure() {
        bind(IBank.class).to(Bank.class);
        bind(IKir.class).to(KIR.class);
        bind(ICustomer.class).to(Customer.class);
        bind(IAccount.class).to(Account.class);
    }
}
