package jakartaee.examples.jpa.joinedInheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;



@Entity @DiscriminatorValue("1") public class Cat extends Animal {

    private Integer age;

    public Cat() {
    }

    public Cat(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
