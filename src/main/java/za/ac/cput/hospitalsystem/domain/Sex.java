package za.ac.cput.hospitalsystem.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/05/13.
 */
@Embeddable
public enum Sex implements Serializable {
    Male, Female
}
