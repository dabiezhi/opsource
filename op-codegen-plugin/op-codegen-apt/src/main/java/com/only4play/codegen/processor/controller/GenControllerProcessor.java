package com.only4play.codegen.processor.controller;


import com.google.auto.service.AutoService;
import com.only4play.codegen.processor.BaseCodeGenProcessor;
import com.only4play.codegen.processor.DefaultNameContext;
import com.only4play.codegen.spi.CodeGenProcessor;
import com.only4play.codegen.util.StringUtils;
import com.only4play.common.constants.CodeEnum;
import com.only4play.common.model.JsonObject;
import com.only4play.common.model.PageRequestWrapper;
import com.only4play.common.model.PageResult;
import com.squareup.javapoet.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import java.lang.annotation.Annotation;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author gim
 * 获取名称时可以先获取上下文再取，不用一个个的取，这样更方便
 */
@AutoService(value = CodeGenProcessor.class)
public class GenControllerProcessor extends BaseCodeGenProcessor {

    public static final String CONTROLLER_SUFFIX = "Controller";

    @Override
    protected void generateClass(TypeElement typeElement, RoundEnvironment roundEnvironment) {
        DefaultNameContext nameContext = getNameContext(typeElement);
        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(nameContext.getControllerClassName())
                .addAnnotation(RestController.class)
                .addAnnotation(Slf4j.class)
                .addAnnotation(AnnotationSpec.builder(RequestMapping.class).addMember("value", "$S", StringUtils.camel(typeElement.getSimpleName().toString()) + "/v1").build())
                .addAnnotation(RequiredArgsConstructor.class)
                .addModifiers(Modifier.PUBLIC);
        String serviceFieldName = StringUtils.camel(typeElement.getSimpleName().toString()) + "Service";
        if(StringUtils.containsNull(nameContext.getServicePackageName())){
            return;
        }
        FieldSpec serviceField = FieldSpec
                .builder(ClassName.get(nameContext.getServicePackageName(), nameContext.getServiceClassName()), serviceFieldName)
                .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .build();
        typeSpecBuilder.addField(serviceField);
        Optional<MethodSpec> createMethod = createMethod(serviceFieldName, typeElement, nameContext);
        createMethod.ifPresent(m -> typeSpecBuilder.addMethod(m));
        Optional<MethodSpec> updateMethod = updateMethod(serviceFieldName, typeElement, nameContext);
        updateMethod.ifPresent(m -> typeSpecBuilder.addMethod(m));
        Optional<MethodSpec> validMethod = validMethod(serviceFieldName, typeElement);
        validMethod.ifPresent(m -> typeSpecBuilder.addMethod(m));
        Optional<MethodSpec> invalidMethod = inValidMethod(serviceFieldName, typeElement);
        invalidMethod.ifPresent(m -> typeSpecBuilder.addMethod(m));
        Optional<MethodSpec> findById = findById(serviceFieldName, nameContext);
        findById.ifPresent(m -> typeSpecBuilder.addMethod(m));
        Optional<MethodSpec> findByPage = findByPage(serviceFieldName, nameContext);
        findByPage.ifPresent(m -> typeSpecBuilder.addMethod(m));
        genJavaSourceFile(generatePackage(typeElement),
                typeElement.getAnnotation(GenController.class).sourcePath(), typeSpecBuilder);
    }

    @Override
    public Class<? extends Annotation> getAnnotation() {
        return GenController.class;
    }

    @Override
    public String generatePackage(TypeElement typeElement) {
        return typeElement.getAnnotation(GenController.class).pkgName();
    }

    /**
     * 创建方法
     *
     * @param serviceFieldName
     * @param typeElement
     * @param nameContext
     * @return
     */
    private Optional<MethodSpec> createMethod(String serviceFieldName, TypeElement typeElement, DefaultNameContext nameContext) {
        boolean containsNull = StringUtils.containsNull(nameContext.getCreatePackageName(), nameContext.getCreatorPackageName(), nameContext.getMapperPackageName());
        if (!containsNull) {
            return Optional.of(MethodSpec.methodBuilder("create" + typeElement.getSimpleName())
                    .addParameter(ParameterSpec.builder(ClassName.get(nameContext.getCreatePackageName(), nameContext.getCreateClassName()), "request").addAnnotation(
                            RequestBody.class).build())
                    .addAnnotation(AnnotationSpec.builder(PostMapping.class).addMember("value", "$S", "create" + typeElement.getSimpleName()).build())
                    .addModifiers(Modifier.PUBLIC)
                    .addCode(
                            CodeBlock.of("$T creator = $T.INSTANCE.request2Dto(request);\n",
                                    ClassName.get(nameContext.getCreatorPackageName(), nameContext.getCreatorClassName()), ClassName.get(nameContext.getMapperPackageName(), nameContext.getMapperClassName()))
                    )
                    .addCode(
                            CodeBlock.of("return JsonObject.success($L.create$L(creator));", serviceFieldName, typeElement.getSimpleName().toString())
                    )
                    .addJavadoc("createRequest")
                    .returns(ParameterizedTypeName.get(ClassName.get(JsonObject.class), ClassName.get(Long.class))).build());
        }
        return Optional.empty();
    }

