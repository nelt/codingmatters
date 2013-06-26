package org.codingmatters.injector.injectors;

import org.codingmatters.injector.exception.InjectionException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 26/06/13
 * Time: 07:17
 * To change this template use File | Settings | File Templates.
 */
public class AnnotatedFieldInjector extends FieldInjector {
    private final Class<? extends Annotation> annotationClass;

    public AnnotatedFieldInjector(String field, Class<? extends Annotation> annotationClass, Object value) {
        super(field, value) ;
        this.annotationClass = annotationClass;
    }

    @Override
    protected boolean matches(Field field) throws Exception {
        Annotation annotation = field.getAnnotation(this.annotationClass);
        return annotation != null ;
    }
}
