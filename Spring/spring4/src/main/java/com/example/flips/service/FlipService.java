package com.example.flips.service;

import com.example.flips.model.Foo;
import org.flips.annotation.FlipBean;
import org.flips.annotation.FlipOnSpringExpression;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// The @Service annotation is used with classes that provide some business functionalities.
@Service public class FlipService {
    // A list of Foo objects is declared.
    private final List<Foo> foos;

    // In the constructor, the list is initialized and some Foo objects are added to it.
    public FlipService() {
        foos = new ArrayList<>();
        foos.add(new Foo("Foo1", 1));
        foos.add(new Foo("Foo2", 2));
        foos.add(new Foo("Foo3", 3));
        foos.add(new Foo("Foo4", 4));
        foos.add(new Foo("Foo5", 5));
        foos.add(new Foo("Foo6", 6));
    }

    // This method returns all the Foo objects in the list.
    public List<Foo> getAllFoos() {
        return foos;
    }

    // This method returns a Foo object with the given id. If no such object is found, it returns
    // an empty Optional.
    public Optional<Foo> getFooById(int id) {
        return foos.stream().filter(foo -> (foo.getId() == id)).findFirst();
    }

    // This method returns a new Foo object. The @FlipBean and @FlipOnSpringExpression
    // annotations are custom annotations used for feature flipping based on certain conditions.
    @FlipBean(with = NewFlipService.class) @FlipOnSpringExpression(expression = "(2 + 2) == 4")
    public Foo getNewFoo() {
        return new Foo("New Foo!", 99);
    }

    // This method returns the last Foo object in the list.
    public Foo getLastFoo() {
        return foos.get(foos.size() - 1);
    }
}
