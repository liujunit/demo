package sqlCreate;

import util.UuidUtil;

public class TempLet {

    public static void main(String[] args) {
        System.out.println("INSERT INTO TEMPLET (\"UUID\", \"ISBASEFILED\", \"TYPE\", \"SHOW\") VALUES ('"+ UuidUtil.get32UUID() +"', 0, '地质资料', 0);");
    }

}
