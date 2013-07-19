package org.codingmatters.code.analysis.processors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
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

    public TestInstanceVariableProcessor(String inspectedClassname) {
        this.inspectedClassname = inspectedClassname;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if(! roundEnv.getRootElements().isEmpty()) {
            for (Element root : roundEnv.getRootElements()) {
                if(
                        ElementKind.CLASS.equals(root.getKind()) && 
                                ((TypeElement)root).getQualifiedName().toString().equals(this.inspectedClassname) 
                        ) {
                    for (Name name : VariableNameIndexer.index((TypeElement) root).indexed()) {
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
