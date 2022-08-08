import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;

public class Runner {
    private static final String PLAN_CVS = "./plans.csv";
    private static final String ZIP_CVS = "./zips.csv";
    private static final String SLCSP_CVS = "./slcsp.csv";

    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        List<Plan> plans = Utils.read(PLAN_CVS,Plan.class,true);

        List<Zip> zips = Utils.read(ZIP_CVS,Zip.class,true);

        List<Slcsp> slcsps = Utils.read(SLCSP_CVS,Slcsp.class,true);

        Utils.updateData(slcsps,zips,plans,"slcsp.csv");

    }


}
