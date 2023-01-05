import java.util.Objects;
import java.util.Optional;

/*
        Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий элементам
        принимать значение null.
        Реализуйте методы getFirst(), getSecond(), equals() и hashCode().
        Реализуйте статический фабричный метод of(). Конструктор должен быть закрытым (private).
        Реализуйте метод ifPresent, аналогичный одноименному методу класса Optional и принимающий java.util.function.BiConsumer
        Реализуйте метод empty(), который возвращает экземпляр с нулевыми полями {null,null} (см. реализацию в классе Optional).*/
public class PairDemo {
    public static void main(String[] args) {
        Pair<Integer,String> pair = Pair.of(1, "Hello");
       // Optional<Integer> optional = new Optional<>();
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        System.out.printf("key: %d, value: %s",i,s);

    }
}
class Pair <K,V> {


    private final K key;
    private final V value;

    private static final Pair<?,?> EMPTY = new Pair<>(null, null);

    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

 //   private Pair() {
   //}

   public static <K,V> Pair of(K key, V value){
       return new Pair(key, value);


   }
    public static<K,V> Pair<K,V> empty() {

        Pair<K,V> pair = (Pair<K,V>) EMPTY;
        return pair;
    }

    public K getFirst() {
        return key;
    }

    public V getSecond() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) &&
                Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
