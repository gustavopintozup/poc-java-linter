package br.com.stackedu.linter;

import java.util.ArrayList;
import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.ModifierKind;
import spoon.support.Level;

public class PublicMethodsWithoutDocs extends AbstractProcessor<CtMethod> {

    public final List<CtMethod> methodsWithoutDocs = new ArrayList<>();

    @Override
    public boolean isToBeProcessed(CtMethod method) {
        if (method.hasModifier(ModifierKind.PUBLIC)) {
            if (method.getDocComment().length() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void process(CtMethod method) {
        System.out.println("Public methods should be documented!");
        System.out.println(method.getParent(CtType.class).getQualifiedName() + "#" + method.getSignature());

        getEnvironment().report(this, Level.INFO, "Public methods should be documented!");
        methodsWithoutDocs.add(method);
    }
}