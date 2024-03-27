package com.a08r.awlabsapps.models.mapper;

import com.a08r.awlabsapps.models.dto.TrackingPointDto;
import com.a08r.awlabsapps.models.trackpointentity.TrackingPointEntity;

public interface ITrackingPointMapper {

//    Course CourseDtoToCourse(CourseDto addCourseDto);
//    CourseDto courseToCourseDto(Course course);
    TrackingPointEntity trackingPointDtoToTrackingPointEntity(TrackingPointDto addTrackingPoint);
    TrackingPointDto trackingPointEntityTotrackingPointDto(TrackingPointEntity trackingPointEntity);
}
