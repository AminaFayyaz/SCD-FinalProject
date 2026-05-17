public class ValidationService {

    public boolean validIndex(int i, int size) {
        return i >= 0 && i < size;
    }

    public boolean empty(int count) {
        return count == 0;
    }
}