package br.com.stackedu.linter;

import java.util.ArrayList;
import java.util.List;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCatch;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.support.Level;

public class TryWithEmptyCatchProcessor extends AbstractProcessor<CtCatch> {

    public final List<CtCatch> emptyCatchs = new ArrayList<>();

    @Override
    public boolean isToBeProcessed(CtCatch candidate) {
        return candidate.getBody().getStatements().isEmpty();
    }

    @Override
    public void process(CtCatch element) {
        getEnvironment().report(this, Level.INFO, "empty catch clause at " + element.getPosition().toString());
        System.out.println("> Catch blocks should not be empty");
        System.out.println(element.getParent(CtType.class).getQualifiedName() + "#"
                + element.getParent(CtMethod.class).getSignature());
        emptyCatchs.add(element);
    }
}