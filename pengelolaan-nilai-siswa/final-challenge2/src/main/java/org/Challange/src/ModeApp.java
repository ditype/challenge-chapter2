

import java.io.*;
import java.util.*;

public class ModeApp {

    // field with final and private modifier, part of implementing Encapsulation.
    private final List<List<String>> data;
    private final String csvFileName;
    private final String txtFileName;

    /**
     * Constructor
     * @param csvFileName to collect the csv file
     * @param txtFileName to collect the txt file
     */
    public ModeApp(String csvFileName, String txtFileName) {
        this.csvFileName = csvFileName;
        this.txtFileName = txtFileName;
        this.data = new ArrayList<>();
    }

    /**
     * Method to read csv
     * @throws IOException for error handling
     */
    public void readCsv() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFileName));
        String line = reader.readLine();
        while (line != null) {
            String[] values = line.split(",");
            List<String> row = new ArrayList<>(Arrays.asList(values));
            data.add(row);
            line = reader.readLine();
        }
        reader.close();
    }

    /**
     * Method to sort csv by frequency
     */
    public void sortDataByFrequency() {
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

        /**
         * Implement method compare from interface Comparator
         *
         */
        Collections.sort(data, new Comparator<List<String>>() {
            public int compare(List<String> list1, List<String> list2) {
                int freq1 = 0;
                int freq2 = 0;
                for (String value : list1) {
                    freq1 += freqMap.get(value);
                }
                for (String value : list2) {
                    freq2 += freqMap.get(value);
                }
                return Integer.compare(freq2, freq1);
            }
        });
    }

    /**
     * Method to calculate mode
     * @return mode
     */
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

    /**
     * Method to write the result to destination file
     * @throws IOException for error handling
     */
    public void writeModeToFile() throws IOException {
        String mode = calculateMode();
        BufferedWriter writer = new BufferedWriter(new FileWriter(txtFileName));
        writer.write(mode);
        writer.close();
    }

    /**
     * Create object from this class, call the created method and fill it's arguments/params
     * @throws IOException for error handling
     */
    public void call() throws IOException {
        ModeApp csvProcessor = new ModeApp("/home/summer/Documents/BINAR - MATERI BEJ/CHAPTER 2/temp/direktori/data_sekolah.csv", "/home/summer/Documents/BINAR - MATERI BEJ/CHAPTER 2/temp/direktori/output_mode.txt");
        csvProcessor.readCsv();
        csvProcessor.sortDataByFrequency();
        csvProcessor.writeModeToFile();
    }
}