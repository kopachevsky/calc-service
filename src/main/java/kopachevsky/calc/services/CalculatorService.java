package kopachevsky.calc.services;

import java.util.concurrent.locks.Lock;

import kopachevsky.calc.services.storage.IReadService;
import kopachevsky.calc.services.storage.IReadWriteService;
import kopachevsky.calc.services.sync.ILocksRepository;

public class CalculatorService implements ICalculatorService {

    private final IReadService f1;
    private final IReadWriteService f2;
    private final ILocksRepository locksRepository;

    public CalculatorService(final IReadService f1, final IReadWriteService f2, final ILocksRepository locksRepository) {
        this.f1 = f1;
        this.f2 = f2;
        this.locksRepository = locksRepository;
    }

    @Override
    public double get(final int v1) {
        final Lock lock = locksRepository.getLock(v1);
        try {
            lock.lock();
            final double value = f2.get(v1);
            if (value > 10) {
                return value - 10;
            } else {
                return value;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean post(final double v2, final int v3, final int v4) {
        final double f1v3 = f1.get(v3);

        final boolean result = f1v3 + v2 < 10;
        final Lock lock = locksRepository.getLock(v4);
        try {
            lock.lock();
            if (result) {
                f2.set(v4, f1v3 + v2 + 10);
            } else {
                f2.set(v4, f1v3 + v2);
            }
        } finally {
            lock.unlock();
        }
        return result;
    }
}
