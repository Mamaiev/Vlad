package ua.vlad;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.vlad.interfaces.IngredientsRepository;
import ua.vlad.models.Ingredients;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    private final IngredientsRepository repo;

    public Controller(IngredientsRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView model) {
        model.setViewName("index");
        return model;
    }

    @GetMapping("/ing")
    public ModelAndView ing(ModelAndView model) {
        model.addObject("ingredients", repo.findAll());
        model.addObject("ingredient", new Ingredients());
        model.setViewName("ing");

        return model;
    }

    @PostMapping("/add")
    public ModelAndView addIngredient(@Valid @ModelAttribute("ingredient") Ingredients ingredient, BindingResult result, ModelAndView model) {
        repo.save(new Ingredients(ingredient.getName()));
        return new ModelAndView("redirect:ing" );
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
