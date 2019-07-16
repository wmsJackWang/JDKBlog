package springboot.anoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import springboot.enums.RedisDataSource;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RDS {

	RedisDataSource value();
}
