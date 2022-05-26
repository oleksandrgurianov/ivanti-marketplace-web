package s3_gps_ivanti.business.review;

import org.bson.types.ObjectId;

public interface DeleteReviewUseCase {
    void deleteReview(ObjectId id);
}
