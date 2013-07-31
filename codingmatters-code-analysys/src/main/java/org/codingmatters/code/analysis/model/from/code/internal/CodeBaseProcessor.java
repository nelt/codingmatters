package org.codingmatters.code.analysis.model.from.code.internal;

import com.sun.source.util.Trees;
import org.codingmatters.code.analysis.model.ClassModel;
import org.codingmatters.code.analysis.model.CodeBaseModel;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
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
    private Trees trees;

    public CodeBaseProcessor(CodeBaseModel codeBaseModel) {
        this.codeBaseModel = codeBaseModel;
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
                if(ElementKind.CLASS.equals(root.getKind())) {
                    ClassModel model = ClassModel.forName(((TypeElement) root).getQualifiedName().toString());
                    this.codeBaseModel.addClass(model);
                    
                    root.accept(new ClassVisitor(model, trees), null);
                }
            }
        }
        return false;
    }
}
