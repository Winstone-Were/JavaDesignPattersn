
abstract class Animal{
    public abstract String getName();

    public static Animal createAnimal(String type) {
        switch (type) {
            case "cat":
                return new Cat();
                break;
            case "dog":
                return new Dog();
                break;
        }
    }

}

class Cat extends Animal {
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Cat";
    }
}

class Dog extends Animal {
    @Override
    public String getName() {
        return "Dog";
    }
}

