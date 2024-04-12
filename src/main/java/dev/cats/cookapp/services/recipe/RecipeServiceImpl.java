package dev.cats.cookapp.services.recipe;

import dev.cats.cookapp.dto.response.RecipeResponse;
import dev.cats.cookapp.mappers.RecipeMapper;
import dev.cats.cookapp.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    @Override
    public Page<RecipeResponse> getRecipes(int page, int size) {
        var pageRequest = PageRequest.of(page, size);
        var pageOfIds = recipeRepository.findAllIds(pageRequest);
        var recipes = recipeRepository.findAllByIdIn(pageOfIds.getContent());
        var recipeResponses = recipes.stream()
                .map(recipeMapper::toDto)
                .toList();
        return new PageImpl<>(recipeResponses, pageRequest, pageOfIds.getTotalElements());
    }
}
