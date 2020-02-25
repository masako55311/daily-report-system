package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="follow")
@NamedQuery(
            name="getAllFollowers",
            query="SELECT f FROM Follow AS f WHERE f.user_id = f.user_id"
            )


@Entity
public class Follow {
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;

@ManyToOne
@JoinColumn(name="user_id",nullable=false)
private Employee user_id;

@ManyToOne
@JoinColumn(name="follower_id",nullable=false)
private Employee follower_id;

@Column(name="follow_flag")
private Integer follow_flag;

public Integer getFollow_flag() {
    return follow_flag;
}

public void setFollow_flag(Integer follow_flag) {
    this.follow_flag = follow_flag;
}

public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public Employee getUser_id() {
    return user_id;
}

public void setUser_id(Employee user_id) {
    this.user_id = user_id;
    }

public Employee getFollower_id() {
    return follower_id;
}

public void setFollower_id(Employee follower_id) {
    this.follower_id = follower_id;
}


}
