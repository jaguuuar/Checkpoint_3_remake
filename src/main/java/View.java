import java.util.Collection;

public class View {

    public void printString(String string) {
        System.out.print(string);
    }

    public void printNumber(Integer number) {
        System.out.print(number);
    }

    public void printStringAndNumber(String string, Integer number) {
        System.out.print(string + number);
    }

    public void printCollection(Collection collection) {
        System.out.print(collection);
    }

}
