import com.example.Car;
import com.example.Engine;
import com.example.Suspension;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// MainXmlAndAnnotationConfig.java
public class MainXmlAndAnnotationConfig {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnotation.xml");
        Car car = context.getBean(Car.class);
        System.out.println(car);

        Engine engine = context.getBean(Engine.class);
        System.out.println(engine.getFullDescription());

        Suspension suspension = context.getBean(Suspension.class);
        System.out.println(suspension.getFullDescription());
    }
}