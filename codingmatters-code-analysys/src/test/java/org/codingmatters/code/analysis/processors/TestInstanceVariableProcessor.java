package org.codingmatters.code.analysis.processors;

import com.sun.source.util.Trees;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nel
 * Date: 19/07/13
 * Time: 06:17
 * To change this template use File | Settings | File Templates.
 */

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("*")
public class TestInstanceVariableProcessor extends AbstractProcessor {
    
    private final String inspectedClassname ;
    private final HashSet<String> variableNames = new HashSet<>() ;
    private Trees trees;

    public TestInstanceVariableProcessor(String inspectedClassname) {
        this.inspectedClassname = inspectedClassname;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.trees = Trees.instance(processingEnv) ;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if(! roundEnv.getRootElements().isEmpty()) {
            for (Element root : roundEnv.getRootElements()) {
                if(
                        ElementKind.CLASS.equals(root.getKind()) && 
                                ((TypeElement)root).getQualifiedName().toString().equals(this.inspectedClassname) 
                        ) {
                    for (Name name : VariableNameIndexer.index((TypeElement) root, this.trees).indexed()) {
                        this.variableNames.add(name.toString());
                    }
                }
            }
        }
        return false;
    }

    public Set<String> variableNames() {
        return this.variableNames;
    }
}
