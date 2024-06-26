package dev.cats.cookapp.dto.response;

import dev.cats.cookapp.models.RecipeCategory;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link dev.cats.cookapp.models.Recipe}
 */
@Value
@FieldDefaults(makeFinal = true)
public class RecipeListResponse implements Serializable {
    Long id;
    String title;
    Integer price;
    Integer time;
    Integer servings;
    String image;
    Boolean isSaved;
    Integer calories;
    Set<RecipeCategoryResponse> categories;

    public RecipeListResponse(Long id, String title, Integer price, Integer time, Integer servings,
                              String image, Boolean isSaved, Integer calories,
                              Set<RecipeCategory> categories) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.time = time;
        this.calories = calories;
        this.servings = servings;
        this.image = image;
        this.isSaved = isSaved;
        this.categories = RecipeCategoryResponse.from(categories);
    }
}