package cf.mindaugas.pagalbadovilei._0_racap;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class Annotations {
    public static void main(String[] args) {
        AnimalBase.addToList(new ArrayList(), "Mindaugas");
    }
}

class AnimalBase {
    void makeNoise(){
        System.out.println("Noise");
        System.out.println("fsdfsdf");
    }

    @SuppressWarnings("unchecked")
    public static void addToList(List list, String string) {
        list.add(string);
    }
}

class CatBase extends AnimalBase {
    @Override
    void makeNoise(){
        System.out.println("Cat noise");
    }

    @Override
    public String toString() {
        return "CatBase{} " + super.toString();
    }
}

// ... declaring custom annotations

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface JsonSerializable {

}

// ... to apply annotations you need to know java reflection api
// ... see example: https://www.baeldung.com/java-custom-annotation