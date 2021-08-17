package lesson1.homeworkPt3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    ArrayList<T> arrayList = new ArrayList<>();

    public void add(T t) {
        arrayList.add(t);
    }

    public float getWeight() {
        float weight = 0f;

        for (int i = 0; i < arrayList.size(); i++) {
            weight = weight + (arrayList.get(i)).getFruitWeight();
        }

        return weight;
    }

    public boolean compare(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.00001;
    }

    public void transfer(Box<T> another) {
        for (int i = 0; i < arrayList.size(); i++) {
            another.add(arrayList.get(i));
        }
        arrayList.clear();
    }

}
