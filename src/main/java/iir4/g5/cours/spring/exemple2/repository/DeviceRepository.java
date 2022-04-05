package iir4.g5.cours.spring.exemple2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iir4.g5.cours.spring.exemple2.entities.Device;
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{
	Device findByImei(String imei);
}
