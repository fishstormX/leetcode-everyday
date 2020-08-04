package aspect;


import jdk.nashorn.internal.objects.annotations.Function;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:ApplicationContext.xml"})
@FunctionalInterface
public interface TestCase {
    @Function
    public void test();
}
