package org.codingmatters.code.analysis.model.from.code;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/09/13
 * Time: 06:14
 * To change this template use File | Settings | File Templates.
 */
public class CodeBaseLoaders {
    static public CodeBaseLoader loader() {
        return new DcdCodeBaseLoader();
//        return new JavacCodeBaseLoader();
    }
}
