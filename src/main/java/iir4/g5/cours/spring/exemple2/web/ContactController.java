package iir4.g5.cours.spring.exemple2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iir4.g5.cours.spring.exemple2.entities.Contact;
import iir4.g5.cours.spring.exemple2.entities.Device;
import iir4.g5.cours.spring.exemple2.repository.ContactRepository;
import iir4.g5.cours.spring.exemple2.repository.DeviceRepository;
import iir4.g5.cours.spring.exemple2.service.ContactService;

@RestController
@RequestMapping("contact")
public class ContactController {

	@Autowired
	ContactService contactService;
	@Autowired 
	DeviceRepository deviceRepository;
	@Autowired 
	ContactRepository contactRepository;
	@PostMapping
	@ResponseBody
	public List<Contact> create(@RequestBody List<Contact> o) {
		return contactService.create(o);
	}

	@GetMapping
	public List<Contact> findAll() {
		return contactService.findByAll();
	}
	@GetMapping("nom/{nom}")
	@ResponseBody

	public List<Contact> findByNom(@PathVariable String nom, String imei) {
		return contactService.findByNom(nom, imei);
	}
	@GetMapping("{imei}")
	@ResponseBody

	public List<Contact> findByDevice_Imei(@PathVariable String imei) {
		return contactRepository.findByDevice_Imei(imei);
}
	@GetMapping("Imei/{imei}")
	@ResponseBody
	public Device findByImei(@PathVariable String imei) {
		return contactService.findByImei(imei);
	}

	@GetMapping("tel/{tel}")
	@ResponseBody
	public List<Contact> findByTelephone(@PathVariable String tel, String imei) {
		return contactService.findByTelephone(tel, imei);
	}

}
