/*
 * 文件名：PoolTest.java 版权：北京明朝万达科技股份有限公司 描述： 修改人：dongxiaobin-0751 修改时间：2016年10月9日
 */

package thread;


import java.util.concurrent.*;


public class PoolTest implements Runnable
{
    /**
     * 消费数据的线程池，核心大小以及最大大小一致<br>
     */
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 3, TimeUnit.SECONDS,
        new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());

    BlockingQueue<String> userStatusQueue = new ArrayBlockingQueue<String>(10);

    public void run()
    {
        for (int i = 0; i < 10; i++ )
        {
            try
            {
                userStatusQueue.put(String.valueOf(i));
            }
            catch (InterruptedException e)
            {}
        }
        while (true)
        {
            String a = null;
            try
            {
                a = userStatusQueue.take();
            }
            catch (InterruptedException e1)
            {}
            // 将发送数据的线程添加到上述定义的线程池中
            boolean isSuccess = true;
            try
            {
                executor.execute(new Thread()
                {
                    @Override
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
                        System.out.println("111");
                    }
                });
            }
            catch (Exception e)
            {
                isSuccess = false;
                System.out.println("error");
            }
            finally
            {
                if (!isSuccess)
                {
                    try
                    {
                        userStatusQueue.put(a);
                    }
                    catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(userStatusQueue.toString());
        }
    }

    public static void main(String[] args)
    {
        Thread thread = new Thread(new PoolTest());
        thread.start();
    }
}
