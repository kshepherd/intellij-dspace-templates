#parse("DSpace_Licence_Header")

#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implementation of ${NAME} REST resource, representing some DSpace object model
 * for use with the REST API
 * 
 * @author #parse("Author_Attribution")
 */
public class ${NAME} implements RestModel {

    // Set names used in component wiring
    public static final String NAME = "${SINGULAR}";
    public static final String PLURAL_NAME = "${PLURAL}";
    
    // Empty constructor
    public ${NAME}() {}
    
    // Return name for getType()
    @Override
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String getType() {
        return NAME;
    }

}

