package org.codingmatters.injector.injectors;

import org.codingmatters.injector.exception.InjectionException;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 25/06/13
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public interface Injector {
    void inject(Object bean) throws InjectionException ;
}
