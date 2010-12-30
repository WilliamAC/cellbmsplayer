package com.cell.util.concurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import com.cell.CUtil;


public class ThreadPool implements ThreadPoolService
{
    /** temp workaround for VM issue */
    private static final long 				MAX_DELAY		= Long.MAX_VALUE/1000000/2;
    
    final public String						name;
    
	private ThreadPoolExecutor 				gameThreadPool;
	private ScheduledThreadPoolExecutor 	gameScheduledThreadPool;

    private ShutDownHook					shutdown_hook	= new ShutDownHook();
	private boolean 						shutdown		= false;

	public ThreadPool(
			String pool_name,
			int scheduled_corePoolSize, 
			int threadpool_corePoolSize,
            int threadpool_maximumPoolSize, 
            int priority)
	{
		this.name = pool_name;

		if (scheduled_corePoolSize>0) {
			gameScheduledThreadPool = new ScheduledThreadPoolExecutor(
					scheduled_corePoolSize, 
					new PriorityThreadFactory(name + " Scheduled ThreadPool", priority));
		}
		
		if (threadpool_corePoolSize>0) {
			gameThreadPool = new ThreadPoolExecutor(
					threadpool_corePoolSize, 
					threadpool_maximumPoolSize,
			        5L, 
			        TimeUnit.SECONDS,
			        new LinkedBlockingQueue<Runnable>(),
			        new PriorityThreadFactory(name + " ThreadPool", priority));
		}

		Runtime.getRuntime().addShutdownHook(shutdown_hook);
	}
	
	public ThreadPool(
			String pool_name,
			int scheduled_corePoolSize, 
			int threadpool_corePoolSize,
            int threadpool_maximumPoolSize)
	{
		this(pool_name, 
				scheduled_corePoolSize,
				threadpool_corePoolSize, 
				threadpool_maximumPoolSize,
				Thread.NORM_PRIORITY);
	}
    
	
	
	public ThreadPool(String pool_name)
	{
		this(pool_name,
				Runtime.getRuntime().availableProcessors(),
				Runtime.getRuntime().availableProcessors(), 
				Runtime.getRuntime().availableProcessors()+1);
	}
	
	public ThreadPoolExecutor getExecutor() 
	{
		return gameThreadPool;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		shutdownNow();
	}
	
	public ScheduledThreadPoolExecutor getScheduledExecutor() 
	{
		return gameScheduledThreadPool;
	}
	
    public static long validateDelay(long delay) 
    {
		if (delay < 0) {
			delay = 0;
		} else if (delay > MAX_DELAY) {
			delay = MAX_DELAY;
		}
		return delay;
	}

	public ScheduledFuture<?> schedule(Runnable r, long delay)
	{
		try
        {
            delay = ThreadPool.validateDelay(delay);
            return gameScheduledThreadPool.schedule(r, delay, TimeUnit.MILLISECONDS);
        }
		catch (RejectedExecutionException e)
        {
			e.printStackTrace();
            return null;
        }
    }

	public ScheduledFuture<?> scheduleAtFixedRate(Runnable r, long initial, long period)
    {
        try
        {
        	period = ThreadPool.validateDelay(period);
            initial = ThreadPool.validateDelay(initial);
            return gameScheduledThreadPool.scheduleAtFixedRate(r, initial, period, TimeUnit.MILLISECONDS);
        }
        catch (RejectedExecutionException e)
        {
        	e.printStackTrace();
            return null;
        }
    }

	public void executeTask(Runnable r)
	{
		gameThreadPool.execute(r);
	}

	public String getStats()
	{
		StringBuilder lines = new StringBuilder();
		
		if (gameScheduledThreadPool!=null)
		{
		lines.append("[" + name + "] Scheduled Thread Pool:" + "\n");
		lines.append(" |-    ActiveThreads : " + gameScheduledThreadPool.getActiveCount() + "\n");
		lines.append(" |-     CorePoolSize : " + gameScheduledThreadPool.getCorePoolSize() + "\n");
		lines.append(" |-         PoolSize : " + gameScheduledThreadPool.getPoolSize() + "\n");
		lines.append(" |-  MaximumPoolSize : " + gameScheduledThreadPool.getMaximumPoolSize() + "\n");
		lines.append(" |-   CompletedTasks : " + gameScheduledThreadPool.getCompletedTaskCount() + "\n");
		lines.append(" |-   ScheduledTasks : "+ (gameScheduledThreadPool.getTaskCount() - gameScheduledThreadPool.getCompletedTaskCount()) + "\n");
		lines.append(" |---------------------\n");
		}
		
		if (gameThreadPool!=null)
		{
		lines.append("[" + name + "] Thread Pool:"+"\n");
		lines.append(" |-    ActiveThreads : "+gameThreadPool.getActiveCount() + "\n");
		lines.append(" |-     CorePoolSize : "+gameThreadPool.getCorePoolSize() + "\n");
		lines.append(" |-  MaximumPoolSize : "+gameThreadPool.getMaximumPoolSize() + "\n");
		lines.append(" |-  LargestPoolSize : "+gameThreadPool.getLargestPoolSize() + "\n");
		lines.append(" |-         PoolSize : "+gameThreadPool.getPoolSize() + "\n");
		lines.append(" |-   CompletedTasks : "+gameThreadPool.getCompletedTaskCount() + "\n");
		lines.append(" |-      QueuedTasks : "+gameThreadPool.getQueue().size() + "\n");
		lines.append(" |---------------------\n");
		};
		lines.append("[heap status]\n");
		lines.append(" |-       FreeMemory : " + CUtil.toBytesSizeString(Runtime.getRuntime().freeMemory())+"\n");
		lines.append(" |-      TotalMemory : " + CUtil.toBytesSizeString(Runtime.getRuntime().totalMemory())+"\n");
		lines.append(" |-        MaxMemory : " + CUtil.toBytesSizeString(Runtime.getRuntime().maxMemory())+"\n");
		lines.append(" |---------------------\n");
		return lines.toString();
	}


