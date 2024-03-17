package com.bukeetcakir.userService.entity;

import com.bukeetcakir.userService.enums.Score;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserReview extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_review_generator")
    @SequenceGenerator(name = "user_review_generator", sequenceName = "user_review_seq", allocationSize = 1)
    private Long Id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "restaurant_id", nullable = false)
    private Long restaurantId;

    @Enumerated(EnumType.STRING)
    @Column(name = "score", nullable = false)
    private Score score;

    @Column(name = "text")
    private String text;
}
