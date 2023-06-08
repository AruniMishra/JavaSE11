package outOfOrdinary;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

// This processor will process ALL annotations.
@SupportedAnnotationTypes({"*"})
@SupportedSourceVersion(SourceVersion.RELEASE_11)

// Annotation processors extend AbstractProcessor
public class CustomProcessor extends AbstractProcessor {

    // Constructor required if used by external tools
    public CustomProcessor() {

    }

    // Implementing process method to do what you want with annotations
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        String info = null;
        for (TypeElement annotation : annotations) {
            // Using getElementsAnnotatedWithAny which checks for 
            // inherited annotations
            System.out.println(annotation);
            for (Element element : roundEnv.getElementsAnnotatedWithAny(annotation)) {

                info = "\t" + element.getKind() + " :  " +
                        // Strip out unnamed package information using
                        // ternary operator
                        ((element.getEnclosingElement().toString().contains("unnamed"))
                                // If element enclosed, print enclosing element
                                ? "" : element.getEnclosingElement() + ".") +
                        // element name
                        element;

                System.out.println(info);
            }
        }

        // return true if this is the only processor permitted to
        // process the annotations listed in SupportedAnnotationTypes
        return false;
    }
}