package com.offcn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Auther: lhq
 * @Date: 2020/8/4 15:25
 * @Description:
 */
@Entity
@Table(name = "tb_user")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {


    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", length = 100, nullable = true)
    private String name;
    @Column(name = "age", length = 4, nullable = true)
    private Integer age;

}
