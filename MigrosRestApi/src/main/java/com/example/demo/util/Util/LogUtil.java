package com.example.demo.util.Util;

import java.util.List;

import com.example.demo.entity.AttendanceLog;
import com.example.demo.model.ClosestStore;

public interface LogUtil {
	ClosestStore getClosestStoreId(float lat, float lng);

	double getTotalDistanceOfCourier(List<AttendanceLog> logs);
}
