package com.only4play.codegen.processor.query;

import com.google.auto.service.AutoService;
import com.only4play.codegen.processor.BaseCodeGenProcessor;
import com.only4play.codegen.spi.CodeGenProcessor;
import com.squareup.javapoet.TypeSpec;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.annotation.Annotation;
import java.util.Objects;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import lombok.Data;

/**
 * @Author: Gim
 * @Date: 2019-10-08 17:14
 * @Description:
 */
@AutoService(value = CodeGenProcessor.class)
public class GenQueryProcessor extends BaseCodeGenProcessor {

  public static String QUERY_SUFFIX = "Query";
  @Override
  protected void generateClass(TypeElement typeElement, RoundEnvironment roundEnvironment) {
    String className = PREFIX + typeElement.getSimpleName() + QUERY_SUFFIX;
    String sourceClassName = typeElement.getSimpleName() + QUERY_SUFFIX;
    TypeSpec.Builder builder = TypeSpec.classBuilder(className)
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Schema.class)
        .addAnnotation(Data.class);
    addSetterAndGetterMethod(builder, findFields(typeElement, ve -> Objects.nonNull(ve.getAnnotation(
        QueryItem.class))));
    String packageName = generatePackage(typeElement);
    genJavaFile(packageName,builder);
    genJavaFile(packageName, getSourceType(sourceClassName, packageName, className));
  }

  @Override
  public Class<? extends Annotation> getAnnotation() {
    return GenQuery.class;
  }

  @Override
  public String generatePackage(TypeElement typeElement) {
    return typeElement.getAnnotation(GenQuery.class).pkgName();
  }
}
