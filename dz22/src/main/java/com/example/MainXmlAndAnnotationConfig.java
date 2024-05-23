import com.example.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// MainXmlAndAnnotationConfig.java
public class MainXmlAndAnnotationConfig {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnotation.xml");
        Car car = context.getBean(Car.class);
        System.out.println(car);
    }
}