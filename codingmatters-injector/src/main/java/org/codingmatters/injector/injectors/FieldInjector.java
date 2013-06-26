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
    private final String field;
    private final Object value;

    public FieldInjector(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    public void inject(Object bean) throws InjectionException {
        try {
            Field field = bean.getClass().getDeclaredField(this.field);
            if(this.matches(field)) {
                this.setFieldValue(bean, field);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new InjectionException(e) ;
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
