package hockey.icescore.activities;
        import java.beans.PropertyChangeListener;
        import java.beans.PropertyChangeSupport;
// Done by Jack, dont change without asking first
public class Timer implements Runnable {
    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    private volatile boolean running =true;
    private volatile boolean allowed = false;
    private volatile int ticks = 0;
    Thread t = new Thread(this);
    Timer(PropertyChangeListener l){
        addPropertyChangeListener(l);
        t.start();
    }


    public synchronized int time(){
        return ticks;

    }

    public synchronized void reset(){
        ticks = 0;
    }

    public synchronized void setTime(int time){
        ticks = time;
    }

    public synchronized void stop(){
        allowed = false;
    }

    @SuppressWarnings("deprecation")
    public synchronized void terminate(){

      running=false;
    }

    public synchronized void start(){
        allowed = true;
    }

    private void tick(){
        ticks++;
        changes.firePropertyChange("Ticks", ticks-1, ticks);
    }
    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        long lastTime = currentTime;
        while(running){
            try {
                t.sleep(10);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            if(allowed){

                currentTime = System.currentTimeMillis();
                if(currentTime >= lastTime +1000){
                    tick();
                    lastTime = currentTime;
                }
            }

        }

    }


}
