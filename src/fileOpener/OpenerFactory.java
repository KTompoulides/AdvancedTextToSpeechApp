/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//Factory that returns "opener" type objects
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
