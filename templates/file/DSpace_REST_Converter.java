#parse("DSpace_Licence_Header")

#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import org.springframework.stereotype.Component;

/**
 * Convert DSpace ${DSPACE_MODEL} object to a ${REST_RESOURCE} REST resource
 * for use in REST results.
 * 
 * @author #parse("Author_Attribution")
 */
@Component
public class ${NAME} implements DSpaceConverter<${DSPACE_MODEL}, ${REST_RESOURCE}> {

    /**
     * Convert a DSpace model object into its equivalent REST resource, applying
     * a given projection.
     *
     * @param modelObject a DSpace API model object.
     * @param projection
     * @return a resource representing the model object.
     */
     */
    @Override
    public ${REST_RESOURCE} convert(${DSPACE_MODEL} modelObject, Projection projection) {
        ${REST_RESOURCE} rest = new ${REST_RESOURCE}();
        // Set or otherwise transform things here, then return
        return rest;
    }

    /**
     * For what DSpace API model class does this converter convert?
     * @return Class of model objects represented.
     */
    @Override
    public Class<${DSPACE_MODEL}> getModelClass() {
        return ${DSPACE_MODEL}.class;
    }

}

