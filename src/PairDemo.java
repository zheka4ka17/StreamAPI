import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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
        Pair<Integer,String> pair2 = Pair.of(1, "Hello");
       // Optional<Integer> optional = new Optional<>();
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        System.out.printf("key: %d, value: %s",i,s);
        System.out.println();

        boolean b1 = pair.equals(pair2);
        boolean b2 = pair.hashCode()== pair2.hashCode();

        System.out.println(b1+" "+ b2);

        pair.ifPresent((first, second) -> {
            System.out.println(first);
            System.out.println(second);
        });

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

    public void ifPresent(BiConsumer<? super K, ? super V> action) {
        if (key!= null && value!=null) {
            action.accept(key, value);
        }
    }

}
