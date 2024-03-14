package swigncomponents;

public interface PortionListener {
    void onClick(int x, int y);

    void onPress(int x, int y);

    void onRelease(int x, int y);

    void dragged(int x,int y);
}
