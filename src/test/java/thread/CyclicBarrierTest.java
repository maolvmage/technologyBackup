/*
 * 文件名：CyclicBarrierTest.java 版权：北京明朝万达科技股份有限公司 描述： 修改人：dongxiaobin-0751 修改时间：2016年10月17日
 */

package thread;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CyclicBarrierTest
{

    public static void main(String[] args)
        throws InterruptedException, BrokenBarrierException
    {
        final int N = 5;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        for (int i = 0; i < N; i++ )
        {
            allSoldier[i] = new Thread(new Soldier("士兵" + i, cyclic));
            allSoldier[i].start();
        }
        System.out.println("-----------");
    }

    public static void main2(String[] args)
    {
        ExecutorService service = Executors.newCachedThreadPool();
        final CyclicBarrier cb = new CyclicBarrier(3);// 创建CyclicBarrier对象并设置3个公共屏障点
        for (int i = 0; i < 3; i++ )
        {
            Runnable runnable = new Runnable()
            {
                public void run()
                {
                    try
                    {
                        Thread.sleep((long)(Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName()
                                           + "即将到达集合地点1，当前已有" + cb.getNumberWaiting()
                                           + "个已经到达，正在等候");
                        cb.await();// 到此如果没有达到公共屏障点，则该线程处于等待状态，如果达到公共屏障点则所有处于等待的线程都继续往下运行

                        Thread.sleep((long)(Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName()
                                           + "即将到达集合地点2，当前已有" + cb.getNumberWaiting()
                                           + "个已经到达，正在等候");
                        cb.await();
                        Thread.sleep((long)(Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName()
                                           + "即将到达集合地点3，当前已有" + cb.getNumberWaiting()
                                           + "个已经到达，正在等候");
                        cb.await();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            System.out.println("--------------------------");
            service.execute(runnable);
        }
        service.shutdown();
    }

    public static class Soldier implements Runnable
    {
        private final CyclicBarrier cyclic;

        private String soldier;

        Soldier(String name, CyclicBarrier _cyclic)
        {
            this.soldier = name;
            this.cyclic = _cyclic;
        }

        public void run()
        {
            try
            {
                cyclic.await();
                System.out.println(soldier + "任务完成");
                cyclic.await();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            catch (BrokenBarrierException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static class BarrierRun implements Runnable
    {
        boolean flag;

        int N;

        public BarrierRun(boolean flag, int n)
        {
            this.flag = flag;
            this.N = n;
        }

        public void run()
        {
            if (flag)
                System.out.println("司令：[" + N + "]个，任务完成！");
            else
            {
                System.out.println("司令：[" + N + "]个，集合完毕");
                flag = true;
            }
        }
    }
}