    /**
     * 更新方法
     *
     * @param serviceFieldName
     * @param typeElement
     * @param nameContext
     * @return
     */
    private Optional<MethodSpec> updateMethod(String serviceFieldName, TypeElement typeElement, DefaultNameContext nameContext) {
        boolean containsNull = StringUtils.containsNull(nameContext.getUpdatePackageName(), nameContext.getUpdaterPackageName(), nameContext.getMapperPackageName());
        if (!containsNull) {
            return Optional.of(MethodSpec.methodBuilder("update" + typeElement.getSimpleName())
                    .addParameter(ParameterSpec.builder(ClassName.get(nameContext.getUpdatePackageName(), nameContext.getUpdateClassName()), "request").addAnnotation(RequestBody.class).build())
                    .addAnnotation(AnnotationSpec.builder(PostMapping.class).addMember("value", "$S", "update" + typeElement.getSimpleName()).build())
                    .addModifiers(Modifier.PUBLIC)
                    .addCode(
                            CodeBlock.of("$T updater = $T.INSTANCE.request2Updater(request);\n",
                                    ClassName.get(nameContext.getUpdaterPackageName(), nameContext.getUpdaterClassName()), ClassName.get(nameContext.getMapperPackageName(), nameContext.getMapperClassName()))
                    )
                    .addCode(
                            CodeBlock.of("$L.update$L(updater);\n", serviceFieldName, typeElement.getSimpleName().toString())
                    )
                    .addCode(
                            CodeBlock.of("return $T.success($T.Success.getName());", JsonObject.class, CodeEnum.class)
                    )
                    .returns(ParameterizedTypeName.get(ClassName.get(JsonObject.class), ClassName.get(String.class)))
                    .addJavadoc("update request")
                    .build());
        }
        return Optional.empty();
    }

    /**
     * 启用
     *
     * @param serviceFieldName
     * @param typeElement
     * @return
     */
    private Optional<MethodSpec> validMethod(String serviceFieldName, TypeElement typeElement) {
        return Optional.of(MethodSpec.methodBuilder("valid" + typeElement.getSimpleName())
                .addParameter(ParameterSpec.builder(Long.class, "id").addAnnotation(PathVariable.class).build())
                .addAnnotation(AnnotationSpec.builder(PostMapping.class).addMember("value", "$S", "valid/{id}").build())
                .addModifiers(Modifier.PUBLIC)
                .addCode(
                        CodeBlock.of("$L.valid$L(id);\n",
                                serviceFieldName, typeElement.getSimpleName().toString())
                )
                .addCode(
                        CodeBlock.of("return $T.success($T.Success.getName());", JsonObject.class, CodeEnum.class)
                )
                .returns(ParameterizedTypeName.get(ClassName.get(JsonObject.class), ClassName.get(String.class)))
                .addJavadoc("valid")
                .build());
    }

    /**
     * 修复不返回方法的问题
     * @param serviceFieldName
     * @param typeElement
     * @return
     */
    private Optional<MethodSpec> inValidMethod(String serviceFieldName, TypeElement typeElement) {
        return Optional.of(MethodSpec.methodBuilder("invalid" + typeElement.getSimpleName())
                .addParameter(ParameterSpec.builder(Long.class, "id").addAnnotation(PathVariable.class).build())
                .addAnnotation(AnnotationSpec.builder(PostMapping.class).addMember("value", "$S", "invalid/{id}").build())
                .addModifiers(Modifier.PUBLIC)
                .addCode(
                        CodeBlock.of("$L.invalid$L(id);\n",
                                serviceFieldName, typeElement.getSimpleName().toString())
                )
                .addCode(
                        CodeBlock.of("return $T.success($T.Success.getName());", JsonObject.class, CodeEnum.class)
                )
                .returns(ParameterizedTypeName.get(ClassName.get(JsonObject.class), ClassName.get(String.class)))
                .addJavadoc("invalid")
                .build());
    }

