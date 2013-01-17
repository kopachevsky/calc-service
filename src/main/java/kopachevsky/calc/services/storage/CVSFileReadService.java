package kopachevsky.calc.services.storage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CVSFileReadService implements IReadService {

    protected final Double[] data;

    private final File file;

    public CVSFileReadService(final String fileName) throws IOException {

        file = new File(fileName);

        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("File [%s] does not exist, absolute path [%s]", fileName, file.getAbsolutePath()));
        }
        final String[] dataStr = FileUtils.readFileToString(file).split(",");

        data = new Double[dataStr.length];

        for (int i = 0; i < dataStr.length; i++) {
            data[i] = Double.valueOf(dataStr[i].trim());
        }
    }

    @Override
    public Double get(final int index) {
        return data[index];
    }

    protected File getFile() {
        return file;
    }

    @Override
    public int getSize() {
        return data.length;
    }

}
