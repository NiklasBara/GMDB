package de.owpgmdb.gmdbbackend.models;

/**
 * This Interface flags an Entity as Reviewable. The Flagged Entity is able to save {@link Review}.
 */
public interface Reviewable {
    /**
     * Adds an {@link Review} to the Entity
     * @param review - The Review that will be saved
     */
    void addReview(Review review);
}
