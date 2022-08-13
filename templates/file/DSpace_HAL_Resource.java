#parse("DSpace_Licence_Header")

package ${PACKAGE_NAME};

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import ${PACKAGE_NAME}.annotations.RelNameDSpaceResource;

/**
 *
 * Wrap ${REST_RESOURCE} REST resource in a very simple HALResource class
 *
 * @author #parse("Author_Attribution")
 */
@RelNameDSpaceResource(${REST_RESOURCE}.NAME)
public class ${NAME} extends HALResource<${REST_RESOURCE}> {
    @JsonUnwrapped
    private ${REST_RESOURCE} data;

    public ${NAME}(${REST_RESOURCE} ${REST_RESOURCE}) {
        super(${REST_RESOURCE});
    }

    public ${REST_RESOURCE} getData() {
        return data;
    }
}

