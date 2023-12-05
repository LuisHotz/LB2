package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Reservation;

@ApplicationScoped
public class ReservationService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Reservation createReservation(Reservation reservation) {
        return entityManager.merge(reservation);
    }

    @Transactional
    public void deleteReservation(Long id) {
        var entity = entityManager.find(Reservation.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Reservation updateReservation(Long id, Reservation reservation) {
        reservation.setId(id);
        return entityManager.merge(reservation);
    }

    public List<Reservation> findAll() {
        var query = entityManager.createQuery("FROM Reservation", Reservation.class);
        return query.getResultList();
    }
}
