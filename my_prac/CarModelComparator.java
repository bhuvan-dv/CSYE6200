import java.util.Comparator;

public class CarModelComparator implements Comparator <Car>{

    @Override
    public int compare(Car c1, Car c2) {
        return c1.getModel().compareToIgnoreCase(c2.getModel());
    }
    
}
