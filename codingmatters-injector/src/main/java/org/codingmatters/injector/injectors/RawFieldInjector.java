package org.codingmatters.injector.injectors;

import org.codingmatters.injector.exception.InjectionException;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 25/06/13
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
public class RawFieldInjector implements Injector {
    private final String field;
    private final Object value;

    public RawFieldInjector(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    public void inject(Object bean) throws InjectionException {
        try {
            Field field = bean.getClass().getDeclaredField(this.field);
            boolean accessibility = field.isAccessible();
            field.setAccessible(true);
            field.set(bean, this.value);
            field.setAccessible(accessibility);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new InjectionException(e) ;
        }
    }
}
