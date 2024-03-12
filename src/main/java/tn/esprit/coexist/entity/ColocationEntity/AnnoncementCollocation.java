package tn.esprit.coexist.entity.ColocationEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import tn.esprit.coexist.entity.User;

import java.util.List;

@Entity
@Data
public class AnnoncementCollocation  {
  @Override
  public String toString() {
    return "AnnoncementCollocation{" +
            "annoncementCollocationId=" + annoncementCollocationId +
            ", homeSize=" + homeSize +
            ", numPerso=" + numPerso +
            ", address='" + address + '\'' +
            ", imageHouse='" + imageHouse + '\'' +
            ", pricePerPerson=" + pricePerPerson +
            ", houseType=" + houseType +
            ", equipmentType=" + equipmentType +
            ", pictures=" + pictures +
            ", user=" + user +
            ", favorisess=" + favorisess +
            '}';
  }

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
