/*
 * 文件名：CyclicBarrierTest.java 版权：北京明朝万达科技股份有限公司 描述： 修改人：dongxiaobin-0751 修改时间：2016年10月17日
 */

package thread;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class CyclicBarrierTest
{

    public static class Soldier implements Runnable
    {
        private String soldier;

        private final CyclicBarrier cyclic;

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
}