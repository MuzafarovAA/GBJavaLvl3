package lesson1.homeworkPt3;

public class HomeworkPt3 {

    public static void main(String[] args) {

        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> box1 = new Box();
        Box<Orange> box2 = new Box();
        Box<Apple> box3 = new Box();
        box1.add(apple);
        box1.add(apple);
        box1.add(apple);
        box1.add(apple);
        box2.add(orange);
        box2.add(orange);
        box3.add(apple);
        box3.add(apple);
        box3.add(apple);

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());

        System.out.println(box1.compare(box2));
        System.out.println(box1.compare(box3));
        System.out.println(box2.compare(box3));

        box1.transfer(box3);

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());

        box1.add(apple);
        System.out.println(box1.getWeight());

    }
}