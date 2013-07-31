package org.codingmatters.code.analysis.model.from.code.internal;

import org.codingmatters.code.analysis.model.ClassModel;
import org.codingmatters.code.analysis.model.CodeBaseModel;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: nelt
 * Date: 31/07/13
 * Time: 07:16
 */

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("*")
public class CodeBaseProcessor extends AbstractProcessor {
    private final CodeBaseModel codeBaseModel;

    public CodeBaseProcessor(CodeBaseModel codeBaseModel) {
        this.codeBaseModel = codeBaseModel;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if(! roundEnv.getRootElements().isEmpty()) {
            for (Element root : roundEnv.getRootElements()) {
                if(ElementKind.CLASS.equals(root.getKind())) {
                    this.codeBaseModel.addClass(ClassModel.forName(((TypeElement)root).getQualifiedName().toString()));
                }
            }
        }
        return false;
    }
}
