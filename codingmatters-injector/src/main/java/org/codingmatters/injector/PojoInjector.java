package org.codingmatters.injector;

import org.codingmatters.injector.exception.InjectionException;
import org.codingmatters.injector.injectors.AnnotatedFieldInjector;
import org.codingmatters.injector.injectors.Injector;
import org.codingmatters.injector.injectors.AnnotationMatcher;
import org.codingmatters.injector.injectors.RawFieldInjector;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 25/06/13
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class PojoInjector {
    private final ArrayList<Injector> injectors = new ArrayList<>();
    
    public <T> T injectValues(T bean) throws InjectionException {
        for (Injector injector : this.injectors) {
            injector.inject(bean);
        }
        return bean ;
    }
    
    public PojoInjector rawField(String field, Object value) {
        this.injectors.add(new RawFieldInjector(field, value)) ;
        return this ;
    }

    public <T extends Annotation> PojoInjector annotatedField(Class<T> anotationClass, Object value) {
        return this.annotatedField(anotationClass, AnnotationMatcher.<T>matchall(), value) ;
    }

    public <T extends Annotation> PojoInjector annotatedField(Class<T> anotationClass, AnnotationMatcher<T> matcher, Object value) {
        this.injectors.add(new AnnotatedFieldInjector<T>(anotationClass, matcher, value));
        return this ;
    }
}
