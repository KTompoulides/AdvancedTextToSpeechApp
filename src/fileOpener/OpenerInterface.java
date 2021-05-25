/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//Opener interface MUST be implemented by opener classes
package fileOpener;
import java.io.File;

public interface OpenerInterface {
    String getFileContents(File file);
}
