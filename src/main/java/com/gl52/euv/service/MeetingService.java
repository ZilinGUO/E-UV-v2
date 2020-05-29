package com.gl52.euv.service;

import com.gl52.euv.pojo.Meeting;

import java.util.Date;

public interface MeetingService {
    void createMeeting(int groupId, Date mDate);
    Meeting getLastMeeting(int groupId);
}
