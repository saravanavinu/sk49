package foodorderingsystem;

public interface Pizza
{
    String getDescription();
    double getCost();
}

package foodorderingsystem;

   public class PlainPizza implements Pizza
   {
    @Override
    public String getDescription()
    {
        return "Plain Pizza";
    }
    @Override
    public double getCost()
    {
        return 120.0;
    }
}


package foodorderingsystem;

    public abstract class PizzaDecorator implements Pizza 
    {
    protected Pizza pizza;
    public PizzaDecorator(Pizza pizza) 
    {
        this.pizza = pizza;
    }
}


package foodorderingsystem;

    public class Cheese extends PizzaDecorator
    {
    public Cheese(Pizza pizza)
    {
        super(pizza);
    }
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + ", Cheese";
    }
    @Override
    public double getCost() 
    {
        return pizza.getCost() + 30.0;
    }
}


package foodorderingsystem;

    public class Mushroom extends PizzaDecorator 
    {
    public Mushroom(Pizza pizza)
    {
        super(pizza);
    }
    @Override
    public String getDescription() 
    {
        return pizza.getDescription() + ", Mushroom";
    }
    @Override
    public double getCost()
    {
        return pizza.getCost() + 25.0;
    }
}


package foodorderingsystem;

    public class Olive extends PizzaDecorator 
    {
    public Olive(Pizza pizza)
    {
        super(pizza);
    }
    @Override
    public String getDescription()
    {
        return pizza.getDescription() + ", Olive";
    }
    @Override
    public double getCost()
    {
        return pizza.getCost() + 20.0;
    }
}


package foodorderingsystem;

public class FoodOrderingSystem {

    public static void main(String[] args) {

        Pizza p1 = new PlainPizza();
        Pizza p2 = new Cheese(new PlainPizza());
		
        Pizza p3 = new Mushroom(new Cheese( new PlainPizza()));
        Pizza p4 = new Olive(new Mushroom(new Cheese(new PlainPizza())));

        System.out.println("Description : " + p1.getDescription());
        System.out.println("Cost        : " + p1.getCost());
        System.out.println();
        System.out.println("Description : " + p2.getDescription());
        System.out.println("Cost        : " + p2.getCost());
        System.out.println();
        System.out.println("Description : " + p3.getDescription());
        System.out.println("Cost        : " + p3.getCost());
        System.out.println();
        System.out.println("Description : " + p4.getDescription());
        System.out.println("Cost        : " + p4.getCost());
    }
}