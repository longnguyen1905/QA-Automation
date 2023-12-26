import org.testng.annotations.Test;
import utils.LogUtils;

public class TestHandle {

    @Test
    public void test(){
        LogUtils.info("info");
        LogUtils.error("error");
        LogUtils.warn("warm");
    }
}
