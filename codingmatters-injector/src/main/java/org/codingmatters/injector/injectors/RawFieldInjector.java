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
public class RawFieldInjector extends FieldInjector {

    private final String field;

    public RawFieldInjector(String field, Object value) {
        super(value);
        this.field = field;
    }

    @Override
    protected boolean matches(Field field) throws Exception {
        return field.getName().equals(this.field) ;
    }


}
