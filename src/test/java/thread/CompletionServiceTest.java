/*
 * 文件名：CompletionServiceTest.java 版权：北京明朝万达科技股份有限公司 描述： 修改人：dongxiaobin-0751 修改时间：2016年8月23日
 */

package thread;


import java.util.concurrent.*;


public class CompletionServiceTest
{
    public static void main(String[] args)
        throws InterruptedException, ExecutionException
    {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        // 创建CompletionService
        CompletionService<String> serv = new ExecutorCompletionService<String>(exec);
        for (int index = 0; index < 5; index++ )
        {
            final int NO = index;
            // Callable 接口类似于 Runnable
            Callable<String> downImg = new Callable<String>()
            {
                public String call()
                    throws Exception
                {
                    Thread.sleep((long)(Math.random() * 10000));
                    return "Downloaded Image " + NO;
                }
            };
            // 提交要执行的值返回任务，并返回表示挂起的任务结果的 Future。在完成时，可能会提取或轮询此任务。
            serv.submit(downImg);
        }
        Thread.sleep(1000 * 1);
        System.out.println("Show web content");
        for (int index = 0; index < 5; index++ )
        {
            // 获取并移除表示下一个已完成任务的 Future，如果目前不存在这样的任务，则等待。
            Future<String> task = serv.take();
            // 如有必要，等待计算完成，然后获取其结果。
            String img = task.get();
            System.out.println(img);
        }
        System.out.println("End");
        // 关闭线程池
        exec.shutdown();
    }
}
