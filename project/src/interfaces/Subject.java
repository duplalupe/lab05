package interfaces;

public interface Subject {
    public void attach(Observer obs);

    public void dettach(Observer obs);

    public void notifyUpdate();
}
