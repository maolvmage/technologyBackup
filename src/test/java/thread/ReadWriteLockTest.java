/*
 * 文件名：ReadWriteLockTest.java 版权：北京明朝万达科技股份有限公司 描述： 修改人：dongxiaobin-0751 修改时间：2016年10月11日
 */

package thread;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;


/**
 * <p>读写锁 </p>
 * 
 * @author dongxiaobin-0751
 * @version 2016年10月11日
 * @see ReadWriteLockTest
 * @since
 */
/**
 * 〈一句话功能简述〉 〈功能详细描述〉
 * 
 * @author dongxiaobin-0751
 * @version 2016年10月11日
 * @see ReadWriteLockTest
 * @since
 */
public class ReadWriteLockTest
{
    /**
     * 缓存对象<br>
     */
    private Map<String, String> cacheMap = new HashMap<String, String>();

    /**
     * 读写锁<br>
     */
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    /**
     * 读锁<br>
     */
    private ReadLock readLock = lock.readLock();

    /**
     * 写锁<br>
     */
    private WriteLock writeLock = lock.writeLock();

    public class Consumer implements Runnable
    {
        private String id;

        public Consumer(String _id)
        {
            this.id = _id;
        }

        public void run()
        {
            readLock.lock();
            try
            {
                System.out.println(cacheMap.get(id));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                readLock.unlock();
            }
        }
    }

    public class Produter implements Runnable
    {
        private String id;

        public Produter(String _id)
        {
            this.id = _id;
        }

        public void run()
        {
            writeLock.lock();
            try
            {
                System.out.println(cacheMap.put(id, id));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                writeLock.unlock();
            }
        }
    }

    public static void main(String[] args)
    {
        ReadWriteLockTest test = new ReadWriteLockTest();
        for (int i = 0; i < 10; i++ )
        {
            String id = String.valueOf(i);
            Produter c = test.new Produter(id);
            Thread t = new Thread(c);
            t.start();
        }
        for (int i = 0; i < 20; i++ )
        {
            String id = String.valueOf(i);
            Consumer c = test.new Consumer(id);
            Thread t = new Thread(c);
            t.start();
        }
    }
}
