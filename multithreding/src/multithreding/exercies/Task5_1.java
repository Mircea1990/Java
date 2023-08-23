package multithreding.exercies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class synchronize work of writer and readers.
 * 
 * This class cooperate behavior of writer and readers. At first writer writes
 * to buffer, after that readers should read from buffer. Every reader uses its
 * own thread for reading.
 * 
 * After every reader has read from buffer writer erase buffer and write again.
 * 
 * This cycle repeats specified times in the constant field ITERATION_NMBER.
 *
 */
public class Task5_1 {

	/**
	 * Number of cycle repeats.
	 */
	private static final int ITERATION_NUMBER = 3;

	/**
	 * Number of readers.
	 */
	private static final int READERS_NUMBER = 3;

	/**
	 * Buffer to write and to read from.
	 */
	private static final StringBuilder BUFFER = new StringBuilder();

	/**
	 * Buffer length.
	 */
	private static final int BUFFER_LENGTH = 5;

	/**
	 * Speed parameter.
	 */
	private static final int PAUSE = 5;

	/**
	 * Boolean flag if stop signal
	 */
	private static boolean stop;

	/**
	 * Boolean flag that shows true if buffer contains anything or false if buffer
	 * content had been read.
	 */
	private static boolean isWrittenToBuffer;

	/**
	 * Show amount of readers which haven't read from buffer yet Reader counter
	 */
	private static volatile int readersRead = READERS_NUMBER;

	/**
	 * Object for synchronizing access to synchronized blocks
	 */
	private static final Object MONITOR = new Object();

	/**
	 * Reader class which extends Thread and reads from buffer.
	 * 
	 * Overrides run method and synchronized all readers between each others.
	 */
	private static class Reader extends Thread {

		/**
		 * In while loop calls read() method from the synchronized block.
		 * 
		 * Call of read() method is synchronized by MONITOR constant object so that it
		 * is impossible that two threads calls read at the same time.
		 * 
		 * After each reading the field readersRead is increased by one. In case
		 * readersRead has the value as constant READERS_NUMBER flag isWrittenToBuffer
		 * is changed and notifying all of the threads waiting of MONITOR object.
		 * 
		 */
		@Override
		public void run() {
			while (!stop) {
				if (readersRead == 0) {
					try {
						// read from buffer
						synchronized (MONITOR) {
							read(getName());

							if (readersRead == READERS_NUMBER) {
								isWrittenToBuffer = false;
								MONITOR.notifyAll();
							}

						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // if radersRead == 0
			} // while loop ends
		}

		/**
		 * Reads from buffer char by char.
		 * 
		 * Prints result to console. After work is done increased readersRead counter by
		 * one.
		 * 
		 * @param threadName name of Thread which calls this method
		 * @throws InterruptedException in case of interruption of thread
		 */
		private static void read(String threadName) throws InterruptedException {
			System.out.printf("Reader %s:", threadName);
			for (int i = 0; i < BUFFER_LENGTH; i++) {
				Thread.sleep(PAUSE);
				System.out.println(BUFFER.charAt(i));
			}
			System.out.println();
			readersRead++;
			Thread.sleep(5);
		}
	}

	/**
	 * Writer class which extends Thread and writes to the buffer.
	 * 
	 * Overrides run method and synchronized all readers between each others.
	 *
	 */
	private static class Writer extends Thread {

		/**
		 * In while loop calls write() method from the synchronized block.
		 * 
		 * Call of write() method is synchronized by MONITOR constant object so that it
		 * is impossible that readers catch MONITOR before writer has written to buffer.
		 * 
		 * After writing to the buffer readersRead counter is set to zero and
		 * isWrittenToBuffer flag set to true, while Reader object will not change it.
		 * 
		 */

		@Override
		public void run() {
			int tact = 0;
			while (!stop) {
				try {
					synchronized (MONITOR) {
						// write to buffer
						write();
						while (isWrittenToBuffer) {
							MONITOR.wait();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					if (++tact == ITERATION_NUMBER) {
						stop = true;
					}
				}
			}
		}

		/**
		 * Writes to buffer char by char.
		 * 
		 * At the beginning reset buffer length to zero. Writes chars to buffer randomly
		 * choosing letter from English alphabet.
		 * 
		 * @param threadName name of Thread which calls this method
		 * @throws InterruptedException in case of interruption of thread
		 */
		private void write() throws InterruptedException {
			// clear buffer
			BUFFER.setLength(0);

			// write to buffer
			System.err.println("Writer writes:");

			Random random = new Random();
			for (int i = 0; i < BUFFER_LENGTH; i++) {
				Thread.sleep(PAUSE);
				char ch = (char) ('A' + random.nextInt(26));
				System.err.println(ch);
				BUFFER.append(ch);
			}
			System.err.println();
			Thread.sleep(5);
			isWrittenToBuffer = true;
			readersRead = 0;
		}

		/**
		 * Enter point to application.
		 * 
		 * Create and start readers threads.
		 * 
		 * Create and starts writer thread.
		 * 
		 * @param args input parameters.
		 * @throws InterruptedException in case of exception while sleeping.
		 */
		public static void main(String[] args) {
			// create write
			Writer writer = new Writer();

			// create readers
			List<Thread> readers = new ArrayList<Thread>();
			for (int i = 0; i < READERS_NUMBER; i++) {
				readers.add(new Reader());
			}

			// start readers
			for (Thread reader : readers) {
				reader.start();
			}

			// start writer
			writer.start();
		}
	}
}
