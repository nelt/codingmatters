package org.codingmatters.injector.injectors;

import org.codingmatters.injector.exception.InjectionException;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 26/06/13
 * Time: 07:20
 * To change this template use File | Settings | File Templates.
 */
public abstract class FieldInjector implements Injector {
    private final Object value;

    public FieldInjector(Object value) {
        this.value = value;
    }

    public void inject(Object bean) throws InjectionException {
        try {
            for (Field field : bean.getClass().getDeclaredFields()) {
                if(this.matches(field)) {
                    this.setFieldValue(bean, field);
                }
            }
        } catch (Exception e) {
            throw new InjectionException(e) ;
        }
    }

    protected abstract boolean matches(Field field) throws Exception ;

    private void setFieldValue(Object bean, Field field) throws IllegalAccessException {
        boolean accessibility = field.isAccessible();
        field.setAccessible(true);
        field.set(bean, this.value);
        field.setAccessible(accessibility);
    }
}
