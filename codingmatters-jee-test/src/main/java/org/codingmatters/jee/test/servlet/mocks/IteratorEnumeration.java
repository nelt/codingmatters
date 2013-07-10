package org.codingmatters.jee.test.servlet.mocks;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 10/07/13
 * Time: 02:32
 * To change this template use File | Settings | File Templates.
 */
public class IteratorEnumeration<T> implements Enumeration<T> {

    private final Iterator<T> delegate ;

    public IteratorEnumeration(Iterator<T> delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean hasMoreElements() {
        return this.delegate.hasNext() ;
    }

    @Override
    public T nextElement() {
        return this.delegate.next() ;
    }
}
