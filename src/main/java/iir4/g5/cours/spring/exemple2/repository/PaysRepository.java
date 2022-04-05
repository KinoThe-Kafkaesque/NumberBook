package iir4.g5.cours.spring.exemple2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iir4.g5.cours.spring.exemple2.entities.Pays;
@Repository
public interface PaysRepository  extends JpaRepository<Pays, Integer>{

}
