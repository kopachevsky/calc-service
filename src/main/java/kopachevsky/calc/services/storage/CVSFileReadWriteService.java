package kopachevsky.calc.services.storage;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.util.StringUtils;

public class CVSFileReadWriteService extends CVSFileReadService implements IReadWriteService {

    public CVSFileReadWriteService(final String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void set(final int index, final Double value) {
        data[index] = value;
    }

    @Override
    public void dump() throws IOException {
        System.out.println("SAVING DATA TO FILE SYSTEM ");
        final String dataStr = StringUtils.arrayToDelimitedString(data, ",");
        FileUtils.writeStringToFile(getFile(), dataStr);
    }

}
