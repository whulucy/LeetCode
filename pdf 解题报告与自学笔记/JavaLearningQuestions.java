int foo;
String StringThatCouldBeANumberOrNot = "26263Hello"; //will throw exception
String StringThatCouldBeANumberOrNot2 = "26263"; //will not throw exception
try {
      foo = Integer.parseInt(StringThatCouldBeANumberOrNot);
} catch (NumberFormatException e) {
      //Will Throw exception!
      //do something! anything to handle the exception.
}

try {
      foo = Integer.parseInt(StringThatCouldBeANumberOrNot2);
} catch (NumberFormatException e) {
      //No problem this time, but still it is good practice to care about exceptions.
      //Never trust user input :)
      //Do something! Anything to handle the exception.
}

ToDO Question
NumberFormatException 是自己写的， 还是系统自带的？


public abstract class Duck {
  FlyBehavior flyBehavior;
  QuackBehavior quackBehavior;
  public Duck() {

  }
  public abstract void display();

  public void performFly() {
    flyBehavior.fly();
  }
  public void performQuack(){
    quackBehavior.quack();
  }
  public void swim() {
    System.out.println("All ducks float, even decoys");
  }
}

public interface FlyBehavior {
  public void fly();
}

public class FlyWithWings implements FlyBehavior {
  public void fly() {
    System.out.println ("I'm flying");
  }
}
public class FlyNoWay implements FlyBehavior {
  public void fly() {
    System.out.println("I cab't fly");
  }
}

public class MallardDuck extends Duck {
  public MallardDuck() {
    quackBehavior = new Quack();
    flyBehavior = new FlyWithWings;
  }
}
