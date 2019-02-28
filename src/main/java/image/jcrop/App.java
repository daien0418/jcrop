package image.jcrop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Hello world!
 * by daien
 */
@SpringBootApplication
public class App  extends WebMvcConfigurerAdapter
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
