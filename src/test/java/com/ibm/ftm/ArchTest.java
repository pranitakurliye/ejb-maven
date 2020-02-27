package com.ibm.ftm;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.ibm.ftm");

        noClasses()
            .that()
                .resideInAnyPackage("com.ibm.ftm.service..")
            .or()
                .resideInAnyPackage("com.ibm.ftm.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.ibm.ftm.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
