package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

    private static final String PERSISTENCE_NAME = "tasklist";
    // クラス変数なので、呼び出されるたび初期化されず、共有変数になる
    private static EntityManagerFactory emf;

    public static EntityManager createEntityManager() {
        // EntitiManagerFactoryのインスタンスを未取得なら、取得する
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        }
        //永続エンティティ(DB)の接続情報を返却
        return emf.createEntityManager();

    }

}
