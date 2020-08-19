package aspect;

/**
 * 统计用时不代表最终的算法代码运行时间，但是同个算法的
 * */
public class FunctionRunner implements FunctionTest {
    FunctionTest functionTest;
    public FunctionRunner(FunctionTest functionTest){
        this.functionTest = functionTest;
    }

    public void run(){
        long timeline=System.currentTimeMillis();
        this.functionTest.handle();
        System.out.println("\n用时"+(System.currentTimeMillis()-timeline)+"ms");
    }

    @Override
    public void handle() {

    }
}
