package iir4.g5.cours.spring.exemple2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iir4.g5.cours.spring.exemple2.entities.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	List<Contact> findByTelephoneAndDevice_Imei(String telephone , String imei);
	List<Contact> findByNomAndDevice_Imei(String nom ,String imei);	
	List<Contact> findByDevice_Imei(String imei);	
}
