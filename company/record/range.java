package company.record;

public record range(int start, int end) {
    int distance() {
        return end - start;
    }

    public static void main(String[] args) {
        range r = new range(100, 200);
        System.out.println(r.distance());
    }
}
