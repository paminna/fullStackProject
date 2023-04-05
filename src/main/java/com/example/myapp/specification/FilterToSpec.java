package com.example.myapp.specification;

import org.springframework.data.jpa.domain.Specification;

public class FilterToSpec {

    public static Specification getUser(Filter filter) {
        Specification spec = Specification.
                where(Specifications.likeLogin(filter.getLogin()))
                .and((Specifications.likeName(filter.getName())));
        return spec;
    }
}
