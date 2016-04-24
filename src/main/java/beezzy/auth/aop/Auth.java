package beezzy.auth.aop;

import beezzy.domain.enums.Permissions;
import beezzy.domain.enums.Roles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by oleh on 06.04.2016.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {

    Roles[] roles() default { };

    boolean required() default false;

}
