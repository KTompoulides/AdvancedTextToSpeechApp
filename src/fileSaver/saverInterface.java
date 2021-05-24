package fileSaver;

import java.io.File;

public interface saverInterface {
    public boolean writeContentsToFile(File file,String textToWrite);
}
