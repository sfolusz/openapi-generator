package org.openapitools.codegen.languages;

import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.Schema;
import org.openapitools.codegen.*;
import org.openapitools.codegen.meta.features.*;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.OperationMap;
import org.openapitools.codegen.model.OperationsMap;
import org.openapitools.codegen.utils.ModelUtils;

import java.io.File;
import java.util.*;

public class GoFiberServerCodegen extends AbstractGoCodegen implements CodegenConfig {
    public static final String PROJECT_NAME = "projectName";

    protected String packageName = "openapi";

    protected String sourceFolder = "server-fiber";

    @Override
    public String apiPackage() {
        return sourceFolder;
    }

    public CodegenType getTag() {
        return CodegenType.SERVER;
    }

    public String getName() {
        return "server-fiber";
    }

    public String getHelp() {
        return "Generates a server-fiber server.";
    }

    @Override
    public String apiFileFolder() {
        return outputFolder + File.separator + apiPackage().replace('.', File.separatorChar);
    }

    @Override
    public String modelFileFolder() {
        return outputFolder + File.separator + apiPackage().replace('.', File.separatorChar);
    }

    public GoFiberServerCodegen() {
        super();

        modifyFeatureSet(features -> features
                .includeDocumentationFeatures(DocumentationFeature.Readme)
                .wireFormatFeatures(EnumSet.of(WireFormatFeature.JSON, WireFormatFeature.XML))
                .securityFeatures(EnumSet.noneOf(
                        SecurityFeature.class
                ))
                .excludeGlobalFeatures(
                        GlobalFeature.XMLStructureDefinitions,
                        GlobalFeature.Callbacks,
                        GlobalFeature.LinkObjects,
                        GlobalFeature.ParameterStyling
                )
                .excludeSchemaSupportFeatures(
                        SchemaSupportFeature.Polymorphism
                )
                .excludeParameterFeatures(
                        ParameterFeature.Cookie
                )
        );

        outputFolder = "generated-code" + File.separator + sourceFolder;
        /*
         * Models.  You can write model files using the modelTemplateFiles map.
         * if you want to create one template for file, you can do so here.
         * for multiple files for model, just put another entry in the `modelTemplateFiles` with
         * a different extension
         */
        modelTemplateFiles.put(
                "model.mustache",
                ".go");

        /*
         * Api handlers. You can write classes for each Api file with the apiTemplateFiles map.
         * as with models, add multiple entries with different extensions for multiple files per
         * class
         */
        apiTemplateFiles.put(
                "api_handler.mustache",   // the template to use
                "_handler.go");       // the extension for each file to write

        /*
         * Service templates.  You can write services for each Api file with the apiTemplateFiles map.
            These services are skeletons built to implement the logic of your api using the
            expected parameters and response.
         */
        apiTemplateFiles.put(
                "controller.mustache",   // the template to use
                "_controller.go");       // the extension for each file to write

        embeddedTemplateDir = templateDir = "server-fiber";
        apiPackage = "Apis";
        modelPackage = "Models";
        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));

        /*
         * Reserved words.  Override this with reserved words specific to your language
         */
        setReservedWordsLowerCase(
                Arrays.asList(
                        // data type
                        "string", "bool", "uint", "uint8", "uint16", "uint32", "uint64",
                        "int", "int8", "int16", "int32", "int64", "float32", "float64",
                        "complex64", "complex128", "rune", "byte", "uintptr",

                        "break", "default", "func", "interface", "select",
                        "case", "defer", "go", "map", "struct",
                        "chan", "else", "goto", "package", "switch",
                        "const", "fallthrough", "if", "range", "type",
                        "continue", "for", "import", "return", "var", "error", "nil")
                // Added "error" as it's used so frequently that it may as well be a keyword
        );
    }

    @Override
    public void processOpts() {
        super.processOpts();

        additionalProperties.put(CodegenConstants.PACKAGE_NAME, packageName);

        modelPackage = packageName;
        apiPackage = packageName;

        supportingFiles.add(new SupportingFile("main.mustache", "", "main.go"));
        supportingFiles.add(new SupportingFile("openapi.mustache", "api", "openapi.yaml"));
        supportingFiles.add(new SupportingFile("routers.mustache", sourceFolder, "routers.go"));
        supportingFiles.add(new SupportingFile("api_response.mustache", sourceFolder, "api_response.go"));
        supportingFiles.add(new SupportingFile("helpers.mustache", sourceFolder, "helpers.go"));
        supportingFiles.add(new SupportingFile("api.mustache", sourceFolder, "api.go"));
        supportingFiles.add(new SupportingFile("error.mustache", sourceFolder, "error.go"));
        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md")
                .doNotOverwrite());
    }

    @Override
    public OperationsMap postProcessOperationsWithModels(OperationsMap objs, List<ModelMap> allModels) {
        objs = super.postProcessOperationsWithModels(objs, allModels);
        OperationMap objectMap = objs.getOperations();
        List<CodegenOperation> operations = objectMap.getOperation();

        List<Map<String, String>> imports = objs.getImports();
        if (imports == null)
            return objs;

        // override imports to only include packages for interface parameters
        imports.clear();

        boolean addedTimeImport = false;
        boolean addedOSImport = false;
        for (CodegenOperation operation : operations) {
            for (CodegenParameter param : operation.allParams) {
                // import "os" if the operation uses files
                if (!addedOSImport && ("*os.File".equals(param.dataType) || ("[]*os.File".equals(param.dataType)))) {
                    imports.add(createMapping("import", "os"));
                    addedOSImport = true;
                }

                // import "time" if the operation has a required time parameter
                if (param.required) {
                    if (!addedTimeImport && "time.Time".equals(param.dataType)) {
                        imports.add(createMapping("import", "time"));
                        addedTimeImport = true;
                    }
                }
            }

            List<CodegenResponse> responses = operation.responses;

            operation.returnType = getReturnType(responses);
        }

        return objs;
    }

    /**
     * Returns the correct return type based on all 2xx HTTP responses defined for an operation.
     *
     * @param responses all CodegenResponses defined for one operation
     * @return TypeScript return type
     */
    private String getReturnType(List<CodegenResponse> responses) {
        Set<String> returnTypes = new HashSet<>();
        for (CodegenResponse response : responses) {
            if (response.dataType != null) {
                if (response.dataType.startsWith("[]") || response.dataType.startsWith("map")) {
                    returnTypes.add(response.dataType);
                } else {
                    returnTypes.add("*" + response.dataType);
                }
            }
        }

        if (returnTypes.size() == 0) {
            return "Void";
        }

        return String.join(" | ", returnTypes);
    }

    @Override
    protected void updateModelForObject(CodegenModel m, Schema schema) {
        /**
         * we have a custom version of this function so we only set isMap to true if
         * ModelUtils.isMapSchema
         * In other generators, isMap is true for all type object schemas
         */
        if (schema.getProperties() != null || schema.getRequired() != null && !(schema instanceof ComposedSchema)) {
            // passing null to allProperties and allRequired as there's no parent
            addVars(m, unaliasPropertySchema(schema.getProperties()), schema.getRequired(), null, null);
        }
        if (ModelUtils.isMapSchema(schema)) {
            // an object or anyType composed schema that has additionalProperties set
            addAdditionPropertiesToCodeGenModel(m, schema);
        } else {
            m.setIsMap(false);
            if (ModelUtils.isFreeFormObject(openAPI, schema)) {
                // non-composed object type with no properties + additionalProperties
                // additionalProperties must be null, ObjectSchema, or empty Schema
                addAdditionPropertiesToCodeGenModel(m, schema);
            }
        }
        // process 'additionalProperties'
        setAddProps(schema, m);
    }
}
