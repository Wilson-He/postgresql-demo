package per.demo;

import reactor.core.publisher.Flux;

/**
 * FluxTest
 *
 * @author Wilson
 * @date 18-5-7
 */
public class FluxTest {
    public static void main(String[] args) {
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .zipWith(Flux.just("a", "d"))
                .zipWith(Flux.just("b", "d"))
                .subscribe(System.out::println);
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d", "e"), (s1, s2) -> String.format("%s-%s", s1, s2))
                .subscribe(System.out::println);
        Flux.range(1, 100).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);
    }
}
