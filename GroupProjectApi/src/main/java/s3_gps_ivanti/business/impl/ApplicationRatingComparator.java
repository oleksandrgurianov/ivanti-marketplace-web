package s3_gps_ivanti.business.impl;

import s3_gps_ivanti.model.Application;
import java.util.Comparator;

public class ApplicationRatingComparator implements Comparator<Application> {
    @Override
    public int compare(Application firstApplication, Application secondApplication) {
        return Double.compare(firstApplication.getRating().avgStar(), secondApplication.getRating().avgStar());
    }
}
