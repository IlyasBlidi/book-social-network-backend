package com.razer.book.network.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
  name = "tokens",
  indexes = {
    @Index(name = "token_primary_key", columnList = "id", unique = true)
  }
)
public class Token {

    @Id
    @GeneratedValue
    private Integer id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private LocalDateTime validatedAt;

    @ManyToOne
    @JoinColumn(
      name = "userId",
      nullable = false,
      foreignKey = @ForeignKey(name = "fk_user_id")
    )
    private User user;
}
