package top.bwang;

import com.jayway.jsonpath.internal.function.numeric.Average;
import com.jayway.jsonpath.internal.function.numeric.Min;
import org.apache.catalina.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalTest {

    @Test
    public void TestIfPresentOrElse() {
        /*Optional<String> optional = Optional.of("javaone");
        if (optional.isPresent()) {
            System.out.println(optional);
        }

        optional.ifPresent(System.out::println);*/
        String nullName = "1";
        String name = Optional.ofNullable(nullName).orElse(getName());
        System.out.println("====================");
        String str = Optional.ofNullable(nullName).orElseGet(() -> getName());
    }

    public String getName() {
        System.out.println("被执行");
        return "other";
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Random().nextInt(1000));
        }
        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(collect);
    }

}
