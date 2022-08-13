#parse("DSpace_Licence_Header")
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dspace.authorize.factory.AuthorizeServiceFactory;
import org.dspace.authorize.service.AuthorizeService;
import org.dspace.content.DSpaceObject;
import org.dspace.content.Item;
import org.dspace.content.MetadataFieldName;
import org.dspace.content.MetadataValue;
import org.dspace.content.factory.ContentServiceFactory;
import org.dspace.content.service.BitstreamService;
import org.dspace.curate.AbstractCurationTask;
import org.dspace.curate.Curator;
import org.dspace.curate.Distributive;
import org.dspace.services.ConfigurationService;
import org.dspace.services.factory.DSpaceServicesFactory;

/**
 * Description of curation task.
 *
 * @author #parse("Author_Attribution")
 */
@Distributive
public class ${NAME} extends AbstractCurationTask {

    // Logger and services
    private static final Logger log = LogManager.getLogger(${NAME}.class);
    ConfigurationService configurationService;
    BitstreamService bitstreamService;
    AuthorizeService authorizeService;

    // Status, reports, results
    protected int status = Curator.CURATE_UNSET;
    protected String result = null;
    protected StringBuilder resBuilder;

    // Static date formatter, useful for reporting
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    // Configuration properties
    private MetadataFieldName exampleField;

    /**
     * Initialise task, services, configuration properties, check compatibility, etc
     * @param curator Curator process
     * @param taskId Curation task ID
     * @throws IOException
     */
    @Override
    public void init(Curator curator, String taskId) throws IOException {
        super.init(curator, taskId);
        // Initialise services
        configurationService = DSpaceServicesFactory.getInstance().getConfigurationService();
        bitstreamService = ContentServiceFactory.getInstance().getBitstreamService();
        authorizeService = AuthorizeServiceFactory.getInstance().getAuthorizeService();

        // Initialise configuration properties
        String exampleFieldProperty = configurationService.getProperty("example.field", "dc.type");
        exampleField = new MetadataFieldName(exampleFieldProperty);
    }

    /**
     * Usual perform pattern, where a single result string can be built up and returned after processing
     * @param dso DSpace Object to distribute across or perform
     * @return curation status
     * @throws IOException
     */
    @Override
    public int perform(DSpaceObject dso) throws IOException {
        // Handle reporting, results, and distribution
        this.resBuilder = new StringBuilder();
        // Append header row to resBuilder if needed here

        // Distribute over objects
        this.distribute(dso);
        // Success? These statuses are not as useful for distributive but can still be some help for fatal errors
        this.status = Curator.CURATE_SUCCESS;
        // Build result
        this.result = this.resBuilder.toString();
        this.setResult(this.result);
        // Send result to report stream
        this.report(this.result);
        // Return status
        return this.status;
    }

    /**
     * For a given item: DESCRIBE OPERATIONS HERE
     * 1. ...
     * 2. ..
     * @param item the DSpace Item
     * @throws SQLException
     */
    @Override
    protected void performItem(Item item) throws SQLException {
        log.debug("Working on " + item.getID());

        // Get example values from configured example field
        List<MetadataValue> exampleValues = itemService.getMetadata(item, exampleField.schema, exampleField.element,
                exampleField.qualifier, Item.ANY);
        for (MetadataValue value : exampleValues) {
            // Do something with values, eg. report to report stream or append to result string builder
            resBuilder.append(item.getID()).append(": ").append(value);
        }

    }

}

