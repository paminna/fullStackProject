package com.example.myapp.specification;

import com.example.myapp.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class Specifications {

    public static <T> Specification<T> likeName (String value){
        if (value == null){
            return null;
        }
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get(User.Fields.username), "%"+value+"%"));
    }

    public static <T> Specification<T> likeLogin (String value){
        if (value == null){
            return null;
        }
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get(User.Fields.login), "%"+value+"%"));
    }
}