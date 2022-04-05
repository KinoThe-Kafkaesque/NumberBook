package iir4.g5.cours.spring.exemple2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iir4.g5.cours.spring.exemple2.entities.Contact;
import iir4.g5.cours.spring.exemple2.entities.Device;
import iir4.g5.cours.spring.exemple2.repository.ContactRepository;
import iir4.g5.cours.spring.exemple2.repository.DeviceRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private DeviceRepository deviceRepository;
	@Autowired
	private PaysService paysService;

	public List<Contact> create(List<Contact> o) {

		Device device = deviceRepository.findByImei(o.get(0).getDevice().getImei()) ;

		if ( device== null) {
			deviceRepository.save(o.get(0).getDevice());
		}
		else {
			return null;
		}
		device = deviceRepository.findByImei(o.get(0).getDevice().getImei()) ;
			for (Contact c : o)
				c.setDevice(device);
		
		return contactRepository.saveAll(o);
	}

	public List<Contact> findByNom(String nom, String imei) {
		return contactRepository.findByNomAndDevice_Imei(nom, imei);
	}

	public List<Contact> findByTelephone(String tel, String imei) {
		return contactRepository.findByTelephoneAndDevice_Imei(tel, imei);
	}
	public List<Contact> findByAll() {
		return contactRepository.findAll();
	}
	
	public Device findByImei(String Imei) {
		return deviceRepository.findByImei(Imei);
	}
}
