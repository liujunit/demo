package sqlCreate;

/**
 * Created by jiuyuan4 on 2018/8/9.
 */
public class CreateKCMC {

    public static void main(String[] args) {
        for (int i = 1; i < 264; i++){
            System.out.println("INSERT INTO KCMC_DATA VALUES(" + i + ",null,null);");
        }
    }

}
