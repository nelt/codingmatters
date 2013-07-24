package org.codingmatters.code.analysis.model.lookup;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/07/13
 * Time: 07:01
 * To change this template use File | Settings | File Templates.
 */
public interface Lookup<LookedUp>  {
    Iterable<LookedUp> lookup() throws LookupException;
}
