import com.jcraft.jsch.Session;

/**
 * @author Mr.Xu
 * @description:
 * @create 2021-02-01 18:23
 */
public class JCshTest {

    private static Session session = null;

    public static void createSession(String host, Integer port, String username, String password) {
        session = JSchUtils.getSession(host, port, username, password);
    }

    public static void main(String[] args) {
        if (session == null) {
            createSession("192.168.2.201", 22, "xu", "123456");
        }

        System.out.println(JSchUtils.execCmdWithResult(session, "ps -ef | grep mysql | grep -v grep", "utf-8"));

        System.out.println(JSchUtils.getPidLinuxCmd(session, "mysql"));
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(JSchUtils.execCmdWithResult(session, "date", "utf-8"));
    }

//        File file = new File("hello.txt");
//        JcshUtils.uploadFile(session, "/opt/software", file);
//    }
}
