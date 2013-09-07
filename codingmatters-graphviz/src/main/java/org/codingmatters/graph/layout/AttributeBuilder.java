package org.codingmatters.graph.layout;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 04/09/13
 * Time: 06:39
 * To change this template use File | Settings | File Templates.
 */
public abstract class AttributeBuilder<B extends AttributeBuilder<B>> {
    protected abstract B self();
}
