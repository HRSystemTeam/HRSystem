import com.human.HumanApplication;
import com.human.project.schedule.dao.WagesInfoMapper;
import com.human.project.schedule.domain.WagesInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author linwt
 * @date 2019/12/19 15:31
 */
@SpringBootTest(classes = HumanApplication.class)
@RunWith(SpringRunner.class)
public class ServiceTest {
    @Autowired
    private WagesInfoMapper wagesInfoMapper;

    @Test
    public void test() {
        List<WagesInfo> wagesInfos = wagesInfoMapper.getAllWageInfo();
        for (WagesInfo wagesInfo : wagesInfos) {
            System.out.println(wagesInfo);
        }
        wagesInfoMapper.insertWagesRecord(wagesInfos);
    }
}
