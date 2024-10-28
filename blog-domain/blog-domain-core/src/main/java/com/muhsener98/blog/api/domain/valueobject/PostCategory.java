package com.muhsener98.blog.api.domain.valueobject;

import com.muhsener98.blog.api.domain.entity.Post;
import com.muhsener98.blog.api.domain.exception.InvalidDomainException;
import com.muhsener98.blog.api.domain.exception.ValidationError;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.muhsener98.blog.api.domain.exception.util.Assert.notNull;

public enum PostCategory {

    TECHNOLOGY("technology"),
    HEALTH_AND_WELLNESS("health_and_wellness"),
    LIFESTYLE("lifestyle"),
    EDUCATION("education"),
    FOOD_AND_COOKING("food_and_cooking"),
    HOME_AND_GARDEN("home_and_garden"),
    PARENTING_AND_FAMILY("parenting_and_family"),
    TRAVEL("travel"),
    ARTS_AND_ENTERTAINMENT("arts_and_entertainment"),
    SPORTS_AND_FITNESS("sports_and_fitness"),
    SCIENCE_AND_ENVIRONMENT("science_and_environment"),
    SELF_IMPROVEMENT("self_improvement"),
    DIY_AND_CRAFTS("diy_crafts"),
    REAL_ESTATE_AND_HOME_BUYING("real_estate_and_home_buying"),
    PETS_AND_ANIMALS("pets_and_animals");


    private static Map<String, PostCategory> contextMap;

    static {
        contextMap = new HashMap<>();
        for (PostCategory postCategory : PostCategory.values()) {
            contextMap.put(postCategory.string, postCategory);
        }
    }


    private final String string;

    PostCategory(String string) {
        this.string = string;
    }


    public static PostCategory of(String val) {
        notNull(val);
        val = val.toLowerCase();
        PostCategory category = contextMap.get(val);

        if (category != null)
            return category;
        else
            throw new InvalidDomainException(
                    "PostCategory", List.of(new ValidationError("category", "No such post category: " + val)));

    }


}
