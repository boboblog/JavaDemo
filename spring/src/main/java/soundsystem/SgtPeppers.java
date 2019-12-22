package soundsystem;

import org.springframework.stereotype.Component;

@Component
/* component注解表示该类会作为组件类，并告知spring要为这个类创建bean
 * spring应用上下文会给所以bean给定一个id，默认为sgtPeppers
 * 主动指定
 * @Component("beanName")
 */

public class SgtPeppers implements CompactDisc {
	private String title = "";
	private String artist = "";
	
	public void play() {
		System.out.println("Playing" + title + "by" + artist);
	}
}
