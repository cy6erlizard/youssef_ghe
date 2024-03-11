package tn.esprit.coexist.entity.ColocationEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import tn.esprit.coexist.entity.User;

import java.util.List;

@Entity
@Data
public class AnnoncementCollocation  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer annoncementCollocationId;
  private Integer homeSize;
  private Integer numPerso;
  private String address;
  private String imageHouse;
  private float pricePerPerson;
  @Enumerated(EnumType.STRING)
  private HouseType houseType;
  @Enumerated(EnumType.STRING)
  private EquipmentType equipmentType;
  @OneToMany(mappedBy = "annoncementCollocation", cascade = CascadeType.ALL)
  private List<Picture> pictures;
  @ManyToOne
  @JsonIgnore
  private User user;
  @OneToMany(mappedBy = "annoncementCollocation", cascade = CascadeType.ALL)
  private List<Favoris> favorisess;
}
