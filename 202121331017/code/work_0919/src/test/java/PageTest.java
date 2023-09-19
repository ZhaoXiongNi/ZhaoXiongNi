import org.example.Main;
import org.junit.Test;

public class PageTest {
    @Test
    public void mainTest() throws Exception{
        //主测试函数，用以完成绝大多数测试
        String[] arg = new String[3];
        //noinspection SpellCheckingInspection
        arg[0] = "D:\\Table\\各科文件\\工程概论\\ZhaoXiongNi\\202121331017\\testFile\\org.txt";
        //noinspection SpellCheckingInspection
        arg[1] = "D:\\Table\\各科文件\\工程概论\\ZhaoXiongNi\\202121331017\\testFile\\org_add.txt";
        //noinspection SpellCheckingInspection
        arg[2] = "D:\\Table\\各科文件\\工程概论\\ZhaoXiongNi\\202121331017\\testFile\\ans.txt";

        Main.main(arg);
    }

    @Test
    public void pathErrorTest() throws Exception{
        //测试路径错误
        String[] arg = new String[3];
        //noinspection SpellCheckingInspection
        arg[0] = "D:\\Table\\各科文件\\工程概论\\ZhaoXiongNi\\202121331017\\errorPath\\org.txt";
        //noinspection SpellCheckingInspection
        arg[1] = "D:\\Table\\各科文件\\工程概论\\ZhaoXiongNi\\202121331017\\testFile\\org_add.txt";
        //noinspection SpellCheckingInspection
        arg[2] = "D:\\Table\\各科文件\\工程概论\\ZhaoXiongNi\\202121331017\\testFile\\ans.txt";

        Main.main(arg);
    }
}
