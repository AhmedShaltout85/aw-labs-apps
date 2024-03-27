package com.a08r.awlabsapps.models.mapper;

import com.a08r.awlabsapps.models.dto.TrackingPointDto;
import com.a08r.awlabsapps.models.trackpointentity.TrackingPointEntity;

public class TrackingPointMapperImp implements ITrackingPointMapper{
    @Override
    public TrackingPointEntity trackingPointDtoToTrackingPointEntity(TrackingPointDto trackingPointDto) {
        TrackingPointEntity trackingPointEntity = new TrackingPointEntity();
        trackingPointEntity.setSectorName(trackingPointDto.getSectorName());
        trackingPointEntity.setLabName(trackingPointDto.getLabName());
        trackingPointEntity.setLabCode(trackingPointDto.getLabCode());
        trackingPointEntity.setUserId(trackingPointDto.getUserId());
        trackingPointEntity.setBreakId(trackingPointDto.getBreakId());
        trackingPointEntity.setBreakDate(trackingPointDto.getBreakDate());
        trackingPointEntity.setBreakTime(trackingPointDto.getBreakTime());
        trackingPointEntity.setLocationX(trackingPointDto.getLocationX());
        trackingPointEntity.setLocationY(trackingPointDto.getLocationY());
        return trackingPointEntity;
    }

    @Override
    public TrackingPointDto trackingPointEntityTotrackingPointDto(TrackingPointEntity trackingPointEntity) {
        TrackingPointDto trackingPointDto = new TrackingPointDto();
        trackingPointDto.setSectorName(trackingPointEntity.getSectorName());
        trackingPointDto.setLabName(trackingPointEntity.getLabName());
        trackingPointDto.setLabCode(trackingPointEntity.getLabCode());
        trackingPointDto.setUserId(trackingPointEntity.getUserId());
        trackingPointDto.setBreakId(trackingPointEntity.getBreakId());
        trackingPointDto.setBreakDate(trackingPointEntity.getBreakDate());
        trackingPointDto.setBreakTime(trackingPointEntity.getBreakTime());
        trackingPointDto.setLocationX(trackingPointEntity.getLocationX());
        trackingPointDto.setLocationY(trackingPointEntity.getLocationY());

        return trackingPointDto;
    }
}
