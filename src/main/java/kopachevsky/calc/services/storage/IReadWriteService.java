package kopachevsky.calc.services.storage;

import java.io.IOException;

public interface IReadWriteService extends IReadService {
    void set(int index, Double value);

    void dump() throws IOException;
}
