package fileOpener;
public class OpenerFactory {
    public static OpenerInterface createOpener(String name) {
        if (name.equals("word")) {
            return new MSWordOpener();
        }
        else if (name.equals(("excel"))){
            return new MSExcelOpener();
        }
        return null;
    }
}