	/**
	 *
	 */
	public void shutdown()
	{
		synchronized (shutdown_hook)
		{
			if (!shutdown)
			{
				Runtime.getRuntime().removeShutdownHook(shutdown_hook);
				
				shutdown = true;
				
				try {
					if (gameScheduledThreadPool!=null) {
						gameScheduledThreadPool.awaitTermination(1, TimeUnit.SECONDS);
						gameScheduledThreadPool.shutdown();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				try {
					if (gameThreadPool!=null) {
						gameThreadPool.awaitTermination(1, TimeUnit.SECONDS);
						gameThreadPool.shutdown();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				System.out.println("ThreadPool \"" + name+ "\" : All Threads are now stoped");
				
			}
		}
	}
	
	public void shutdownNow()
	{
		synchronized (shutdown_hook)
		{
			if (!shutdown) 
			{
				Runtime.getRuntime().removeShutdownHook(shutdown_hook);
				
				shutdown = true;
				
				try {
					if (gameScheduledThreadPool!=null) {
						gameScheduledThreadPool.awaitTermination(1, TimeUnit.SECONDS);
						gameScheduledThreadPool.shutdownNow();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				try {
					if (gameThreadPool!=null) {
						gameThreadPool.awaitTermination(1, TimeUnit.SECONDS);
						gameThreadPool.shutdownNow();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				System.out.println("ThreadPool \"" + name+ "\" : All Threads are now stoped");
			}
		}
	}
	
	public boolean isShutdown()
	{
		return shutdown;
	}

	/**
	 * 尝试从工作队列移除所有已取消的Future任务。
	 */
	public void purge()
	{
		if (gameScheduledThreadPool != null) {
			gameScheduledThreadPool.purge();
		}
		if (gameThreadPool != null) {
			gameThreadPool.purge();
		}
	}
	
	
//	public static void main(String[] args)
//	{
//		final ThreadPool pool = new ThreadPool("test", 1, 1, 1);
//		
////		pool.executeTask(new Runnable(){
////			public void run() {
////				System.out.println("runtask 1");
////			}
////		});
////		pool.executeTask(new Runnable(){
////			public void run() {
////				System.out.println("runtask 1");
////			}
////		});
////		pool.executeTask(new Runnable(){
////			public void run() {
////				System.out.println("runtask 2" + (1 / 0));
////			}
////		});
////		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(pool.getStats());
//		
//	}
	

    private class PriorityThreadFactory implements ThreadFactory
    {
    	private int 				_prio;
		private String 				_name;
		private AtomicInteger 		_threadNumber = new AtomicInteger(1);
		private ThreadGroup 		_group;

		public PriorityThreadFactory(String name, int prio)
    	{
    		_prio = prio;
    		_name = name;
    		_group = new ThreadGroup(_name);
    	}

		public Thread newThread(Runnable r)
		{
			Thread t = new Thread(_group,r);
			t.setName(_name+"-"+_threadNumber.getAndIncrement());
			t.setPriority(_prio);
			return t;
		}

		public ThreadGroup getGroup()
		{
			return _group;
		}
    }
    
    private class ShutDownHook extends Thread
    {
		public void run() 
		{
			System.out.println("ThreadPool \"" + name + "\" : ShutdownHook running...");
			
			purge();
			
			try {
				if (gameScheduledThreadPool!=null) {
					gameScheduledThreadPool.awaitTermination(1, TimeUnit.SECONDS);
					gameScheduledThreadPool.shutdownNow();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			try {
				if (gameThreadPool!=null) {
					gameThreadPool.awaitTermination(1, TimeUnit.SECONDS);
					gameThreadPool.shutdownNow();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("ThreadPool \"" + name+ "\" : All Threads are now stoped");
		}
    }


}