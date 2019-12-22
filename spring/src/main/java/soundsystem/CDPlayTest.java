package soundsystem;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//在测试开始的时候自动创建Spring的应用上下文
@ContextConfiguration(classes=CDPlayerConfig.class)
//告诉Spring要在CDPlayerConfig中加载配置，由于在CDPlayerConfig中配置了@ComponentScan,
//因此最终的应用上下文中会包含CompactDisc Bean
public class CDPlayTest {
	@Autowired
	private CompactDisc cd ;
	
	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(cd);
	}
}
