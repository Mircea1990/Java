package solid.liskov.solution;

public class LiskovSubstitutionPrincipleDemo {

	public static void main(String[] args) {
		FlyingBird[] flyingBirds = new FlyingBird[] { new Crow(), new Sparrow() };
		for (FlyingBird flyingBird : flyingBirds) {
			flyingBird.fly();
		}

		System.out.println("------------");
		Bird[] birds = new Bird[] { new Crow(), new Sparrow(), new Ostrich() };
		for (Bird bird : birds) {
			bird.eat();
		}
	}

}
