package org.demo.routerfunction.repository;

import org.demo.routerfunction.beans.Device;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DeviceRepository extends ReactiveMongoRepository<Device, String> {
}
