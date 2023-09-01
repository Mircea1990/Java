package org.creational.objectPool;

// class that will use ExportingProcess and ObjectPool class
public class ExportingTask implements Runnable {

    private final ObjectPool<ExportingProcess> pool;
    private final int threadNo;

    public ExportingTask(ObjectPool<ExportingProcess> pool, int threadNo) {
        this.pool = pool;
        this.threadNo = threadNo;
    }

    public void run() {
        // get an object from the pool
        ExportingProcess exportingProcess = pool.borrowObject();
        System.out.println("Thread " + threadNo + ": Object with process no. "
                + exportingProcess.getProcessNo() + " was borrowed");

        // .........
        // return ExportingProcess instance back to the pool
        pool.returnObject(exportingProcess);

        System.out.println("Thread " + threadNo + ": Object with process no. "
                + exportingProcess.getProcessNo() + " was returned");
    }
}
