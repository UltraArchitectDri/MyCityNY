import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestRunner {

    Utils utils;

    private static final String PLAN_CVS = "./plans.csv";
    private static final String ZIP_CVS = "./zips.csv";
    private static final String SLCSP_CVS = "./slcsp.csv";
    private List<Plan> plans = null, zips=null, slcsps=null;


    @Before
    public void init() throws IOException {

        List<Plan> plans = Utils.read(PLAN_CVS,Plan.class,true);

        List<Zip> zips = Utils.read(ZIP_CVS,Zip.class,true);

        List<Slcsp> slcsps = Utils.read(SLCSP_CVS,Slcsp.class,true);

    }

    @Test
    public void readUtils() throws IOException {

        Assert.assertTrue(utils.read("plans.csv",Plan.class,true).size() > 0);

    }

    @Test
    public void getRateUtils() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        List<Plan> plans = Utils.read(PLAN_CVS,Plan.class,true);

        List<Zip> zips = Utils.read(ZIP_CVS,Zip.class,true);

        List<Slcsp> slcsps = Utils.read(SLCSP_CVS,Slcsp.class,true);


        Assert.assertTrue(utils.getSecondLowestCostSilverPlan(43016,zips,plans).equals(""));

    }



}
