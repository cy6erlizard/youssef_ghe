package tn.esprit.coexist.entity.ColocationEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import tn.esprit.coexist.entity.User;

import java.util.Date;

@Entity
@Data
public class Favoris {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer favId;
    private  boolean favoris;
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @ManyToOne
    @JsonIgnore
    User user;
    @ManyToOne
    @JsonIgnore
    private AnnoncementCollocation annoncementCollocation;






}
