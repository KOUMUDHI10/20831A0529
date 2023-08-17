import java.util.Set;

public class NumberResponse {
    private Set<Integer> numbers;

    public NumberResponse() {
    }

    public NumberResponse(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }
}
