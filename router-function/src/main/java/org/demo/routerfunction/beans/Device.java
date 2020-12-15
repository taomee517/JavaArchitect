package org.demo.routerfunction.beans;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author 罗涛
 * @title Device
 * @date 2020/6/28 19:39
 */
@Data
@Document(collection = "Device")
public class Device {
    @Id
    String _id;
    String UUID;
    long SENSOR_TYPE;
    Date TIME_JOIN;
    String MAC;
}
