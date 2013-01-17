package kopachevsky.calc.services.sync;

import java.util.concurrent.locks.Lock;

public interface ILocksRepository {
    Lock getLock(int index);
}
