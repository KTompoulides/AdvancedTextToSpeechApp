package fileSaver;

public class saverFactory {
    public static saverInterface createSaver(String name) {
        if (name.equals("word")) {
            return new MSWordSaver();
        }
        else if (name.equals(("excel"))){
            return new MSExcelSaver();
        }
        return null;
    }
}
