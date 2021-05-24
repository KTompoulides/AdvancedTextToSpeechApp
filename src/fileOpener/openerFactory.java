package fileOpener;
public class openerFactory {
    public static openerInterface createOpener(String name) {
        if (name.equals("word")) {
            return new MSWordOpener();
        }
        else if (name.equals(("excel"))){
            return new MSExcelOpener();
        }
        return null;
    }
}
