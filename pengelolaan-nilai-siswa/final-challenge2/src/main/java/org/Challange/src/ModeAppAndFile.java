import java.io.IOException;
import java.io.*;
import java.util.*;

public class ModeAppAndFile {
    private final List<List<String>> data;
    private final String txt1;
    private final String txt2;

    public ModeAppAndFile(String txt1, String txt2) {
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.data = new ArrayList<>();
    }

    public void read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(txt1, txt2));
        String line = reader.readLine();
        while (line != null) {
            String[] values = line.split(",");
            List<String> row = new ArrayList<>(Arrays.asList(values));
            data.add(row);
            line = reader.readLine();
        }
        reader.close();
    }

    public String sortDataByFrequency() {
        Map<String, Integer> freqMap = new HashMap<>();
        for (List<String> row : data) {
            for (String value : row) {
                if (freqMap.containsKey(value)) {
                    freqMap.put(value, freqMap.get(value) + 1);
                } else {
                    freqMap.put(value, 1);
                }
            }
        }

        public String calculateMode() {
            Map<String, Integer> freqMap = new HashMap<>();
            for (List<String> row : data) {
                for (String value : row) {
                    if (freqMap.containsKey(value)) {
                        freqMap.put(value, freqMap.get(value) + 1);
                    } else {
                        freqMap.put(value, 1);
                    }
                }
            }
            String mode = null;
            int maxFreq = 0;
            for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    mode = entry.getKey();
                    maxFreq = entry.getValue();
                }
            }
            return mode;
        }

        public void writeFile () throws IOException {
            String mode = calculateMode();
            BufferedWriter writer = new BufferedWriter(new FileWriter(txt1, txt2));
            writer.write(mode);
            writer.close();
        }

        public void call () throws IOException {
            ModeAppAndFile folder = new ModeAppAndFile("/home/summer/Documents/BINAR - MATERI BEJ/CHAPTER 2/temp/direktori/output_mode.txt", );
            folder.read();
            folder.

        }
    }
}
