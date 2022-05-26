package testUtilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources( 
    "file:./src/test/resources/${env}.properties" )
public interface Environment extends Config {

    String URL(); 

}