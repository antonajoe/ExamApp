package examapp;

/**
 *
 * @author Joe
 */
public interface TimerInterface {
    
    public void updateObservers();
    
    public void registerObserver(TimerObserver o);
    
    public void removeObserver(TimerObserver o);
}
