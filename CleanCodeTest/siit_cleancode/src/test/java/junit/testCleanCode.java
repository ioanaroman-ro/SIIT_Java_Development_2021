package junit;

import org.cleancode.CarModel;
import org.cleancode.CarSearchCriteria;
import org.cleancode.SearchEngine;
import org.cleancode.YearInterval;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testCleanCode {
    @Test
    public void testCorrectStartYearInterval() {
        YearInterval yearInterval = new YearInterval(2000,2010);
        Assert.assertEquals(2000, yearInterval.getStart());
    }

    @Test
    public void testCorrectEndYearInterval() {
        YearInterval yearInterval = new YearInterval(2000,2010);
        Assert.assertEquals(2010, yearInterval.getEnd());
    }

    @Test
    public void testContainedInYearInterval() {
        YearInterval yearInterval1 = new YearInterval(2000,2010);
        YearInterval yearInterval2 = new YearInterval(2008,2009);
        Assert.assertTrue(yearInterval1.intersect(yearInterval2));
    }

    @Test
    public void testNotContainedInYearInterval() {
        YearInterval yearInterval1 = new YearInterval(2000,2010);
        YearInterval yearInterval2 = new YearInterval(2011,2012);
        Assert.assertFalse(yearInterval1.intersect(yearInterval2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectIntervalThrowsException() {
        new YearInterval(2014,2012);
    }

    @Test
    public void filterCarModels() {
        CarSearchCriteria criteria = new CarSearchCriteria(new YearInterval(2014, 2016), "Ford");
        CarModel fordFocusMk2 = new CarModel("Ford", "Focus", new YearInterval(2012, 2016));
        CarModel opelAstra = new CarModel("Opel", "Astra", new YearInterval(2010, 2013));
        List<CarModel> carModels = new ArrayList<>();
        carModels.add(fordFocusMk2);
        carModels.add(opelAstra);
        List<CarModel> result = new SearchEngine().filterCarModels(criteria, carModels);
        List<CarModel> toTestList = Collections.singletonList(fordFocusMk2);
        Assert.assertEquals(toTestList, result);
    }

}
