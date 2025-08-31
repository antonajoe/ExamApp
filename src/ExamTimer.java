package examapp;

/**
 *
 * @author Joe
 */
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class ExamTimer implements TimerInterface{
    ArrayList<TimerObserver> observers = new ArrayList();
    int seconds;
    Timer timer;
                
    public ExamTimer(int seconds){
        this.seconds = seconds;

    }
    
    @Override
    public void updateObservers(){
        for (TimerObserver observer : observers){
            observer.update();
        }
    }
    
    @Override
    public void registerObserver(TimerObserver o){
        observers.add(o);
    }
    
    @Override
    public void removeObserver(TimerObserver o){
        observers.remove(o);
    }
 
    
    public void start(){
        timer = new Timer();
        CountdownTimer task = new CountdownTimer();
        timer.scheduleAtFixedRate(new CountdownTimer(), 1000, 1000);
        seconds = seconds-1; 
          
    }      

    class CountdownTimer extends TimerTask {
        
        @Override
        public void run(){
            updateObservers();
            
        }
    }
}