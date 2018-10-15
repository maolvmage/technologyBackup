/*
 * 文件名：CountDownLatchTest.java 版权：北京明朝万达科技股份有限公司 描述： 修改人：dongxiaobin-0751 修改时间：2016年10月17日
 */

package thread;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CountDownLatchTest implements Runnable
{
    static CountDownLatch count = new CountDownLatch(10);

    static CountDownLatchTest test = new CountDownLatchTest();

    public void run()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        count.countDown();
    }

    public static void main(String[] args)
        throws InterruptedException
    {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++ )
        {
            CountDownLatchTest test1 = new CountDownLatchTest();
            executor.submit(test1);
        }
        count.await();
        System.out.println("---------");
        executor.shutdown();
    }
}
