import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Utils {

    public static <T> List<T> read(String path,Object o,boolean header) throws IOException {
        List<T> rows = new ArrayList<T>();
        int i = 0;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path));
                CSVReader csvReader = new CSVReader(reader);
        ) {

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {

                if ( i > 0 && header==true) {

                    if (o.toString().equals(Plan.class.toString())) {
                        rows.add((T) new Plan(nextRecord[0], nextRecord[1], nextRecord[2], Float.parseFloat(nextRecord[3]), Integer.parseInt(nextRecord[4])));
                    } else if (o.toString().equals(Slcsp.class.toString())) {
                        rows.add((T) new Slcsp(Integer.parseInt(nextRecord[0]), nextRecord[1]));
                    } else if (o.toString().equals(Zip.class.toString())) {
                        rows.add((T) new Zip(Integer.parseInt(nextRecord[0]), nextRecord[1], Integer.parseInt(nextRecord[2]), nextRecord[3], Integer.parseInt(nextRecord[4])));
                    }

                }
                i++;
            }
        }
        return rows;
    }

    public static <T> void write(String path, List<T> rows) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {

        try (
                Writer writer = Files.newBufferedWriter(Paths.get(path));
        ) {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            beanToCsv.write(rows);
        }
    }


    public static String getSecondLowestCostSilverPlan(Integer zipCode, List<Zip> zips, List<Plan> plans){

        String rate = "";
        Set<Zip> dup= zips.stream()
                      .filter(i -> Collections.frequency(zips, i) > 1)
                      .filter(zip -> zipCode.equals(zip.getZipCode()))
                      .collect(Collectors.toSet());
        // A ZIP code can also be in
        // more than one rate area. In that case, the answer is ambiguous and
        // should be left blank.
        if (dup.size() > 1 ){
            // rate left blank
        }else{
            List<Plan> planRate = plans.stream()
                    .filter(plan -> dup.stream().findFirst().get().getRateArea().equals(plan.getRateArea()))
                    .sorted().collect(Collectors.toSet()).stream().toList();
            // Select the second low rate from the list
            rate = String.valueOf(planRate.get(1).getRate());
        }

        return rate;

    }

    public static void updateData(List<Slcsp> slcsps, List<Zip> zips, List<Plan> plans, String outputPath) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {

        // Read data
        String rate = "";
        List<String> list = new ArrayList<>();
        list.add("zipcode,rate");
        for (Slcsp s : slcsps) {
            rate = getSecondLowestCostSilverPlan(s.getZipCode(),zips,plans);
            list.add(s.getZipCode().toString()+','+rate);
        }

        // Delete Data
        File outFile = new File(outputPath);
        if (outFile.exists()) {
                outFile.delete();
        }

        // Write Data
        write(outputPath,list);

    }



}
