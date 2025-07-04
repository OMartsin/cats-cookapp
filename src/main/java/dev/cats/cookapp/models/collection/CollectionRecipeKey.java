package dev.cats.cookapp.models.collection;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionRecipeKey implements Serializable {
    @Column(name = "collection_id")
    private Long collectionId;

    @Column(name = "recipe_id")
    private Long recipeId;
}
