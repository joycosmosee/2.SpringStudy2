package windwish.com.example.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //이처럼 시작 위치 지정 가능
        //basePackages = "windwish.com.example.core.member",
        //클래스로도 지정 가능
        //basePackageClasses = _4AutoAppConfig.class,

        //빼는 것 - Configuration에 @Component가 붙어있기 때문 : 실무에서는 이렇게 안 씀
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class _4AutoAppConfig {
}
