import org.example.Main;
import org.junit.Test;

public class PageTest {
    @Test
    public void test() throws Exception{
        String[] arg = new String[3];
        arg[0] = "D:\\Table\\各科文件\\工程概论\\ZhaoXiongNi\\202121331017\\testFile\\org.txt";
        arg[1] = "D:\\Table\\各科文件\\工程概论\\ZhaoXiongNi\\202121331017\\testFile\\org_add.txt";
        arg[2] = "D:\\Table\\各科文件\\工程概论\\ZhaoXiongNi\\202121331017\\testFile\\ans.txt";

        Main.main(arg);
    }
}
