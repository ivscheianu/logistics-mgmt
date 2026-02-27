package ro.scoalainformala.logisticsmgmt.pckg;

import jakarta.persistence.*;
import lombok.Data;
import ro.scoalainformala.logisticsmgmt.delivery.DeliveryDO;

import java.util.Objects;

@Data
@Entity(name = "package")
public class PackageDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float volume;

    private float weight;

    @ManyToOne(fetch = FetchType.LAZY)
    private DeliveryDO delivery;

    @Override
    public String toString() {
        return "PackageDO{" +
                "weight=" + weight +
                ", volume=" + volume +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackageDO packageDO = (PackageDO) o;
        return Float.compare(volume, packageDO.volume) == 0 && Float.compare(weight, packageDO.weight) == 0 && Objects.equals(id, packageDO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, volume, weight);
    }
}
