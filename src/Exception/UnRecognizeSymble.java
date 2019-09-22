package Exception;

public class UnRecognizeSymble extends Exception {
    public UnRecognizeSymble(char c) {
        super(String.valueOf(c));
    }
}