    private Optional<MethodSpec> findById(String serviceFieldName, DefaultNameContext nameContext) {
        boolean containsNull = StringUtils.containsNull(nameContext.getVoPackageName(), nameContext.getResponsePackageName(), nameContext.getMapperPackageName());
        if (!containsNull) {
            return Optional.of(MethodSpec.methodBuilder("findById")
                    .addParameter(ParameterSpec.builder(Long.class, "id").addAnnotation(PathVariable.class).build())
                    .addAnnotation(AnnotationSpec.builder(GetMapping.class).addMember("value", "$S", "findById/{id}").build())
                    .addModifiers(Modifier.PUBLIC)
                    .addCode(
                            CodeBlock.of("$T vo = $L.findById(id);\n", ClassName.get(nameContext.getVoPackageName(), nameContext.getVoClassName()), serviceFieldName)
                    )
                    .addCode(
                            CodeBlock.of("$T response = $T.INSTANCE.vo2CustomResponse(vo);\n"
                                    , ClassName.get(nameContext.getResponsePackageName(), nameContext.getResponseClassName()),
                                    ClassName.get(nameContext.getMapperPackageName(), nameContext.getMapperClassName()))
                    )
                    .addCode(
                            CodeBlock.of("return $T.success(response);", JsonObject.class)
                    )
                    .addJavadoc("findById")
                    .returns(ParameterizedTypeName.get(ClassName.get(JsonObject.class), ClassName.get(nameContext.getResponsePackageName(), nameContext.getResponseClassName())))
                    .build());
        }
        return Optional.empty();
    }

    /**
     * 分页
     *
     * @param serviceFieldName
     * @param nameContext
     * @return
     */
    private Optional<MethodSpec> findByPage(String serviceFieldName, DefaultNameContext nameContext) {
        boolean containsNull = StringUtils.containsNull(nameContext.getQueryRequestPackageName(), nameContext.getQueryPackageName(), nameContext.getMapperPackageName(), nameContext.getVoPackageName(), nameContext.getResponsePackageName());
        if (!containsNull) {
            return Optional.of(MethodSpec.methodBuilder("findByPage")
                    .addParameter(ParameterSpec.builder(ParameterizedTypeName.get(ClassName.get(PageRequestWrapper.class), ClassName.get(nameContext.getQueryRequestPackageName(), nameContext.getQueryRequestClassName())), "request").addAnnotation(RequestBody.class).build())
                    .addAnnotation(AnnotationSpec.builder(PostMapping.class).addMember("value", "$S", "findByPage").build())
                    .addModifiers(Modifier.PUBLIC)
                    .addCode(
                            CodeBlock.of("$T<$T> wrapper = new $T<>();\n"
                                    , PageRequestWrapper.class, ClassName.get(nameContext.getQueryPackageName(), nameContext.getQueryClassName()), PageRequestWrapper.class)
                    )
                    .addCode(
                            CodeBlock.of("wrapper.setBean($T.INSTANCE.request2Query(request.getBean()));\n",
                                    ClassName.get(nameContext.getMapperPackageName(), nameContext.getMapperClassName()))
                    )
                    .addCode(
                            CodeBlock.of("wrapper.setSorts(request.getSorts());\n"
                                    + "    wrapper.setPageSize(request.getPageSize());\n"
                                    + "    wrapper.setPage(request.getPage());\n")
                    )
                    .addCode(CodeBlock.of("$T<$T> page = $L.findByPage(wrapper);\n"
                            , Page.class, ClassName.get(nameContext.getVoPackageName(), nameContext.getVoClassName()), serviceFieldName))
                    .addCode(
                            CodeBlock.of("return $T.success(\n"
                                    + "        $T.of(\n"
                                    + "            page.getContent().stream()\n"
                                    + "                .map(vo -> $T.INSTANCE.vo2CustomResponse(vo))\n"
                                    + "                .collect($T.toList()),\n"
                                    + "            page.getTotalElements(),\n"
                                    + "            page.getSize(),\n"
                                    + "            page.getNumber())\n"
                                    + "    );", JsonObject.class, PageResult.class, ClassName.get(nameContext.getMapperPackageName(), nameContext.getMapperClassName()), Collectors.class)
                    )
                    .addJavadoc("findByPage request")
                    .returns(ParameterizedTypeName.get(ClassName.get(JsonObject.class), ParameterizedTypeName.get(ClassName.get(
                            PageResult.class), ClassName.get(nameContext.getResponsePackageName(), nameContext.getResponseClassName()))))
                    .build());
        }
        return Optional.empty();
    }
}
