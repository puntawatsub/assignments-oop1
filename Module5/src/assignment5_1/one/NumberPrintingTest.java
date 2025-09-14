package assignment5_1.one;

import java.util.ArrayList;

// Done with help from ChatGPT. I wanted to challenge myself to create a process manager lol. Still buggy, look at the other one instead please.

/**
 * Multitasking Process
 */
abstract class Process extends Thread {
    private static long processCount = 0;
    private final long processId;
    private final Object lock;
    private ProcessManager pm;

    public Process(Object lock, ProcessManager pm) {
        this.processId = processCount;
        this.lock = lock;
        processCount++;
        this.pm = pm;
    }

    public long getProcessId() {
        return processId;
    }

    /**
     * Wait until it is the process' turn to run,
     * required for all processes
     */
    public void await() {
        synchronized (lock) {
            while (!isActive() && pm.getProcesses().contains(this)) {  // check pm.isEmpty()
                try {
                    waitProcess();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }


    public boolean isActive() {
        return equals(pm.getCurrentProcess());
    }

    public void waitProcess() throws InterruptedException {
        lock.wait();
    }

    /**
     * Give up for other processes to run
     */
    public void giveUp() {
        synchronized (lock) {
            pm.yield();
            lock.notifyAll();
        }
    }

    public void deregister() {
        pm.deregisterProcess(this);
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    abstract protected void runProcess();

    @Override
    public void run() {
        runProcess();
        deregister();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Process process)) {
            return false;
        }
        return process.processId == this.processId;
    }
}

/**
 * Constructs a {@code ProcessNotFoundException} with no detail message.
 */
class ProcessNotFoundException extends RuntimeException {
    public ProcessNotFoundException() {
    };
}

/**
 * Process Manager
 */
class ProcessManager {
    private ArrayList<Process> processes;
    private Object lock;
    private Process currentProcess;
    private int currentProcessIndex = 0;

    public ProcessManager() {
        this.processes = new ArrayList<>();
    };

    public ArrayList<Process> getProcesses() {
        return processes;
    }

    public void yield() {
        if (processes.isEmpty()) {
            currentProcess = null;
            return;
        }
        if (currentProcessIndex + 1 < processes.size()) {
            currentProcessIndex++;
        } else {
            currentProcessIndex = 0;
        }
        currentProcess = processes.get(currentProcessIndex);
    }

    /**
     * Start a specific process
     *
     * @param p A process to start
     */

    public void registerProcess(Process p) {
        if (!processes.contains(p)) {
            processes.add(p);
            currentProcess = processes.get(currentProcessIndex);
            p.start();
            return;
        }
        throw new IllegalArgumentException();
    }

    public void deregisterProcess(Process p) {
        processes.remove(p);
        p.interrupt();
        if (!processes.isEmpty()) {
            if (currentProcessIndex >= processes.size()) {
                currentProcessIndex = 0;
            }
            currentProcess = this.processes.get(currentProcessIndex);
        } else {
            currentProcess = null;
        }
    }

    public Process getCurrentProcess() {
        return currentProcess;
    }
}

class EvenProcess extends Process {

    private int count;

    public EvenProcess(Object lock, ProcessManager pm) {
        super(lock, pm);
        this.count = 0;
    }

    @Override
    public void runProcess() {
        while (true) {
            await();
            do {
                count++;
            } while (count % 2 != 0);
            if (count > 20) {
                giveUp();
                break;
            }
            System.out.printf("Even Thread: %d\n", count);
            giveUp();
        }
    }
}

class OddProcess extends Process {

    private int count;

    public OddProcess(Object lock, ProcessManager pm) {
        super(lock, pm);
        this.count = 0;
    }

    @Override
    public void runProcess() {
        while (true) {
            await();
            do {
                count++;
            } while (count % 2 == 0);
            if (count > 20) {
                giveUp();
                break;
            }
            System.out.printf("Odd Thread: %d\n", count);
            giveUp();
        }
    }
}

public class NumberPrintingTest {
    public static void main(String[] args) throws InterruptedException {
        ProcessManager pm = new ProcessManager();
        Object lock = new Object();
        pm.registerProcess(new OddProcess(lock, pm));
        pm.registerProcess(new EvenProcess(lock, pm));
        pm.registerProcess(new OddProcess(lock, pm));
        pm.registerProcess(new EvenProcess(lock, pm));
        pm.registerProcess(new OddProcess(lock, pm));
        pm.registerProcess(new EvenProcess(lock, pm));
        pm.registerProcess(new OddProcess(lock, pm));
        pm.registerProcess(new EvenProcess(lock, pm));
    }
}