package org.codingmatters.injector;

import org.codingmatters.injector.exception.InjectionException;
import org.codingmatters.injector.injectors.Injector;
import org.codingmatters.injector.injectors.RawFieldInjector;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 25/06/13
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class PojoInjector {
    private final HashMap<String, Injector> injectors = new HashMap<>() ;
    
    public <T> T injectValues(T bean) throws InjectionException {
        for (String fieldName : this.injectors.keySet()) {
            this.injectors.get(fieldName).inject(bean) ;
        }
        return bean ;
    }
    
    public PojoInjector rawField(String field, Object value) {
        this.injectors.put(field, new RawFieldInjector(field, value)) ;
        return this ;
    }
}
