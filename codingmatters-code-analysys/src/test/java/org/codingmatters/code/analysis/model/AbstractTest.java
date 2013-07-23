package org.codingmatters.code.analysis.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/07/13
 * Time: 07:12
 * To change this template use File | Settings | File Templates.
 */
public class AbstractTest {

    protected Set set(Object ... elements) {
        HashSet result = new HashSet();
        if(elements != null) {
            for (Object element : elements) {
                result.add(element);
            }

        }
        return result;
    }
}
