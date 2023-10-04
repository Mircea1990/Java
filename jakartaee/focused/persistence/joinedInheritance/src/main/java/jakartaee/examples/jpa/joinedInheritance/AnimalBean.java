package jakartaee.examples.jpa.joinedInheritance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

/**
 * The bean used to demonstrate usage of @Inheritance with Joined strategy
 */
@Named("animal") @RequestScoped public class AnimalBean implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private AnimalEjb animalEjb;

    private List<Cat> cats;
    private List<Dog> dogs;

    /**
     * Saves information of two animals of type cat and dog
     */
    public void saveAndLoad() {
        animalEjb.persist();

        cats = animalEjb.findAllCats();
        dogs = animalEjb.findAllDogs();
    }

    public List<Cat> getCats() {
        return cats;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

}
