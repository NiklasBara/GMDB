// package de.owpgmdb.gmdbbackend.persistence;

// import static org.junit.jupiter.api.Assertions.assertThrows;

// import java.util.Collections;
// import java.util.List;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.dao.DataIntegrityViolationException;

// import de.owpgmdb.gmdbbackend.models.Review;
// import de.owpgmdb.gmdbbackend.models.User;
// import de.owpgmdb.gmdbbackend.models.UserRole;
// import de.owpgmdb.gmdbbackend.repositories.UserRepository;

// // @DataJpaTest
// public class UserTest {

//     @Autowired
//     private UserRepository userRepo;

//     @Test
//     void dependenciesAreNotNull() {
//         Assertions.assertThat(this.userRepo).isNotNull();
//     }

//     @Test
//     void repoIsEmptyWhenNothingIsAdded() {
//         List<User> expected = Collections.emptyList();

//         List<User> actual = this.userRepo.findAll();

//         Assertions.assertThat(actual).isEqualTo(expected);
//     }

//     @Test
//     void canAddOneUserToRepo() {
//         User expected = new User("Jan", UserRole.REVIEWER);

//         this.userRepo.save(expected);

//         User actual = this.userRepo.findAll().get(0);

//         Assertions.assertThat(actual).isEqualTo(expected);
//     }

//     @Test
//     void canNotAddTwoUsersWithTheSameName() {
//         String name = "Jan";
//         User userOne = new User(name, UserRole.REVIEWER);
//         User userTwo = new User(name, UserRole.ADMIN);

//         this.userRepo.save(userOne);
//         this.userRepo.save(userTwo);

//         assertThrows(DataIntegrityViolationException.class, () -> this.userRepo.flush());
//     }

//     @Test
//     void canGetUserByUsername(){
//         String name = "Niklas";
//         User expected = new User(name, UserRole.REVIEWER);
//         this.userRepo.save(expected);

//         User actual = this.userRepo.findByUsername(name).orElseThrow(()-> new AssertionError("User not found"));
//         Assertions.assertThat(actual).isEqualTo(expected);
//     }

//     @Test
//     void canAddReviewsToUser(){
//         User user = new User("Niklas", UserRole.ADMIN);
//         Review review = new Review("Bad Movie");

//         this.userRepo.save(user);

//         User dbEntry = this.userRepo.findById(user.getId()).orElseThrow(()-> new AssertionError("No User Found"));
//         dbEntry.getReviews().add(review);
//         this.userRepo.save(dbEntry);
        
//         User actual = this.userRepo.findById(user.getId()).orElseThrow(()-> new AssertionError("No User Found"));

//         Assertions.assertThat(actual).isEqualTo(dbEntry);
//         Assertions.assertThat(actual.getReviews()).isEqualTo(dbEntry.getReviews());

//     }

// }