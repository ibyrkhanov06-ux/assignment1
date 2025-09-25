package com.zhanibek.algorithms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private final String fileName;

    public CSVWriter(String fileName) {
        this.fileName = fileName;
    }

    // Пишем заголовок только если файла ещё нет
    public void writeHeader(List<String> headers) throws IOException {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            try (FileWriter fw = new FileWriter(file, true)) { // append = true
                fw.write(String.join(",", headers) + "\n");
            }
        }
    }

    // Добавляем строку в конец
    public void appendRow(List<String> values) throws IOException {
        try (FileWriter fw = new FileWriter(fileName, true)) { // append = true
            fw.write(String.join(",", values) + "\n");
        }
    }
}
