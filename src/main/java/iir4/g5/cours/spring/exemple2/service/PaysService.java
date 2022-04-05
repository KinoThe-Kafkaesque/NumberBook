package iir4.g5.cours.spring.exemple2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iir4.g5.cours.spring.exemple2.entities.Pays;
import iir4.g5.cours.spring.exemple2.repository.PaysRepository;

@Service
public class PaysService {
	
	@Autowired
	PaysRepository paysRepository;
	
	public int add(Pays o ) {
		if ( paysRepository.findById(o.getId()).isPresent()) {
			return -1;
		}
		paysRepository.save(o);
		return 1;
	}
	
}
