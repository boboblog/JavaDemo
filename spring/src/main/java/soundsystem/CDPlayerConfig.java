package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="soundsystem")
//@ComponentScan(basePackageClasses= {CDPlayTest.class})
/*组件扫描的包范围
 * 默认：组件所在包
 * basePackages="包1,······包n"
 * basePackClasses={包1中的某个类.class,······,包n中的某个类.class}
 */
public class CDPlayerConfig {
	
}
