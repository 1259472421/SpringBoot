package com.leichuangkj.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Properties implements Serializable {

    @Value("${user.name}")
    private String name;

    @Value("${user.email}")
    private String email;
}
