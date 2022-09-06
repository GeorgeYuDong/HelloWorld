package src.company.juc.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

public class StreamComputeDemo {
    public static void main(String[] args) {
        User a = new User(1, "a", 21);
        User b = new User(2, "b", 22);
        User c = new User(3, "c", 23);
        User d = new User(4, "d", 24);
        User e = new User(5, "e", 25);
        User f = new User(6, "f", 26);

        List<User> list = Arrays.asList(a, b, c, d, e, f);

        list.stream().filter((u) -> {
                    return u.getId() % 2 == 0;
                })
                .map((u) -> {
                    return u.getName().toUpperCase();
                })
                .sorted((us1, us2) -> {
                    return us2.compareTo(us1);
                })
                .limit(3)
                .forEachOrdered(System.out::println);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private int age;
    private String name;
    private int id;
}
