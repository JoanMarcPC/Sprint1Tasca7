package tasca7n2ex1;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;



@Retention(RUNTIME)
@Target(TYPE)
public @interface JsonSerializable {
	public String ruta() default "";
}
