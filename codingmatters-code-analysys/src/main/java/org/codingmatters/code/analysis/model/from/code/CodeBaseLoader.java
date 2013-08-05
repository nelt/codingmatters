package org.codingmatters.code.analysis.model.from.code;


import org.codingmatters.code.analysis.model.CodeBaseModel;
import org.codingmatters.code.analysis.model.from.code.internal.CodeBaseProcessor;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 31/07/13
 * Time: 07:00
 */
public class CodeBaseLoader {

    private final JavaCompiler compiler;
    private final ArrayList<File> sourcePaths = new ArrayList<>();
    
    public CodeBaseLoader() {
        this.compiler = ToolProvider.getSystemJavaCompiler();
    }

    public CodeBaseLoader addSourcePath(File directory) {
        if(! this.sourcePaths.contains(directory)) {
            this.sourcePaths.add(directory);
        }
        return this;
    }

    public CodeBaseModel load() throws IOException {        
        CodeBaseModel result = new CodeBaseModel();

        JavaCompiler.CompilationTask task = this.createCompilationTask();
        task.setProcessors(Arrays.asList(new CodeBaseProcessor(result)));
        task.call();
        
        return result;
    }

    private JavaCompiler.CompilationTask createCompilationTask() throws IOException {
        StandardJavaFileManager fileManager = this.compiler.getStandardFileManager(null, null, null);
        fileManager.setLocation(StandardLocation.SOURCE_PATH, this.sourcePaths);
        Iterable<JavaFileObject> sources = fileManager.list(StandardLocation.SOURCE_PATH, "", Collections.singleton(JavaFileObject.Kind.SOURCE), true);
        return compiler.getTask(null, fileManager, null, null, null, sources);
    }
}
