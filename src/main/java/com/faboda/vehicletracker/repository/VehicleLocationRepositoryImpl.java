package com.faboda.vehicletracker.repository;

import com.faboda.vehicletracker.model.VehicleTrackingData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class VehicleLocationRepositoryImpl implements VehicleLocationCustomRepository {

    private  final MongoTemplate mongoTemplate;

    @Override
    public List<VehicleTrackingData> findLatestLocationRecordForEachReg() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.sort(Sort.Direction.DESC, "timestamp"),
                Aggregation.group("reg").first("$$ROOT").as("latestRecord"),
                Aggregation.replaceRoot("latestRecord"),
                Aggregation.sort(Sort.Direction.ASC, "reg")
        );
        AggregationResults<VehicleTrackingData> result =
                mongoTemplate.aggregate(aggregation, "vehicle_tracking_data", VehicleTrackingData.class);
        return result.getMappedResults();
    }

    @Override
    public List<VehicleTrackingData> findByReg(String reg) {
        Criteria criteria = Criteria.where("reg").is(reg);
        return mongoTemplate.find(org.springframework.data.mongodb.core.query.Query.query(criteria).limit(20), VehicleTrackingData.class);
    }

}
