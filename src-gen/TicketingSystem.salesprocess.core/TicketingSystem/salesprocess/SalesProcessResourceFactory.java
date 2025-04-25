package TicketingSystem.salesprocess;

import TicketingSystem.salesprocess.core.SalesProcessResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class SalesProcessResourceFactory{
    private static final Logger LOGGER = Logger.getLogger(SalesProcessFactory.class.getName());

    public SalesProcessResourceFactory()
    {

    }

    public static SalesProcessResource createSalesProcessResource(String fullyQualifiedName, Object ... base)
    {
        SalesProcessResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (SalesProcessResource) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of SalesProcess.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of SalesProcess.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of SalesProcess.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of SalesProcess.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
