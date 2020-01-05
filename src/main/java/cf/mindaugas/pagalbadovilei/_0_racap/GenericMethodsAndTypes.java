package cf.mindaugas.pagalbadovilei._0_racap;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodsAndTypes {
    public static void main(String[] args) {
        String name = "Mindaugas";
        StringContainer stringContainer = new StringContainer(name);
        System.out.println(stringContainer.getItem());

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilderContainer stringBuilderContainer = new StringBuilderContainer(stringBuilder);
        // stringContainer.setItem(stringBuilderContainer);

        Integer integer = 5;
        // stringContainer.setItem(integer);

        GenericContainer<Integer> genericContainerForInts = new GenericContainer<>(integer);
        GenericContainer<StringBuilder> genericContainerForStringBuilder = new GenericContainer<>(stringBuilder);
        GenericContainer<String> genericContainerForString= new GenericContainer<>(name);

        // ... let's try with a Pair container
        Pair<String, String[]> pair1 = new Pair<>("Mindaugas", new String[]{"Jonas", "30", "5555555555"});
        Pair<String, List<String>> pair2 = new Pair<>("Mindaugas", new ArrayList<>());
        Pair<List<String>, List<String>> pair3 = new Pair<>(new ArrayList<>(), new ArrayList<>());

        // ... let's try with bounded generics
        BoundedPair<Lion, String> bp1 = new BoundedPair<>(new Lion(), "Simba");
        BoundedPair<Cat, String> bp2 = new BoundedPair<>(new Cat(), "Simba");

        List<Integer> list = new ArrayList<>();
        BoundedPair<Cat, String> bp3 = new BoundedPair<>(new Lion(), "Simba");
        bp3.printNumbers(list);
    }
}

class StringContainer {
    private String item;
    public StringContainer(String item) {
        this.item = item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public String getItem() {
        return item;
    }
}

class StringBuilderContainer {
    private StringBuilder item;
    public StringBuilderContainer(StringBuilder item) {
        this.item = item;
    }
    public void setItem(StringBuilder item) {
        this.item = item;
    }
    public StringBuilder getItem() {
        return item;
    }
}

class GenericContainer<T> {
    private T item;
    public GenericContainer(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

// class PairOfIntegers ...
// class PairOfStrings ...
class Pair<X, VAL>{
    private X key;
    private VAL value;

    public Pair(X key, VAL value) {
        this.key = key;
        this.value = value;
    }

    public X getKey() {
        return key;
    }

    public void setKey(X key) {
        this.key = key;
    }

    public VAL getValue() {
        return value;
    }

    public void setValue(VAL value) {
        this.value = value;
    }
}



//Wild card with Upper bound - galime dėti klases, kurios yra Cat ar žemesnės
// - Object
//      - Animal
//          - Cat <--- šitas tinka
//              - Lion <--- šitas tinka
class BoundedPair<K extends Cat, V> {
    private K key;
    private V value;

    public BoundedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        key.doSomethingWithThisCar();
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    //java.lang.Object
    //  java.lang.Number
    //      java.lang.Integer
    public void printNumbers(List<? super Integer> list) {
        for (Object number: list)
            System.out.println(number);
        System.out.println();
    }
}

class Animal implements Comparable<Animal> {
    @Override
    public int compareTo(Animal o) {
        return 0;
    }
}

class Cat extends Animal {
    public void doSomethingWithThisCar(){
        System.out.println("doSomethingWithThisCar()");
    }
}

class Lion extends Cat { }

interface Comparable<T> {
    public int compareTo(T o);
}