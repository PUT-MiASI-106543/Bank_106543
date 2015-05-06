/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmodelowanie;

import com.google.inject.AbstractModule;

/**
 *
 * @author MeloneQ
 */
public class DependencyInjector extends AbstractModule{
    @Override
    protected void configure() {
        bind(IKir.class).to(KIR.class);
        bind(ICustomer.class).to(Customer.class);
        bind(IAccount.class).to(Account.class);
        bind(IBank.class).to(Bank.class);
        bind(ICurrency.class).to(Currency.class);
    }
}
