package java8Task1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    int age;
    String name;
    int weight;
    boolean sex;
    String speciality;

    public User(int age, String name, int weight, boolean sex, String speciality) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.sex = sex;
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", sex=" + sex +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
