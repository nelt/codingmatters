package org.codingmatters.injector.injectors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 26/06/13
 * Time: 07:17
 * To change this template use File | Settings | File Templates.
 */
public class AnnotatedFieldInjector<T extends Annotation> extends FieldInjector {
    private final Class<T> annotationClass;
    private final AnnotationMatcher<T> matcher;

    public AnnotatedFieldInjector(Class<T> annotationClass, AnnotationMatcher<T> matcher, Object value) {
        super(value) ;
        this.annotationClass = annotationClass;
        this.matcher = matcher;
    }

    @Override
    protected boolean matches(Field field) throws Exception {
        T annotation = field.getAnnotation(this.annotationClass);
        return annotation != null && this.matcher.matches(annotation);
    }
}
