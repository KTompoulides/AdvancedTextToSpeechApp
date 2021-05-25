/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//This is the interface for the saver system MUST be implemented by saver classes
package fileSaver;

import java.io.File;

public interface SaverInterface {
    boolean writeContentsToFile(File file, String textToWrite);
}
