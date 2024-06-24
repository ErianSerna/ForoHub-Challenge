package com.challenge.ForoHubChallenge.domain.Topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface topicoRepository extends JpaRepository<Topico,Long> {

    Page<Topico> findByActivoTrue(Pageable paginacion);


}
