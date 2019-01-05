package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

import javax.jws.soap.SOAPBinding;

import static threads.Application.EOF;

public class Application {
	public static final String EOF = "EOF";
	
	public static void main(String[] args) 
	{
//		Countdown countdown = new Countdown();
//		
//		CountdownThread t1 = new CountdownThread(countdown);
//		t1.setName("Thread 1");
//		CountdownThread t2 = new CountdownThread(countdown);
//		t2.setName("Thread 2");
//		
//		t1.start();
//		t2.start();
		
//      ======================================================
		
//		Message message = new Message();
//		(new Thread(new Writer(message))).start();
//		(new Thread(new Reader(message))).start();
		
//      ======================================================
		
		List<String> buffer = new ArrayList<>();
		ReentrantLock bufferLock = new ReentrantLock();
		
		ExecutorService exs = Executors.newFixedThreadPool(3);
		
		MyProducer producer = new MyProducer(buffer, bufferLock);
		MyConsumer consumer1 = new MyConsumer(buffer, bufferLock);
		MyConsumer consumer2 = new MyConsumer(buffer, bufferLock);
		
//		new Thread(producer).start();
//		new Thread(consumer1).start();
//		new Thread(consumer2).start();
		exs.execute(producer);
		exs.execute(consumer1);
		exs.execute(consumer2);
		
		Future<String> future = exs.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("I am being printed from callable");
				return "This is the callable reslt";
			}
		});
		
		try {
			System.out.println(future.get());
		} catch (ExecutionException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("Thread running interrupted");
		}
		
		exs.shutdown();
	}

}

class MyProducer implements Runnable {
	private List<String> buffer;
	private ReentrantLock bufferLock;
	
	public MyProducer(List<String> buffer, ReentrantLock bufferLock)
	{
		this.buffer = buffer;
		this.bufferLock = bufferLock;
	}
	
	public void run()
	{
		Random random = new Random();
		String[] nums = { "1", "2", "3", "4"};
		
		for(String num : nums)
		{
			try {
				System.out.println(Thread.currentThread().getName() + " Adding..." + num);
				//synchronized (buffer) {
				bufferLock.lock();
				try
				{
					buffer.add(num);
				}
				finally 
				{
					bufferLock.unlock();
				}
				//}
				
				Thread.sleep(random.nextInt(1000));
			}
			catch (InterruptedException e) {
				System.out.println("Producer was interrupted");
			}
		}
		
		System.out.println(Thread.currentThread().getName() + " Adding EOF and exiting...");
		
		//synchronized (buffer) {
		bufferLock.lock();
		try
		{
			buffer.add(EOF);
		}
		finally 
		{
			bufferLock.unlock();
		}
		//}
	}
}

class MyConsumer implements Runnable {
	private List<String> buffer;
	private ReentrantLock bufferLock;
	
	public MyConsumer(List<String> buffer, ReentrantLock bufferLock)
	{
		this.buffer = buffer;
		this.bufferLock = bufferLock;
	}
	
	public void run()
	{
		
		while(true)
		{
			//synchronized (buffer) 
			//{
			if(bufferLock.tryLock())
			{
				try
				{
					if(buffer.isEmpty())
					{
						continue;
					}
					
					if(buffer.get(0).equals(EOF))
					{
						System.out.println(Thread.currentThread().getName() + " Exiting");
						break;
					}
					else
					{
						System.out.println(Thread.currentThread().getName() + " Removed " + buffer.remove(0));
					}
				}
				finally 
				{
					bufferLock.unlock();
				}
			}
			//}
		}
	}
}

class Message {
	private String message;
	private boolean empty = true;
	
	public synchronized String read()
	{
		while(empty)
		{
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		empty = true;
		notifyAll();
		return message;
	}
	
	public synchronized void write(String message)
	{
		while(!empty)
		{
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		empty = false;
		notifyAll();
		this.message = message;
	}
}

class Writer implements Runnable {
	private Message message;
	
	public Writer(Message message)
	{
		this.message = message;
	}
	
	public void run()
	{
		String messages[] = { "aasdf", "asdf2", "asdf3"};
		Random random = new Random();
		
		for(int i = 0; i < messages.length; i++)
		{
			message.write(messages[i]);
			
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				
			}
		}
		
		message.write("Finished");
	}
}

class Reader implements Runnable {
	private Message message;
	
	public Reader(Message message)
	{
		this.message = message;
	}
	
	public void run()
	{
		Random random = new Random();
		
		for(String latestMessage = message.read(); !latestMessage.equals("Finished"); latestMessage = message.read())
		{
			System.out.println(latestMessage);
			
			try {
				Thread.sleep(random.nextInt(2000));
			} catch (InterruptedException e) {
				
			}
		}
	}
}

class Countdown {
	
	private int i;
	
	public void doCountdown()
	{
		synchronized (this) 
		{
			for(i = 10; i > 0; i--)
			{
				System.out.println(Thread.currentThread().getName() + ": i = " + i);
			}
		}
	}
}

class CountdownThread extends Thread {
	
	private Countdown threadCountdown;
	
	
	public CountdownThread(Countdown countdown) 
	{
		this.threadCountdown = countdown;
	}
	
	@Override
	public void run() {
		threadCountdown.doCountdown();
	}
}