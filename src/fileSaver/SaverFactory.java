/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//Returns saver classes
package fileSaver;

public class SaverFactory {
    public static SaverInterface createSaver(String name) {
        if (name.equals("word")) {
            return new MSWordSaver();
        }
        else if (name.equals(("excel"))){
            return new MSExcelSaver();
        }
        return null;
    }
}
