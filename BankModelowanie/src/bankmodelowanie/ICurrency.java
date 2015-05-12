package bankmodelowanie;

/**
 *
 * @author MeloneQ
 */
public interface ICurrency {
    public Float getAmount();
    public void setAmount(Float amount);
    public CurrencyUnit getCurrency();
    public void setCurrency(CurrencyUnit currency);
}
