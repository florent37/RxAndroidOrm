package com.github.florent37.rxandroidorm.generator;

import com.github.florent37.rxandroidorm.Constants;
import com.github.florent37.rxandroidorm.ProcessUtils;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

import javax.lang.model.element.Modifier;

/**
 * Created by Thibaud Giovannetti on 09/05/2017.
 */
public class ModelORMInterfaceGenerator {

    public ModelORMInterfaceGenerator() {

    }

    public TypeSpec generate() {
        final TypeVariableName T = TypeVariableName.get("T");
        final TypeName LIST_OF_T = ParameterizedTypeName.get(ClassName.get("java.util", "List"), T);

        final TypeName RETURN_T = ProcessUtils.observableOf(T);
        final TypeName RETURN_LIST_T = ProcessUtils.observableOf(LIST_OF_T);

        return TypeSpec.interfaceBuilder(Constants.DATABASE_COMMON_INTERFACE_NAME)
                .addModifiers(Modifier.PUBLIC)
                .addTypeVariable(T)


                .addMethod(MethodSpec.methodBuilder("select")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .returns(Constants.queryBuilderClassName)
                        .build())

                .addMethod(MethodSpec.methodBuilder("add")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .addParameter(T, "object", Modifier.FINAL)
                        .returns(RETURN_T)
                        .build())

                .addMethod(MethodSpec.methodBuilder("add")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .addParameter(LIST_OF_T, "objects", Modifier.FINAL)
                        .returns(RETURN_LIST_T)
                        .build())

                .addMethod(MethodSpec.methodBuilder("update")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .addParameter(T, "object", Modifier.FINAL)
                        .returns(RETURN_T)
                        .build())

                .addMethod(MethodSpec.methodBuilder("update")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .addParameter(LIST_OF_T, "objects", Modifier.FINAL)
                        .returns(RETURN_LIST_T)
                        .build())

                .addMethod(MethodSpec.methodBuilder("delete")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .addParameter(T, "object", Modifier.FINAL)
                        .returns(ProcessUtils.observableOf(TypeName.BOOLEAN.box()))
                        .build())

                .addMethod(MethodSpec.methodBuilder("delete")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .addParameter(LIST_OF_T, "objects", Modifier.FINAL)
                        .returns(ProcessUtils.observableOf(TypeName.BOOLEAN.box()))
                        .build())

                .addMethod(MethodSpec.methodBuilder("deleteAll")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .returns(ProcessUtils.observableOf(TypeName.BOOLEAN.box()))
                        .build())

                .addMethod(MethodSpec.methodBuilder("count")
                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                        .returns(ProcessUtils.observableOf(TypeName.INT.box()))
                        .build())

                .build();
    }
}
