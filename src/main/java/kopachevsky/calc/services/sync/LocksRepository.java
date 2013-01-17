package kopachevsky.calc.services.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksRepository implements ILocksRepository {

    private final Lock[] locks;

    public LocksRepository(final int size) {
        locks = new Lock[size];
        for (int i = 0; i < locks.length; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    @Override
    public Lock getLock(final int index) {
        return locks[index];
    }

}
