package org.codingmatters.injector.injectors;

import java.lang.annotation.Annotation;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 27/06/13
 * Time: 22:03
 * To change this template use File | Settings | File Templates.
 */
public abstract class AnnotationMatcher<T extends Annotation> {
    
    static public <A extends Annotation> AnnotationMatcher<A> matchall() {
        return new AnnotationMatcher<A>() {
            @Override
            public boolean matches(A annotation) throws Exception {
                return true;
            }
        } ;
    }
    
    public abstract boolean matches(T annotation) throws Exception ;
}
