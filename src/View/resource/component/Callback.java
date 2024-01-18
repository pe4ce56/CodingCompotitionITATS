package View.resource.component;

@FunctionalInterface
public interface Callback {

    public static final int MOUSEENTER = 1;
    public static final int MOUSEEXITED = 2;

    void onHover(int result);
}