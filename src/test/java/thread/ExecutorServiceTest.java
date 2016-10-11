/*
 * 文件名：ExecutorServiceTest.java 版权：北京明朝万达科技股份有限公司 描述： 修改人：dongxiaobin-0751 修改时间：2016年9月26日
 */

package thread;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;


public class ExecutorServiceTest
{
    private static ScheduledExecutorService receiverScheduler = null;

    /**
     * 线程池工厂，使用默认的工厂，给各个线程添加 命名
     */
    private final static ThreadFactory threadFactory = new ThreadFactory()
    {
        private final ThreadFactory internal = Executors.defaultThreadFactory();

        public Thread newThread(Runnable r)
        {
            Thread th = internal.newThread(r);
            // 线程命名
            th.setName("scheduler_" + th.getName());
            return th;
        }
    };

    public static void main(String[] args)
        throws InterruptedException
    {
        receiverScheduler = Executors.newScheduledThreadPool(1, threadFactory);
        // receiverScheduler.isShutdown();
        ScheduledFuture<?> future = receiverScheduler.scheduleAtFixedRate(new Runnable()
        {
            public void run()
            {
                System.out.println("--");
            }
        }, 1, 1, TimeUnit.SECONDS);
        System.out.println(receiverScheduler.isTerminated());
        Thread.sleep(1000 * 10);
        receiverScheduler.shutdown();
        // boolean isSuccess = false;
        // while (!isSuccess)
        // {
        // if (receiverScheduler.isTerminated())
        // {
        // isSuccess = true;
        // }
        // }
        // scheduler.shutdown();
    }
}
