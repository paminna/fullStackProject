package com.example.myapp.specification;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс, описания по каким полям будет осуществляться поиск.
 */
@Getter
@Setter
public class Filter {

    private String name;

    private String login;
}