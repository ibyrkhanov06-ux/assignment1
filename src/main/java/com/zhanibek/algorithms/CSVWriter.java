package com.zhanibek.algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private final String filePath;

    public CSVWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeHeader(List<String> headers) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(String.join(",", headers));
            writer.write("\n");
        }
    }

    public void appendRow(List<String> values) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(String.join(",", values));
            writer.write("\n");
        }
    }
}
