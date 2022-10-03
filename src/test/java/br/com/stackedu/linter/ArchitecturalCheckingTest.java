package br.com.stackedu.linter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import spoon.Launcher;

public class ArchitecturalCheckingTest {

  @Test
  @DisplayName("Testing if public methods are properly documented")
  public void testName1() throws Exception {
    Launcher spoon = new Launcher();
    spoon.getEnvironment().setNoClasspath(true);
    spoon.addInputResource(new Resources().findFile("UploadFileService.java"));

    PublicMethodsWithoutDocs  processor = new PublicMethodsWithoutDocs();
    spoon.addProcessor(processor);
    spoon.run();

    assertEquals(2, processor.methodsWithoutDocs.size());
  }

  @Test
  @DisplayName("Testing if all catch blocks are not empty")
  public void testName2() throws Exception {
    Launcher l = new Launcher();
    l.getEnvironment().setNoClasspath(true);

    l.addInputResource(new Resources().findFile("UploadFileService.java"));

    TryWithEmptyCatchProcessor processor = new TryWithEmptyCatchProcessor();
    l.addProcessor(processor);
    l.run();

    assertEquals(0, processor.emptyCatchs.size());
  }
}