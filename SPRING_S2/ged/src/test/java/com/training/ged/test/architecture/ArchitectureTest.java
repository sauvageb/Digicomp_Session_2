package com.training.ged.test.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchitectureTest {

    @Test
    public void controllers_should_not_import_entitee_Package() {
        JavaClasses classes = new ClassFileImporter()
                .importPackages("com.training.ged");

        ArchRule rule = noClasses()
                .that()
                .resideInAPackage("..controller..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("..repository..");

        rule.check(classes);
    }

    @Test
    public void controllers_should_be_prefixed_by_controller() {
        JavaClasses classes = new ClassFileImporter()
                        .importPackages("com.training");

        ArchRule rule = classes()
                .that()
                .resideInAPackage("..ged.controller")
                .should()
                        .beAnnotatedWith(Controller.class)
                                .orShould()
                                        .beAnnotatedWith(RestController.class);
        rule.check(classes);
    }


}

