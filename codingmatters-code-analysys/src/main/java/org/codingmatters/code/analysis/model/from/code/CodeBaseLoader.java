package org.codingmatters.code.analysis.model.from.code;

import org.codingmatters.code.analysis.model.CodeBaseModel;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 23/09/13
 * Time: 06:12
 * To change this template use File | Settings | File Templates.
 */
public interface CodeBaseLoader {
    CodeBaseLoader addSourcePath(File directory) throws IOException;
    CodeBaseModel load() throws IOException;
}
